package NumberTheory.Boundary;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Main;

public class NumTheoryHome {
    public void build(Stage primaryStage) {
        primaryStage.setTitle("Number Theory");
        Button listGroupBtn = new Button("Primality Test");
        listGroupBtn.setPrefHeight(200);
        listGroupBtn.setPrefWidth(200);

        Button zFieldGroupBtn = new Button("Euler's Totient function");
        zFieldGroupBtn.setPrefHeight(200);
        zFieldGroupBtn.setPrefWidth(200);

        Button cardinalityBtn = new Button("Relative Prime");
        cardinalityBtn.setPrefHeight(200);
        cardinalityBtn.setPrefWidth(200);


        FlowPane buttons1Bane = new FlowPane(Orientation.HORIZONTAL);
        buttons1Bane.getChildren().addAll(listGroupBtn, zFieldGroupBtn);

        FlowPane buttons2Bane = new FlowPane(Orientation.HORIZONTAL);
        buttons2Bane.getChildren().addAll(cardinalityBtn);

        FlowPane allButtonsBane = new FlowPane(Orientation.VERTICAL);
        allButtonsBane.getChildren().addAll(buttons1Bane, buttons2Bane);
        allButtonsBane.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(allButtonsBane, 500, 500);

        Main.sceneStack.push(myScene);

        PrimalityTestPage lp = new PrimalityTestPage();
        EulersFnPage zf = new EulersFnPage();
        RelativePrimePage cp = new RelativePrimePage();
        listGroupBtn.setOnAction(event -> lp.build(primaryStage));
        zFieldGroupBtn.setOnAction(event -> zf.build(primaryStage));
        cardinalityBtn.setOnAction(event -> cp.build(primaryStage));
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}


