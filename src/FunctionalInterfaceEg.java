import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterfaceEg {

    private static void printInterface(int i,PrintMsg printMsg) {
        printMsg.printmsg(i);
    }

    static void print(int i,Consumer consumer) {
        consumer.accept(i);

    }

    static void check(String d, Predicate predicate) {
        predicate.test(d);
    }

    static void predicateex(List<String> list,Predicate<String> predicate) {
        for(String l: list) {
            if (predicate.test(l)) {
            System.out.println("String : " + l);
            }
        }
    }

    public static void main(String[] args) {
        int a = 10;
        String s = "hema";
        List<String> stringList = new ArrayList<>(Arrays.asList("hema","ma","grt","fre"));

        printInterface(a, new PrintMsg() {
            @Override
            public void printmsg(int i) {
                System.out.println("anonymous inner class: " + i);
            }
        });

        printInterface(a,(i) -> System.out.println("lambda myinterface :" + a));

        print( a,w -> System.out.println("Consumer interface : " + w));

        check(s,b-> {
            if (s.length() < 10) {
                System.out.println(s);
                return true;
            }
            return false;
        });

        predicateex(stringList,p->p.equalsIgnoreCase("ma"));
        predicateex(stringList,e->e.endsWith("t"));

    }
}

interface PrintMsg {

    void printmsg(int i);
}