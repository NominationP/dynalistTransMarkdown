import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class RulerManager {
    private boolean changeState;
    private Set<String> checkChangeDetail;

    RulerManager() {
        changeState = true;
        checkChangeDetail = new HashSet<>();
    }

    String transform(String line) {
//        char firstChar = line.charAt(0);
//        if(isFeatureChar(String.valueOf(firstChar))){
//
//        }
        //such as '    ```'
        if (isChangeChar(line) && getChangeState(line)) {
            return line.trim();
        }

        //such as '    eee'
        int spaceCount = 0;
        for (char c : line.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            } else {
                break;
            }
        }

        if (isFeatureChar(String.valueOf(spaceCount))) {
            line = spaceCount + line.trim();
            line = line.replaceFirst(String.valueOf(spaceCount), getTransByRuler(String.valueOf(spaceCount)));
        }
        for (Map.Entry<String, String> sc :
                RulerConst.characterTransformRule.entrySet()) {
            line = line.replace(sc.getKey(), sc.getValue());
        }
        return line;
    }

    private boolean isFeatureChar(String c) {
        return RulerConst.characterTransformRule.containsKey(c.trim());
    }

    private boolean isChangeChar(String c) {
        return RulerConst.CHANGESET.contains(c.trim());
    }

    String getTransByRuler(String specialCharacter) {
        specialCharacter = specialCharacter.trim();
        if (getChangeState(specialCharacter) && isFeatureChar(specialCharacter)) {
            return RulerConst.characterTransformRule.get(specialCharacter);
        }
        return specialCharacter.trim();
    }

    private Boolean getChangeState(String specialCharacter) {
        if (isChangeChar(specialCharacter)) {
            if (!checkChangeDetail.contains(specialCharacter)) {
                checkChangeDetail.add(specialCharacter);
                changeState = false;
            } else {
                checkChangeDetail.remove(specialCharacter);
                changeState = true;
            }
        }
        return changeState;
    }
}