package interpreter.bytecode;

import java.util.Vector;
import interpreter.VirtualMachine;

/**
 *
 * @author dreruff
 */
public class ArgsCode extends ByteCode {
    private int numOfArgs; 
    private Vector<String> args;
    
    public void init(Vector<String> args){
        numOfArgs = Integer.parseInt(args.get(0));
        this.args = args;
    }
    
    public void execute(VirtualMachine vm){ 
        vm.newFrameAt(numOfArgs); 
        vm.dump(this);
    }
        
    public void dump() {    
        String str = "ARGS "; str = str.concat(((Integer)numOfArgs).toString());
        System.out.println(str);
    }
}
