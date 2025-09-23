public class LinkedList {
    private class Node{
        private IDedObject.AnyType obj;
        private Node next;

        public Node(IDedObject.AnyType o){
            obj = o;
            next = null;
        }
        public Node(IDedObject.AnyType o, Node n){
            obj = o;
            next = n;
        }

        public IDedObject.AnyType getObj() {
            return obj;
        }
        public Node getNext() {
            return next;
        }

        public void setObj(IDedObject.AnyType obj) {
            this.obj = obj;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }

    Node head;

    /**
     *  empties the linked list
     *  keeps deleting head until head is null;
     * */
    void makeEmpty(){
        while(deleteFromFront() != null);
    }

    /**
     *  searches nodes in linked list
     *  takes ID and finds the matching Object AnyType with id
     *  returns AnyType with same ID
     *  returns null, if not found
     * */
    IDedObject.AnyType findID(int ID){
        Node cur = head;
        while(cur!=null){
            if(cur.obj.getID() == ID){
                return cur.obj;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     *  first checks if list already has a node with same object
     *  if:  has same Anytype obj, return false;
     *  if not, make a new node with Anytype obj and returns true;
     * */
    boolean insertAtFront(IDedObject.AnyType x){
        if(findID(x.getID()) != null) return false;

        head = new Node(x, head);
        return true;
    }

    /**
     *  first checks if list is empty
     *  if:  is empty, return null;
     *  if not, capture current head and set head's next to new head
     *  return old head;
     * */
    IDedObject.AnyType deleteFromFront(){
        if(head == null) return null;

        Node cur = head;
        head = head.next;
        return cur.getObj();
    }

    /**
     *  iterates through linked list capturing node and previous node.
     *  if: node has same ID, set previous node's next to node's next
     *      return node's AnyType obj
     *  if not found, return null
     * */
    IDedObject.AnyType delete(int ID){
        //Check head first
        if(head.obj.getID() == ID){
            return deleteFromFront();
        }

        // continue
        Node prev = head;
        Node cur = head.next;
        while(cur != null){
            if(cur.obj.getID() == ID){
                prev.next = cur.next;
                return cur.obj;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    /**
     *  if list empty(head null), print "This list is empty!"
     *  else, iterate through list, print each Node's AnyType
     * */
    void printAllRecords(){
        if(head == null) System.out.println("This list is Empty!");

        Node cur = head;
        while(cur != null){
            cur.obj.printID();
            System.out.println();

            cur = cur.next;
        }
    }

}
