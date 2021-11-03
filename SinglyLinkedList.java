package SinglyLinkedList;

/**
 * @author HUSEYIN EMRE UGDUL
 * @since 3.11.2021
 */
public class SinglyLinkedList<E> {
    private static class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E value){
            this.data = value;
            next = null;
        }
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size;
    public void insertFirst(E value){
        Node<E> temp = new Node<>(value);
        if (head == null){
            head = temp;
            tail = temp;
            size++;
            return;
        }
        temp.next = head;
        head = temp;
        size++;
    }
    public void insertLast(E value){
        Node<E> temp = new Node<>(value);
        if (tail == null){
            insertFirst(value);
        }
        tail.next = temp;
        tail = temp;
        size++;
    }
    public void insert(E value, int position){
        if (position<0){
            throw new IllegalArgumentException("position cant be smaller than"
                                               + " 0");
        }
        if (position == size){
            insertLast(value);
            return;
        }
        if (position == 0){
            insertFirst(value);
            return;
        }
        Node<E> temp = new Node<>(value);
        Node<E> temp2 = head;
        for (int i = 0; i < position - 1; i++) {
            temp2 = temp2.next;
        }
        temp.next = temp2.next;
        temp2.next = temp;
        size++;
    }
    public void delete(int position){
        if (position>size){
            throw new IllegalArgumentException("position cant bigger than "
                                               + "size");
        }
        if (position == 0){
            head = head.next;
            size--;
            return;
        }
        if (position == size - 1){
            Node<E> temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
            return;
        }
        Node<E> temp = head;
        for (int i = 0; i < position - 2; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }
    public void update(E value, int position){
        Node<E> temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        temp.data =value;
    }
    public String toString(){
        Node<E> temp = head;
        StringBuilder sb = new StringBuilder();
        while(temp != null){
            sb.append(temp.data).append(" ");
            temp = temp.next;
        }
        return sb.toString();
    }
    public static void main(String[] args) {

    }
}
