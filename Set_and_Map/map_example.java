/**Reads each word in a data file and stores it in an index 
   along with a list with a list of line numbers where it occurs*/


public void buildIndex(Scanner scan) {
        int lineNum = 0;

        while(scan.nextLine()) {
                lineNum++;

                String token;
                while((token = scan.findInLine("[\\p{L}\\p{N}']+")) != null) {
                        token = token.toLowerCase();

                        ArrayList<Integer> lines = index.get(token);
                        if (line == null) {
                                lines = new ArrayList<Integer>();
                        }
                        lines.add(lineNum);
                        lines.put(token, lines); // Store new list of line numbers 
                } 
                scan.nextline(); // Clear the buffer
        }
}


