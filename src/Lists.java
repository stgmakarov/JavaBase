import java.util.ArrayList;

/**
 * @author Stanislav Makarov
 */
public class Lists {
    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for(int i =0;i<100;i++){
            integerArrayList.add(1);
        }
        System.out.println(integerArrayList);
    }
}
