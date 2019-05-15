import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TransformFileTest {

    @Test
    public void transFile() throws IOException {
        TransformFile transformFile = new TransformFile();
        transformFile.transFile("/Users/yibo/Documents/html/github/MyPro/dynalistTransMarkdown/src/records/example1");
    }
}