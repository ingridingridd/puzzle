package puzzle;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.imageio.ImageIO;

public class Puzzle extends JFrame{
    public static Container contenedor;
    private BufferedImage img;
    public static Board board;
    
    public Puzzle(){
        this.setTitle("Puzzle");
        this.setSize(550,550);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        contenedor = this.getContentPane();
        
        
        try{
            img = ImageIO.read(new File("D:\\Users\\Ingrid\\Downloads\\Rompecabezas1.jpg"));
        } catch(IOException e){
            e.printStackTrace();
        }
        
        board = new Board(3,img);
        contenedor.add(board);
        this.setVisible(true);
    }
  
    public static void main(String[] args) {
        // TODO code application logic here
        new Puzzle();
    }
    
}
