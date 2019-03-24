import java.util.NoSuchElementException;
import java.util.*;

public class MyDeque<E>{
  @SuppressWarnings("unchecked")
  private E[] data;
  private int size, start, end;
  public MyDeque(){
    data = (E[])new Object[10];
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
    String output = "{";
    if (start < end){
      for (int i = 0; i < data.length; i++){
        output += data[i] + " ";
      }
    }
    if (start > end){
      for(int i = start; i < data.length; i++){
        output += data[i] + " ";
      }
      for(int i = 0; i < end; i++){
        output += data[i] + " ";
      }
    }
    return output + "}";
  }

  public void addFirst(E element){
    if (element == null){
      throw new NullPointerException("Can't add null");
    }
    if(size == data.length-1){
      resize();
      size++;
    }
    if (start == 0 && end == 0){
      start = data.length - 1;
      data[start] = element;
      size++;
    }
    else if(start == 0){
      data[data.length - 1] = element;
      start = data.length - 1;
      size ++;
    else{
      data[start] = element;
      start--;
      size++;
    }
  }

  public void addLast(E element){
    if (element == null){
      throw new NullPointerException("Can't add null");
    }
    if (start == data.length - 1){
      resize();
    }
    if (end == data.length - 1){
      data[data.length - 1] = element;
      end = 0;
      size++;
    }
    else{
      data[end] = element;
      end++;
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
    if(size == 0){
      throw new NoSuchElementException();
    }
    return data[start];
  }

  public E getLast(E element){
    if(size == 0){
      throw new NoSuchElementException();
    }
    return data[end];
  }

  @SuppressWarnings("unchecked")
  private void resize(){
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
