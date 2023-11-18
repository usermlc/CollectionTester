public class Main {
    public static void main(String[] args) {
        CollectionTester tester = new CollectionTester();
        tester.ArrayListTest(50000);
        tester.ArrayListTest(500000);
        tester.ArrayListTest(1000000);

        tester.LinkedListTest(50000);
        tester.LinkedListTest(500000);
        tester.LinkedListTest(1000000);

        tester.HashMapTest(50000);
        tester.HashMapTest(500000);
        tester.HashMapTest(1000000);

        tester.TreeMapTest(50000);
        tester.TreeMapTest(500000);
        tester.TreeMapTest(1000000);

        tester.LinkedHashMapTest(50000);
        tester.LinkedHashMapTest(500000);
        tester.LinkedHashMapTest(1000000);

        tester.WeakHashMapTest(50000);
        tester.WeakHashMapTest(500000);
        tester.WeakHashMapTest(1000000);

        tester.IdentityHashMapTest(50000);
        tester.IdentityHashMapTest(500000);
        tester.IdentityHashMapTest(1000000);

        String input = "This string is going to be spinned";
        String spunWords = WordSpinner.spinWords(input);
        System.out.println("\nSpun Words: " + spunWords);

        tester.printResults();
    }
}