package sample;

import java.io.IOException;
import java.nio.file.Path;

public interface FileSaver {
    void writeString(Path path, String str) throws IOException;
}