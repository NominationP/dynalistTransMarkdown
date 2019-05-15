import java.util.HashSet;
import java.util.Set;

class RulerManager {
    private boolean changeState;
    private Set<String> checkChangeDetail;

    RulerManager() {
        changeState = true;
        checkChangeDetail = new HashSet<>();
    }

    String getTransByRuler(String specialCharacter){

        if(getChangeState(specialCharacter) && RulerConst.characterTransformRule.containsKey(specialCharacter)){
            return RulerConst.characterTransformRule.get(specialCharacter);
        }
        return specialCharacter;
    }

    private Boolean getChangeState(String specialCharacter){
        if(RulerConst.CHANGESET.contains(specialCharacter)){
            if(!checkChangeDetail.contains(specialCharacter)){
                checkChangeDetail.add(specialCharacter);
                changeState = false;
            }else{
                checkChangeDetail.remove(specialCharacter);
                changeState = true;
            }
        }
        return changeState;
    }
}