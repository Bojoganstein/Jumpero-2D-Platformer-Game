package com.company.Tile;

import com.company.Game.Handler;
import com.company.Game.Id;

import java.awt.*;
//clasa ce implementeaza blocul care avanseaza in nivel
public class Portal extends Tile {
    public Portal(int x, int y, int type, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, type, width, height, solid, id, handler);
    }
    //coloreaza blocul
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x,y,width,height);

    }

    public void tick() {

    }
}
