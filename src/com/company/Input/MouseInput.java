package com.company.Input;

import com.company.Game.Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//clasa ce permite interactiunea playerului prin intermediul mouse-ului
public class MouseInput implements MouseListener {
    public void mouseClicked(MouseEvent mouseEvent) {

    }
    //metoda ce preia miscarea si pozitia mous-ului la un moment dat
    public void mousePressed(MouseEvent mouseEvent) {
        int mx= mouseEvent.getX();
        int my=mouseEvent.getY();
        if(mx>=350 && mx<=500){
            if(my>=300 && my<=400){
                Game.state=Game.STATE.GAME;
            }else if(my>=450 && my<=550)
                System.exit(1);
        }

    }

    public void mouseReleased(MouseEvent mouseEvent) {

    }

    public void mouseEntered(MouseEvent mouseEvent) {

    }

    public void mouseExited(MouseEvent mouseEvent) {

    }
}
