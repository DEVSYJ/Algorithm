import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimpleTest {
    @Test
    public void startWithTest() {
        String str = "test";
        String str2 = "test";

        System.out.println(str.startsWith(str2));
    }

    @Test
    public void streamTest() {
        int sum = IntStream.of(1, 3, 5, 7, 9)
                .peek(System.out::println)
                .sum();

        OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
        min.ifPresent(System.out::println);
        OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();
        max.ifPresent(System.out::println);

        Product p1 = new Product();
        p1.setAmount(1);
        Product p2 = new Product();
        p2.setAmount(2);
        List<Product> productList = new ArrayList<Product>();
        productList.add(p1);
        productList.add(p2);

        Map<Boolean, List<Integer>> mapPartitioned = IntStream.of(1, 2).boxed()
                        .collect(Collectors.partitioningBy((i -> i > 15)));


        min.ifPresent(System.out::println);
    }
}
