package com.company.Entity;


import com.company.Game.Game;
import com.company.Game.Handler;
import com.company.Game.Id;
import com.company.Sprites.Texture;
import com.company.Tile.Tile;

import java.awt.*;
import java.util.LinkedList;

//clasa ce prezinta idea de player
public class Player extends Entity {
    public int frame = 0;
    private int frameDelay = 0;

    public Player(int x, int y, int width, int height, Id id, Handler handler) {
        super(x, y, width, height, id, handler);
    }
    //metoda ce deseneaza si animeaza miscarile playerului
    public void render(Graphics g) {
        if(facing==-1){
           if(jumping )
                g.drawImage(Texture.player[frame+11].getBufferedImage(), x, y, width, height, null);
            else
                g.drawImage(Texture.player[frame+7].getBufferedImage(), x, y, width, height, null);
    }else
        if(facing==1){
            if(jumping )
                g.drawImage(Texture.player[frame+4].getBufferedImage(), x, y, width, height, null);
            else
                g.drawImage(Texture.player[frame].getBufferedImage(), x, y, width, height, null);
        }
    }
    //metoda ce updateaza playerul si coliziunea acestuia cu mediul
    public void tick()  {
        x += velX;
        y += velY;
        boolean animate;
        if(velX!=0)
            animate =true;
        else
            animate =false;
        for (int i=0;i<handler.tile.size();i++) {
            Tile t=handler.tile.get(i);
                if(t.getId()==Id.portal){
                    if(getBounds().intersects(t.getBounds())){
                        Game.nextLvl();
                    }
                }
                if(t.getId()==Id.coin)
                    if(getBounds().intersects(t.getBounds())) {
                      Game.coins++;
                     handler.removeTile(t);
                 }
                if (getBoundsTop().intersects(t.getBounds()) && t.getId()!=Id.coin) {
                    setVelY(0);

                    if (jumping) {
                        jumping = false;
                        gravity = 0.8;
                        falling = true;

                    }

                }
                if (getBoundsBottom().intersects(t.getBounds())&& t.getId()!=Id.coin) {

                    y = t.getY() - height;
                    if (falling)
                        falling = false;

                } else if (!falling && !jumping) {
                    gravity = 0.0;
                    falling = true;
                }

                if (getBoundsLeft().intersects(t.getBounds())&& t.getId()!=Id.coin) {
                    setVelX(0);
                    x = t.getX() + width - width / 3;
                }
                if (getBoundsRight().intersects(t.getBounds())&& t.getId()!=Id.coin) {
                    setVelX(0);
                    x = t.getX() - width;
                }
        }
        Colision(handler.entity);


        if (jumping) {
            gravity -= 0.1;
            setVelY((int) -gravity);
            if (gravity <= 0.0) {
                jumping = false;
                falling = true;
            }
        }
        if (falling) {
            gravity += 0.1;
            setVelY((int) gravity);
        }
        if(animate) {
            if (jumping || falling) {

                frameDelay++;
                if (frameDelay >= 15) {
                    frame++;
                    if (frame >= 3) {
                        frame = 0;
                    }
                    frameDelay = 0;
                }
            }else{
            frameDelay++;
            if (frameDelay >= 10) {
                frame++;
                if (frame >= 5) {
                    frame = 0;
                }
                frameDelay = 0;
            }
        }
        }
    }
    //metoda ce implementeaza coliziunile playerului cu alte entitati
    public void Colision(LinkedList<Entity> entities)
    {
        for(int i=0;i<entities.size();i++){
            Entity e=entities.get(i);
            if(e.getId()==Id.walker){
                if(getBoundsBottom().intersects(e.getBoundsTop())) {
                    die(e);
                    Game.coins += 25;
                    if(Game.coins>=100){
                        Game.lives++;
                        Game.coins%=100;
                    }

                } else if(getBounds().intersects(e.getBounds())){
                    die(this);
                }

            }

        }
    }
}
