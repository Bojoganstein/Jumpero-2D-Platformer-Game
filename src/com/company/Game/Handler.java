package com.company.Game;

import com.company.Entity.Entity;
import com.company.Entity.Player;
import com.company.Entity.Walker;
import com.company.Tile.Coin;
import com.company.Tile.Portal;
import com.company.Tile.Tile;
import com.company.Tile.Wall;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

// clasa ce menegeriaza toate randarile si updaturile
public class Handler {
    public  LinkedList<Entity> entity=new LinkedList<Entity>();
    public  LinkedList<Tile> tile=new LinkedList<Tile>();

    public Handler(){
    }
    //metoda ce deseneaza elementele din cele 2 liste
    public void render(Graphics g){
        for(int i=0;i<this.entity.size();i++){
            Entity e=this.entity.get(i);
            e.render(g);
        }
        for(int i=0;i<this.tile.size();i++){
            Tile t=this.tile.get(i);
            t.render(g);
        }
    }
    //metoda ce updateaza obiectele din cele 2 liste
    public void tick() {
        for(int i=0;i<this.entity.size();i++){
            Entity e=this.entity.get(i);
            e.tick();
        }
        for(int i=0;i<this.tile.size();i++){
            Tile t=this.tile.get(i);
            t.tick();
        }
    }
    //metoda ce adauga o entitate
    public void addEntity(Entity en){
        this.entity.add(en);
    }
    //metoda ce elimina o entitate
    public void removeEntity(Entity en){
        entity.remove(en);
    }
    //metoda ce adauga un tile
    public void addTile(Tile ti){
        this.tile.add(ti);
    }
    //metoda ce elimina un tile
    public void removeTile(Tile ti){
        this.tile.remove(ti);
    }
    //metoda ce interpreteaza o imagine si o transforma in harta jocului
    public void createLevel(BufferedImage level){
        int height=level.getHeight();
        int width=level.getWidth();
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                int pixel=level.getRGB(x,y);
                int red=(pixel>>16) &0xff;
                int green=(pixel>>8) &0xff;
                int blue=(pixel) &0xff;
                if(red==128 && green==64 && blue==0)
                    addTile(new Wall(x*32,y*32,1,32,32,true,Id.wall,this));
                if(red==0 && green==0 && blue==255)
                    addEntity(new Player(x*32,y*32,48,64,Id.player,this));
                if(red==255 && green==0 && blue==0)
                    addEntity(new Walker(x*32,y*32,48,64,Id.walker,this));
                if(red==255 && green==242 && blue==0)
                    addTile(new Coin(x*32,y*32,10,32,32,true,Id.coin,this));
                if(red==64 && green==0 && blue==64)
                    addTile(new Portal(x*32,y*32,10,32,32,true,Id.portal,this));
                if(red==128 && green==128 && blue==127)
                    addTile(new Wall(x*32,y*32,4,32,32,true,Id.wall,this));
                if(red==128 && green==128 && blue==128)
                    addTile(new Wall(x*32,y*32,5,32,32,true,Id.wall,this));
                if(red==128 && green==64 && blue==64)
                    addTile(new Wall(x*32,y*32,2,32,32,true,Id.wall,this));
                if(red==0 && green==128 && blue==0)
                    addTile(new Wall(x*32,y*32,10,32,32,true,Id.wall,this));
                if(red==0 && green==128 && blue==128)
                    addTile(new Wall(x*32,y*32,6,32,32,true,Id.wall,this));
                if(red==0 && green==0 && blue==64)
                    addTile(new Wall(x*32,y*32,3,32,32,true,Id.wall,this));
                if(red==255 && green==0 && blue==128)
                    addTile(new Wall(x*32,y*32,0,32,32,true,Id.wall,this));
            }
        }
    }
    // metoda ce sterge elementele din liste
    public void clearLvl(){
        entity.clear();
        tile.clear();
    }
}
