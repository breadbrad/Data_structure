public static void main(String[] args) {
        NavigableSet<Integer> odds = new TreeSet<Integer> ();
        odds.add(5);
        odds.add(3);
        odds.add(7);
        odds.add(1);
        odds.add(9);
        odds.add(2);
        NavigableSet b = odds.subset(1, false, 7, true);
        System.out.println("The ordered set b is " + b);
        System.out.println("Its first element is " + b.first());
        System.out.println("Its smallest element >= 6 is " + b.ceiling(6));
}
