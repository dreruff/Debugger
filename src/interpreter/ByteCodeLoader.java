package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import interpreter.bytecode.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author dreruff
 */
public class ByteCodeLoader {
    private BufferedReader source;
    
    public ByteCodeLoader(String programFile) throws IOException {
        source = new BufferedReader(new FileReader( programFile ) );
    }
    
    public Program loadCodes() {
        String key, code;
        String line;
        ByteCode bytecode;
        Vector<String> args = new Vector<>();
        
        Program program = new Program();
        
        try {
            line = source.readLine();
            
            while(line != null) {
                StringTokenizer tok = new StringTokenizer(line);
                
                key = tok.nextToken();
                code = CodeTable.get(key);
                bytecode = (ByteCode) (Class.forName("interpreter.bytecode." + code).newInstance());
                System.out.println(code);
                
                while (tok.hasMoreTokens()) 
                    args.add(tok.nextToken());
                
                bytecode.init(args);
                
                program.set(bytecode);
                
                args.clear();
                
                line = source.readLine();
                
                
            }
            
        } catch (IOException e ) {
            System.out.println(e.getMessage());
            //System.out.println("***file not found***");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            //System.out.println("***class not found: " + e + "***");
        } catch (InstantiationException e) {
            System.out.println(e.getMessage());
            //Logger.getLogger(ByteCodeLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
            //Logger.getLogger(ByteCodeLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        program.resolveAddress();
        return program;
    }
}
