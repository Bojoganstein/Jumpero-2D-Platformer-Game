package com.company.Sprites;

import com.company.Sprites.SpriteSheet;

import java.awt.image.BufferedImage;
//clasa ce preia un singur sprite
public class Sprite {
    public SpriteSheet sheet;
    public BufferedImage image;
    public Sprite(SpriteSheet sheet,int x,int y,int width,int height){
        image=sheet.getSprite(x,y,width,height);
    }
    public BufferedImage getBufferedImage(){
        return image;
    }
}
