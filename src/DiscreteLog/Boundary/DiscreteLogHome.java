package DiscreteLog.Boundary;

import NumberTheory.Boundary.EulersFnPage;
import NumberTheory.Boundary.PrimalityTestPage;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Main;

public class DiscreteLogHome {
    public void build(Stage primaryStage) {
        primaryStage.setTitle("Discrete Log");
        Button listGroupBtn = new Button("Primitive Root");
        listGroupBtn.setPrefHeight(200);
        listGroupBtn.setPrefWidth(200);

        Button zFieldGroupBtn = new Button("Discrete Logarithm");
        zFieldGroupBtn.setPrefHeight(200);
        zFieldGroupBtn.setPrefWidth(200);


        FlowPane buttons1Bane = new FlowPane(Orientation.HORIZONTAL);
        buttons1Bane.getChildren().addAll(listGroupBtn, zFieldGroupBtn);


        FlowPane allButtonsBane = new FlowPane(Orientation.VERTICAL);
        allButtonsBane.getChildren().addAll(buttons1Bane);
        allButtonsBane.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(allButtonsBane, 500, 500);

        Main.sceneStack.push(myScene);

        DiscreteLogPage lp = new DiscreteLogPage();
        //EulersFnPage zf = new EulersFnPage();

        //listGroupBtn.setOnAction(event -> lp.build(primaryStage));
        zFieldGroupBtn.setOnAction(event -> lp.initializeDiscreteLogPage(primaryStage));

        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}




