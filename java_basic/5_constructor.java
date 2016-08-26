/** constructor has a same name as class name
    constructor doesn't define return type */

// default constructor -> no parameter constructor 

/** Constructor overloading */
// different argument type, number 
public class HouseDog {
        public HouseDog(String name) {
                this.setName(name);
        }

        public HouseDog(int type) {
                if (type == 1) {
                        this.setName("toby");
                } else if (type == 2) {
                        this.setName("ruby");
                }
        }

        public static void main(String[] args){
                HouseDog h1 = new HouseDog("jindori");
                HouseDog h2 = new HouseDog(2);
        }
}


