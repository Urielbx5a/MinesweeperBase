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
    Cell[] board;
    int rows;
    int columns;
    public MinesweeperBoard2(int row, int column){
        //Put the constructor here.

        this.rows = row;
        this.columns = column;
        board = new Cell[rows*columns];
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
    //aevaldez123@gmail.com
    public void addBombs(int bombs) {//throws Exception{

        for(int i = 0; i < bombs; i ++){
            boolean placed = false;

            while (!placed){
                int rand = (int)(Math.random() * (rows*columns) - 1);
                if (board[rand].getValue() == 0){
                    board[rand].setBomb();
                    placed = true;
                }
            }

        }

    }

    public void addNums(){
        int total = (rows * columns);

        for ( int i = 0; i < total; i++){
            
            if (board[i].getValue() != -1){
                //top
                if ((board[i - rows]).getValue() == -1 && i-rows >= 0){
                    board[i].setValue();
                }
                //top-left
                if (board[i - rows - 1].getValue() == -1 && i - rows - 1 >= 0 ){
                    board[i].setValue();
                }
                //top-right
                if (board[i - rows + 1].getValue() == -1 && i - rows + 1 >= 0){
                    board[i].setValue();
                }
                //left
                if (board[i - 1].getValue() == -1 ){
                    board[i].setValue();
                }
                //right
                if (board[i + 1].getValue() == -1 ){
                    board[i].setValue();
                }
                //bot
                if (board[i + rows].getValue() == -1 ){
                    board[i].setValue();
                }
                //bot-left
                if (board[i + rows -1].getValue() == -1 ){
                    board[i].setValue();
                }
                //bot-right
                if (board[i + rows + 1].getValue() == -1 ){
                    board[i].setValue();
                }
            }
            board[i].getValue();
        }
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int index  = 0;
        int j = 0;
        for (int i = 0; i < rows; i++){
            while(j < columns){
                j++;
                if (board[index].getValue() == -1){
                    System.out.print("X ");
                }else{
                    System.out.print(board[index].getValue() + " ");
                }
                index ++;
                
            }
            System.out.println();
            j = 0;
        }
    }

    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows*columns; i++){
            board[i]= new Cell();
            panel.add(board[i].getButton());
        }
        return panel;
    }

}
