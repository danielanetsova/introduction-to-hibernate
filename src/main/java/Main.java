
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("3000");
        BigDecimal bigDecimal2 = new BigDecimal("7000");

        BigDecimal salaryAbove = new BigDecimal("71120");
        BigDecimal salaryBetween = new BigDecimal("33376");
        BigDecimal salaryBetween2 = new BigDecimal("50500");
        BigDecimal salaryBelow = new BigDecimal("24000");

//        List<BigDecimal> list = Arrays.asList(salaryAbove, salaryBetween, salaryBetween2, salaryBelow);
//
//        list.stream().filter(salary -> bigDecimal1.compareTo(salary) < 0 ||
//                bigDecimal2.compareTo(salary) > 0).forEach(System.out::println);

//        System.out.println(salaryAbove.compareTo(bigDecimal1)); // 1
//        System.out.println(salaryAbove.compareTo(bigDecimal2)); // 1
//
//        System.out.println(salaryBetween.compareTo(bigDecimal1)); // 1
//        System.out.println(salaryBetween.compareTo(bigDecimal2)); // 0
//
//        System.out.println(salaryBetween2.compareTo(bigDecimal1)); // 1
//        System.out.println(salaryBetween2.compareTo(bigDecimal2)); // 0
//
//        System.out.println(salaryBelow.compareTo(bigDecimal1)); // 0
//        System.out.println(salaryBelow.compareTo(bigDecimal2)); // 0

        System.out.println(Double.toString(2.2));
    }
}
