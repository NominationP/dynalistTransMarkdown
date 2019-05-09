public class Process {
    private boolean isChangeState;
    public String getTransByRuler(String specialCharacter){
        if(isChangeState && Ruler.characterTransformRule.containsKey(specialCharacter)){
            return Ruler.characterTransformRule.get(specialCharacter);
        }
        return specialCharacter;
    }

    public Boolean isChangeState(){
        Ruler.IMMUTABLE.
    }

}