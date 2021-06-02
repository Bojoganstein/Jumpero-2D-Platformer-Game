package com.company.Tile;

import com.company.Game.Handler;
import com.company.Game.Id;
import com.company.Sprites.Texture;

import java.awt.*;
//clasa ce incapsuleaza idea de moneda
public class Coin extends Tile {
    public int frame = 0;
    private int frameDelay = 0;
    public Coin(int x, int y,int type, int width, int height,boolean solid, Id id, Handler handler) {
        super(x,y,type,width,height,solid,id,handler);
    }

    //metoda ce deseneaza moneda pe ecran
    public void render(Graphics g) {
        g.drawImage(Texture.points[frame].getBufferedImage(), x, y, width, height, null);

    }

    //metoda ce permite updatul monedei(pentru a fii randat)
    public void tick() {
        frameDelay++;
        if (frameDelay >= 20) {
            frame++;
            if (frame >= 3) {
                frame = 0;
            }
            frameDelay = 0;
        }

    }
}
