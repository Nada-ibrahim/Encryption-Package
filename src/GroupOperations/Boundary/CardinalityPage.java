package GroupOperations.Boundary;

import GroupOperations.Cardinality;
import GroupOperations.DataModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Main;

import java.util.List;

public class CardinalityPage {
    Cardinality c;
    void initializeCardinalityPage(Stage primaryStage){
        //Label sizeLabel = new Label("Enter Size of the list: ");
        TextField sizeTxt = new TextField();
        sizeTxt.setPromptText("Enter The Cardinality of the list here");
        sizeTxt.setPrefWidth(400);
        sizeTxt.setPrefHeight(40);
        sizeTxt.setFocusTraversable(false);

        Button EnterListBtn = new Button("Check Cardinality");
        EnterListBtn.setPrefHeight(50);
        EnterListBtn.setPrefWidth(200);
        EnterListBtn.setAlignment(Pos.CENTER);

        Button backBtn = new Button("Back");
        backBtn.setPrefHeight(50);
        backBtn.setPrefWidth(200);
        backBtn.setAlignment(Pos.CENTER);

        Button multiTableBtn = new Button("Multiplicative Inverse Table");
        multiTableBtn.setPrefHeight(50);
        multiTableBtn.setPrefWidth(200);
        multiTableBtn.setAlignment(Pos.CENTER);

        Button addTableBtn = new Button("Additive Inverse Table");
        addTableBtn.setPrefHeight(50);
        addTableBtn.setPrefWidth(200);
        addTableBtn.setAlignment(Pos.CENTER);

        Button multiFlyBtn = new Button("Multiplicative Inverse on The Fly");
        multiFlyBtn.setPrefHeight(50);
        multiFlyBtn.setPrefWidth(200);
        multiFlyBtn.setAlignment(Pos.CENTER);

        Button addFlyBtn = new Button("Additive Inverse on The fly");
        addFlyBtn.setPrefHeight(50);
        addFlyBtn.setPrefWidth(200);
        addFlyBtn.setAlignment(Pos.CENTER);

        FlowPane tablesPane1 = new FlowPane(Orientation.HORIZONTAL, 2, 0);
        tablesPane1.getChildren().addAll(multiTableBtn, addTableBtn);
        FlowPane tablesPane2 = new FlowPane(Orientation.HORIZONTAL,2, 0);
        tablesPane2.getChildren().addAll(multiFlyBtn, addFlyBtn);

        tablesPane1.setVisible(false);
        tablesPane2.setVisible(false);

        Label outputLbl = new Label();
        //outputLbl.setVisible(false);
//        FlowPane outputPane = new FlowPane(Orientation.VERTICAL);
//        outputPane.getChildren().addAll(outputLbl, tablesPane);


        FlowPane buttonsPane = new FlowPane(Orientation.HORIZONTAL);
        buttonsPane.getChildren().addAll(EnterListBtn, backBtn);

        FlowPane allPane = new FlowPane(Orientation.VERTICAL, 0, 10);
        allPane.getChildren().addAll(sizeTxt, buttonsPane, outputLbl, tablesPane1, tablesPane2);
        allPane.setAlignment(Pos.CENTER);


        backBtn.setOnAction(event -> {
            Main.sceneStack.pop();
            primaryStage.setScene(Main.sceneStack.peek());
            primaryStage.show();
        });
        EnterListBtn.setOnAction(event -> {
            int number = Integer.parseInt(sizeTxt.getText());
            c = new Cardinality(number);
            outputLbl.setText(c.testCardinality());
            boolean isPrime = c.getAprime();
            boolean isAprime = c.getPrime();
            if(isAprime ||isPrime ){
                tablesPane1.setVisible(true);
                tablesPane2.setVisible(true);
            }else{
                tablesPane1.setVisible(false);
                tablesPane2.setVisible(false);
            }

        });
        multiTableBtn.setOnAction(event -> {
            Stage stage = new Stage();
            stage.setTitle("Multiplicative Table");
            List<Integer> Inv = c.getInverseTable('*');
            List<Integer> numberList = c.getNumberLs();
            ObservableList<DataModel> data =
                    FXCollections.observableArrayList();
            for(int i = 0; i < numberList.size(); ++i){
                data.add(new DataModel(numberList.get(i), Inv.get(i)));
            }

            TableView<DataModel> table = new TableView<>();
            TableColumn col1 = new TableColumn("Original Number");
            col1.setPrefWidth(250);

            TableColumn col2 = new TableColumn("Multiplicative Inverse");
            col2.setPrefWidth(250);

            col1.setCellValueFactory(
                    new PropertyValueFactory<>("number")
            );
            col2.setCellValueFactory(
                    new PropertyValueFactory<>("inverse")
            );

            table.setItems(data);
            table.getColumns().addAll(col1, col2);



            Scene newScene = new Scene(table, 500, 500);
            stage.setScene(newScene);
            stage.show();
        });
        multiFlyBtn.setOnAction(event -> {
            Stage stage = new Stage();
            stage.setTitle("Multiplicative Table");
            List<Integer> Inv = c.getInverseFly('*');
            List<Integer> numberList = c.getNumberLs();
            ObservableList<DataModel> data =
                    FXCollections.observableArrayList();
            for(int i = 0; i < numberList.size(); ++i){
                data.add(new DataModel(numberList.get(i), Inv.get(i)));
            }

            TableView<DataModel> table = new TableView<>();
            TableColumn col1 = new TableColumn("Original Number");
            col1.setPrefWidth(250);

            TableColumn col2 = new TableColumn("Multiplicative Inverse");
            col2.setPrefWidth(250);

            col1.setCellValueFactory(
                    new PropertyValueFactory<>("number")
            );
            col2.setCellValueFactory(
                    new PropertyValueFactory<>("inverse")
            );

            table.setItems(data);
            table.getColumns().addAll(col1, col2);
            Scene newScene = new Scene(table, 500, 500);
            stage.setScene(newScene);
            stage.show();
        });
        addTableBtn.setOnAction(event -> {
            Stage stage = new Stage();
            stage.setTitle("Additive Table");
            List<Integer> Inv = c.getInverseTable('+');
            List<Integer> numberList = c.getNumberLs();
            ObservableList<DataModel> data =
                    FXCollections.observableArrayList();
            for(int i = 0; i < numberList.size(); ++i){
                data.add(new DataModel(numberList.get(i), Inv.get(i)));
            }

            TableView<DataModel> table = new TableView<>();
            TableColumn col1 = new TableColumn("Original Number");
            col1.setPrefWidth(250);

            TableColumn col2 = new TableColumn("Additive Inverse");
            col2.setPrefWidth(250);

            col1.setCellValueFactory(
                    new PropertyValueFactory<>("number")
            );
            col2.setCellValueFactory(
                    new PropertyValueFactory<>("inverse")
            );

            table.setItems(data);
            table.getColumns().addAll(col1, col2);

            Scene newScene = new Scene(table, 500, 500);
            stage.setScene(newScene);
            stage.show();
        });
        addFlyBtn.setOnAction(event -> {
            Stage stage = new Stage();
            stage.setTitle("Additive Table");
            List<Integer> Inv = c.getInverseFly('+');
            List<Integer> numberList = c.getNumberLs();
            ObservableList<DataModel> data =
                    FXCollections.observableArrayList();
            for(int i = 0; i < numberList.size(); ++i){
                data.add(new DataModel(numberList.get(i), Inv.get(i)));
            }

            TableView<DataModel> table = new TableView<>();
            TableColumn col1 = new TableColumn("Original Number");
            col1.setPrefWidth(250);

            TableColumn col2 = new TableColumn("Additive Inverse");
            col2.setPrefWidth(250);

            col1.setCellValueFactory(
                    new PropertyValueFactory<>("number")
            );
            col2.setCellValueFactory(
                    new PropertyValueFactory<>("inverse")
            );

            table.setItems(data);
            table.getColumns().addAll(col1, col2);

            Scene newScene = new Scene(table, 500, 500);
            stage.setScene(newScene);
            stage.show();
        });

        Scene listScene = new Scene(allPane, 500, 500);
        Main.sceneStack.push(listScene);
        primaryStage.setScene(listScene);
        primaryStage.show();

    }
}
