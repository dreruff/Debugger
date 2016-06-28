package interpreter.bytecode;

import java.util.Vector;
import interpreter.VirtualMachine;

/**
 *
 * @author dreruff
 */
public class WriteCode extends ByteCode {
    public void init(Vector<String> args){}
    
    public void execute(VirtualMachine vm){
        Integer i = vm.peek();
        vm.dump(this);
        
        System.out.println(i.toString());
    }
    
    public void dump() {
        System.out.println("WRITE");
    }
}
