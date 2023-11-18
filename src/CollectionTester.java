import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CollectionTester {
    private List < TestResult > results;

    public CollectionTester() {
        results = new ArrayList < > ();
    }

    public void ArrayListTest(int Elements) {
        List < Integer > a = IntStream.range(0, Elements)
            .parallel()
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));

        long timer = System.nanoTime();
        a.get(Elements / 2);
        long estimated = System.nanoTime() - timer;
        results.add(new TestResult("ArrayList Get", estimated));

        timer = System.nanoTime();
        a.set(Elements / 2, 0);
        estimated = System.nanoTime() - timer;
        results.add(new TestResult("ArrayList Set", estimated));

        timer = System.nanoTime();
        a.remove(Elements / 2);
        estimated = System.nanoTime() - timer;
        results.add(new TestResult("ArrayList Remove", estimated));
    }

    public void LinkedListTest(int Elements) {
        LinkedList < Integer > l = IntStream.range(0, Elements)
            .parallel()
            .boxed()
            .collect(Collectors.toCollection(LinkedList::new));

        long timer = System.nanoTime();
        l.get(Elements / 2);
        long estimated = System.nanoTime() - timer;
        results.add(new TestResult("LinkedList Get", estimated));

        timer = System.nanoTime();
        l.set(Elements / 2, 0);
        estimated = System.nanoTime() - timer;
        results.add(new TestResult("LinkedList Set", estimated));

        timer = System.nanoTime();
        l.remove(Elements / 2);
        estimated = System.nanoTime() - timer;
        results.add(new TestResult("LinkedList Remove", estimated));
    }

    public void HashMapTest(int Elements) {
        Map < Integer, Integer > map = IntStream.range(0, Elements)
            .parallel()
            .boxed()
            .collect(Collectors.toMap(
                i -> i,
                i -> i,
                (e1, e2) -> e1,
                HashMap::new
            ));

        long timer = System.nanoTime();
        map.get(Elements / 2);
        long estimated = System.nanoTime() - timer;
        results.add(new TestResult("HashMap Get", estimated));

        timer = System.nanoTime();
        map.put(Elements / 2, 0);
        estimated = System.nanoTime() - timer;
        results.add(new TestResult("HashMap Put (overwrite)", estimated));

        timer = System.nanoTime();
        map.remove(Elements / 2);
        estimated = System.nanoTime() - timer;
        results.add(new TestResult("HashMap Remove", estimated));
    }

    public void TreeMapTest(int Elements) {
        TreeMap < Integer, Integer > map = IntStream.range(0, Elements)
            .parallel()
            .boxed()
            .collect(Collectors.toMap(
                i -> i,
                i -> i,
                (e1, e2) -> e1,
                TreeMap::new
            ));

        long timer = System.nanoTime();
        map.get(Elements / 2);
        long estimated = System.nanoTime() - timer;
        results.add(new TestResult("TreeMap Get", estimated));

        timer = System.nanoTime();
        map.put(Elements / 2, 0);
        estimated = System.nanoTime() - timer;
        results.add(new TestResult("TreeMap Put (overwrite)", estimated));

        timer = System.nanoTime();
        map.remove(Elements / 2);
        estimated = System.nanoTime() - timer;
        results.add(new TestResult("TreeMap Remove", estimated));
    }

    public void LinkedHashMapTest(int Elements) {
        LinkedHashMap < Integer, Integer > map = IntStream.range(0, Elements)
            .parallel()
            .boxed()
            .collect(Collectors.toMap(
                i -> i,
                i -> i,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));

        long timer = System.nanoTime();
        map.get(Elements / 2);
        long estimated = System.nanoTime() - timer;
        results.add(new TestResult("LinkedHashMap Get", estimated));

        timer = System.nanoTime();
        map.put(Elements / 2, 0);
        estimated = System.nanoTime() - timer;
        results.add(new TestResult("LinkedHashMap Put (overwrite)", estimated));

        timer = System.nanoTime();
        map.remove(Elements / 2);
        estimated = System.nanoTime() - timer;
        results.add(new TestResult("LinkedHashMap Remove", estimated));
    }

    public void WeakHashMapTest(int Elements) {
        WeakHashMap < Integer, Integer > map = IntStream.range(0, Elements)
            .parallel()
            .boxed()
            .collect(Collectors.toMap(
                i -> i,
                i -> i,
                (e1, e2) -> e1,
                WeakHashMap::new
            ));

        long timer = System.nanoTime();
        map.get(Elements / 2);
        long estimated = System.nanoTime() - timer;
        results.add(new TestResult("WeakHashMap Get", estimated));

        timer = System.nanoTime();
        map.put(Elements / 2, 0);
        estimated = System.nanoTime() - timer;
        results.add(new TestResult("WeakHashMap Put (overwrite)", estimated));

        timer = System.nanoTime();
        map.remove(Elements / 2);
        estimated = System.nanoTime() - timer;
        results.add(new TestResult("WeakHashMap Remove", estimated));
    }

    public void IdentityHashMapTest(int Elements) {
        IdentityHashMap < Integer, Integer > map = IntStream.range(0, Elements)
            .parallel()
            .boxed()
            .collect(Collectors.toMap(
                i -> i,
                i -> i,
                (e1, e2) -> e1,
                IdentityHashMap::new
            ));

        long timer = System.nanoTime();
        map.get(Elements / 2);
        long estimated = System.nanoTime() - timer;
        results.add(new TestResult("IdentityHashMap Get", estimated));

        timer = System.nanoTime();
        map.put(Elements / 2, 0);
        estimated = System.nanoTime() - timer;
        results.add(new TestResult("IdentityHashMap Put (overwrite)", estimated));

        timer = System.nanoTime();
        map.remove(Elements / 2);
        estimated = System.nanoTime() - timer;
        results.add(new TestResult("IdentityHashMap Remove", estimated));
    }

    public void printResults() {
        results.sort(Comparator.comparingLong(TestResult::getTime));
        System.out.println("Results:");
        System.out.println("-----------------------------------------------------");
        System.out.println("| Test Name            | Execution Time (ns) |");
        System.out.println("-----------------------------------------------------");
        for (TestResult result: results) {
            System.out.printf("| %-20s | %19d |\n", result.getName(), result.getTime());
        }
        System.out.println("-----------------------------------------------------");
    }

    private static class TestResult {
        private String name;
        private long time;

        public TestResult(String name, long time) {
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public long getTime() {
            return time;
        }
    }
}