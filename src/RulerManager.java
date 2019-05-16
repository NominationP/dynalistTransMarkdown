import java.util.HashSet;
import java.util.Set;

class RulerManager {
    private boolean changeState;
    private Set<String> checkChangeDetail;

    RulerManager() {
        changeState = true;
        checkChangeDetail = new HashSet<>();
    }

    String transform(String line){
//        char firstChar = line.charAt(0);
//        if(isFeatureChar(String.valueOf(firstChar))){
//
//        }
        int spaceCount = 0;
        for (char c : line.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }else{
                break;
            }
        }
        if(isFeatureChar(String.valueOf(spaceCount))){
            line = spaceCount+line.trim();
            line = line.replaceFirst(String.valueOf(spaceCount),getTransByRuler(String.valueOf(spaceCount)));
        }
        return line;
    }

    private boolean isFeatureChar(String c){
        return RulerConst.characterTransformRule.containsKey(c);
    }

    String getTransByRuler(String specialCharacter){
        if(getChangeState(specialCharacter) && isFeatureChar(specialCharacter)){
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