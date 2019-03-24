import java.util.NoSuchElementException;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    start = 0;
    end = 0;
    size = 0;
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = 0;
    end = 0;
    size = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String output = "{}";
    for (int y = 0; y < data.length; y++){
      output += data + " ";
    }
    return output + "}";
  }

  public void addFirst(E element){
    if (element == null){
      throw new NullPointerException("Can't add null");
    }
    else if (end == start - 1){
      resize();
      addFirst(element);
    }
    else if (start == 0){
      start = data.length - 1;
      data[start] = element;
      size++;
    }
    else{
      start--;
      data[start] = element;
      size++;
    }
  }

  public void addLast(E element){
    if (element == null){
      throw new NullPointerException("Can't add null");
    }
    else if (start == end - 1){
      resize();
      addLast(element);
    }
    else if (end == data.length - 1){
      end = 0;
      data[end] = element;
      size++;
    }
    else{
      end++;
      data[end] = element;
      size++;
    }
  }

  public E removeFirst(){
    if (size == 0){
      throw new NoSuchElementException("Empty deque");
    }
    E output = data[start];
    data[start] = null;
    size--;
    if (start == data.length - 1){
      start = 0;
    }
    else{
      start++;
    }
    return output;
  }

  public E removeLast(){
    if (size == 0){
      throw new NoSuchElementException("Empty deque");
    }
    E output = data[end];
    data[end] = null;
    size--;
    if (end == 0){
      end = data.length - 1;
    }
    else{
      end--;
    }
    return output;
  }

  public E getFirst(E element){
    return data[start];
  }

  public E getLast(E element){
    return data[end];
  }

  private void resize(){
    @SuppressWarnings("unchecked")
    E[] temp = (E[])new Object[2 * size + 1];
    if (start < end){
      for (int i = 0; i < data.length; i++){
        temp[i] = data[i];
      }
    }
    if(start > end){
      int idx = 0;
      for(int i = start; i < data.length; i++){
        temp[idx] = data[i];
        idx++;
      }
      for(int i = 0; i < end; i++){
        temp[idx] = data[i];
        idx++;
      }
    }
    data = temp;
    start = 0;
    end = size;
  }
}
