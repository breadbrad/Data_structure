import java.util.*;

class Dog implements Comparator<Dog>, Comparable<Dog> {
	private String name;
	private int age;
	Dog() {}

	Dog (String n, int a){
		name = n;
		age = a;
	}

	public String getDogName() {
		return name;
	}

	public int getDogAge() {
		return age;
	}

	// Override the compareTo method 
	@Override 
	public int compareTo(Dog d) {
		return (this.name).compareTo(d.name);
	}
	
	// Override the compare method (to sort based on age)
	@Override 	
	public int compare(Dog d1, Dog d2) {
		return d1.age - d2.age;
	}

	public static void main(String[] args) {
		List<Dog> list = new ArrayList<Dog>();

		list.add(new Dog("Shaggy", 3));
		list.add(new Dog("Lacy", 2));
		list.add(new Dog("Roger", 10));
		list.add(new Dog("Tommy", 4));
		list.add(new Dog("Tammy", 1));

		/** compareTo() in Comparable<T> 
                    Usage : Collections.sort(lst)    */
		Collections.sort(list);  
		for(Dog a: list) // sorted order of name 
   			System.out.println(a.getDogName() + ",");

		/** compare() in Comparator<T>
                    Usage : Collections.sort(list, Comparator) */	
		// compare() in Comparator<T>  
		Collections.sort(list, new Dog());
                System.out.println(" ");
		for(Dog a: list) 
			System.out.println(a.getDogName() + " : " + a.getDogAge() + ", ");
	}
}
