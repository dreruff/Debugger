package interpreter.bytecode;

/**
 *
 * @author dreruff
 */
public interface AddressResolution {
    public String getLabel();
    public void setAddress(int index);
    public int getAddress();  
}
