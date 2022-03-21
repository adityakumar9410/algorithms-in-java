public class Array {

    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {

        //If the array is full , resize it
        if (items.length == count) {
            //create new array with double size
            int[] newItems = new int[count * 2];
            //copy all the existing items
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            //Set items to newItem
            items = newItems;
        }
        //Add new item at end
        items[count++] = item;
    }

    //Delete
    public void removeAt(int index) {
        //Validate index
        if (index < 0 || index > count)
            throw new IllegalArgumentException();
        //Shift item to left to fill hole
        for (int i = index; i < count; i++)
            items[i] = items[i + 1];
        count--;

    }

    //Search
    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;
    }

    //Print array TC : O(N)
    public void printArray() {
        for (int i = 0; i < count; i++) {
            System.out.print(items[i] + "   ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int[]arr={9,45,23,78,12,34,5,39,27,80};
        Array array = new Array(3);
        array.insert(12);
        array.insert(24);
        array.insert(27);
        array.insert(13);
        array.insert(68);
        array.insert(29);
        array.insert(90);
        array.removeAt(3);
        System.out.println(array.indexOf(68));
        array.printArray();
    }
}
