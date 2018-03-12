import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Fibonacci {
    static void createSeq (int n) {
        int first =0;
        int second =1;
        int total;

        System.out.println(first);
        System.out.println(second);

        for (int i=2; i< n;i++) {

        total = first+second;
        first = second;
        second = total;
        System.out.println(total);
        }
    }

    static void listOperations() {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,4,2,4,1,2,5,3));
        List<String> stringList = new ArrayList<>(Arrays.asList("sds","awes","erer"));

        integerList.sort(Comparator.comparingInt(Integer::intValue));

        integerList.sort(Comparator.reverseOrder());
        System.out.println("Reverse sorted : " + integerList);


        stringList.sort(Comparator.comparing(String::toString));


        List<Integer> integerList1 = integerList.stream()
                .filter(s->s>2).sorted()
                .collect(Collectors.toList());

        System.out.println("Filtered sorted: "  + integerList1);

        List<Integer> integerList2 = integerList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Stream reverse sorted : "  + integerList2);

        integerList.forEach(s-> System.out.println("for each sorted: " + s));

        List<Integer> integerList3 = integerList.stream().map(e->e+2).collect(Collectors.toList());
        System.out.println("Added: " + integerList3);

        System.out.println("Divided in for each: ");
        integerList.stream().map(k->k/2).forEach(System.out::println);

        integerList3.stream().max(Comparator.comparingInt(Integer::intValue))
                .ifPresent(o-> System.out.println("max in list3: " + o));

        Collections.sort(integerList);
        Collections.sort(stringList);

        System.out.println(integerList);
        System.out.println(stringList);

    }

    static void mapOperations() {

        Map<Integer,String> maph = new HashMap<>();

        maph.put(1,"nand");
        maph.put(4,"hini");
        maph.put(0,"Hema");


        Map<Integer, String> map = new TreeMap<>(maph);

        System.out.println("sorted map : " + map.keySet() + map.entrySet());

        for (Map.Entry<Integer,String> entry : map.entrySet() ) {
            out.println("keys : " + entry.getKey() + " values : " + entry.getValue());
        }

        maph.forEach((id,name) -> System.out.println("map for each : " + id + " " + name));

        maph.keySet().stream().sorted();
        System.out.println("sorted map : " + maph.keySet() + maph.entrySet());

        maph.entrySet().stream().sorted();
        System.out.println("sorted mapentry : " + maph);

        maph.values().stream().sorted();
        System.out.println("value: " + maph);

    }

    public static void main(String[] args) {

        System.out.println("Enter the total number for Fibonacci (>1):");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        createSeq(n);

        listOperations();
        mapOperations();


        /* USING ARRAYS ASLIST TO ADD OBJECTS TO LIST
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");

        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[]{e2,e3,e4,e5,e6,e7,e8,e9,e10}));

        static List<Employee> employeeList = Arrays.asList(
      new Employee("Tom Jones", 45, 7000.00),
      new Employee("Harry Major", 25, 10000.00),
      new Employee("Ethan Hardy", 65, 8000.00),
      new Employee("Nancy Smith", 22, 12000.00),
      new Employee("Deborah Sprightly", 29, 9000.00));

*/
       //TO MOVE THE VALUE 0 TO LAST
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,0,2,3,0,5,0));

        for (int i=0;i<integerList.size();i++){
            if (integerList.get(i) == 0) {
                integerList.add(0);
                integerList.remove(i);
            }
        }

        System.out.println("Altered List (solution): " + integerList);


    }
}
