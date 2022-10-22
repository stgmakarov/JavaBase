import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Stanislav Makarov
 */
public class LinkedLists {
    static int arrSize = 1000000;
    public static void main(String[] args) {
        List<Integer> lnkLst = new LinkedList<>();
        List<Integer> arrLst = new ArrayList<>(arrSize);
        measureTime(lnkLst);
        measureTime(arrLst);
    }

    private static void measureTime(List<Integer> list){
        for(int i = 0;i<arrSize;i++){
            list.add(i);
        }
        long startTime = System.currentTimeMillis();

        for(int i = 0;i<arrSize/2;i++){
         list.remove(0);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime));
    }
}
