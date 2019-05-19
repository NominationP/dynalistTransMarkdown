import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import static org.junit.Assert.*;

public class TransformFileTest {

    @Test
    public void transFile() throws IOException {
        TransformFile transformFile = new TransformFile();
        String path = "/Users/yibo/Documents/html/github/MyPro/dynalistTransMarkdown/src/records/example1";
        Path file = Paths.get(path + ".md");
        Files.write(file, Collections.singleton(""));
        transformFile.transFile(path);
    }
}