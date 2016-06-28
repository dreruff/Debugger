package interpreter.bytecode;

import java.util.Vector;
import interpreter.VirtualMachine;

/**
 *
 * @author dreruff
 */
public class CallCode extends ByteCode implements AddressResolution {
    private String label;
    private int labelAddress;

    public void init(Vector<String> args) { label = (String) args.get(0); }

    public void execute(VirtualMachine vm) {
        vm.saveReturnAddrs();
        vm.setProgramCounter(labelAddress);
        vm.dump(this);
    }
    
    public void dump() {
        String str = "CALL ";
        str = str.concat(label);   
    }
    
    public String getLabel() { return label; }

    public void setAddress(int index) { labelAddress = index; }

    public int getAddress() { return labelAddress; }   
}