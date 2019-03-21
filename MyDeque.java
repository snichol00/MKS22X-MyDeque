public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){

  }

  public MyDeque(int initialCapacity){

  }

  public int size(){
    return size;
  }

  public String toString(){
    String output = "[";
    for (int y = 0; y < data.length; y++){
      output += data + ", ";
    }
    return output + "]";
  }

  public void addFirst(E element){

  }

  public void addLast(E element){

  }

  public E removeFirst(){
    data[start] = null;
    if (start == data.length - 1){
      start = 0;
    }
    else{
      start++;
    }
  }

  public E removeLast(){
    data[end] = null;
    if (end == 0){
      end = data.length - 1;
    }
    else{
      end--;
    }
  }

  public E getFirst(E element){
    return data[start];
  }

  public E getLast(E element){
    return data[end];
  }
}
