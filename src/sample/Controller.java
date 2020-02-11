package sample;

import Filbehandlig.FileOpenerTxt;
import Filbehandlig.FileSaverTxt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;

import static sample.PersonFormatter.formatPersoner;
import static sample.PesjonRegester.personer;

public class Controller implements Initializable {
    PesjonRegester regester = new PesjonRegester();

//metodet for å lese fra filen

public String testReading() throws IOException {
    Path path = Paths.get("person.txt");
    FileOpenerTxt file = new FileOpenerTxt();
    List<Person> people = file.readPeople(path);
    StringBuffer str = new StringBuffer();
    for (Person p : people){
        str.append(formatPersoner(p));
        str.append("\n");
    }
    return str.toString();


}


//Metoden for å skrive pesroner i Person.txt

    public void testWriter() {
        int dag = Integer.parseInt(txtdag.getText());
        int måned = Integer.parseInt(txtmåned.getText());
        int år = Integer.parseInt(txtÅr.getText());
        int alder = 2020-år;


        Person person1 = new Person(txtNavn.getText(), new Dato(dag,måned,år),alder,epostTxt.getText(), tlfTxt.getText());
        personer.add(person1);



        String person1String = PersonFormatter.formatPeople(personer);
        Path path = Paths.get("person.txt");
        try {
            FileSaverTxt fileSaver =new FileSaverTxt();
            fileSaver.writeString(path, person1String);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField txtNavn;

    @FXML
    private TextField txtdag;

    @FXML
    private TextField txtmåned;

    @FXML
    private TextArea resultat;

    @FXML
    private TextField txtÅr;

    @FXML
    private TextField epostTxt;

    @FXML
    private TextField tlfTxt;
    @FXML
    private TableView<?> tableView;



    @FXML
    void regester(ActionEvent event) {
        int dag = Integer.parseInt(txtdag.getText());
        int måned = Integer.parseInt(txtmåned.getText());
        int år = Integer.parseInt(txtÅr.getText());


        regester.regResjon(txtNavn.getText(),dag,måned,år,
                epostTxt.getText()
                ,tlfTxt.getText());

    }

    @FXML
    void remo(ActionEvent event) {
        resultat.setText(" ");
        personer.clear();

    }

    @FXML
    void visPersoner(ActionEvent event) {
        int år = Integer.parseInt(txtÅr.getText());
        int dag = Integer.parseInt(txtdag.getText());
        int måned = Integer.parseInt(txtmåned.getText());
        int alder = 2020-år;
        PersonCollection collection = new PersonCollection();
        String dateS = txtÅr.getText()+"-"+txtmåned.getText()+"-"+txtdag.getText();

        PersonModel model = new PersonModel(txtNavn.getText(), dateS,epostTxt.getText(), tlfTxt.getText());
        collection.leggTilElement(model);

    //    resultat.setText(regester.vispersoner());

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    void ritePeople_tofiler(ActionEvent event) {
        testWriter();

    }
    @FXML
    void readPeople(ActionEvent event) throws IOException {
       String str =  testReading();
       resultat.setText(str);

    }



}

