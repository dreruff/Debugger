package debugger;

/**
 *
 * @author dreruff
 */
public class SourceCode {
    private String sourceLine;
    private boolean isBreakpoint;
    
   
    public SourceCode(){
        sourceLine = null;
        isBreakpoint = false;
    }
    
    public void setSourceLine(String sourceLine){
        this.sourceLine = sourceLine;
    }
    
    public String getSourceLine(){
        return this.sourceLine;
    }
    
    public void setBreakpoint(Boolean bool){
        isBreakpoint = bool;
    }
    
    public boolean getIsBreakpoint(){
        return isBreakpoint;
    }
}