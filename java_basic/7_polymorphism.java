//Bad example 

public class Bouncer {
        // it can be comlicated (too many instanceof ..) 
        public void barkAnimal(Animal animal) {
                if (animal instanceof Tiger) {
                        System.out.println("Growl");
                } else if (animal instanceof Lion) {
                        System.out.println("Grrrr!");
                }
        }

        public static void main(String[] args){
                Tiger tiger = new Tiger();
                Lion lion = new Lion();

                Bouncer bouncer = new Bouncer();
                bouncer.barkAnimal(tiger);
                bouncer.barkAnimal(lion);
        }
}

/** better version
    polymorphism -> an object can have several data types */

public interface Barkable {
        public void bark();
}

public class Tiger extends Animal implement Predator, Barkable {
        public void bark() {
                System.out.println("Growl");
        }
}

public class Lion extends Animal implement Predator, Barkable {
        public void bark() {
                System.out.println("Grrr");
        }
}

public class Bouncer {
        public void barkAnimal(Barkable animal) {
                 animal.bark();
        }
        
        public static void main(String[] args) {
                Tiger tiger = new Tiger();
                Lion lion = new Lion();

                Bouncer bouncer = new Bouncer();
                bouncer.barkAnimal(tiger);
                bouncer.barkAnimal(lion);
        }
}







