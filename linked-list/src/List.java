import java.util.NoSuchElementException;

class List {

    /**
     * class for linked list
     */
    private static class ListNode {
        private final Object item;//current node info
        private ListNode next;//pointer to the next node

        public ListNode(Object ob) {
            item = ob;
        }

        public Object getObject() { //method to get the content of the node
            return item;
        }

        public void setNext(ListNode node) {
            next = node;
        }

        public ListNode getNext() {
            return next;
        }
    }

    public class Iterator {
        private ListNode currentObject;//pointer to the current object

        /**
         * set the first object as a current
         */
        private Iterator() {
            currentObject = header;
        }

        public boolean hasMoreElements() {
            return currentObject.getNext() != null;
        }

        public Object nextElement() {
            if (currentObject.getNext() != null) {
                currentObject = currentObject.getNext();
            } else {
                throw new NoSuchElementException();
            }
            return currentObject.getObject();
        }
    }

    private final ListNode header;//declared a pointer to the list itself, i.e. to the first node
    private ListNode currentLast;//pointer to the current last element

    /**
     * constructor: initialize the list to be empty
     */
    public List() {
        header = new ListNode(null);
        currentLast = header;
    }

    /**
     * Given: Object ob
     * Do:    Add ob to the end of the list.
     */
    public void addToEnd(Object ob) {
        ListNode newNode = new ListNode(ob);//new node
        currentLast.setNext(newNode);
        currentLast = newNode;//set the new node as the last node
    }

    /**
     * Given: Object ob
     * Do:    Add ob to the start of the list.
     */
    public void addToStart(Object ob) {
        ListNode newNode = new ListNode(ob);//new node
        newNode.setNext(header.getNext());//set the pointer of the new node as pointer to the old second element, i.e. as the old pointer of the header
        header.setNext(newNode);//set the pointer of the header to the new next element
    }

    public Iterator iterator() {
        return new Iterator();
    }

    /**
     * Print (to standard output) the objects in the list in order, enclosed in
     * square brackets, separated by spaces.
     */
    public void print() {
        StringBuilder builder = new StringBuilder("[");
        Iterator iterator = new Iterator();
        if (iterator.hasMoreElements()) {
            builder.append(iterator.nextElement());
        }
        while (iterator.hasMoreElements()) {
            builder.append(", ").append(iterator.nextElement());
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

    /**
     * returns the current object, and also updates the currentObject field to "point to" the next object in the list
     */

    /**
     * returns true if the list is not empty and the current-object "pointer" hasn't "fallen off"
     * the end of the list (i.e., if there are still more items in the list that haven't been accessed yet).
     * Note that this method should return true when the current-object "pointer" is pointing
     * to the last object in the list -- it should only return false
     * when the list is empty or the current-object pointer has "fallen off" the end of the list.
     */

    public static void main(String[] args) {
        List list = new List();
        list.print();//empty
        list.addToEnd("boo");
        int n = 400;
        for (int k = 0; k < n; k++) {
            list.addToEnd(k);
            list.addToStart(k);
        }
        list.print();
        Iterator iterator = list.iterator();
        int i = 0;
        try {
            while (true) {
                iterator.nextElement();
                i++;
            }
        } catch (NoSuchElementException e) {
            System.out.println(i);
        }
    }
}

