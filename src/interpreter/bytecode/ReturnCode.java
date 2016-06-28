package interpreter.bytecode;

import java.util.Vector;
import interpreter.VirtualMachine;

/**
 *
 * @author dreruff
 */
public class ReturnCode extends ByteCode {
    protected String label; 
    protected int labelAddress;

    public void init(Vector<String> args) { 
        if(args.isEmpty())
            label = "";
        else
            label = (String) args.get(0);        
    }

    public void execute(VirtualMachine vm) {
        vm.popFrame();
        int pc = vm.popReturnAddrs();  
        vm.setProgramCounter(pc);
        vm.dump(this);
    }
        
    public void dump(){       
        String str = "RETURN ";
        if(!label.isEmpty())
            str = str.concat(label);  

        System.out.println(str);
    }      
}