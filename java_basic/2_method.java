// method structure 

public RETUNR_TYPE METHOD_NAME (INPUT_TYPE INPUT_NAME, . . . ) {
        return RETURN_VALUE; // if return type is void, it is not necessary
        }

public int sum(int a, int b) {
        return a+b;
}

Test t1 = new Test();
int c = t1.sum(a, b); // int c -> since sum method returns int type 

/** void */
public void say() {
        System.out.println("Howdy");
}

Test t2 = new Test();
t2.say(); // no input value, no return value 


/**return usage */
public void say_something(String something) {
        if("some".equals(something)) {
                return; // return can get out of method 
        }
        System.out.println(something + " does not match ..");
}



/** local variable scope */

public void vartest(int a) { // int a -> only stay in method 
        a++; // local variable 
}

public static void main(String[] args) {
        int a = 10;
        Test t3 = new Test();
        t2.variable(a);
        System.out.println(a);
}

/** let's use return ! */

public int vartest(int a) {
        a++;
        return a;
}

