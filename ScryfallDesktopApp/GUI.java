import java.awt.Dimension;
import javax.swing.*;

//This file is in the View in the MVC
public class GUI {

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


        //Initialize GUI elements
        JFrame mainFrame = new JFrame("Scryfall Desktop");
        JPanel mainPanel = new JPanel();
        JLabel label = new JLabel("Search for a card");
        JTextField searchField = new JTextField("Type card name here");
        JButton searchButton = new JButton("Search");

        //Put the elements in the mainFrame
        mainPanel.add(label);
        mainPanel.add(searchField);
        mainPanel.add(searchButton);
        mainFrame.add(mainPanel);

        //Pack, make ready, and make visible the mainFrame
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(searchField);
        mainFrame.setPreferredSize(new Dimension(500,500));
        mainFrame.setVisible(true);
    }

}
