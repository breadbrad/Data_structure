/**class explanation */
public class Animal {

}

// Class creates objects

Animal cat = new Animal(); // cat object is an instance of Animal 
// new keyword -> for creating an object 
public class Animal {
        String name; // instance variable 
}

Animal dog = new Animal();
dog.name; // access an instance variable 'name' 


/** method explanation*/

public class Animal {
        String name;

        public void setName(String name) {
                this.name = name; // this -> refer to an instance created by Animal class
        }
        
        public static void main(String[] args) {
                Animal dog = new Animal(); // this keyword will refer to dog 
                dog.setName("toby");
                System.out.println(cat.name);
        }
}
