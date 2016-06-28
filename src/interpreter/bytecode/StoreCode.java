package interpreter.bytecode;


import java.util.Vector;
import interpreter.VirtualMachine;

/**
 *
 * @author dreruff
 */
public class StoreCode extends ByteCode{
    private int literal, storeVar; 
    private String id;
    
    public void init(Vector<String> args){
         literal = Integer.parseInt(((String)args.get(0)));
         id = (String)args.get(1);     
    }
    
    public void execute(VirtualMachine vm){
        storeVar = vm.peek();
        vm.store(literal);
        vm.dump(this);
    }
    
    public void dump(){
        String str = "STORE "; Integer lit = literal;
        str = str.concat(lit.toString() + " "+ id + "  " + id 
                + " = " + storeVar);
        System.out.print(str);
    }
}