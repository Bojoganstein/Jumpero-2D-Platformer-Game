package com.company.Tile;
import com.company.Game.Handler;
import com.company.Game.Id;

import java.awt.*;
//clasa abstracta ce prezinta atributele unui block
public abstract class Tile {
    public int x,y;
    public boolean solid;
    public int width,height;
    public int velX,velY;
    public int type;
    public Id id;
    public Handler handler;

    public Tile(int x,int y,int type,int width,int height,boolean solid,Id id,Handler handler){
        this.x=x;
        this.y=y;
        this.type=type;
        this.width=width;
        this.height=height;
        this.solid=solid;
        this.id=id;
        this.handler=handler;
    }

    public abstract void render(Graphics g);
    public abstract void tick();

    public void die(){
        handler.removeTile(this);
    }

    public int  getX(){
        return x;
    }

    public void setX(int x){
        this.x=x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y=y;
    }

    public boolean isSolid(){ return solid; };

    public void setVelX(int velX){
        this.velX=velX;
    }

    public void setVelY(int velY){
        this.velY=velY;
    }

    public Id getId() {
        return id;
    }
    public Rectangle getBounds(){
        return new Rectangle(getX(),getY(),width,height);
    }
}
