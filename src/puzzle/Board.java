/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ingrid
 */
public class Board extends JPanel{
    
    public static Cell[][] board;
    private ArrayList<Cell> completeBoard = new ArrayList<Cell>();
    private int dimension;
    private int x,y;
    private int figuraWidth, figuraHeight;
    private JLabel empty;
    
    
    public Board(int dimension, BufferedImage rompecabezas){
        this.dimension = dimension;
        board = new Cell[dimension][dimension];
        this.setBackground(Color.black);
        x = 0;
        y = 0;
        figuraWidth = rompecabezas.getWidth()/dimension;
        figuraHeight = rompecabezas.getHeight()/dimension;
        
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        
        for(int i=0; i<dimension ; i++){
            for(int j =0; j< dimension; j++){
                if(i==dimension-1 && j == dimension-1){
                    continue;
                }
                
                completeBoard.add(new Cell(i,j, new Figura(i,j, new ImageIcon(rompecabezas.getSubimage(x,y, figuraWidth, figuraHeight)), dimension)));
            x += figuraWidth;
            }
            x =0;
            y += figuraHeight;
        }
        
        Desordenar();
        Remover();
    
    }
    
    private void Desordenar(){
        Random generador = new Random();
        ArrayList<Cell> copia = new ArrayList<Cell>(completeBoard);
        for(int i=0; i<dimension ; i++){
            for(int j =0; j< dimension; j++){
                if(i==dimension-1 && j == dimension-1){
                    board[i][j] = new  Cell(i,j);
                    continue;
                }
                int aleatorio = generador.nextInt(completeBoard.size());
                completeBoard.get(aleatorio).getFigura().setxPos(i);
                completeBoard.get(aleatorio).getFigura().setyPos(j);
                board[i][j] = new Cell(i,j,completeBoard.get(aleatorio).getFigura());
                completeBoard.remove(aleatorio);
            }
        }
        completeBoard = copia;
        Remover();
    }        
            
    private void Actualizar(){
        for(int i =0; i< dimension; i++){
            for(int j=0; j<dimension; j++){
                if(board[i][j].getFigura()== null){
                    empty = new JLabel();
                    empty.setPreferredSize(new Dimension(figuraWidth, figuraHeight));
                    this.add(empty);
                    continue;
                }
                this.add(board[i][j].getFigura());
            }
        }
        
        Puzzle.contenedor.validate();
    }
    
    private void Remover(){
        this.removeAll();
        Actualizar();
    }
    
}
