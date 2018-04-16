package GroupOperations.Boundary;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Main;

public class GFHome {
    public void build(Stage primaryStage){
        primaryStage.setTitle("Group Operations");
        Button listGroupBtn = new Button("Group Check for a List");
        listGroupBtn.setPrefHeight(200);
        listGroupBtn.setPrefWidth(200);

        Button zFieldGroupBtn = new Button("Group Check for a Z-Field");
        zFieldGroupBtn.setPrefHeight(200);
        zFieldGroupBtn.setPrefWidth(200);

        Button cardinalityBtn = new Button("Check Cardinality for a Cardinality Field");
        cardinalityBtn.setPrefHeight(200);
        cardinalityBtn.setPrefWidth(200);

        Button polynomialBtn = new Button("Do Polynomial operations");
        polynomialBtn.setPrefHeight(200);
        polynomialBtn.setPrefWidth(200);

        FlowPane buttons1Bane = new FlowPane(Orientation.HORIZONTAL);
        buttons1Bane.getChildren().addAll(listGroupBtn, zFieldGroupBtn);

        FlowPane buttons2Bane = new FlowPane(Orientation.HORIZONTAL);
        buttons2Bane.getChildren().addAll(cardinalityBtn, polynomialBtn);

        FlowPane allButtonsBane = new FlowPane(Orientation.VERTICAL);
        allButtonsBane.getChildren().addAll(buttons1Bane, buttons2Bane);
        allButtonsBane.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(allButtonsBane, 500,500);

        Main.sceneStack.push(myScene);

        ListPage lp = new ListPage();
        ZFieldPage zf = new ZFieldPage();
        CardinalityPage cp = new CardinalityPage();
        PolyPage pp = new PolyPage();
        listGroupBtn.setOnAction(event -> lp.initializeListPage(primaryStage));
        zFieldGroupBtn.setOnAction(event -> zf.initializeZfieldPage(primaryStage));
        cardinalityBtn.setOnAction(event -> cp.initializeCardinalityPage(primaryStage));
        polynomialBtn.setOnAction(event -> pp.initializePolyPage(primaryStage));
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
