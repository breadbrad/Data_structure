public class Animal {
        String name;

        public void setName(String name){
                this.name = name;
        }
}

public class Dog extends Animal { // for class inheritance, extends keyword
        public void sleep() {
                System.out.println(this.name + " zzz...");
        public static void main(String[] args) {
                Dog doggo = new Dog();
                doggo.setName("toby");
                System.out.println(doggo.name);
        }
}

/** Method overriding */

public class HouseDog extends Dog {
        /** sleep() in HouseDog class has higher priority than sleep() in Dog classi */
        public void sleep() { 
                System.out.println(this.name + " zzz in house ");
        }

        public static void main(String[] args) {
                HouseDog h = new HouseDog();
                h.setName("ruby");
                h.sleep();
        }
}





