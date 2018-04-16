package GroupOperations.Boundary;

import GroupOperations.Program;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Main;

public class ZFieldPage {
    void initializeZfieldPage(Stage primaryStage){
        //Label sizeLabel = new Label("Enter Size of the list: ");
        TextField sizeTxt = new TextField();
        sizeTxt.setPromptText("Enter Size of the list here");
        sizeTxt.setPrefWidth(400);
        sizeTxt.setPrefHeight(40);
        sizeTxt.setFocusTraversable(false);


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

        Label outputLbl = new Label();
        outputLbl.setVisible(false);

        FlowPane buttonsPane = new FlowPane(Orientation.HORIZONTAL);
        buttonsPane.getChildren().addAll(EnterListBtn, backBtn);

        FlowPane allPane = new FlowPane(Orientation.VERTICAL, 0, 10);
        allPane.getChildren().addAll(sizeTxt,identityTxt, operationTxt, buttonsPane, outputLbl);
        allPane.setAlignment(Pos.CENTER);

        backBtn.setOnAction(event -> {
            Main.sceneStack.pop();
            primaryStage.setScene(Main.sceneStack.peek());
            primaryStage.show();
        });
        EnterListBtn.setOnAction(event -> {
            int size = Integer.parseInt(sizeTxt.getText());
            int identity = Integer.parseInt(identityTxt.getText());
            char operation = operationTxt.getText().charAt(0);
            Program programLogic = new Program();
            String output = programLogic.zField(size, operation, identity);
            outputLbl.setText(output);
            outputLbl.setVisible(true);

        });

        Scene listScene = new Scene(allPane, 500, 500);
        Main.sceneStack.push(listScene);
        primaryStage.setScene(listScene);
        primaryStage.show();

    }

}
