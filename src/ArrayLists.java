import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislav Makarov
 */
public class ArrayLists {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for(int i =0;i<10;i++){
            list.add(i);
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        for(Integer x: list){
            System.out.println(x);
        }

        list.forEach(x-> System.out.println(x));

        //удаление не с конца очень не эффективно
        list.remove(5);
        System.out.println(list);
    }
}
