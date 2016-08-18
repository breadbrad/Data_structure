/**NO duplicate elements 
sets contain no pair of elements e1 and e2 such that e1.equals(e2) 
seem like a mathematical concept of set*/
import java.util.Set;
import java.util.HashSet;
class Set_explanation{ 
public static void main(String[] args) {
        String[] listA = {"Ann", "Sally", "Jill", "Sally"};
        String[] listB = {"Bob", "Bill", "Ann", "Jill"};
        Set<String> setA = new HashSet<String>();
        Set<String> setAcopy = new HashSet<String>(); //copy of setA 
        Set<String> setB = new HashSet<String>();
        
        for(int i = 0; i < listA.length; i++) { 
                setA.add(listA[i]);
                setAcopy.add(listA[i]);
        }
        
        for(int i = 0; i < listB.length; i++) {
                setB.add(listB[i]);
        }

        System.out.println("The 2 sets are: " + "\n" + setA + "\n" + setB);

        setA.addAll(setB); // Set union
        setAcopy.retainAll(setB); // Set intersection 
        System.out.println("Items in set union are: " + setA);
        System.out.println("items in set intersection are: " + setAcopy);
        }
}
