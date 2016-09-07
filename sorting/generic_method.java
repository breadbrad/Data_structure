/** declaring a Generic Method */

// methodModifier <genericParameter> returnType methodName(methodParameters)

// for example 
public static <T extends Comparable<T>> int binarySearch(T[] items, T target) 



public static <T> void sort(T[] items, Comparator<? super T> comp)
//<T> -> generic parameter for the sort method (should appear in parameter list) 
//comp -> object that implements Comparator interface for type T or for a superclass of type T 



public static <T extends Comparable<T>> void sort(List<T> list)
// <T extends Comparable<T>> -> generic parameter T must implement the interface Comparable<T>
// list -> (the object being sorted) of type List<T> 



