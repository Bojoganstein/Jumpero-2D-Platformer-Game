package com.company.Entity;

import com.company.Game.Game;
import com.company.Game.Handler;
import com.company.Game.Id;

import java.awt.*;
//clasa abstracta ce incapsuleaza idea de entitate ce se misca
public abstract class Entity { //clasa
    public int x,y;
    public int width,height;
    public int velX,velY;
    public boolean jumping=false;
    public boolean falling=true;
    public double gravity=0.5;
    public int facing=-1;//-1=left ,1=right
    public Id id;
    public Handler handler;

    public Entity(int x,int y,int width,int height,Id id,Handler handler){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.id=id;
        this.handler=handler;
    }
    //metoda ce elimina o entitate din lista(inclusiv playerul)
    public void die(Entity e){
        handler.removeEntity(e);
        if(e.id==Id.player){
            Game.coins-=25;
            if(Game.coins<=0)
                Game.coins=0;
            Game.lives--;
            Game.deathScreen=true;
            if(Game.lives<=0)
                Game.gameOver=true;
        }
    }

    public abstract void render(Graphics g);
    public abstract void tick() ;

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

    public Rectangle getBoundsTop(){
        return new Rectangle(getX()+6,getY(),width-12,height/2);
    }
    public Rectangle getBoundsBottom(){
        return new Rectangle(getX()+6,getY()+height/2,width-12,height/2);
    }
    public Rectangle getBoundsLeft(){
        return new Rectangle(getX(),getY()+5,5,height-10);
    }
    public Rectangle getBoundsRight(){
        return new Rectangle(getX()+width-5,getY()+5,5,height-10);
    }


}
