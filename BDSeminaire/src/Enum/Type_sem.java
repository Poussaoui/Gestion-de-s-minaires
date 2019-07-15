package Enum;

public enum Type_sem{
    AM,
    PM,
    JR;
    
    public Type_sem getTypeSem(String s){
        Type_sem ts = null;
        switch (s) {
            case "AM":
                ts = AM;
                break;
            case "PM":
                ts = PM;
                break;
            default:
                ts = JR;
                break;
        }
        return ts;
    }
}
