package com.company.Game;

import java.awt.*;
//clasa ce deseneaza pe ecran butoanele de pornire
public class Menu {
    public Rectangle playButton=new Rectangle(350,300,150,100);
    public Rectangle exitButton=new Rectangle(350,450,150,100);
    //metoda ce deseneaza efectiv ecranul de inceput al jocului
    public void render(Graphics g){
        Graphics2D g2d=(Graphics2D)g;

        Font f=new Font("arial",Font.BOLD,75);
        g.setFont(f);
        g.setColor(Color.GREEN);
        g.drawString("Jumpero",250,200);
        Font f1=new Font("arial",Font.BOLD,75);
        g.setColor(Color.WHITE);
        g.setFont(f1);
        g.drawString("Play",playButton.x,playButton.y+75);
        g2d.draw(playButton);
        g.drawString("Exit",exitButton.x,exitButton.y+75);
        g2d.draw(exitButton);
    }
}
