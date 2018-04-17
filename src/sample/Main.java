package sample;

import ClassicalEncryption.Boundary.ClassicalEncHome;
import DES.Boundary.DesPage;
import GroupOperations.Boundary.GFHome;
import NumberTheory.RelativePrime;
import NumberTheory.TestPrimality;
import javafx.application.Application;

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
        groupOpBtn.setPrefHeight(200);
        groupOpBtn.setPrefWidth(200);
        groupOpBtn.setAlignment(Pos.CENTER);

        Button classicalEncBtn = new Button("Classical Encryption");
        classicalEncBtn.setPrefHeight(200);
        classicalEncBtn.setPrefWidth(200);
        classicalEncBtn.setAlignment(Pos.CENTER);

        Button desBtn = new Button("DES Encryption");
        desBtn.setPrefHeight(200);
        desBtn.setPrefWidth(200);
        desBtn.setAlignment(Pos.CENTER);

        FlowPane buttons1 = new FlowPane(Orientation.HORIZONTAL);
        buttons1.getChildren().addAll(groupOpBtn,classicalEncBtn);
        FlowPane buttons2 = new FlowPane(Orientation.HORIZONTAL);
        buttons2.getChildren().addAll(desBtn);

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

        Scene myScene = new Scene(allButtons, 500,500);
        Main.sceneStack.push(myScene);
        primaryStage.setTitle("Security");
        primaryStage.setScene(myScene);
        primaryStage.show();

    }

    public static void main(String[] args) {
//        RelativePrime R = new RelativePrime();
//        System.out.println("R " +R.numOFrelative(35));
//        List num = R.SetRelative;
////         for (int i=0 ;i<num.size();i++)
////         {
////                 System.out.println(num.get(i));
////
////         }
//
//        ISRelative IR=new ISRelative();
//        System.out.println( IR.isRelative(3, 10));
        TestPrimality p = new TestPrimality();
        System.out.print(p.test(new BigInteger("199")));
        //launch(args);
    }
}
