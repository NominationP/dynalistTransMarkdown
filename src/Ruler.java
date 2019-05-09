import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Ruler{
    protected static final Map<String,String> characterTransformRule;
    static {
        Map<String, String> map = new HashMap<>();
        map.put("0","#");
        map.put("4", "##");
        map.put("8", "-");
//        map.put("`", "\n```\n");
        map.put("!", "!");
        map.put("#", "@");
        map.put(">", "> ");
        characterTransformRule = Collections.unmodifiableMap(map);
    }

    public static final [] IMMUTABLE = {"```"};
}
