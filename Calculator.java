public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      //makes an array of the terminal input
      String [] input = s.split(" ");
      MyDeque<Double> deque = new MyDeque<Double>();
      for (int i = 0; i < input.length; i++){
        if (input[i].equals("+")){
          Double second = deque.removeLast();
          Double first = deque.removeLast();
          deque.addLast(first + second);
        }
        if (input[i].equals("-")){
          Double second = deque.removeLast();
          Double first = deque.removeLast();
          deque.addLast(first - second);
        }
        if (input[i].equals("*")){
          Double second = deque.removeLast();
          Double first = deque.removeLast();
          deque.addLast(first * second);
        }
        if (input[i].equals("/")){
          Double second = deque.removeLast();
          Double first = deque.removeLast();
          deque.addLast(first / second);
        }
        if (input[i].equals("%")){
          Double second = deque.removeLast();
          Double first = deque.removeLast();
          deque.addLast(first % second);
        }
      }
      return deque.getFirst();
    }

}
