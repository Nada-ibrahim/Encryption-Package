package DiscreteLog.Boundary;

import DiscreteLog.DiscreteLog;
import GroupOperations.Cardinality;
import DiscreteLog.DataModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import sample.Main;

import java.util.List;

public class DiscreteLogPage {

    void initializeDiscreteLogPage(Stage primaryStage){
        //Label sizeLabel = new Label("Enter Size of the list: ");
        TextField mTxt = new TextField();
        mTxt.setPromptText("Enter M");
        mTxt.setPrefWidth(400);
        mTxt.setPrefHeight(40);
        mTxt.setFocusTraversable(false);

        TextField aTxt = new TextField();
        aTxt.setPromptText("Enter a");
        aTxt.setPrefWidth(400);
        aTxt.setPrefHeight(40);
        aTxt.setFocusTraversable(false);

        TextField pTxt = new TextField();
        pTxt.setPromptText("Enter p");
        pTxt.setPrefWidth(400);
        pTxt.setPrefHeight(40);
        pTxt.setFocusTraversable(false);

        Button EnterListBtn = new Button("Get Discrete Logarithm");
        EnterListBtn.setPrefHeight(50);
        EnterListBtn.setPrefWidth(200);
        EnterListBtn.setAlignment(Pos.CENTER);

        Button backBtn = new Button("Back");
        backBtn.setPrefHeight(50);
        backBtn.setPrefWidth(200);
        backBtn.setAlignment(Pos.CENTER);

        Label outputLbl = new Label();
        //outputLbl.setVisible(false);
//        FlowPane outputPane = new FlowPane(Orientation.VERTICAL);
//        outputPane.getChildren().addAll(outputLbl, tablesPane);


        FlowPane buttonsPane = new FlowPane(Orientation.HORIZONTAL);
        buttonsPane.getChildren().addAll(EnterListBtn, backBtn);

        FlowPane allPane = new FlowPane(Orientation.VERTICAL, 0, 10);
        allPane.getChildren().addAll(aTxt, pTxt, mTxt , buttonsPane, outputLbl);
        allPane.setAlignment(Pos.CENTER);


        backBtn.setOnAction(event -> {
            Main.sceneStack.pop();
            primaryStage.setScene(Main.sceneStack.peek());
            primaryStage.show();
        });
        EnterListBtn.setOnAction(event -> {
            int m = Integer.parseInt(mTxt.getText());
            int p = Integer.parseInt(pTxt.getText());
            int a = Integer.parseInt(aTxt.getText());
            if(m > p || m < 1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                //alert.setHeaderText("Look, an Information Dialog");
                alert.setContentText("M value should be between 1 and P");
                alert.show();
            }else {
                DiscreteLog dl = new DiscreteLog(m);
                dl.getDiscreteLog(a, p);
                Stage stage = new Stage();
                stage.setTitle("Discrete logarithm Table");
                ObservableList<DataModel> data =
                        FXCollections.observableArrayList();
                for(int i = 0; i < dl.bList.length; ++i){
                    data.add(new DataModel(dl.bList[i], dl.iList[i], dl.timeList[i]));
                }

                TableView<DataModel> table = new TableView<>();
                TableColumn col1 = new TableColumn("b");
                col1.setPrefWidth(200);

                TableColumn col2 = new TableColumn("i");
                col2.setPrefWidth(200);

                TableColumn col3 = new TableColumn("Time");
                col3.setPrefWidth(200);

                col1.setCellValueFactory(
                        new PropertyValueFactory<>("b")
                );
                col2.setCellValueFactory(
                        new PropertyValueFactory<>("i")
                );
                col3.setCellValueFactory(
                        new PropertyValueFactory<>("time")
                );

                table.setItems(data);
                table.getColumns().addAll(col1, col2, col3);

                Scene newScene = new Scene(table, 600, 500);
                stage.setScene(newScene);
                stage.show();
            }

        });


        Scene listScene = new Scene(allPane, 500, 500);
        Main.sceneStack.push(listScene);
        primaryStage.setScene(listScene);
        primaryStage.show();

    }
}
