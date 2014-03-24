import java.util.Objects;

class List {
    private static final int INIT_LEN = 10;
    private Object[] items;  // the actual items
    private int numItems;     // the number of items currently in the list
    private int currentObject;//the number of current object

    /**
     *constructor: initialize the list to be empty */
    public List() {
        items = new Object[INIT_LEN];
        numItems = 0;
    }

    /**
     * auxiliary method for adding object
     */
    private void AddItem(Object ob){
        items[numItems] = ob;
        numItems++;
        currentObject = numItems - 1;
    }

    /**Given: Object ob
     * Do:    Add ob to the end of the list.*/
    public void AddToEnd(Object ob) {
        if (numItems < items.length) {
            AddItem(ob);
        } else {
            int currLength = items.length;//the length of the current list before increase it
            Object[] tmp = items;
            items = new Object[2 * currLength];
            System.arraycopy(tmp, 0, items, 0, currLength);//copy old objects to the new list
            AddItem(ob);
        }
    }

    /** Print (to standard output) the objects in the list in order, enclosed in
     * square brackets, separated by spaces.*/
    public void Print() {
        StringBuilder stmp = new StringBuilder("[");
        if (numItems > 0) {
            for (int i = 0; i < numItems; i++) {
                stmp.append(items[i] + " ");
            }
            stmp.deleteCharAt(numItems-1);
        }
        stmp.append("]");
        System.out.println(stmp.toString());
    }

    /**
    * set the first object as a current*/
    public void firstElement() {
        currentObject = 0;
    }

    /**
    * returns the current object, and also updates the currentObject field to "point to" the next object in the list*/
    public Object nextElement() {
        Object tmp = 0;
        if (currentObject < numItems && numItems != 0) {
            currentObject++;
            tmp = items[currentObject];
        }//here must be a check(exception) if the text is an error text or just content
        return tmp;
    }

    /**
    * returns true if the list is not empty and the current-object "pointer" hasn't "fallen off"
    * the end of the list (i.e., if there are still more items in the list that haven't been accessed yet).
    * Note that this method should return true when the current-object "pointer" is pointing
    * to the last object in the list -- it should only return false
    * when the list is empty or the current-object pointer has "fallen off" the end of the list.*/
    public boolean hasMoreElements() {
        return currentObject<(numItems - 1);
    }

    public static void main(String[] args) {
        List test1 = new List();
        test1.Print();//empty
        int n = 15;
        for (int k = 0; k < n; k++) {
            test1.AddToEnd(k);
        }
        test1.Print();
        test1.firstElement();
        while (test1.hasMoreElements()) {
            Object tmp = test1.nextElement();
            System.out.println(tmp);
        }
    }
}
