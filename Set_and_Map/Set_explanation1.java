// Set interface must contain unique elements 
// Set.add returns false if you attempt to add a duplicate item


// Iterate through set elements using an iterator object 
/** elements will be accessed in arbitrary order */

// Create an iterator to setA 
Iterator<String> setAIter = setA.iterator();
while(setAIter.hasNext()) {
        String nextItem = setAIter.next();
        // Do something with nextItem 

}
/** for each */
for (String nextItem: setA) {
        // Do something will nextItem

}


