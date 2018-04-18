package NumberTheory.Boundary;

import NumberTheory.ISRelative;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Main;


class RelativePrimePage {
    void build(Stage primaryStage) {
        TextField sentenceTxt = new TextField();
        sentenceTxt.setPromptText("Enter the first Number");
        sentenceTxt.setPrefWidth(400);
        sentenceTxt.setPrefHeight(40);
        sentenceTxt.setFocusTraversable(false);

        TextField number2Txt = new TextField();
        number2Txt.setPromptText("Enter the Second Number");
        number2Txt.setPrefWidth(400);
        number2Txt.setPrefHeight(40);
        number2Txt.setFocusTraversable(false);

        Button encryptBtn = new Button("Relative Prime");
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
            String number1 = sentenceTxt.getText();
            String number2 = number2Txt.getText();
            ISRelative t = new ISRelative();
            String output = t.isRelative(Integer.parseInt(number1), Integer.parseInt(number2));
            outputLbl.setText(output);

        });

        Scene listScene = new Scene(allPane, 500, 500);
        Main.sceneStack.push(listScene);
        primaryStage.setScene(listScene);
        primaryStage.show();

    }
}
