package sample;

import ClassicalEncryption.Boundary.ClassicalEncHome;
import DES.Boundary.DesPage;
import DiscreteLog.Boundary.DiscreteLogHome;
import DiscreteLog.DiscreteLog;
import GroupOperations.Boundary.GFHome;
import NumberTheory.Boundary.NumTheoryHome;
import NumberTheory.RelativePrime;
import NumberTheory.TestPrimality;
import RSAEncryption.Boundary.RSAPage;
import RSAEncryption.RSA;
import SecurityMath.CheckPrime;
import javafx.application.Application;
import DiscreteLog.PrimitiveRoot;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


import java.math.BigInteger;
import java.util.*;

public class Main extends Application {
    static public Stack<Scene>  sceneStack = new Stack<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        //System.out.println(Math.floorMod(-11, 26));
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Button groupOpBtn = new Button("Group Operations");
        groupOpBtn.setPrefHeight(130);
        groupOpBtn.setPrefWidth(130);
        groupOpBtn.setAlignment(Pos.CENTER);

        Button classicalEncBtn = new Button("Classical Encryption");
        classicalEncBtn.setPrefHeight(130);
        classicalEncBtn.setPrefWidth(130);
        classicalEncBtn.setAlignment(Pos.CENTER);

        Button desBtn = new Button("DES Encryption");
        desBtn.setPrefHeight(130);
        desBtn.setPrefWidth(130);
        desBtn.setAlignment(Pos.CENTER);

        Button numTheoryBtn = new Button("Number Theory");
        numTheoryBtn.setPrefHeight(130);
        numTheoryBtn.setPrefWidth(130);
        numTheoryBtn.setAlignment(Pos.CENTER);

        Button discLogBtn = new Button("Discrete Logarithm");
        discLogBtn.setPrefHeight(130);
        discLogBtn.setPrefWidth(130);
        discLogBtn.setAlignment(Pos.CENTER);

        Button rsaBtn = new Button("RSA Encryption");
        rsaBtn.setPrefHeight(130);
        rsaBtn.setPrefWidth(130);
        rsaBtn.setAlignment(Pos.CENTER);

        FlowPane buttons1 = new FlowPane(Orientation.HORIZONTAL);
        buttons1.getChildren().addAll(groupOpBtn,classicalEncBtn, discLogBtn);
        FlowPane buttons2 = new FlowPane(Orientation.HORIZONTAL);
        buttons2.getChildren().addAll(desBtn, numTheoryBtn, rsaBtn);


        FlowPane allButtons = new FlowPane(Orientation.VERTICAL);
        allButtons.getChildren().addAll(buttons1, buttons2);
        allButtons.setAlignment(Pos.CENTER);

        groupOpBtn.setOnAction(event -> {
            GFHome gf = new GFHome();
            gf.build(primaryStage);
        });
        classicalEncBtn.setOnAction(event -> {
            ClassicalEncHome ch = new ClassicalEncHome();
            ch.build(primaryStage);
        });

        desBtn.setOnAction(event -> {
            DesPage ch = new DesPage();
            ch.build(primaryStage);
        });
        numTheoryBtn.setOnAction(event -> {
            NumTheoryHome ch = new NumTheoryHome();
            ch.build(primaryStage);
        });
        discLogBtn.setOnAction(event -> {
            DiscreteLogHome ch = new DiscreteLogHome();
            ch.build(primaryStage);
        });
        rsaBtn.setOnAction(event -> {
            RSAPage ch = new RSAPage();
            ch.build(primaryStage);
        });

        Scene myScene = new Scene(allButtons, 500,600);
        Main.sceneStack.push(myScene);
        primaryStage.setTitle("Security");
        primaryStage.setScene(myScene);
        primaryStage.show();

    }

    public static void main(String[] args) {
//        DiscreteLog dl = new DiscreteLog(18);
//        dl.getDiscreteLog(4,19);
        RSA r = new RSA();

//        r.generateKey("10007", "100003");
//        String enc = r.encrypt("we");
//        System.out.println(enc);
//        System.out.println(CheckPrime.isPrime(BigInteger.valueOf(10007)));
//        System.out.println(CheckPrime.isPrime(BigInteger.valueOf(100003)));
//        System.out.println(r.decrypt(enc));
        launch(args);
    }
}
