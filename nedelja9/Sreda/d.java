import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class domaci9nedelja {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,5,6,4,8,5,2,9,12,15,1,3);
//        Sve brojeve deljive sa 3 uvecati za 2
        List<Integer> p1=list.stream().filter(x-> x%3==0).map(x->x+2).collect(Collectors.toList());
        System.out.println(p1);
//        Izbaciti sve brojeve koji su deljivi sa 3 prilikom njihovog dupliranja
        List<Integer> p2 =
                list.stream().map(x->x*2).filter(x->x%3==0).collect(Collectors.toList());
        System.out.println(p2);
        //Pomnoziti svaki neparan broj sa 2 i izbaciti duplikate
        HashSet<Integer> s= list.stream().filter(x -> x % 2 != 0).map(x -> x * 2).collect(Collectors.toCollection(HashSet::new));
        System.out.println(s);
    }
}
