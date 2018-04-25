package DiscreteLog.Boundary;

import DiscreteLog.PrimitiveRoot;
import NumberTheory.ISRelative;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Main;

public class PrimitiveRootPage {
    void build(Stage primaryStage) {
        TextField sentenceTxt = new TextField();
        sentenceTxt.setPromptText("Enter the root Number");
        sentenceTxt.setPrefWidth(400);
        sentenceTxt.setPrefHeight(40);
        sentenceTxt.setFocusTraversable(false);

        TextField number2Txt = new TextField();
        number2Txt.setPromptText("Enter the mod Number");
        number2Txt.setPrefWidth(400);
        number2Txt.setPrefHeight(40);
        number2Txt.setFocusTraversable(false);

        Button encryptBtn = new Button("Is Primitive Root?");
        encryptBtn.setPrefHeight(50);
        encryptBtn.setPrefWidth(200);
        encryptBtn.setAlignment(Pos.CENTER);


        Button backBtn = new Button("Back");
        backBtn.setPrefHeight(50);
        backBtn.setPrefWidth(200);
        backBtn.setAlignment(Pos.CENTER);

        FlowPane buttonsPane = new FlowPane(Orientation.HORIZONTAL);
        buttonsPane.getChildren().addAll(encryptBtn, backBtn);
        TextField outputLbl = new TextField();
        outputLbl.setPromptText("Output");
        outputLbl.setPrefWidth(400);
        outputLbl.setPrefHeight(40);
        outputLbl.setFocusTraversable(false);

        FlowPane allPane = new FlowPane(Orientation.VERTICAL, 0, 10);
        allPane.getChildren().addAll(sentenceTxt, number2Txt, buttonsPane, outputLbl);
        allPane.setAlignment(Pos.CENTER);

        backBtn.setOnAction(event -> {
            Main.sceneStack.pop();
            primaryStage.setScene(Main.sceneStack.peek());
            primaryStage.show();
        });
        encryptBtn.setOnAction(event -> {
            String g = sentenceTxt.getText();
            String n = number2Txt.getText();
            PrimitiveRoot pr = new PrimitiveRoot();
            pr.GetA(Integer.parseInt(g), Integer.parseInt(n));
            outputLbl.setText(pr.reason);

        });

        Scene listScene = new Scene(allPane, 500, 500);
        Main.sceneStack.push(listScene);
        primaryStage.setScene(listScene);
        primaryStage.show();

    }
}
