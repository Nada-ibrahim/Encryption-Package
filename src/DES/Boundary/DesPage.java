package DES.Boundary;

import DES.DesCipher;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Main;

public class DesPage {
    public void build(Stage primaryStage) {
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
        TextField outputLbl = new TextField();
        outputLbl.setPromptText("Output");
        outputLbl.setPrefWidth(400);
        outputLbl.setPrefHeight(40);
        outputLbl.setFocusTraversable(false);

        FlowPane allPane = new FlowPane(Orientation.VERTICAL, 0, 10);
        allPane.getChildren().addAll(sentenceTxt, keyTxt, buttonsPane, outputLbl);
        allPane.setAlignment(Pos.CENTER);

        backBtn.setOnAction(event -> {
            Main.sceneStack.pop();
            primaryStage.setScene(Main.sceneStack.peek());
            primaryStage.show();
        });
        encryptBtn.setOnAction(event -> {
            String sentence = sentenceTxt.getText();
            String key = keyTxt.getText();
            if(key.length() < 16){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                //alert.setHeaderText("Look, an Information Dialog");
                alert.setContentText("key length must be at least 16");
                alert.show();
            }else {
                DesCipher p = new DesCipher();
                String output = p.encrypt(sentence, key);
                outputLbl.setText(output);
            }

        });
        decryptBtn.setOnAction(event -> {
            String sentence = sentenceTxt.getText();
            String key = keyTxt.getText();
            if(key.length() < 16){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                //alert.setHeaderText("Look, an Information Dialog");
                alert.setContentText("key length must be at least 16");
                alert.show();
            }else {
                DesCipher p = new DesCipher();
                String output = p.decrypt(sentence, key);
                outputLbl.setText(output);
            }

        });

        Scene listScene = new Scene(allPane, 500, 500);
        Main.sceneStack.push(listScene);
        primaryStage.setScene(listScene);
        primaryStage.show();

    }
}
