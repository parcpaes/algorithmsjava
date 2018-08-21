import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {

    private List<String> postFix(String cad){
        List<String> pos= new ArrayList<>();
        Stack<String> num = new Stack<>();
        String expression[] = cad.split(" ");

        for(int i=0;i<expression.length;i++){
            if(expression[i].matches("[\\+\\-\\*\\/\\^]")){

                while(!num.isEmpty() && num.peek() !="(" && hasHigherPresedence(num.peek(),expression[i])) pos.add(num.pop());
                num.push(expression[i]);

            }else if(expression[i].matches("[0-9]+")){
                pos.add(expression[i]);
            }else if(expression[i].equals("(")){
                num.push(expression[i]);
            }else if(expression[i].equals(")")){
                while(!num.isEmpty() && (!num.peek().equals("("))) pos.add(num.pop());
                num.pop();
            }
        }
        while(!num.isEmpty()) pos.add(num.pop());
        return pos;
    }
    private int getOperatorWeight(String op){
        switch(op){
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
        }
        return -1;
    }
    private boolean hasHigherPresedence(String a, String b){
        int op1 = getOperatorWeight(a);
        int op2 = getOperatorWeight(b);
        if(op1 == op2){
            if(a.equals("^")) return false;
            else return true;
        }
        return op1 > op2 ? true: false;
    }
    public long evalutePostfix(List<String> expression){
        Stack<Long> operand = new Stack<>();
        for(String ex: expression){
            if(ex.matches("[0-9]+")){
                operand.push(Long.parseLong(ex));
            }else{
                long op2 = operand.pop();
                long op1 = operand.pop();
                long result = performOp(ex, op1, op2);
                operand.push(result);
            }
        }
        return operand.pop();
    }
    private long performOp(String operator, long op1, long op2){
        if(operator.equals("+")) return op1 + op2;
        if(operator.equals("-")) return op1 - op2;
        if(operator.equals("*")) return op1 * op2;
        if(operator.equals("/")) return op1 / op2;
        return (int)Math.pow(op1, op2);
    }
    public static void main(String arg[]){
        Calculator cal = new Calculator();
        List<String> postfix = cal.postFix("2 ^ 3 ^ 2");
        System.out.println(cal.evalutePostfix(postfix));
    }
}