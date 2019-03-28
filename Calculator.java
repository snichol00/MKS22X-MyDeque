public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      //makes an array of the terminal input
      String [] input = s.split(" ");
      MyDeque<int> deque = new MyDeque<int>();
      for (int i = 0; i < input.length; i++){
        if (input[i] == "+"){
          int second = deque.removeLast();
          int first = deque.removeLast();
          deque.addLast(first + second);
        }
        if (input[i] == "-"){
          int second = deque.removeLast();
          int first = deque.removeLast();
          deque.addLast(first - second);
        }
        if (input[i] == "*"){
          int second = deque.removeLast();
          int first = deque.removeLast();
          deque.addLast(first * second);
        }
        if (input[i] == "/"){
          int second = deque.removeLast();
          int first = deque.removeLast();
          deque.addLast(first / second);
        }
        if (input[i] == "%"){
          int second = deque.removeLast();
          int first = deque.removeLast();
          deque.addLast(first % second);
        }
      }
      return deque.getFirst();
    }

}
