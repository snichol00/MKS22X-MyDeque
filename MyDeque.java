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
      output += data + " ";
    }
    return output + "]";
  }

  public void addFirst(E element){
    if (element == null){
      throw new NullPointerExcpetion();
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
      throw new NullPointerExcpetion();
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
      throw new NoSuchElementException();
    }
    data[start] = null;
    size--;
    if (start == data.length - 1){
      start = 0;
    }
    else{
      start++;
    }
  }

  public E removeLast(){
    if (size == 0){
      throw new NoSuchElementException();
    }
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

  private void resize(){
    int[] temp = new int[2 * size() + 1];
    for (int i = 0; i < data.length){
      temp[i] = data[i];
    }
    data = temp;
  }
}
