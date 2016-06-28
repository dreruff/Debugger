package debugger;

import java.util.Vector;
import java.util.Stack;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import interpreter.*;
import interpreter.bytecode.*;

/**
 *
 * @author dreruff
 */
public class DebuggerVirtualMachine extends VirtualMachine {
    private Vector<SourceCode> src;
    private Stack<FunctionEnvironmentRecord> ferStack;
    private FunctionEnvironmentRecord fer;
    private SourceCode srcLine;
    
    public DebuggerVirtualMachine(Program program){
        super(program);
        
        src = new Vector<>();
        ferStack = new Stack<>();
        fer = new FunctionEnvironmentRecord();
        
        runStack = new RunTimeStack();
        returnAddrs = new Stack();
        pc = 0;
        isRunning = true;
        //startFunc = new Stack<>();
        //endFunc = new Stack<>(); 
    }
    
    public void executeProgram() {
        /*while (isRunning) {
            ByteCode code = program.getCode(pc);

            //Checking for potential breakpoint
            if (code instanceof DebugLineCode) {
                DebugLineCode tempLine = (DebugLineCode) code;

                //retrieving boolean isBreakpoint from Source object
                if (tempLine.getLineNum() > 0 && lineCode.get(tempLine.getLineNum() - 1).getIsBreakpoint()) {
                    
                    isStepOut = false;
                    isStepIn = false;
                    isStepOver = false;
                    
                    code.execute(this);
                    pc++;
                    code = program.getCode(pc);
 
                    //Executing the expected following function code
                    if (code instanceof DebugFunctionCode) {
                        code.execute(this);
                        pc++;
                        code = program.getCode(pc);

                        //Exectuing the expected formal(s) which may or may not be there
                        while (code instanceof DebugFormalCode) {
                            code.execute(this);
                            pc++;
                            code = program.getCode(pc);
                        }
                    }
                    //Returning control to the Debugger and then UI userCommand
                    break;
                }
            }
            
            //Find the new functionCode and save the start and end for later printing (FUNC)
            if (code instanceof DebugFunctionCode) {
                DebugFunctionCode temp = (DebugFunctionCode) code;
                startFunc.push(temp.getStart());
                endFunc.push(temp.getEnd());
            }

            if (isStepOut) {
                if (FERstack.size() == stackSize - 1) {
                    isStepOut = false;
                    break;
                }
            }

            if (isStepOver) {
                  if (FERstack.size() == stackSize && code instanceof DebugLineCode) {
                    code.execute(this);
                    pc++;
                    isStepOver = false;
                    break;
                } else if (FERstack.size() < stackSize) {
                    isStepOver = false;
                    break;
                }
            }

            if (isStepIn) {

                if (FERstack.size() == stackSize && code instanceof DebugLineCode) {
                    code.execute(this);
                    pc++;
                    isStepIn = false;
                    code = program.getCode(pc);
                     
                    //Executing the potential function code
                    if (code instanceof DebugFunctionCode) {
                        code.execute(this);
                        pc++;
                        code = program.getCode(pc);

                        //Exectuing the expected formal(s) which may or may not be there
                        while (code instanceof DebugFormalCode) {
                            code.execute(this);
                            pc++;
                            code = program.getCode(pc);
                        }
                    }
                    break;
                    
                } else if (FERstack.size() > stackSize) {
                    for (int i = 0; i < 2; i++) {
                        code.execute(this);
                        pc++;
                        code = program.getCode(pc);
                    }
                    while (code instanceof DebugFormalCode) {
                        code.execute(this);
                        pc++;
                        code = program.getCode(pc);
                    }
                    isStepIn = false;
                    break;
                }
            }

            code.execute(this);
            pc++;
        }
    }
    
    public void loadSource(String sourceFile) {
        try{
            Scanner in = (new Scanner(new FileReader(sourceFile)));
            String nextLine;

            while (in.hasNextLine()) {
                srcLine = new SourceCode();
                nextLine = in.nextLine();
                srcLine.setSourceLine(nextLine);
                src.add(srcLine);
            }
        } catch (IOException io) {
            System.out.print("IOException in Debugger VM");
        }*/
    }

    
    public Vector<SourceCode> getSourceCode() {
        return src;
    }
    
    public boolean getIsRunning() {
        return isRunning;
    }
    
    public void setIsRunning(boolean running) {
        isRunning = running;
    }

    public void newFunction() {
        ferStack.push(fer);
        fer = new FunctionEnvironmentRecord();
        fer.beginScope();
    }
    
    public void endFunction() {
        fer = ferStack.pop();
    }
}
