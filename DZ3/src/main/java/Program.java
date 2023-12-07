public class Program {
    public static void main(String[] args) {
        task1();
        task2();
        task4();
    }

    static void task1() {
        MyList<Number> myList = new MyList<>();
        myList.addElement(3);
        myList.addElement(2.1);
        myList.addElement(92346593243475897L);
        myList.addElement(123.321f);

        myList.forEach(System.out::println);
    }

    static void task2() {
        System.out.println(Calculator.sum(2, 2.0));
        System.out.println(Calculator.multiply(2.0f, 2.0));
        System.out.println(Calculator.divide(2L, 2.0));
        System.out.println(Calculator.subtract(2, 2));
    }

    private static <T> boolean compareArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }

    static void task4() {
        Pair<Integer, String> pair1 = new Pair<>(1, "one");
        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());
        System.out.println(pair1);

        Pair<String, Double> pair2 = new Pair<>("pi", 3.14);
        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());
        System.out.println(pair2);
    }
}
