package interpreter;

import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;
import interpreter.bytecode.*;

/**
 *
 * @author dreruff
 */
public class Program {
    private Vector <ByteCode> bytecodes;
    private HashMap<String, Integer> labelAddress;
    
    public Program() {
        bytecodes = new Vector();
        labelAddress = new HashMap();
    }
    
    public void set(ByteCode bytecode) {
        bytecodes.add(bytecode);
        
        if (bytecode instanceof LabelCode) {
            String label = ((LabelCode) bytecode).getLabel();
            Integer index = bytecodes.size() - 1;
            
            labelAddress.put(label, index);
        }
    }
    
    public ByteCode getCode(int i){ return bytecodes.get(i); }
    
    public void resolveAddress() {
        
        ByteCode bytecode;
        Integer index;

        Iterator<ByteCode> iterator = bytecodes.iterator();
        while (iterator.hasNext()) {

            bytecode = iterator.next();
            if (bytecode instanceof AddressResolution) {

                AddressResolution ar = (AddressResolution) bytecode;

                String label = ar.getLabel();
                index = labelAddress.get(label);
                ar.setAddress(index);
            }
        }
    }
}
