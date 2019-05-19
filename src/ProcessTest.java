import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

import static org.junit.Assert.*;

public class ProcessTest {

    @org.junit.Test
    public void getTransByRuler() {
        RulerManager process = new RulerManager();
//        assertEquals("#",process.getTransByRuler("0"));
        assertEquals("##", process.getTransByRuler("4"));
        assertEquals("-", process.getTransByRuler("8"));
//        assertEquals("!", process.getTransByRuler("!"));
        assertEquals("@", process.getTransByRuler("#"));

        process.getTransByRuler("```");
        assertEquals("4", process.getTransByRuler("4"));
        process.getTransByRuler("```");
        assertEquals("##", process.getTransByRuler("4"));
        assertEquals("```", process.getTransByRuler("```"));
        assertEquals("```", process.getTransByRuler("   ```"));
    }

    @Test
    public void getTransform() {
        RulerManager rulerManager = new RulerManager();
//        assertEquals("4",rulerManager.transform("4"));
        assertEquals("```",rulerManager.transform("    ```"));
        assertEquals("```",rulerManager.transform("     ```"));
        assertEquals("```",rulerManager.transform("            ```"));
        assertEquals("#",rulerManager.transform("#"));
        assertEquals("8",rulerManager.transform("8"));
        assertEquals("```",rulerManager.transform("```"));
        assertEquals("-",rulerManager.transform("8"));
    }
}
