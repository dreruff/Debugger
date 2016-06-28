package debugger;

import interpreter.*;
import debugger.ui.UI;

/**
 *
 * @author dreruff
 */
public class Debugger {
    private UI ui;
    private DebuggerVirtualMachine dvm;
    private Interpreter interpreter;

    public Debugger(Interpreter interpreter) {
        this.interpreter = interpreter;
    }

    public void debugRun(String codeFile, ByteCodeLoader bcl) {
        Program program = bcl.loadCodes();
        dvm = new DebuggerVirtualMachine(program);
        //dvm.loadSource(codeFile);
        ui = new UI(dvm);
        
        while (dvm.getIsRunning())
            ui.userCommand();
    }
}
