public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
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
    if (end == start - 1){
      resize();
      addFirst(element);
    }
    else if (start == 0){
      start = data.length - 1;
      data[start] = element;
    }
    else{
      start--;
      data[start] = element;
    }
  }

  public void addLast(E element){
    if (start == end - 1){
      resize();
      addLast(element);
    }
    else if (end == data.length - 1){
      end = 0;
      data[end] = element;
    }
    else{
      end++;
      data[end] = element;
    }
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
