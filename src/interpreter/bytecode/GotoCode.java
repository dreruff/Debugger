package interpreter.bytecode;

import java.util.Vector;
import interpreter.VirtualMachine;

/**
 *
 * @author dreruff
 */
public class GotoCode extends ByteCode implements AddressResolution {
    private String label;
    private int labelAddress;
    
    public void init(Vector<String> args){
        label = args.get(0);
    }
    
    public void execute(VirtualMachine vm) {
        vm.setProgramCounter(labelAddress);
        vm.dump(this);
    }
    
    public void dump() {
        String str = "GOTO "; str = str.concat(label);
        System.out.println(str);
    }
    
    public String getLabel() { return label; }
    
    public void setAddress(int index){ labelAddress = index; }
    
    public int getAddress(){ return labelAddress; }
}