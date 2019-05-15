import java.io.*;

public class TransformFile {
     void transFile(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
        String strLine;
        while((strLine = br.readLine())!=null){
            System.out.println(strLine);
        }
        fileInputStream.close();
    }
}
