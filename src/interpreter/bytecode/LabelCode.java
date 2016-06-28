package interpreter.bytecode;

import java.util.Vector;
import interpreter.VirtualMachine;

/**
 *
 * @author dreruff
 */
public class LabelCode extends ByteCode{
    private String label;
    
    public void init(Vector<String> args){ label = args.get(0); }
    
    public void execute(VirtualMachine vm){ vm.dump(this); }
        
    public void dump() {
        String str = "LABEL "; str = str.concat(label);
        System.out.println(str);
    }    
     
    public String getLabel(){ return label; }
}