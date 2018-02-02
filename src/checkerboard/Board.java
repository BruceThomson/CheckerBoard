/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Bruce
 */
public class Board {
    
    private AnchorPane pane;
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor;
    private Color darkColor;
    
    public Board(int numRows, int numCols, double boardWidth, double boardHeight) {
        this(numRows, numCols, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    
    public Board(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build() {
        pane = new AnchorPane();
  
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                Rectangle rec = new Rectangle(boardWidth / numCols, boardHeight / numRows);
                
                if((i + j) % 2 == 1) {
                    rec.setFill(darkColor);
                } else {
                    rec.setFill(lightColor);
                }
               
                AnchorPane.setLeftAnchor(rec, i * boardWidth / numCols);
                AnchorPane.setTopAnchor(rec, j * boardHeight / numRows);
                pane.getChildren().add(rec);
            }
        }
        return pane;
    }
    
    public int getNumRows() {
        return numRows;
    }
    
    public int getNumCols() {
        return numCols;
    }
    
    public Color getLightColor() {
        return lightColor;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }
    
    public AnchorPane getBoard() {
        return pane;
    }
}

