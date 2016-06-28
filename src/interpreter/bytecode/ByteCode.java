package interpreter.bytecode;

import java.util.Vector;
import interpreter.VirtualMachine;

/**
 *
 * @author dreruff
 */
public abstract class ByteCode {
    public abstract void init(Vector<String> args);
    public abstract void execute(VirtualMachine vm);
    public abstract void dump();
}
