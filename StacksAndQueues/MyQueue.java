//implementing a queue in same way has stack. thinking of using same approach of linked list
//add(): add the element at the top of the list
//remove(): remove the element from the end of the list
//peek(): return the element from the end of the list
//isEmpty(): return true if the list is empty

class Queue<T>{
    private static class Node<T>{
        private T data;
        private Node<T> next;
        public Node(T data){
            this.data=data;
        }

        private Node<T> first;
        private Node<T> last;

        public void add(T data){
            Node<T> node = new Node<T>(data);
            last.next = node;
            last = node;
        }

        public T pop(){
            if(first==null) throw new NoElementFoundException();
            T data = first.data;
            first = first.next;
            return data;
        }
    }
}