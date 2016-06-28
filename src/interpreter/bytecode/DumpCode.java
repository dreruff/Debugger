package interpreter.bytecode;

import java.util.Vector;
import interpreter.VirtualMachine;


/**
 *
 * @author dreruff
 */
public class DumpCode extends ByteCode {
    private String status;
    
    public void init(Vector<String> args) { 
        status= (String)(args.get(0));
    }
    
    public void execute(VirtualMachine vm) {
        if(status.equals("ON"))
            vm.setDumping(true);
        else
            vm.setDumping(false);
    }
    
    public void dump(){}
}
