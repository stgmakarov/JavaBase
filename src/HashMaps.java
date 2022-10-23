import java.util.HashMap;
import java.util.Map;

/**
 * @author Stanislav Makarov
 */
public class HashMaps {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1,"Один");
        hashMap.put(2,"Два");
        hashMap.put(3,"Три");

        hashMap.forEach((k,v) -> System.out.println(k + "=" + v));

        for(Map.Entry<Integer,String> entry:hashMap.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }
}
