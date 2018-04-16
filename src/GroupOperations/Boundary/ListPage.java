package GroupOperations.Boundary;

import GroupOperations.Program;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListPage {
    void initializeListPage(Stage primaryStage){
        //Label sizeLabel = new Label("Enter Size of the list: ");

        TextField listTxt = new TextField();
        listTxt.setPromptText("Enter the elements of the list separated by a space");
        listTxt.setPrefWidth(400);
        listTxt.setPrefHeight(40);
        listTxt.setFocusTraversable(false);

        TextField identityTxt = new TextField();
        identityTxt.setPromptText("Enter the identity of the list separated by a space");
        identityTxt.setPrefWidth(400);
        identityTxt.setPrefHeight(40);
        identityTxt.setFocusTraversable(false);

        TextField operationTxt = new TextField();
        operationTxt.setPromptText("Enter the operation of the list [ +, -, * ]");
        operationTxt.setPrefWidth(400);
        operationTxt.setPrefHeight(40);
        operationTxt.setFocusTraversable(false);

        Button EnterListBtn = new Button("Check List");
        EnterListBtn.setPrefHeight(50);
        EnterListBtn.setPrefWidth(200);
        EnterListBtn.setAlignment(Pos.CENTER);

        Button backBtn = new Button("Back");
        backBtn.setPrefHeight(50);
        backBtn.setPrefWidth(200);
        backBtn.setAlignment(Pos.CENTER);

        FlowPane buttonsPane = new FlowPane(Orientation.HORIZONTAL);
        buttonsPane.getChildren().addAll(EnterListBtn, backBtn);
        Label outputLbl = new Label();
        outputLbl.setVisible(false);

        FlowPane allPane = new FlowPane(Orientation.VERTICAL, 0, 10);
        allPane.getChildren().addAll(listTxt,identityTxt, operationTxt, buttonsPane, outputLbl);
        allPane.setAlignment(Pos.CENTER);

        backBtn.setOnAction(event -> {
            Main.sceneStack.pop();
            primaryStage.setScene(Main.sceneStack.peek());
            primaryStage.show();
        });
        EnterListBtn.setOnAction(event -> {
            String listStr = listTxt.getText();
            String[] list = listStr.split(" ");
            List<Integer> numberList = new ArrayList<>();
            for (String aList : list) {
                numberList.add(Integer.parseInt(aList));
            }
            int max = Collections.max(numberList);
            int min = Collections.min(numberList);
            if(numberList.size() <= max || min < 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                //alert.setHeaderText("Look, an Information Dialog");
                alert.setContentText("Elements in the list should be in the range of its size");
                alert.show();
            }else{
                int identity = Integer.parseInt(identityTxt.getText());
                char operation = operationTxt.getText().charAt(0);
                Program programLogic = new Program();
                String output = programLogic.List(numberList, operation, identity);
                outputLbl.setText(output);
                outputLbl.setVisible(true);
            }
        });

        Scene listScene = new Scene(allPane, 500, 500);
        Main.sceneStack.push(listScene);
        primaryStage.setScene(listScene);
        primaryStage.show();

    }
}
