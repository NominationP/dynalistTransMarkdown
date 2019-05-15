import static org.junit.Assert.*;

public class ProcessTest {

    @org.junit.Test
    public void getTransByRuler() {
        RulerManager process = new RulerManager();
        assertEquals("#",process.getTransByRuler("0"));
        assertEquals("##",process.getTransByRuler("4"));
        assertEquals("-",process.getTransByRuler("8"));
        assertEquals("!",process.getTransByRuler("!"));
        assertEquals("@",process.getTransByRuler("#"));

        process.getTransByRuler("```");
        assertEquals("4",process.getTransByRuler("4"));
    }
}
