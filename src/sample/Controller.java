package sample;

import Filbehandlig.FileOpenerTxt;
import Filbehandlig.FileSaverTxt;
import Filbehandlig.PersonFormatter;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static Filbehandlig.PersonFormatter.formatPersoner;
import static sample.PersonRegester.personer;

public class Controller implements Initializable {
    private PersonCollection collection= new PersonCollection();

    @FXML
    private TextField txtNavn;

    @FXML
    private TextField txtdag;

    @FXML
    private TextField txtmåned;


    @FXML
    private TextField txtÅr;
    @FXML
    private TextField search;

    @FXML
    private TextField epostTxt;

    @FXML
    private TextField tlfTxt;

    @FXML
    private TableView tableView;




//metodet for å lese fra filen

public String testReading() throws IOException {
    Path path = Paths.get("person.txt");
    FileOpenerTxt file = new FileOpenerTxt();
    List<PersonModel> people = file.readPeople(path);
    StringBuffer str = new StringBuffer();
    for (PersonModel p : people){
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

        Dato nyDato = new Dato(dag,måned,år);
        String datoS = nyDato.toString();
        PersonModel model =  new PersonModel(txtNavn.getText(),datoS,epostTxt.getText(), tlfTxt.getText());
        personer.add(model);




        String person1String = PersonFormatter.formatPeople(personer);
        Path path = Paths.get("person.txt");
        try {
            FileSaverTxt fileSaver =new FileSaverTxt();
            fileSaver.writeString(path, person1String);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    PersonRegester regester = new PersonRegester();





    @FXML
    void removAll(ActionEvent event) {
       // resultat.setText(" ");
        txtNavn.setText("");
        txtdag.setText("");
        txtmåned.setText("");
        txtÅr.setText("");
        epostTxt.setText("");
        tlfTxt.setText("");

        personer.clear();

    }


    @FXML
    void searchM(KeyEvent event) {
        String s = search.getText();

        collection.objToTV = collection.objToTV.stream().filter(x->x.getNavn().startsWith(s)).collect(Collectors.toCollection(FXCollections::observableArrayList));
        collection.koblingTiltable(tableView);
    }



    private PersonModel creatPerson(){
        int år = Integer.parseInt(txtÅr.getText());
        int dag = Integer.parseInt(txtdag.getText());
        int måned = Integer.parseInt(txtmåned.getText());
        String navn = txtNavn.getText();
        String epost=epostTxt.getText();
        String tlfNr = tlfTxt.getText();

        String dateS = dag+"-"+måned+"-"+år;
        PersonModel obj = null;
        if(regester.regester(navn,dag,måned,år, epost,tlfNr)){
            obj = new PersonModel(navn,dateS,epost,tlfNr);
        }
        return obj;
    }

    @FXML
    void visPersoner(ActionEvent event) {

        PersonModel personObj =creatPerson();
        if(personObj != null){
            collection.leggTilElement(personObj);
        }


    //    resultat.setText(regester.vispersoner());

    }

    @FXML
    void writePeople_tofiler(ActionEvent event) {
        testWriter();

    }
    @FXML
    void readPeople(ActionEvent event) throws IOException {
       String str =  testReading();
      // resultat.setText(str);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        collection.koblingTiltable(tableView);
    }




}

