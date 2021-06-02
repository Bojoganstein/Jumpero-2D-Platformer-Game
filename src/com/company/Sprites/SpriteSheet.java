package com.company.Sprites;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

//clasa ce ia o imagine si o desparte in mai multe sprite-uri
public class SpriteSheet {
    private BufferedImage sheet;
    SpriteSheet(String path) throws IOException {
        sheet= ImageIO.read(getClass().getResource(path));
    }

    public BufferedImage getSprite(int col,int row,int width,int height){
        return sheet.getSubimage(col*width,row*height,width,height);
    }
}
