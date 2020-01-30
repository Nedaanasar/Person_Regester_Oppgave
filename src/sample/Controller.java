package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static sample.PesjonRegester.personer;

public class Controller {
    PesjonRegester regester = new PesjonRegester();





//Metoden for å skrive pesroner i Person.txt
    public void testWriter() {
        int dag = Integer.parseInt(txtdag.getText());
        int måned = Integer.parseInt(txtmåned.getText());
        int år = Integer.parseInt(txtÅr.getText());
        int alder = 2020-år;


        Person person1 = new Person(txtNavn.getText(), new Dato(dag,måned,år),alder,epostTxt.getText(), tlfTxt.getText());
        personer.add(person1);
        //String person1String = PersonFormatter.formatPersoner(person1);

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

        resultat.setText(regester.vispersoner());

    }
    @FXML
    void ritePeople_tofiler(ActionEvent event) {
        testWriter();

    }


}

