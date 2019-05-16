import java.io.*;

public class TransformFile {
     void transFile(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
        String strLine;
        RulerManager rulerManager = new RulerManager();
        while((strLine = br.readLine())!=null){
            String line = rulerManager.transform(strLine);
            System.out.println(line);
        }
        fileInputStream.close();
    }
}
