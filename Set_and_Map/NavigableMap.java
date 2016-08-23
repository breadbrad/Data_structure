/**Returns the average of the numbers in its Map argument 
   @param valueMap The map whose values are averaged 
   @return The average of the map values */

public static double computeAverage(Map<Integer, Double> valueMap) {
        int count = 0;
        double sum = 0;
        for (Map.Entry<Integer, Double> entry : valueMap.entrySet()) {
               sum += entry.getValue().doubleValue();
               count++;
        }
        return (double) sum / count;
}

/** Returns a list of the averages of nonoverlapping spans of
    values in its NavigableMap argument
    @param valueMap The map whose values are averaged 
    @param delta The number of map values in each span
    @return An Arraylist of average values for each span */

public static List<Double> computeSpans(NavigableMap valueMap, int delta) {
        List<Double> result = new ArrayList<Double>();
        Integer min = (Integer) valueMap.firstEntry().getKey();
        Integer max = (Integer) valueMap.lastEntry().getKey();
        for (int index = min; index <= max; index += delta) {
                double average = computeAverage(valueMap.subMap(index, true, index+delta, false));
                result.add(average);
        }
        return result;
}

