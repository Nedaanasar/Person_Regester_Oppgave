package sample;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public interface FileOpener {

      ArrayList<Person> readPeople(Path path) throws IOException ;


}

