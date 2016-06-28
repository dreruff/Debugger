package interpreter.bytecode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;
import java.io.IOException;
import interpreter.VirtualMachine;

//import javax.swing.JOptionPane;

/**
 *
 * @author dreruff
 */
public class ReadCode extends ByteCode{
    
    public void init(Vector<String> args){}
    
    public void execute(VirtualMachine vm){
        try {
            //String readStr = JOptionPane.showInputDialog("Enter an integer:");
            BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
            String line = in.readLine();
            int input = Integer.parseInt(line);
            vm.push(input);
            vm.dump(this);
        } catch( IOException ex ) {}    
    }
    
    public void dump() {
        System.out.println("READ");
    }
}