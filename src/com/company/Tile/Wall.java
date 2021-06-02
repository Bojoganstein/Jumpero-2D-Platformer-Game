package com.company.Tile;

import com.company.Game.Handler;
import com.company.Game.Id;
import com.company.Sprites.Texture;

import java.awt.*;
//clasa ce prezinta atributele unui block solid
public class Wall extends Tile{
    public Wall(int x, int y,int type, int width, int height,boolean solid, Id id, Handler handler) {
        super(x, y,type, width, height,solid ,id, handler);
    }
    //metoda ce deseneaza pe ecran tipul de block
    public void render(Graphics g) {
        switch (type) {
            case 0:
                g.drawImage(Texture.block[0].getBufferedImage(), x, y, width, height, null);
                break;
            case 1:
                g.drawImage(Texture.block[1].getBufferedImage(), x, y, width, height, null);
                break;
            case 2:
                g.drawImage(Texture.block[2].getBufferedImage(), x, y, width, height, null);
                break;
            case 3:
                g.drawImage(Texture.block[3].getBufferedImage(), x, y, width, height, null);
                break;
            case 4:
                g.drawImage(Texture.block[4].getBufferedImage(), x, y, width, height, null);
                break;
            case 5:
                g.drawImage(Texture.block[5].getBufferedImage(), x, y, width, height, null);
                break;
            case 6:
                g.drawImage(Texture.block[6].getBufferedImage(), x, y, width, height, null);
                break;
            case 7:
                g.drawImage(Texture.block[7].getBufferedImage(), x, y, width, height, null);
                break;
            case 8:
                g.drawImage(Texture.block[8].getBufferedImage(), x, y, width, height, null);
                break;
            case 9:
                g.drawImage(Texture.block[9].getBufferedImage(), x, y, width, height, null);
                break;
            case 10:
                g.drawImage(Texture.block[10].getBufferedImage(), x, y, width, height, null);
                break;
            case 11:
                g.drawImage(Texture.block[11].getBufferedImage(), x, y, width, height, null);
                break;
            case 12:
                g.drawImage(Texture.block[12].getBufferedImage(), x, y, width, height, null);
                break;
            case 13:
                g.drawImage(Texture.block[13].getBufferedImage(), x, y, width, height, null);
                break;
            case 14:
                g.drawImage(Texture.block[14].getBufferedImage(), x, y, width, height, null);
                break;
        }
    }


    public void tick() {

    }
}
