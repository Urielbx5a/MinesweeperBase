/**
 * Write a description of class Minesweeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MinesweeperBoard2{
    Cell[][] board;
    int rows;
    int columns;
    public MinesweeperBoard2(int row, int column){
        //Put the constructor here.

        this.rows = row;
        this.columns = column;
        board = new Cell[rows][columns];
        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public MinesweeperBoard2(){
        this(10,10);
    }

    public void addBombs(int bombs) {//throws Exception{

        for(int i = 0; i < bombs; i ++){
            boolean placed = false;

            while (!placed){
                int rand1 = (int)(Math.random() * (rows) - 1);
                int rand2 = (int)(Math.random() * (columns) - 1);
                if (board[rand1][rand2].getValue() == 0){
                    board[rand1][rand2].setBomb();
                    placed = true;
                }
            }

        }

    }

    public void addNums(){
        int total = (rows * columns);
        int row = rows;
        int column = columns;
        for ( int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                
                if (board[i][j].getValue() != -1){

                    if (board[0][0].getValue() == 0){ // first corner
                        //right
                        if (board[0][1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //bot
                        if (board[1][0].getValue() == -1 ){
                            board[i][j].setValue();
                        }
                        //bot-right
                        if (board[1][1].getValue() == -1 ){
                            board[i][j].setValue();
                        }
                    } else if (board[0][column-1].getValue() == 0){ // second corner
                        //left
                        if (board[i ][j -1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //bot
                        if (board[i + rows][columns-1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //bot-left
                        if (board[i + rows -1][1].getValue() == -1 ){
                            board[i][j].setValue();
                        }
                    } else if (board[rows-1][0].getValue() == 0){ // bottom left corner
                        //right
                        if (board[rows-1][j+1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //top
                        if (board[i-1][j].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //top-right
                        if (board[i-1][j+1].getValue() == -1){
                            board[i][j].setValue();
                        }                
                    }else if (board[rows-1][columns-1].getValue() == -1){ // bottom right corner
                        //top
                        if ((board[i-1][j]).getValue() == -1){
                            board[i][j].setValue();
                        }
                        //top-left
                        if (board[i-1][j-1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //left
                        if (board[i][j-1].getValue() == -1){
                            board[i][j].setValue();
                        }
                    } else if (board[i][0].getValue() == 0){//left side
                        //right
                        if (board[i][j+1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //top
                        if ((board[i-1][j]).getValue() == -1 && i - rows >=0){
                            board[i][j].setValue();
                        }
                        //top-right
                        if (board[i-1][j+1].getValue() == -1 ){
                            board[i][j].setValue();
                        }
                        //bot
                        if (board[i+1][j].getValue() == -1 ){
                            board[i][j].setValue();
                        }
                        //bot-right
                        if (board[i+1][j+1].getValue() == -1){
                            board[i][j].setValue();
                        }
                    }else if(board[i][columns-1].getValue()== 0){//right side
                        //top
                        if ((board[i - 1][j]).getValue() == -1 ){
                            board[i][j].setValue();
                        }
                        //top-left
                        if (board[i-1][j-1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //left
                        if (board[i][j-1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //bot
                        if (board[i + 1][j].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //bot-left
                        if (board[i + 1][j -1].getValue() == -1){
                            board[i][j].setValue();
                        }

                    } 
                    else if(board[0][j].getValue()==0){//top row
                        //left
                        if (board[i][j-1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //right
                        if (board[i][j+1].getValue() == -1 ){
                            board[i][j].setValue();
                        }
                        //bot
                        if (board[i + 1][j].getValue() == -1 ){
                            board[i][j].setValue();
                        }
                        //bot-left
                        if (board[i + 1][j-1].getValue() == -1 ){
                            board[i][j].setValue();
                        }
                        //bot-right
                        if (board[i + 1][j + 1].getValue() == -1){
                            board[i][j].setValue();
                        }
                    }else if(board[rows-1][j].getValue()==0){//bot row
                        //top
                        if ((board[i-1][j]).getValue() == -1){
                            board[i][j].setValue();
                        }
                        //top-left
                        if (board[i-1][j-1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //top right
                        if (board[i-1][j+1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //left
                        if (board[i][j-1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //right
                        if (board[i][j+1].getValue() == -1){
                            board[i][j].setValue();
                        }
                    }
                    else {
                        //top
                        if ((board[i-1][j]).getValue() == -1){
                            board[i][j].setValue();
                        }
                        //top-left
                        if (board[i-1][j-1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //top-right
                        if (board[i-1][j+1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //left
                        if (board[i][j-1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //right
                        if (board[i][j+1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //bot
                        if (board[i + 1][j].getValue() == -1 ){
                            board[i][j].setValue();
                        }
                        //bot-left
                        if (board[i+1][j-1].getValue() == -1){
                            board[i][j].setValue();
                        }
                        //bot-right
                        if (board[i+1][j+1].getValue() == -1){
                            board[i][j].setValue();
                        }
                    }
                }
                
            }

        }
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */

    public void printBoard(){
        //int index  = 0;
        //int j = 0;
        for (int i = 0; i < rows; i++){
            //while(j < columns){
            for(int j = 0; j < columns; j++){
                //j++;
                if (board[i][j].getValue() == -1){
                    System.out.print("X ");
                }else{
                    System.out.print(board[i][j].getValue() + " ");
                }
                //index ++;
            }
            System.out.println();
        }
    }

    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows; i++){
            for(int j = 0; j < columns;j++){
                board[i][j]= new Cell();
                panel.add(board[i][j].getButton());
            }
        }
        return panel;
    }

}

