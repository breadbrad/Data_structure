/** In order to create abstract clas, keyword abstract should be preceded */

public abstract class Predator extends animal {
        public abstract String getName(); // no body 
}

public class Tiger extends Predator implements Barkable { // 'extends' abstract class 

}


