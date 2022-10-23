/**
 * @author Stanislav Makarov
 */
public class MyLinkedList {
    Node head;
    Node last;
    int size=0;

    public void add(int value, int position){
        if(position>size|position<0)throw new ArrayIndexOutOfBoundsException();

        if(size==0){
            head = new Node(value);
            last = head;
        } else if(size==1){
            if(position==0){
                last = head;
                head = new Node(value);
            }else {
                last = new Node(value);
            }
            last.setPrev(head);
            head.setNext(last);
        } else {
            if(position==0){
                Node temp = new Node(value, head, null);
                head = temp;
            }else if(position == size){
                Node temp = new Node(value, null, last);
                last = temp;
            }else {
                Node tempExists = get(position);
                Node temp = new Node(value,tempExists,tempExists.getPrev());
            }
        }
        size++;
    }

    public void rem(int position){
        if(position>size-1|position<0) new ArrayIndexOutOfBoundsException();
        if(size==1){
            head = null;
        } else if(size==2){
            if(position==0){
                head = last;
            }
            last = null;
            head.setNext(null);
            head.setPrev(null);
        } else {
            if(position==0){
                Node temp = head;
                head = head.getNext();
                temp.remove();
            }else if(position == size - 1){
                Node temp = last;
                last = last.getPrev();
                temp.remove();
            }else {
                get(position).remove();
            }
        }
        size--;
    }

    public void check(){
        for(int i=0;i<size;i++){
            Node checkedNode = get(i);
            assert checkedNode.getPrev() == null || checkedNode.getPrev().getNext() == checkedNode;
            assert checkedNode.getNext() == null || checkedNode.getNext().getPrev() == checkedNode;
        }
        assert size>0||head!=null;
        assert size>1||head!=null&last!=null;

        if (size>1){
            Node temp=head;
            while (temp.getNext()!=null){
                temp = temp.getNext();
            }
            assert temp==last;

            temp=last;
            while (temp.getPrev()!=null){
                temp = temp.getPrev();
            }
            assert temp==head;
        }

        assert head.getPrev() == null;
        assert last.getNext() == null;
    }


    public Node get(int position){
        if(position<0|position>(size-1)) throw new ArrayIndexOutOfBoundsException();

        int halfSize = size / 2;
        Node temp;
        int i;
        if(position<=halfSize){
            temp = head;
            i = 0;
            while (i<position){
                temp = temp.getNext();
                i++;
            }
        }else{
            temp = last;
            i = size - 1;
            while (i>position){
                temp = temp.getPrev();
                i--;
            }
        }
        return temp;
    }

    private class Node{
        private int value;
        private Node next;
        private Node prev;

        public String toString(){
            return String.valueOf(value);
        }

        public void remove(){
            if (next!=null & prev!=null){
                next.setPrev(prev);
                prev.setNext(next);
            }else if(next!=null){
                next.setPrev(null);
            }else if (prev!=null){
                prev.setNext(null);
            }
        }

        private Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
            if (next!=null){
                next.setPrev(this);
            }
            if(prev!=null){
                prev.setNext(this);
            }
        }
        private Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}
