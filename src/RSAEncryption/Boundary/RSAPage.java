package RSAEncryption.Boundary;

import DES.DesCipher;
import RSAEncryption.RSA;
import SecurityMath.CheckPrime;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Main;

import java.io.StringReader;
import java.math.BigInteger;

public class RSAPage {
    public void build(Stage primaryStage) {
        TextField sentenceTxt = new TextField();
        sentenceTxt.setPromptText("Enter the sentence");
        sentenceTxt.setPrefWidth(400);
        sentenceTxt.setPrefHeight(40);
        sentenceTxt.setFocusTraversable(false);

        TextField keyTxt = new TextField();
        keyTxt.setPromptText("Enter P");
        keyTxt.setPrefWidth(400);
        keyTxt.setPrefHeight(40);
        keyTxt.setFocusTraversable(false);

        TextField qTxt = new TextField();
        qTxt.setPromptText("Enter q");
        qTxt.setPrefWidth(400);
        qTxt.setPrefHeight(40);
        qTxt.setFocusTraversable(false);

        TextField dTxt = new TextField();
        dTxt.setPromptText("d");
        dTxt.setPrefWidth(100);
        dTxt.setPrefHeight(40);
        dTxt.setFocusTraversable(false);

        TextField eTxt = new TextField();
        eTxt.setPromptText("e");
        eTxt.setPrefWidth(100);
        eTxt.setPrefHeight(40);
        eTxt.setFocusTraversable(false);

        TextField nTxt = new TextField();
        nTxt.setPromptText("n");
        nTxt.setPrefWidth(100);
        nTxt.setPrefHeight(40);
        nTxt.setFocusTraversable(false);

        FlowPane keysPane = new FlowPane(Orientation.HORIZONTAL);
        keysPane.getChildren().addAll(dTxt, eTxt, nTxt);

        Button encryptBtn = new Button("Encrypt");
        encryptBtn.setPrefHeight(50);
        encryptBtn.setPrefWidth(200);
        encryptBtn.setAlignment(Pos.CENTER);

        Button decryptBtn = new Button("Decrypt");
        decryptBtn.setPrefHeight(50);
        decryptBtn.setPrefWidth(200);
        decryptBtn.setAlignment(Pos.CENTER);

        Button keyBtn = new Button("Generate Key");
        keyBtn.setPrefHeight(50);
        keyBtn.setPrefWidth(200);
        keyBtn.setAlignment(Pos.CENTER);

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
        allPane.getChildren().addAll(keyTxt, qTxt, keyBtn,keysPane, sentenceTxt, buttonsPane, outputLbl);
        allPane.setAlignment(Pos.CENTER);

        backBtn.setOnAction(event -> {
            Main.sceneStack.pop();
            primaryStage.setScene(Main.sceneStack.peek());
            primaryStage.show();
        });
        keyBtn.setOnAction(event -> {
            String p = keyTxt.getText();
            String q = qTxt.getText();
            if(!CheckPrime.isPrime(new BigInteger(p)) || !CheckPrime.isPrime(new BigInteger(q))){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                //alert.setHeaderText("Look, an Information Dialog");
                alert.setContentText("p or q isn't prime");
                alert.show();
            }else {
                RSA r = new RSA();
                r.generateKey(p,q);
                dTxt.setText(r.d.toString());
                eTxt.setText(r.e.toString());
                nTxt.setText(r.n.toString());
            }

        });
        encryptBtn.setOnAction(event -> {
            String sentence = sentenceTxt.getText();
            RSA r = new RSA();
            String e = eTxt.getText();
            String n = nTxt.getText();
            String output = r.encrypt(sentence, new BigInteger(e), new BigInteger(n));
            outputLbl.setText(output);
        });
        decryptBtn.setOnAction(event -> {
            String sentence = sentenceTxt.getText();
            RSA r = new RSA();
            String d = dTxt.getText();
            String n = nTxt.getText();
            String output = r.decrypt(sentence, new BigInteger(d), new BigInteger(n));
            outputLbl.setText(output);
        });

        Scene listScene = new Scene(allPane, 500, 500);
        Main.sceneStack.push(listScene);
        primaryStage.setScene(listScene);
        primaryStage.show();

    }
}
