package interpreter.bytecode.debuggerByteCodes;

import debugger.DebuggerVirtualMachine;
import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;
import java.util.Vector;

/**
 *
 * @author dreruff
 */

public class DebugFormalCode extends ByteCode {
    private String var, offset;
    
    

    public void init(Vector<String> args){
        var = args.get(0);
        offset = args.get(1);
    }

    public void execute(VirtualMachine vm) {
        DebuggerVirtualMachine dvm = (DebuggerVirtualMachine) vm;
        //dvm.enterSymbol(var, dvm.getRunStackSize() - Integer.parseInt(offset));
    }
    
    public void dump() {}
    
    public String getOffset(){
        return offset;
    }
    
}