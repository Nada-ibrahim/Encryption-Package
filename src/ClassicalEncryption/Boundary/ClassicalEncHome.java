package ClassicalEncryption.Boundary;

import GroupOperations.Boundary.CardinalityPage;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Main;

public class ClassicalEncHome {
    public void build(Stage primaryStage){
        primaryStage.setTitle("Classical Encryption");
        Button caesarBtn = new Button("Caesar Encryption");
        caesarBtn.setPrefHeight(200);
        caesarBtn.setPrefWidth(200);

        Button playFairBtn = new Button("PlayFair Encryption");
        playFairBtn.setPrefHeight(200);
        playFairBtn.setPrefWidth(200);

        Button hillBtn = new Button("Hill Encryption");
        hillBtn.setPrefHeight(200);
        hillBtn.setPrefWidth(200);

        Button BackBtn = new Button("Back");
        BackBtn.setPrefHeight(200);
        BackBtn.setPrefWidth(200);

        FlowPane buttons1Bane = new FlowPane(Orientation.HORIZONTAL);
        buttons1Bane.getChildren().addAll(caesarBtn, playFairBtn);

        FlowPane buttons2Bane = new FlowPane(Orientation.HORIZONTAL);
        buttons2Bane.getChildren().addAll(hillBtn, BackBtn);

        FlowPane allButtonsBane = new FlowPane(Orientation.VERTICAL);
        allButtonsBane.getChildren().addAll(buttons1Bane, buttons2Bane);
        allButtonsBane.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(allButtonsBane, 500,500);

        Main.sceneStack.push(myScene);

        CaesarPage cae = new CaesarPage();
        PlayFairPage pf = new PlayFairPage();
        CardinalityPage cp = new CardinalityPage();
        HillPage hp = new HillPage();
        caesarBtn.setOnAction(event -> cae.initializeCaesarPage(primaryStage));
        playFairBtn.setOnAction(event -> pf.initializePlayFairPage(primaryStage));
        hillBtn.setOnAction(event -> hp.initializeHillPage(primaryStage));
        BackBtn.setOnAction(event -> {
            Main.sceneStack.pop();
            primaryStage.setScene(Main.sceneStack.peek());
            primaryStage.show();
        });
        primaryStage.setScene(myScene);
        primaryStage.show();

    }
}
