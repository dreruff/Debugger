package interpreter.bytecode;

import java.util.Vector;
import interpreter.VirtualMachine;

/**
 *
 * @author dreruff
 */
public class BopCode extends ByteCode{
    private String operator;
    
    public void init(Vector<String> args){ operator = args.get(0); }
    
    public void execute(VirtualMachine vm){
        int topOperand = vm.pop(); //uper leve is the second operand
        int bottomOperand = vm.pop();
        Integer result = new Integer(0);
        
        if(operator.equals("+"))
            result = bottomOperand + topOperand;
        
        else if(operator.equals("-"))
            result = bottomOperand - topOperand;
        
        else if(operator.equals("/"))
            result = bottomOperand / topOperand;
        
        else if(operator.equals("*"))
            result = bottomOperand * topOperand;
        
        else if(operator.equals("==")){
            if(bottomOperand == topOperand)
                result = 1;
            else
                result = 0;
        }
        else if(operator.equals("!=")){
            if(bottomOperand == topOperand)
                result = 0;
            else
                result = 1;
        }
        else if(operator.equals("<=")){
            if(bottomOperand <= topOperand)
                result = 1;
            else
                result = 0;
        }
        else if(operator.equals("<")){
            if(bottomOperand < topOperand)
                result = 1;
            else
                result = 0;
        }
        else if(operator.equals(">=")){
            if(bottomOperand >= topOperand)
                result = 1;
            else
                result = 0;
        }
        else if(operator.equals(">")){
            if(bottomOperand > topOperand)
                result = 1;
            else
                result = 0;     
        }
        else if(operator.equals("|")){
            if ((bottomOperand !=0) || (topOperand !=0))
                result = 1;
            else
                result = 0;
        }
        else if(operator.equals("&")){
            if((bottomOperand != 0)&&(topOperand != 0))
                result = 1;
            else
                result = 0;
        }
        
        vm.push(result);
        vm.dump(this);
    }   
    
    public void dump() {
        String str = "BOP "; str = str.concat(operator);
        System.out.println(str);
    }
}