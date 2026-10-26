class Node<E> {
    // instance variables
    private E data;
    private Node<E> next, prev;

    // constructor
    public Node(E dataL) {
        data = dataL;
        next = null;
        prev = null;
    }
    
    // methods
    public E get() {
      return data;
    }
    
    public Node<E> next() {
      return next;
    }
    
    public Node<E> prev() {
      return prev;
    }
    
    public void setNext(Node<E> next) {
      this.next = next;
    }
    
    public void setPrev(Node<E> prev) {
      this.prev = prev;
    }
    
    public void setData(E elem){
      data = elem;
    }
}

public class DLList<E> {
  //instance variables
  private Node<E> head, tail;
  private int size;
  
  //constructors
  public DLList(){
    head = new Node<E>(null);
    tail = new Node<E>(null);
    size = 0;
    head.setNext(tail);
    tail.setPrev(head);
  }
  
  //methods
  public boolean add(E elem){
        Node<E> newNode = new Node<>(elem);
        // connect new node to the one before it
        tail.prev().setNext(newNode);
        newNode.setPrev(tail.prev());
        // connect new node to the tail
        newNode.setNext(tail);
        tail.setPrev(newNode);
        size++;
        return true;
  }

  public void add(int index, E elem){
    Node<E> adding = new Node<E>(elem); //node new
    
    Node<E> atInd = getNode(index); //node at the right spot/index
    Node<E> before = atInd.prev();
    Node<E> after = atInd;

    adding.setNext(after);
    adding.setPrev(before);
    before.setNext(adding);
    after.setPrev(adding);
    size ++;
  }
  
  public E get(int index){
    return getNode(index).get();
  }
  
  public boolean contains(Object obj){
    if(size > 0){
      Node<E> current = head.next();
      for(int i = 0; i < size; i++){
        if(current.get().equals(obj)){
          return true;
        }
        current = current.next();
      }
      return false;
    }
    return false;
  }
  
  public E remove(int index){
    if(size > 0){
      Node<E> toRemove = getNode(index);
      toRemove.prev().setNext(toRemove.next());
      toRemove.next().setPrev(toRemove.prev());
      size --;
      return toRemove.get();
    }
    return null;
  }
  
  public int size(){
    return size;
  }
  
  public E set(int index, E elem){
    Node<E> find = getNode(index);
    Node<E> replaced = find;
    find.setData(elem);
    return replaced.get();
  }
  
  public String toString(){
    if(size > 0){
      String toReturn = "[";
      Node<E> current = head;
      for (int i = 0; i < size - 1; i++) { // until one before the last
        current = current.next();
        toReturn += current.get() + ", ";
      }
      toReturn += current.next().get() + "]";
      return toReturn;
    }
    return "[]";
  }
  
  private Node<E> getNode(int index){
    if(size > 0){ //make sure it isn't empty
      Node<E> current = null;
      if(size/2 < index){ // closer to end
        current = tail.prev();
        for(int i = 0; i < size - index; i++){
          current = current.prev();
        }
      }
      else{ //closer to front
        current = head.next();
        for(int i = 0; i < index; i++){
          current = current.next();
        }
      }
      return current;
    }
    return null;
  }
  
  
  public void scramble() {
    Node<E> current = head;
    Node<E> toSwitch = null;
    for (int i = 0; i < size; i++) {
      current = current.next();
      int index = (int)(Math.random()*size());
      
      E temp = current.get();
      current.setData(getNode(index).get());
      getNode(index).setData(temp);
    }
  }
}
