package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;



public class PersonCollection {
    private ObservableList<PersonModel> objToTV = FXCollections.observableArrayList();

    public void koblingTiltable(TableView table) {
        table.setItems(objToTV);
    }
    public void leggTilElement(PersonModel obj){
        objToTV.add(obj);
    }
}
