import java.util.Map;

public class Process {
    private boolean isChangeState;
    public String getTransByRuler(String specialCharacter){
        if(isChangeState && Ruler.rule.containsKey(specialCharacter)){
            return Ruler.rule.get(specialCharacter);
        }
        return specialCharacter;
    }
}