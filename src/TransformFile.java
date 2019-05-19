import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

class TransformFile {
    void transFile(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        Path file = Paths.get(path+".md");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
        String strLine;
        RulerManager rulerManager = new RulerManager();
        while ((strLine = br.readLine()) != null) {
            String line = rulerManager.transform(strLine);
            Files.write(file, Collections.singleton(line), StandardOpenOption.APPEND);
        }
        fileInputStream.close();
    }
}
