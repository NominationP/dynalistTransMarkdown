import java.util.Set;

public class Process {
    private boolean isChangeState;
    private Set<String> 

    public Process() {
        isChangeState = true;
    }

    public String getTransByRuler(String specialCharacter){
        if(isChangeState(specialCharacter) && Ruler.characterTransformRule.containsKey(specialCharacter)){
            return Ruler.characterTransformRule.get(specialCharacter);
        }
        return specialCharacter;
    }

    private Boolean isChangeState(String specialCharacter){
        if(Ruler.CHANGESET.contains(specialCharacter)){
            return !isChangeState;
        }
        return true;
    }

}