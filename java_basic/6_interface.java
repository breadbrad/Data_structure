public interface Predator {
        public String getName();// method in interface just has a name 
}

public class Animal {
        String name;

        public void setName(String name) {
                this.name = name;
        }

        public String getName() {
                return this.name;
        }
}

public class Tiger extends Animal implements Predator {

}

public class Lion extends Animal implements Predator {

}

public class ZooKeeper {
        // Predator from predator interface 
        public void feed(Predator predator) {
                System.out.println("feed " + predator.getName());
        }

        public static void main(String[] args) {
                Tiger tiger = new Tiger();
                tiger.setName("tiger");

                Lion lion = new Lion();
                lion.setName("lion");

                ZooKeeper zookeeper = new ZooKeeper();
                zookeeper.feed(tiger);
                zookeeper.feed(lion);
        }
}



