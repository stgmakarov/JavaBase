/**
 * @author Stanislav Makarov
 */
public class MyArrTest {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.add(1,0);
        myList.add(2,1);
        myList.add(3,2);
        myList.add(4,3);
        myList.add(5,4);
        myList.add(6,5);
        myList.add(7,6);
        myList.add(8,7);

        myList.check();

        myList.add(9,3);
        myList.rem(3);
        myList.rem(0);
        myList.rem(myList.size-1);
        myList.rem(0);

        myList.check();

        myList.rem(0);
        myList.rem(0);
        myList.rem(0);
        myList.rem(1);

        for(int i=0;i< myList.size;i++) System.out.println(myList.get(i));


    }
}
