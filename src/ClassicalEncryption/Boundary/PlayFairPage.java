package ClassicalEncryption.Boundary;

import ClassicalEncryption.Caesar;
import ClassicalEncryption.PlayFair;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Main;

public class PlayFairPage {
    public void initializePlayFairPage(Stage primaryStage) {
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
        Label outputLbl = new Label();
        outputLbl.setVisible(false);

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
            PlayFair p = new PlayFair();
            String output = p.Encryption(sentence, key);
            outputLbl.setText(output);
            outputLbl.setVisible(true);

        });
        decryptBtn.setOnAction(event -> {
            String sentence = sentenceTxt.getText();
            String key = keyTxt.getText();
            PlayFair p = new PlayFair();
            String output = p.Decryption(sentence, key);
            outputLbl.setText(output);
            outputLbl.setVisible(true);

        });

        Scene listScene = new Scene(allPane, 500, 500);
        Main.sceneStack.push(listScene);
        primaryStage.setScene(listScene);
        primaryStage.show();

    }
}
