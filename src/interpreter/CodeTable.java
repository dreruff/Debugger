package interpreter;


/**
 *
 * @author dreruff
 */
public class CodeTable {
    private static java.util.HashMap<String,String> codes = new java.util.HashMap<>();
    
    public static String get(String code) { return codes.get(code); }
    
    public static void init() {
        codes.put("HALT", "HaltCode");
        codes.put("POP", "PopCode");
        codes.put("FALSEBRANCH", "FalseBranchCode");
        codes.put("GOTO", "GotoCode");
        codes.put("STORE", "StoreCode");
        codes.put("LOAD", "LoadCode");
        codes.put("LIT", "LitCode");
        codes.put("ARGS", "ArgsCode");
        codes.put("CALL", "CallCode");
        codes.put("RETURN", "ReturnCode");
        codes.put("BOP", "BopCode");
        codes.put("READ", "ReadCode");
        codes.put("WRITE", "WriteCode");
        codes.put("LABEL", "LabelCode");
        codes.put("DUMP", "DumpCode");
    }
}
