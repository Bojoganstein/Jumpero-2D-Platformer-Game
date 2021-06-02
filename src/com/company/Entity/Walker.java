package com.company.Entity;

import com.company.Game.Handler;
import com.company.Game.Id;
import com.company.Sprites.Texture;
import com.company.Tile.Tile;

import java.awt.*;
import java.util.Random;
//clasa ce implementeaza conceptul de inamic
public class Walker extends Entity {
    public int frame = 0;
    private int frameDelay = 0;
    private Random random=new Random();
    public Walker(int x, int y, int width, int height, Id id, Handler handler) {
        super(x, y, width, height, id, handler);
        int dir=random.nextInt(2);
        //face inamicul sa porneasca intr-o directie random
        switch (dir){
            case 0:
                setVelX(2);
                facing=1;
                break;
            case 1:
                setVelX(-2);
                facing=-1;
                break;
        }
    }
    //metoda ce deseneaza si animeaza inamicul
    public void render(Graphics g) {
        if(facing==-1){
                g.drawImage(Texture.walker[frame+4].getBufferedImage(), x, y, width, height, null);
        }else
        if(facing==1){
                g.drawImage(Texture.walker[frame].getBufferedImage(), x, y, width, height, null);
        }

    }
    //metoda ce updateaza si schimba directia inamicului
    public void tick() {
        x += velX;
        y += velY;
        for (int i = 0; i < handler.tile.size(); i++) {
            Tile t = handler.tile.get(i);

                if(getBoundsBottom().intersects((t.getBounds()))){
                    setVelY(0);
                    if(falling)
                        falling=false;
                }else if(!falling){
                    falling=true;
                    gravity=0.0;
                }
                if(getBoundsLeft().intersects(t.getBounds())){
                    setVelX(2);
                    facing=1;
                }
                if(getBoundsRight().intersects(t.getBounds())){
                    setVelX(-2);
                    facing=-1;
                }

        }
        if(falling){
            gravity+=0.1;
            setVelY((int)gravity);
        }
        frameDelay++;
        if (frameDelay >= 10) {
            frame++;
            if (frame >= 3) {
                frame = 0;
            }
            frameDelay = 0;
        }


    }
}
