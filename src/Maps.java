import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Stanislav Makarov
 */
public class Maps {
    public static void main(String[] args) {
        Map<Integer,String> hashMaps = new HashMap<>(); //нет порядка элементов
        Map<Integer,String> linkedHashMap = new LinkedHashMap<>(); //есть порядок элементов (порядок добавления)
        Map<Integer,String> treeMap = new TreeMap<>(); //пары отсортированы по ключу

        testMap(hashMaps);
        testMap(linkedHashMap);
        testMap(treeMap);
    }

    public static void testMap(Map<Integer,String> map){
        System.out.println("-----------------------");
        map.put(39,"Bob");
        map.put(12,"Mike");
        map.put(78,"Tom");
        map.put(0,"Tim");
        map.put(1500,"Lewis");
        map.put(7,"Bob");

        map.forEach((k,v)->{
            System.out.println(k+" = "+v);
        });

/*        for(Map.Entry<Integer,String> entry: map.entrySet()){
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }*/
    }
}
