package GroupOperations.Boundary;

import GroupOperations.GFOperation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.Main;

import java.util.ArrayList;
import java.util.List;

public class PolyPage {

    void initializePolyPage(Stage primaryStage){
        //Label sizeLabel = new Label("Enter Size of the list: ");

        List<TextField> coefficients1 = new ArrayList<>();
        FlowPane allEqPane = new FlowPane(Orientation.VERTICAL, 0, 20);
        FlowPane firstEqPane = new FlowPane(Orientation.HORIZONTAL, 2, 0);
        Label lbl1 = new Label("First Polynomial Equation:- ");
        for(int i = 0; i < 8; ++i){
            TextField t = new TextField();
            t.setPrefHeight(15);
            t.setPrefWidth(23);
            coefficients1.add(t);
            if(i != 7){
                String x = "X" + (7 - i) + " +";
                Label newlbl = new Label(x);

                firstEqPane.getChildren().addAll(coefficients1.get(i), newlbl);
            }else{
                firstEqPane.getChildren().addAll(coefficients1.get(i));
            }
        }
        List<TextField> coefficients2 = new ArrayList<>();
        FlowPane secondEqPane = new FlowPane(Orientation.HORIZONTAL, 2, 0);
        Label lbl2 = new Label("Second Polynomial Equation:- ");
        for(int i = 0; i < 8; ++i){
            TextField t = new TextField();
            t.setPrefHeight(15);
            t.setPrefWidth(23);
            coefficients2.add(t);
            if(i != 7){
                String x = "X" + (7 - i) + " +";
                Label newlbl = new Label(x);
                secondEqPane.getChildren().addAll(coefficients2.get(i), newlbl);
            }else{
                secondEqPane.getChildren().addAll(coefficients2.get(i));
            }
        }

        List<TextField> coefficients3 = new ArrayList<>();
        FlowPane thirdEqPane = new FlowPane(Orientation.HORIZONTAL, 2, 0);
        Label lbl3 = new Label("Reduction Equation:- ");
        for(int i = 0; i < 8; ++i){
            TextField t = new TextField();
            t.setPrefHeight(15);
            t.setPrefWidth(23);
            coefficients3.add(t);
            if(i != 7){
                String x = "X" + (7 - i) + " +";
                Label newlbl = new Label(x);
                thirdEqPane.getChildren().addAll(coefficients3.get(i), newlbl);
            }else{
                thirdEqPane.getChildren().addAll(coefficients3.get(i));
            }
        }

        Button addBtn = new Button("Add");
        addBtn.setPrefHeight(50);
        addBtn.setPrefWidth(120);
        addBtn.setAlignment(Pos.CENTER);

        Button subBtn = new Button("Subtract");
        subBtn.setPrefHeight(50);
        subBtn.setPrefWidth(120);
        subBtn.setAlignment(Pos.CENTER);

        Button multiBtn = new Button("Multiply");
        multiBtn.setPrefHeight(50);
        multiBtn.setPrefWidth(120);
        multiBtn.setAlignment(Pos.CENTER);

        Button divBtn = new Button("Divide");
        divBtn.setPrefHeight(50);
        divBtn.setPrefWidth(120);
        divBtn.setAlignment(Pos.CENTER);

        Button invBtn = new Button("Invert First Equation");
        invBtn.setPrefHeight(50);
        invBtn.setPrefWidth(120);
        invBtn.setAlignment(Pos.CENTER);

        Button backBtn = new Button("Back");
        backBtn.setPrefHeight(50);
        backBtn.setPrefWidth(120);
        backBtn.setAlignment(Pos.CENTER);

        List<Label> coefficients4 = new ArrayList<>();
        FlowPane fourthEqPane = new FlowPane(Orientation.HORIZONTAL, 0, 0);
        Label lbl4 = new Label("Result:- ");
        for(int i = 0; i < 8; ++i){
            Label t = new Label();
            t.setTextFill(Color.RED);
//            t.setPrefHeight(15);
//            t.setPrefWidth(23);
            coefficients4.add(t);
            if(i != 7){
                String x = "X" + (7 - i) + " + ";
                Label newlbl = new Label(x);
                fourthEqPane.getChildren().addAll(coefficients4.get(i), newlbl);
            }else{
                fourthEqPane.getChildren().addAll(coefficients4.get(i));
            }
        }

        FlowPane allButtons = new FlowPane(Orientation.HORIZONTAL, 3, 3);
        allButtons.getChildren().addAll(addBtn, subBtn, multiBtn, divBtn, invBtn,backBtn);
        allEqPane.getChildren().addAll(lbl1, firstEqPane, lbl2, secondEqPane, lbl3, thirdEqPane, allButtons, lbl4, fourthEqPane);
        allEqPane.setAlignment(Pos.CENTER);

        backBtn.setOnAction(event -> {
            Main.sceneStack.pop();
            primaryStage.setScene(Main.sceneStack.peek());
            primaryStage.show();
        });

        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GFOperation gf = getGF(coefficients1, coefficients2, coefficients3);
                String output = gf.add();
                for(int i = 0; i < 8; ++i){
                    if(i < 8 - output.length()) {
                        coefficients4.get(i).setText("0");
                    }else{
                        coefficients4.get(i).setText(Character.toString(output.charAt((i-8+output.length()))));
                    }
                }
            }
        });
        subBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GFOperation gf = getGF(coefficients1, coefficients2, coefficients3);
                String output = gf.add();
                for(int i = 0; i < 8; ++i){
                    if(i < 8 - output.length()) {
                        coefficients4.get(i).setText("0");
                    }else{
                        coefficients4.get(i).setText(Character.toString(output.charAt((i-8+output.length()))));
                    }
                }
            }
        });

        multiBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GFOperation gf = getGF(coefficients1, coefficients2, coefficients3);
                String output = gf.multiply();
                for(int i = 0; i < 8; ++i){
                    if(i < 8 - output.length()) {
                        coefficients4.get(i).setText("0");
                    }else{
                        coefficients4.get(i).setText(Character.toString(output.charAt((i-8+output.length()))));
                    }
                }
            }
        });

        divBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GFOperation gf = getGF(coefficients1, coefficients2, coefficients3);
                String output = gf.divide();
                for(int i = 0; i < 8; ++i){
                    if(i < 8 - output.length()) {
                        coefficients4.get(i).setText("0");
                    }else{
                        coefficients4.get(i).setText(Character.toString(output.charAt((i-8+output.length()))));
                    }
                }
            }
        });

        invBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GFOperation gf = getGF(coefficients1, coefficients2, coefficients3);
                String output = gf.inverse();
                for(int i = 0; i < 8; ++i){
                    if(i < 8 - output.length()) {
                        coefficients4.get(i).setText("0");
                    }else{
                        coefficients4.get(i).setText(Character.toString(output.charAt((i-8+output.length()))));
                    }
                }
            }
        });

        Scene listScene = new Scene(allEqPane, 500, 500);
        Main.sceneStack.push(listScene);
        primaryStage.setScene(listScene);
        primaryStage.show();

    }
    private GFOperation getGF(List<TextField> coefficients1, List<TextField> coefficients2, List<TextField> coefficients3){
        StringBuilder eq1 = new StringBuilder();
        StringBuilder eq2 = new StringBuilder();
        StringBuilder eq3 = new StringBuilder();
        for(int i = 0; i < 8; ++i){
            eq1.append(coefficients1.get(i).getText());
            eq2.append(coefficients2.get(i).getText());
            eq3.append(coefficients3.get(i).getText());
        }
        return new GFOperation(eq1.toString(), eq2.toString(), eq3.toString());
    }


}
