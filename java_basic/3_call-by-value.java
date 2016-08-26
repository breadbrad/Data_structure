class Updator {
        public void update(int count) {
                count++;
        }
}

public class Counter {
        int count = 0;
        public static void main(String[] args) {
                Counter c1 = new Counter();
                System.out.println("before update: " + c1.count);
                
                Updator u1 = new Updator();
                u1.update(u1.count);
                System.out.println("after update: " + u1.count);
        }
}

// output -> before update: 0 , after update: 0

class Updator {
        // call by value
        public void update(Counter c) { // change the parameter to an object
                c.count++;
        }
}

public class Counter {
        int count = 0;
        public static void main(String[] args) {
                Counter c1 = new Counter();
                System.out.println("before update: " + c1.count);
                
                Updator u1 = new Updator();
                u1.update(u1);
                System.out.println("after update: " + u1.count);
        }
}

