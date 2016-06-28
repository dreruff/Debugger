package interpreter.bytecode;

import java.util.Vector;
import interpreter.VirtualMachine;

/**
 *
 * @author dreruff
 */
public class HaltCode extends ByteCode{
    
    public void init(Vector<String> args){}
    
    public void execute(VirtualMachine vm){ vm.stopVM(); }
    
    public void dump(){}
}