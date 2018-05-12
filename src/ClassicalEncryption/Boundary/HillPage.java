package ClassicalEncryption.Boundary;

import ClassicalEncryption.Hill;
import ClassicalEncryption.PlayFair;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Main;

public class HillPage {
    public void initializeHillPage(Stage primaryStage) {
        TextField sentenceTxt = new TextField();
        sentenceTxt.setPromptText("Enter the sentence");
        sentenceTxt.setPrefWidth(400);
        sentenceTxt.setPrefHeight(40);
        sentenceTxt.setFocusTraversable(false);

        TextField keyTxt = new TextField();
        keyTxt.setPromptText("Enter the key");
        keyTxt.setPrefWidth(400);
        keyTxt.setPrefHeight(40);
        keyTxt.setFocusTraversable(false);

        RadioButton rb2 = new RadioButton("2*2");
        RadioButton rb3 = new RadioButton("3*3");

        Button encryptBtn = new Button("Encrypt");
        encryptBtn.setPrefHeight(50);
        encryptBtn.setPrefWidth(200);
        encryptBtn.setAlignment(Pos.CENTER);

        Button decryptBtn = new Button("Decrypt");
        decryptBtn.setPrefHeight(50);
        decryptBtn.setPrefWidth(200);
        decryptBtn.setAlignment(Pos.CENTER);

        Button backBtn = new Button("Back");
        backBtn.setPrefHeight(50);
        backBtn.setPrefWidth(200);
        backBtn.setAlignment(Pos.CENTER);

        FlowPane buttonsPane = new FlowPane(Orientation.HORIZONTAL);
        buttonsPane.getChildren().addAll(encryptBtn, decryptBtn, backBtn);
        Label outputLbl = new Label();
        outputLbl.setVisible(false);

        FlowPane radioPane = new FlowPane(Orientation.HORIZONTAL);
        radioPane.setHgap(30);
        radioPane.getChildren().addAll(rb2, rb3);

        FlowPane allPane = new FlowPane(Orientation.VERTICAL, 0, 10);
        allPane.getChildren().addAll(sentenceTxt, keyTxt, radioPane, buttonsPane, outputLbl);
        allPane.setAlignment(Pos.CENTER);

        backBtn.setOnAction(event -> {
            Main.sceneStack.pop();
            primaryStage.setScene(Main.sceneStack.peek());
            primaryStage.show();
        });
        encryptBtn.setOnAction(event -> {
            String sentence = sentenceTxt.getText();
            String key = keyTxt.getText();
            if(key.length() < 4 && rb2.isSelected()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                //alert.setHeaderText("Look, an Information Dialog");
                alert.setContentText("key length must be at least 4");
                alert.show();
            }else if(key.length() < 9 && rb3.isSelected()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                //alert.setHeaderText("Look, an Information Dialog");
                alert.setContentText("key length must be at least 9");
                alert.show();
            }else {
                Hill p = new Hill(key, rb2.isSelected()? 2:3);
                String output = p.encrypt(sentence);
                outputLbl.setText(output);
                outputLbl.setVisible(true);
            }

        });
        decryptBtn.setOnAction(event -> {
            String sentence = sentenceTxt.getText();
            String key = keyTxt.getText();
            if(key.length() < 4 && rb2.isSelected()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                //alert.setHeaderText("Look, an Information Dialog");
                alert.setContentText("key length must be at least 4");
                alert.show();
            }else if(key.length() < 9 && rb3.isSelected()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                //alert.setHeaderText("Look, an Information Dialog");
                alert.setContentText("key length must be at least 9");
                alert.show();
            }else {
                Hill p = new Hill(key, rb2.isSelected()? 2:3);
                String output = p.decrypt(sentence);
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
