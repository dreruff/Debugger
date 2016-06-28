package debugger.ui;

import java.util.Vector;
import java.util.Scanner;
import debugger.DebuggerVirtualMachine;
import debugger.SourceCode;

/**
 *
 * @author dreruff
 */
public class UI {
    private DebuggerVirtualMachine dvm;
    private Vector<SourceCode> src;
    private Scanner scanner;
    int currentLine;
    //boolean firstPrint = true;
    
    public UI(DebuggerVirtualMachine dvm) {
        this.dvm = dvm;
        src = dvm.getSourceCode();
        scanner = new Scanner(System.in);
        currentLine = 1;
    }
    
    public void userCommand() {
        System.out.print("Type ? for help\n>> ");
        String line = scanner.next();
        if(line.equals("?")) {
            System.out.println();
            help();
            userCommand();
        } else if (line.equals("sb")) {
            setBreak();
            userCommand();
        } else if (line.equals("clr")) {
            clearBreak();
            userCommand();
        } else if (line.equals("fun")) {
            displayFunction();
            System.out.println();
            userCommand();
        } else if (line.equals("cont")) {
            continueExecution();  
        } else if (line.equals("quit")) {
            quitExecution();
        } else if (line.equals("var")) {
            displayVars();
            userCommand();
        } else {
            System.out.println("\n**** ERROR: Invalid Command \"?\" for list of Commands\n");
            userCommand();       
        }
    }
    
    public void help() {
        System.out.println("\n"
                + " Commands \n"
                + "?    help menu\n"
                + "sb   set breakpoints   (e.g. sb 3 6)\n"
                + "cb   clear breakpoints (e.g. cb 3 6)\n"
                + "fun   display current function\n"
                + "cont   continue execution\n"
                + "quit   quit execution\n"
                + "var   display vars in the current function\n"
                + "\n\n");
    }
    
    public void setBreak() {
        Vector<Integer> breakpoints = new Vector<>();
        
    }
    
    public void clearBreak() {
        
    }
    
    public void displayFunction(){
        
    }
    
    public void displayVars(){
        
    }
    
    public void continueExecution(){
        dvm.executeProgram();
    }
    
    public void quitExecution(){
        dvm.setIsRunning(false);
    }
}


