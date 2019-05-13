import java.util.Set;

public class Process {
    private boolean changeState;
    private Set<String> checkChangeDetail;

    public Process() {
        changeState = true;
    }

    public String getTransByRuler(String specialCharacter){

        if(getChangeState(specialCharacter) && Ruler.characterTransformRule.containsKey(specialCharacter)){
            return Ruler.characterTransformRule.get(specialCharacter);
        }
        return specialCharacter;
    }

    private Boolean getChangeState(String specialCharacter){
        if(Ruler.CHANGESET.contains(specialCharacter)){
            if(!checkChangeDetail.contains(specialCharacter)){
                checkChangeDetail.add(specialCharacter);
                changeState = false;
            }
            checkChangeDetail.remove(specialCharacter);
            changeState = true;
        }
        return changeState;
    }
}