package interpreter;

import java.util.Stack;
import interpreter.bytecode.*;

/**
 *
 * @author dreruff
 */
public class VirtualMachine {
    protected int pc;     //-- the program counter
    protected Stack<Integer> returnAddrs; //-- push/pop when call/return functions
    protected RunTimeStack runStack;
    protected boolean isRunning;      //-- true while the VM is running
    protected Program program;        //-- bytecode program
    protected boolean isDumping;      
    
    public VirtualMachine(Program program) {
        this.program = program;
    }
    
    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack();
        isRunning = true;
        while (isRunning) {
            ByteCode bytecode = program.getCode(pc);
            bytecode.execute(this);
            // runStack.dump(); // check that the operation is correct
            pc++;
        }
    }
    
    public void setProgramCounter(int i){ pc = i; }
    
    public void newFrameAt(int offset) {
        runStack.newFrameAt(offset);
    }
    
    public void dump(ByteCode bytecode) {
        if(isDumping){
            bytecode.dump();
            //runStack.dump();
        }
    }
    
    public boolean isDumping() { return isDumping; }
    
    public void setDumping(boolean dumping) { this.isDumping = dumping; }
    
    public int peek() { return runStack.peek(); }
    
    public int pop() { return runStack.pop(); }
    
    public int push(int n) { return runStack.push(n); }
    
    public int load(int offset) { return runStack.load(offset); }
    
    public int store(int offset) { return runStack.store(offset); }
    
    public void popFrame() { runStack.popFrame(); }
    
    public Integer popReturnAddrs(){ return returnAddrs.pop(); }
    
    public void saveReturnAddrs(){ returnAddrs.push(pc); }

    public void stopVM(){ isRunning = false; }    
}
