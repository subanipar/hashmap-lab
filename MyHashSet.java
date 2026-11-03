public class MyHashSet<E> {
   private Object[] hashArray;
   private int size;


   // constructor
   public MyHashSet() {
       hashArray = new Object[10000];
       size = 0;
   }


   // add
   public boolean add(E o) {
       // get the hash code
       int location = o.hashCode();


       // check if the slot is free + set location of the array
       if(hashArray[location] == null) {
           hashArray[location] = o;
           size ++;
           return true;
       }
       else {
           return false;
       }
   }
   // clear
   public void clear() {
       hashArray = new Object[100000];
       size = 0;
   }
   // contains
   public boolean contains(Object obj){
       int hashCode = obj.hashCode();
       if(hashArray[hashCode] != null){
           if(hashArray[hashCode].equals(obj)){
               return true;
           }
       }
       return false;
   }
   // remove
   public boolean remove(Object obj) {
       int hashCode = obj.hashCode();


       if (contains(obj)) {
               hashArray[hashCode] = null;
               size --;
               return true;
           }


       return false;
   }


   // size
   public int size() {
       return size;
   }
  
   // to DLList
   public DLList<E> toDLList() {
       DLList<E> list = new DLList();
       for(Object each : hashArray){
           if(each != null){
               list.add((E)each);
           }
       }      


       return list;
   }


  
}


/**Instance Variables.
- hashArray : Object[ ]
- size : int
Constructor(s)
+ MyHashSet() - Instantiate the hashArray. Make sure to have an array size big
enough to fit the hashCode numbers from the Student class. Set size to 0.
Method(s)
+ add(E) : boolean - Return true if successful.  If the element already exists,
leave it unchanged and return false.  Don't forget to adjust the size variable.
+ clear() : void - Clear out all elements.  Don't forget to adjust the size variable.
+ contains(Object) : boolean -  Get the hashcode and check if it exists in the array
location. Check if the element is the same by calling the equals method. Return true if
successful. 
+ remove(Object) : boolean - Get the hashcode and check if it exists in the array.  Check
if the element is the same by calling the equals method.  If all is true, remove it. (Hint: set
it to null).  Return true if successful.  Don't forget to adjust the size variable.
+ size() : int - Return the size.
+ toDLList : DLList<E> - This will return a DLList<E> of all the items in your
MyHashSet.  (Hint: One way to approach this is to create a DLList, go through the
hashtable, and all the non-null elements in it.  Return the DLList. )
Optionally, you can make it compatible with a for each loop.  (See slide 11. Link)
*/



