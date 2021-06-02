package com.company.Input;

import com.company.Entity.Entity;
import com.company.Game.Game;
import com.company.Game.Id;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//clasa ce permite interactiunea cu jocul prin intermediul tastaturii
public class KeyInput implements KeyListener {
    public void keyTyped(KeyEvent keyEvent) {

    }
    //metoda cu ajutorul careia playerul se misca la apasarea tastelor
    public void keyPressed(KeyEvent k) {
        int key=k.getKeyCode();
        for(Entity en: Game.handler.entity) {
            if (en.getId() == Id.player) {
                switch (key) {
                    case KeyEvent.VK_UP:
                        if (en.jumping == false) {
                            en.jumping = true;
                            en.gravity = 4.5;
                        }
                        break;

                    case KeyEvent.VK_LEFT:
                        en.setVelX(-5);
                        en.facing = -1;
                        break;
                    case KeyEvent.VK_RIGHT:
                        en.setVelX(5);
                        en.facing = 1;
                        break;
                }
            }
        }

    }
    //metoda ce implementeaza cazul in care ridicam degetul de pe o tasta
    public void keyReleased(KeyEvent k) {
        int key = k.getKeyCode();
        if (Game.state == Game.STATE.GAME) {
            for (Entity en : Game.handler.entity) {
                if (en.getId() == Id.player) {
                    switch (key) {
                        case KeyEvent.VK_UP:
                            en.setVelY(0);
                            break;
                        case KeyEvent.VK_LEFT:
                            en.setVelX(0);
                            break;
                        case KeyEvent.VK_RIGHT:
                            en.setVelX(0);
                            break;
                    }
                }
            }

        }
    }
}
