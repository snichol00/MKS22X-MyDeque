
import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    start = 0;
    end = 0;
    size = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
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
      for (int i = 0; i < end; i++){
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
      throw new NullPointerException();
    }
    if(size == data.length - 1){
      resize();
    }
    if (start == 0 && end == 0){
      data[0] = element;
      end++;
    }
    else if(start == 0){
      start = data.length - 1;
      data[start] = element;
    }
    else{
      start--;
      data[start] = element;
    }
    size++;
  }

  public void addLast(E element){
    if (element == null){
      throw new NullPointerException("Can't add null");
    }
    if (size == data.length - 1){
      resize();
    }
    if (end == data.length - 1){
      data[data.length - 1] = element;
      end = 0;
    }
    else{
      data[end] = element;
      end++;
    }
    size++;
  }

  public E removeFirst(){
    if (size == 0){
      throw new NoSuchElementException("Empty deque");
    }
    E output = data[start];
    data[start] = null;
    if (start == data.length - 1){
      start = 0;
    }
    else{
      start++;
    }
    size--;
    return output;
  }

  public E removeLast(){
    if (size == 0){
      throw new NoSuchElementException("Empty deque");
    }
    E output;
    if (end == 0){
      end = data.length;
      output = data[end];
    }
    else{
      output = data[end - 1];
      data[end - 1] = null;
      end--;
    }
    size--;
    return output;
  }

  public E getFirst(){
    if(size == 0){
      throw new NoSuchElementException();
    }
    return data[start];
  }

  public E getLast(){
    if(size == 0){
      throw new NoSuchElementException();
    }
    if(end == 0){
      return data[data.length - 1];
    }
    return data[end - 1];
  }

  @SuppressWarnings("unchecked")
  private void resize(){
    E[] temp = (E[])new Object[(2 * data.length) + 1];
    if (start < end){
      for (int i = 0; i + start < end; i++){
        temp[i] = data[i + start];
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
