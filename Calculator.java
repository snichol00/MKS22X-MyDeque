public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
     String[] input;
    public static double eval(String s){
      intput = s.split(" ");
      for (int i = 0; i < input.length; i++){
        if (input[i] == "+" ||input[i] == "-" ||input[i] == "*" ||input[i] == "/"){
          Integer.parseInt(input[i-2]) /*opeerator*/ Integer.parseInt(input[i-2])
        }
      }
    }
}
