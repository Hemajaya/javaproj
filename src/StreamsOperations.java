import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsOperations {
    public static void main(String[] args) {

        Stream.iterate(1, ele -> ele + 1).filter(ele -> ele > 3).limit(5).forEach(System.out::println);

        System.out.println("squares of each numbers ; ");
        Stream.iterate(2, s -> s * s).limit(5).forEach(System.out::println);

        IntSummaryStatistics summaryStatistics = IntStream.of(1, 2, 4, 3, 1, 6).summaryStatistics();
        System.out.println(summaryStatistics);

        //SKIP 0 TO 1 and PRINT 2,3,4
        IntStream.range(0, 5).skip(2).forEach(s -> System.out.println("Un skipped number : " + s));

        System.out.println("sum of 5 to 9: " + IntStream.range(0, 9).skip(5).sum());

        Stream.of("lke", "gor", "sor").filter(s -> s.endsWith("d"))
                .sorted()
                .forEach(System.out::println);

        String[] name = {"lke", "waded", "said", "nani"};
        Arrays.stream(name)        // equal as Stream.of(name)
                .map(String::toUpperCase)
                .forEach(s -> System.out.println("Uppercase : " + s));

        Arrays.stream(new int[]{1, 1, 1, 1})
                .map(a -> a * 2)
                .average()
                .ifPresent(s -> System.out.println("Average : " + s));

        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee("Tom Jones", 45, 7000.00),
                new Employee("Harry Major", 25, 10000.00),
                new Employee("Ethan Hardy", 65, 8000.00),
                new Employee("Nancy Smith", 22, 12000.00),
                new Employee("Deborah Sprightly", 29, 9000.00)
        ));
        employeeList.replaceAll(employee -> {
            employee.setSalary(employee.getSalary() * 1);
            return employee;
        });
        System.out.println("Employee list with all salaries incremented");
        employeeList.forEach(System.out::println);

        Double totSalary = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(0.00, (a, b) -> a + b);
        System.out.println("Total Salary : " + totSalary);

        Optional<Employee> optionalEmployee = employeeList.stream()
                .peek(s -> System.out.println("peek :  " + s))
                .reduce((a1, a2) -> (a1.getSalary() > a2.getSalary()) ? a1 : a2);

        System.out.println("Emp with max salary using reduce:" + optionalEmployee.get());

        //   Optional<Employee> max =
        employeeList.stream().max(Comparator.comparingInt(Employee::getAge))
                .ifPresent(s -> System.out.println("Emp with Maximum age: " + s));

        //   System.out.println("Emp with Maximum age: " + max.get());

        int[] i = {1, 3, 2, 1};
        //  IntSummaryStatistics intSummaryStatistics = Arrays.stream(i).summaryStatistics();
        System.out.println(Arrays.stream(i).summaryStatistics());

        String[] str = {"sds", "awes", "erer"};
        System.out.println("concat string : " + Arrays.stream(str)
                .reduce(String::concat).get());

        List<String> collect = employeeList.stream().map(s -> s.getName()
                .split(" "))  // converts the stream of Employees to a stream of Employee names’ array. I.e. converts from Stream<Employee> to Stream<String[]>
                .flatMap(array -> Arrays.stream(array)) //converts Stream<String[]> into first a Stream<Stream<String>> and then flattens it to Stream<String> i.e. a stream of single character Strings.
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

}
