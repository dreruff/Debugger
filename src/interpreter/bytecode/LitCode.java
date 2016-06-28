package interpreter.bytecode;

import java.util.Vector;
import interpreter.VirtualMachine;

/**
 *
 * @author dreruff
 */
public class LitCode extends ByteCode{
    private int literal;
    private String id;
    
    public void init(Vector<String> args){
         id = "";
         literal = Integer.parseInt(((String)args.get(0)));
         if(args.size() > 1)
             id = (String)args.get(1);      
    }
    
    public void execute(VirtualMachine vm){
        vm.push(literal);
        vm.dump(this);  
    }
    
    public void dump() {
        String str = "LIT "; str = str.concat(((Integer)literal).toString());
        if(!id.isEmpty())  
            str = str.concat(" "+ id+ "   int "+ id);
        
        System.out.println(str);
    }
}