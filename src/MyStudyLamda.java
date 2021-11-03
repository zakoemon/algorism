import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyStudyLamda {
    public static void main(String args[]) throws IOException {
        System.out.println(convert(1, t -> Integer.toString(t)));
        System.out.println(convert(1, 3, (x, y) -> x * y));
        System.out.println(convert(3, 5));
        consume("hello", MyStudyLamda::printNice);
        IntBinaryOperator getBigger = Integer::max;
        System.out.println(getBigger.applyAsInt(3, 5));
        IntStream stream = IntStream.of(1, 3, 4, 5);
        stream.forEach(System.out::println);
        sum(1, 150);
        getPeople().forEach(Person::say);
        int num = 1000;
        System.out.println(~num);
        List<Person> people = getPeople().filter(t -> t.getAge() > 30).sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        people.forEach(System.out::println);

        Function<String, Predicate<String>> func =
                (String letter) -> {
                    Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
                    return checkStarts;
                };
        Files.list(Paths.get(".")).forEach(System.out::println);
    }

    public static String convert(Integer integer, Function<Integer, String> func) {
        return func.apply(integer);
    }

    public static Integer convert(int x, int y, IntBinaryOperator custom) {
        return custom.applyAsInt(x, y);
    }

    public static Integer convert (int x, int y) {
        return convert(x, y, (one, two) -> one * two);
    }

    public static void consume(String str, Consumer<String> consumer) {
        consumer.accept(str);
    }

    private static void printNice(String str) {
        System.out.println("******************");
        System.out.println("Your string is : " + str);
        System.out.println("******************");
    }

    private interface test {
        static void sayHello(String sth) {
            System.out.println(sth);
        }
        default void say(String sth) {
            System.out.println(sth);
        }
    }

    public static void sum (int start, int end) {
        OptionalInt sumOf = IntStream.rangeClosed(start, end).reduce((x, y) -> x + y);
        System.out.println(sumOf.orElse(0));
    }

    public static Stream<Person> getPeople() {
        return Stream.of(
                new Person("Matt"),
                new Person("Kevin"),
                new Person("Jeff"),
                new Person("Kent"),
                new Person("Emy"),
                new Person("Kosugi"),
                new Person("Ami"),
                new Person("Motoki"),
                new Person("Masaharu"),
                new Person("Makoto")
        );
    }

    private static Predicate<String> startWith(final String letter) {
        return str -> str.startsWith(letter);
    }

    public static class Person {
        private String name;
        private int age;
        public Person (String name) {
            this.name = name;
            this.age = (int) (100 * Math.random());
        }
        public void say() {
            System.out.println(this.name);
        }
        public String getName() {
            return this.name;
        }
        public int getAge() {
            return this.age;
        }
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("**********************");
            builder.append("\n");
            builder.append("name: " + this.name);
            builder.append("\n");
            builder.append("age: " + this.age);
            builder.append("\n");
            return builder.toString();
        }
    }
}
