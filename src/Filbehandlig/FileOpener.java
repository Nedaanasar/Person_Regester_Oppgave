package Filbehandlig;

import sample.Person;
import sample.PersonModel;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public interface FileOpener {

      ArrayList<PersonModel> readPeople(Path path) throws IOException ;


}

