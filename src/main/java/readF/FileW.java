package readF;

import java.io.FileInputStream;
import java.io.IOException;

public class FileW {
    String loadTextFile(String path) throws IOException {
        java.io.File file = new java.io.File(path);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        String str = new String(data, "UTF-8");

        System.out.println(str);

        return str;
    }

    int indexOfLine(String str) {
        int index = str.indexOf("-----");
        System.out.println(index);
        return index;
    }
}
