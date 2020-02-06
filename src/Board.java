import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Board extends JPanel{

    Image cardImages;
    int boardX = 20, boardY = 20, boardW = 102, boardH = 140, cardX = 2, cardY = 2, cardW = 72, cardH = 96;
    int gapW = 1, gapH = 2;

    public Board(){
        setBackground(new Color(130, 50, 40));
        setPreferredSize(new Dimension(600, 800));
        loadImage();
    }

    public static void main(String[] args){
        JFrame game = new JFrame("Card Graphics");
        Board board = new Board();
        game.setContentPane(board);
        game.pack();
        game.setLocationRelativeTo(null);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                g.drawImage(cardImages, boardX+(100*i), boardY+(100*i), boardW, boardH, cardX+(i*10*gapW), cardY+(i*10*gapH), cardW, cardH, this);
            }
        }
    }

    private void loadImage(){
        ClassLoader cl = getClass().getClassLoader();
        URL imageURL = cl.getResource("cards.png");
        if (imageURL != null){
            cardImages = Toolkit.getDefaultToolkit().createImage(imageURL);
        }
    }

}
