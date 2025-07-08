import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;

//This file is in the View in the MVC
public class GUI {
    ImageIcon cardArt;

    GUI(){
        //Set Look and Feel
        try{
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName()
            );
        } catch (Exception e){
            System.out.println("Unable to initialize GUI");
            System.exit(1);
        }


        //Initialize the mainGUI elements
        JFrame mainFrame = new JFrame("Scryfall Desktop");
        JPanel mainPanel = new JPanel();

        //Set the Layout
        mainPanel.setLayout(new BorderLayout());
        JPanel northPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        //Put serach elements in the northPanal
        JLabel searchLabel = new JLabel("Search for a card:");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        northPanel.add(searchLabel);
        northPanel.add(searchField);
        northPanel.add(searchButton);

        //Put card elements in the centerPanel
        BufferedImage bufferedCardArt = null;
        try {
            bufferedCardArt = ImageIO.read(new File("graphics/card_back.jpeg"));
        } catch (Exception e) {
            System.err.println("Cannot load image");
        }
        cardArt = new ImageIcon(bufferedCardArt);
        JLabel imageLabel = new JLabel(cardArt);
        centerPanel.add(imageLabel);

        //Put the elements in the mainFrame
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainFrame.add(mainPanel);

        //Pack, make ready, and make visible the mainFrame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setPreferredSize(new Dimension(600,600));
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(searchField);
        mainFrame.setVisible(true);
    }

}
