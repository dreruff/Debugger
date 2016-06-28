package interpreter.bytecode.debuggerByteCodes;

import interpreter.bytecode.CallCode;
import interpreter.VirtualMachine;
import debugger.DebuggerVirtualMachine;

/**
 *
 * @author dreruff
 */
public class DebugCallCode extends CallCode {
    public void execute(VirtualMachine vm){
        DebuggerVirtualMachine dvm = (DebuggerVirtualMachine) vm;
        super.execute(dvm);
        dvm.newFunction();
    }
}
