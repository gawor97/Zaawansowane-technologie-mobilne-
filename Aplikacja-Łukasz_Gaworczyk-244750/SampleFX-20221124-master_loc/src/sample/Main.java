package sample;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    @Override
    public void stop() {
        System.out.println("In stop");    
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parser parser = new Parser();
        List<Warzywa> warzywaList = parser.parse(ReadFile.read());
        warzywaList.forEach(System.out::println);

        TableView tableView = new TableView();

        TableColumn<Warzywa, String> column1 =
                new TableColumn<>("warzywo");

        column1.setCellValueFactory(
                new PropertyValueFactory<>("warzywo"));


        TableColumn<Warzywa, String> column2 =
                new TableColumn<>("ilosc");

        column2.setCellValueFactory(
                new PropertyValueFactory<>("ilosc"));

        TableColumn<Warzywa, String> column3 =
                new TableColumn<>("cena");

        column3.setCellValueFactory(
                new PropertyValueFactory<>("cena"));




        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);


        for (Warzywa warzywa : warzywaList) {
            tableView.getItems().add(
                    warzywa);
        }


        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
