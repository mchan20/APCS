import java.util.*;
public class Calculator {
    public static double eval(String s){
        //turn string into list of numbers and operations
        String[] thing = s.split(" ");
        //make stack to hold everything
        Stack<Double> stack = new Stack<Double>();
        //start parsing data
        for (String a : thing) {
            if (a.equals("+")) {
                if (stack.size() < 2) throw new IllegalArgumentException("too many operands");
                double second = stack.pop();
                double first = stack.pop();
                stack.push(first + second);
            }
            else if (a.equals("-")) {
                if (stack.size() < 2) throw new IllegalArgumentException("too many operands");
                double second = stack.pop();
                double first = stack.pop();
                stack.push(first - second);
            }
            else if (a.equals("*")) {
                if (stack.size() < 2) throw new IllegalArgumentException("too many operands");
                double second = stack.pop();
                double first = stack.pop();
                stack.push(first * second);
            }
            else if (a.equals("/")) {
                if (stack.size() < 2) throw new IllegalArgumentException("too many operands");
                double second = stack.pop();
                double first = stack.pop();
                stack.push(first / second);
            }
            else if (a.equals("%")) {
                if (stack.size() < 2) throw new IllegalArgumentException("too many operands");
                double second = stack.pop();
                double first = stack.pop();
                stack.push(first % second);
            }
            else {
                if (a.length() < 1) throw new IllegalArgumentException("too few operands");
                stack.push(Double.parseDouble(a));
            }
        }
        if (stack.size() > 1) throw new IllegalArgumentException("too few operands");
        return stack.pop();   
    }

    // public static void main(String[] args) {
    //     String[] blah = "1234".split(" ");
    //     double lala = eval("1 2 3 4 5 + * - -");
    //     System.out.println(lala);
    //     System.out.println(Arrays.toString(blah));
    // }


}