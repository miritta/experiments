import org.omg.PortableInterceptor.INACTIVE;

import java.util.Objects;

class List {
    private static final int INIT_LEN = 10;
    private Object[] items;  // the actual items
    private int numItems;     // the number of items currently in the list
    private int currentObject;//номер текущего объекта

    /* constructor: initialize the list to be empty
     */
    public List() {
        items = new Object[INIT_LEN];
        numItems = 0;
    }

    /*Given: Object ob
     * Do:    Add ob to the end of the list.
     */
    public void AddToEnd(Object ob) {
        if (numItems < items.length) {
            items[numItems] = ob;
            numItems++;
            currentObject = numItems - 1;
        } else {
            int l = items.length;
            Object[] tmp = items;
            items = new Object[2 * items.length];
            System.arraycopy(tmp, 0, items, 0, l);//скопировали старые объекты в новый большой список
            items[numItems] = ob;
            numItems++;
            currentObject = numItems;
        }
    }

    /* Print (to standard output) the objects in the list in order, enclosed in
     * square brackets, separated by spaces.
     */
    public void Print() {
        System.out.print("[");
        if (numItems > 0) {
            for (int i = 0; i < numItems; i++) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println("]");
    }

    /*
    * делает текущим первый объект*/
    public void firstElement() {
        currentObject = 0;
    }

    /*
    * returns the current object, and also updates the currentObject field to "point to" the next object in the list*/
    public Object nextElement() {
        Object tmp;
        if (currentObject < numItems && numItems != 0) {
            currentObject++;
            tmp = items[currentObject];
        } else {
            tmp = "error";
        }
        return tmp;
    }

    /*
    * returns true if the list is not empty and the current-object "pointer" hasn't "fallen off"
    * the end of the list (i.e., if there are still more items in the list that haven't been accessed yet).
    * Note that this method should return true when the current-object "pointer" is pointing
    * to the last object in the list -- it should only return false
    * when the list is empty or the current-object pointer has "fallen off" the end of the list.*/
    public boolean hasMoreElements() {
        boolean btmp = true;
        if (currentObject >= (numItems - 1)) {
            btmp = false;
        }
        return btmp;
    }

    public static void main(String[] args) {
        List test1 = new List();
        test1.Print();//empty
        int n = 15;
        for (int k = 0; k < n; k++) {
            test1.AddToEnd(k);
        }
        /*test1.AddToEnd("be");
        test1.AddToEnd("bu");
        test1.AddToEnd("br");
        test1.AddToEnd("bt");
        test1.AddToEnd("by");
        test1.AddToEnd("bi");
        test1.AddToEnd("bo");
        test1.AddToEnd("bp");*/
        test1.Print();
        test1.firstElement();
        while (test1.hasMoreElements()) {
            Object tmp = test1.nextElement();
            System.out.println(tmp);
        }
    }
}