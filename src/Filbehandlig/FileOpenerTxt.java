package Filbehandlig;

        import sample.Person;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.util.ArrayList;

public class FileOpenerTxt implements FileOpener {
    public ArrayList<Person> readPeople(Path path) throws IOException {
        ArrayList<Person> plist = new ArrayList<>();
        try{
            BufferedReader reader = Files.newBufferedReader(path);
            String line;
            while ((line = reader.readLine()) != null){
                Person p = ParsePesron.parsePerson(line);
                plist.add(p);
            }
        }
        catch (IOException ioe){
            return null;
        }
return plist;

    }
}
