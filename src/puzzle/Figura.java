/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puzzle;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Figura extends JButton implements ActionListener{
    private final int xSolPos, ySolPos;
    private int xPos, yPos;
    private int dimension;
    
    public Figura(int xSolPos, int ySolPos, ImageIcon subimage, int dimension){
        this.xSolPos = xSolPos;
        this.ySolPos = ySolPos;
        this.dimension = dimension;
        
        xPos = xSolPos;
        yPos = ySolPos;
        
        this.setIcon(subimage);
        this.setPreferredSize(new Dimension(subimage.getIconWidth(), subimage.getIconHeight()));
        this.addActionListener(this);
    } 
    
    public int getxPos(){
        return xPos;
    }
    
    public void setxPos(int xPos){
        this.xPos = xPos;
    }
    
    public int getyPos(){
        return yPos;
    }
    
    public void setyPos(int yPos){
        this.yPos = yPos;
    }
    
    public int getxSolPos(){
        return xSolPos;
    }
    
    public int getySolPos(){
        return ySolPos;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0){
        Move();
    }
    
    private void Move(){
        Cell[][] board = Board.board;
        try{
        if(board[xPos][yPos-1].getFigura() == null){
            Board.board[xPos][yPos-1].setFigura(this);
            Board.board[xPos][yPos].setFigura(this);
            yPos--;
            Puzzle.board.Remover();
            ComprobarRespuesta();
        }
        }catch(ArrayIndexOutOfBoundsException e){
                
        }
        
        try{
        if(board[xPos][yPos+1].getFigura() == null){
            Board.board[xPos][yPos+1].setFigura(this);
            Board.board[xPos][yPos].setFigura(this);
            yPos++;
            Puzzle.board.Remover();
            ComprobarRespuesta();
        }
        }catch(ArrayIndexOutOfBoundsException e){
                
        }
        
        try{
        if(board[xPos+1][yPos].getFigura() == null){
            Board.board[xPos+1][yPos].setFigura(this);
            Board.board[xPos][yPos].setFigura(this);
            xPos++;
            Puzzle.board.Remover();
            ComprobarRespuesta();
            return;
        }
        }catch(ArrayIndexOutOfBoundsException e){
                
        }
        
        try{
        if(board[xPos-1][yPos].getFigura() == null){
            Board.board[xPos-1][yPos].setFigura(this);
            Board.board[xPos][yPos].setFigura(this);
            xPos--;
            Puzzle.board.Remover();
            ComprobarRespuesta();
        }
        }catch(ArrayIndexOutOfBoundsException e){     
        }
        
     }
    private void ComprobarRespuesta(){
        Figura figura = null;
        for(int i=0; i< dimension; i++){
            for(int j=0; j< dimension; j++){
                figura = Board.board[i][j].getFigura();
                if(figura == null){
                    continue;
                }
                if(figura.getxPos() != figura.getxSolPos() || figura.getyPos() != figura.getySolPos()){
                
                    return;
                
                }
            }
        }
    }
}
