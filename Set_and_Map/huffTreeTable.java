public static HuffData[] builFreqTable(BufferedReader ins) {
        // Map of frequencies 
        Map<Character, Integer> frequencies = new HashMap<Character, Integer>();
        try {
                int nextChar;
                while((nextChar = ins.read()) != -1) {
                        Integer count = frequencies.get((char) nextChar);
                        if (count == null) 
                                count = 1;
                        else 
                                count++;
                        frequencies.put((char) nextChar, count);
                }
                ins.close();
        } catch (IOException ex) {
                ex.printStackTrace();
                system.exit(1);
        }
        
        // Copy Map entries to a HuffData[] array
        HuffData[] freqTable = new HuffData[frequencies.size()];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
                freqTable[i] = new HuffData(entry.getValue().doubleValue(), entry.getKey());
                i++;
        }
        return freqTable;
}
/** starter method to build the code table */
public void buildCodeTable() {
        // Initialize the code map 
        codeMap = new HashMap<Character, BitString>();
        buildCodeTable(huffTree, new BitString());
}

private void buildCodeTable(BinaryTree<HuffData> tree, BitString code) {
        // Get data at local root 
        HuffData datum = tree.getData();
        if(datum.symbol != null) {
                // Found a symbol, insert its code in the map 
                codeMap.put(datum.symbol, code);
        } else {
        I       // Append 0 to code so far and traverse left 
                BitString leftCode = (BitString) code.clone();
                leftCode.append(false); // false is 0 
                buildCodeTable(tree.getLeftSubtree(), leftCode);
                // Append 1 to code so far and traverse left 
                BitString rightCode = (BitString) code.clone();
                rightCode.append(true); // true is 1 
                buildCodeTable(tree.getRighSubtree(), rightCode);
        }
}

/** encode a data file by writing it in compressed bit string form 
    @param ins The input stream
    @param outs The object output stream
    */
public void encode(BufferedReader in, ObjectOutputStream outs) {
        BitString result = new BitString(); // the complete bit string 
        try {
                int nextChar;
                while((nextChar = ins.read()) != -1) { // More data
                        Character next = (char) nextChar;

                        //Get bit string corresponding to symbol nextChar
                        BitString nextChunk = codeMap.get(next);
                        result.append(nextChunk); // append to result string 
                }

                // Write result to output file and close files 
                read.trimCapacity();
                outs.writeObject(result);
                ins.close();
                outs.close();
        } catch (IOException ex) {
                ex.printStackTrace();
                System.exit(1);
        }
}



