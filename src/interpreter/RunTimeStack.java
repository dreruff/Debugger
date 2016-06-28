package interpreter;

//import java.util.*;
import java.util.Stack;
import java.util.Vector;
//import java.util.Iterator;
        
/**
 *
 * @author dreruff
 */

public class RunTimeStack {
    private Stack<Integer> framePointers; 
    private Vector<Integer> runStack;
    
    public RunTimeStack() {
        runStack = new Vector<>();
        framePointers = new Stack<>();
        
        framePointers.push(0);
    }
    
    public int peek() { return runStack.firstElement(); }
    
    public int pop(){ return runStack.remove(0); }
    
    public int push(int i) { runStack.add(i); return i; }
    
    public Integer push(Integer i) { return push((int)i); }
    
    public void newFrameAt(int offset) {
        int size = runStack.size();
        framePointers.add(size - offset);
    }
    
    public void popFrame() {
        int top = (runStack.size()) - 1;
        int returnVal = runStack.get(0);
        int bottom = framePointers.pop();
        while(top >= bottom) {     
            runStack.remove(top);
            top--;
        }
        runStack.add(0, returnVal);
    }
    
    public int store(int offset) {
        int top =  pop();
        offset += framePointers.peek();  
        runStack.add(offset, top);
        return runStack.get(offset);
    }
    
    public int load(int offset) {
        offset += framePointers.peek();
        int literal = runStack.get(offset);
        runStack.add(runStack.size(),literal);
        return runStack.get(0);
    }
    
    /**
     * Dumps the RunTimeStack information for debugging
     * 
     */
    /*
    public void dump() {
        if ((framePointers.size()) == 1) {
            System.out.println(runStack.toArray().toString());
        } else {
            Iterator<Integer> stackIterator = runStack.iterator();
            Iterator<Integer> frameIterator = framePointers.iterator();
            
            Integer stackSize= (runStack.size()-1);
            Integer frameSize= (framePointers.size())-1;
            System.out.print("["); int framecount=0; int stackcount=1;

            Integer fStop = frameIterator.next();
            fStop = frameIterator.next();
            while (stackIterator.hasNext()) {

                Integer stacky = stackIterator.next();
                if((stackIterator.hasNext())&& (stackcount!=fStop))
                    System.out.print(stacky.toString() + ",");
                else if((stackIterator.hasNext())&& (stackcount==fStop))
                    System.out.print(stacky.toString());
                
                if (stackcount== fStop) {
                    System.out.print("] [");
                    if(frameIterator.hasNext())
                        fStop= frameIterator.next();
                }
                stackcount++;
            }
            System.out.print("]"); System.out.println();
        }
    }*/
}