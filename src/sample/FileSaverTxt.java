package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSaverTxt implements FileSaver {
    @Override
    public void writeString(Path path, String str) throws IOException {
        // se den andre writeString metoden
        Files.write(path,str.getBytes());
    }
}
