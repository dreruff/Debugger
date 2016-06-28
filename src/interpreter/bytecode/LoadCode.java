package interpreter.bytecode;

import java.util.Vector;
import interpreter.VirtualMachine;

/**
 *
 * @author dreruff
 */
public class LoadCode extends ByteCode{
    private int offset; 
    private String id;
    
    public void init(Vector<String> args){
         offset = Integer.parseInt(((String)args.get(0)));
         id = (String)args.get(1);
    }
    public void execute(VirtualMachine vm){
        vm.load(offset); 
        vm.dump(this);
    }
    
    public void dump() {
        String str = "LOAD "; str= str.concat(((Integer)offset).toString());
        if(!id.isEmpty())  
            str=str.concat(" "+ id+ "   int"+ id +"   <load "+ id+ ">");
        
        System.out.println(str);
    }
}
