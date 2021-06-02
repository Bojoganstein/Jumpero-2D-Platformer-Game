package com.company.Game;

import com.company.Entity.Entity;
//clasa ce mentine focusul asupra playerului
public class Camera {
    int x,y;
    //metoda ce updateaza locatia camerei
    public void tick(Entity player){
        setX(-player.getX()+Game.WIDTH/2);
        setY(-player.getY()+Game.HEIGHT/2);
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
}
