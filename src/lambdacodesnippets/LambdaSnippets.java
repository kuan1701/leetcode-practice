package lambdacodesnippets;

import java.util.Arrays;
import java.util.List;

public class LambdaSnippets {

    public static final List<String> STRING_LIST = Arrays.asList("Java", "Scala", "Python");

    public static void main(String[] args) throws InterruptedException {
        runnableExample();
        listIterating();
        filteringList();
        sortingList();
        calculate();
    }

    // 1.Simple Runnable Example
    public static void runnableExample() throws InterruptedException {
        System.out.println("1. Simple Runnable Example");

        Runnable runnable = () -> System.out.println("Hello World");
        new Thread(runnable).start();

        Thread.sleep(200L);

        System.out.println("========================================");
    }

    // 2. Iterating List using Lambda
    public static void listIterating() {
        System.out.println("2. Iterating List using Lambda");

        STRING_LIST.forEach(System.out::println);

        System.out.println("========================================");
    }

    // 3. Filtering a List with Lambda
    public static void filteringList() {
        System.out.println("3. Filtering List using Lambda");

        List<String> filteredList = STRING_LIST.stream()
                .filter(item -> item.startsWith("J"))
                        .toList();
        filteredList.forEach(System.out::println);

        System.out.println("========================================");
    }

    // 4. Sorting a List using Lambda
    public static void sortingList() {
        System.out.println("4. Sorting List using Lambda");

        STRING_LIST.sort(String::compareTo);
        STRING_LIST.forEach(System.out::println);

        System.out.println("========================================");
    }

    // 5. Using a Custom Functional Interface
    @FunctionalInterface
    interface Calculator {
        int calculate(int num1, int num2);
    }

    public static void calculate() {
        System.out.println("5. Using a Custom Functional Interface");

        Calculator sum = Integer::sum;
        Calculator divideUnsigned = Integer::divideUnsigned;
        Calculator compareUnsigned = Integer::compareUnsigned;
        Calculator remainderUnsigned = Integer::remainderUnsigned;
        Calculator multiply = (num1, num2) -> num1 * num2;

        System.out.println("Operation sum: " + sum.calculate(1, 2));
        System.out.println("Operation divideUnsigned: " + divideUnsigned.calculate(1, 2));
        System.out.println("Operation compareUnsigned: " + compareUnsigned.calculate(2, 2));
        System.out.println("Operation remainderUnsigned: " + remainderUnsigned.calculate(4, 2));
        System.out.println("Operation multiply: " + multiply.calculate(4, 2));

        System.out.println("========================================");
    }

}
