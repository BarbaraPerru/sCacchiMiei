package com.scacchimiei;

import javax.swing.JFrame;

public class App 
{
    public static void main( String[] args )
    {
        // Creating the screen
        JFrame window = new JFrame("Chess");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        // Add GamePanel to the screen
        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.launchGame();

    }
}
