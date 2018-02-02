/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Bruce
 */
public class CheckerBoardFXMLController implements Initializable, Startable {
    @FXML
    private VBox vBox;
    
    @FXML
    private MenuBar menuBar;
    
    private Board myBoard;
    
     private Stage stage;
     private MenuItem item;
     private int numRows = 8;
     private int numCols = 8;
     private Color lightColor;
     private Color darkColor;
     private double paneWidth;
     private double paneHeight;
     

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void start(Stage stage){
        this.stage = stage;
       myBoard = new Board(8, 8, vBox.getWidth(), vBox.getHeight() - menuBar.getHeight());
       vBox.getChildren().add(myBoard.build());
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            Board newBoard = new Board( myBoard.getNumRows(), myBoard.getNumCols(), vBox.getWidth(), vBox.getHeight() - menuBar.getHeight(), myBoard.getLightColor(), myBoard.getDarkColor());
            vBox.getChildren().remove(myBoard.getBoard());
            vBox.getChildren().add(newBoard.build());
            myBoard = newBoard;
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
 
     }
  
    @FXML 
    private void gridSizeChange(ActionEvent event){
         
       MenuItem clickedItem = (MenuItem) event.getSource();
       int id = Integer.parseInt(clickedItem.getId());
       
       switch (id) {
            case 16:  
                numRows = 16;
                numCols = 16;
                break;
            case 10:
                numRows = 10;
                numCols = 10;
                break;
            case 8:
                numRows = 8;
                numCols = 8;
                break;
            case 3:
                numRows = 3;
                numCols = 3;
                break;
            default:
                break;
       }
       Board newBoard = new Board(numCols, numRows, vBox.getWidth(), vBox.getHeight() - menuBar.getHeight(), myBoard.getLightColor(), myBoard.getDarkColor());
       vBox.getChildren().remove(myBoard.getBoard());
       vBox.getChildren().add(newBoard.build());
       myBoard = newBoard;
    }
    
    @FXML
    private void colorChange(ActionEvent event){
       MenuItem clickedItem = (MenuItem) event.getSource();
       String color = clickedItem.getText();
       
       switch(color){
           case "Blue":
               darkColor = Color.DARKBLUE;
               lightColor = Color.SKYBLUE;
               
               break;
           default:
               darkColor = Color.BLACK;
               lightColor = Color.RED;
               break;
       }
       Board newBoard = new Board(numCols, numRows, vBox.getWidth(), vBox.getHeight() - menuBar.getHeight(), lightColor, darkColor);
       vBox.getChildren().remove(myBoard.getBoard());
       vBox.getChildren().add(newBoard.build());
       myBoard = newBoard;
    }

}
