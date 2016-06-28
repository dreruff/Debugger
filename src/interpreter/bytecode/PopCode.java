package interpreter.bytecode;

import java.util.Vector;
import interpreter.VirtualMachine;

/**
 *
 * @author dreruff
 */
public class PopCode extends ByteCode{
    private int numOfPops;
    
    public void init(Vector<String> args){
        numOfPops = Integer.parseInt(((String)args.get(0)));
    }
    
    public void execute(VirtualMachine vm){ 
        for(int i=1; i <= numOfPops; i++)
            vm.pop();
        
        vm.dump(this);
    }
    
    public void dump() {
        String str = "POP "; str = str.concat(((Integer)numOfPops).toString()); 
        System.out.println(str);
    }
}
