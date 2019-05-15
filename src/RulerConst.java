import java.util.*;

public class RulerConst {
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

    public static final Set<String> CHANGESET =
            new HashSet<String>(Collections.singletonList("```"));
}
