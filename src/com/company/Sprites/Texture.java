package com.company.Sprites;

import java.io.IOException;
//clasa ce incarca toate elementele grafice din joc
public class Texture {
    private static SpriteSheet block_sheet=null;
    private static SpriteSheet player_sheet=null;
    private static SpriteSheet walker_sheet=null;
    private static SpriteSheet points_sheet=null;
    private static SpriteSheet gOver=null;

    public static Sprite block[]=new Sprite[15];
    public static Sprite player[]=new Sprite[14];
    public static Sprite walker[]=new Sprite[8];
    public static Sprite points[]=new Sprite[4];
    public static Sprite go[]=new Sprite[1];
    //metoda ce leaga fiecare imagine de o variabila
    public Texture() throws IOException {
        block_sheet=new SpriteSheet("/block.jpg");
        player_sheet=new SpriteSheet("/player.png");
        walker_sheet=new SpriteSheet("/walker.png");
        points_sheet=new SpriteSheet("/point&life.png");
        gOver=new SpriteSheet("/gameover.jpg");
        getTexture();
    }
    //metoda ce incarca toate sprite-urile din joc
    private void getTexture(){
        block[0]=new Sprite(block_sheet,0,0,32,32);
        block[1]=new Sprite(block_sheet,1,0,32,32);
        block[2]=new Sprite(block_sheet,2,0,32,32);
        block[3]=new Sprite(block_sheet,3,0,32,32);
        block[4]=new Sprite(block_sheet,4,0,32,32);
        block[5]=new Sprite(block_sheet,5,0,32,32);
        block[6]=new Sprite(block_sheet,6,0,32,32);
        block[7]=new Sprite(block_sheet,7,0,32,32);
        block[8]=new Sprite(block_sheet,0,1,32,32);
        block[9]=new Sprite(block_sheet,1,1,32,32);
        block[10]=new Sprite(block_sheet,2,1,32,32);
        block[11]=new Sprite(block_sheet,3,1,32,32);
        block[12]=new Sprite(block_sheet,4,1,32,32);
        block[13]=new Sprite(block_sheet,5,1,32,32);
        block[14]=new Sprite(block_sheet,6,1,32,32);

        //walk right
        player[0]=new Sprite(player_sheet,0,0,48,64);
        player[1]=new Sprite(player_sheet,1,0,48,64);
        player[2]=new Sprite(player_sheet,2,0,48,64);
        player[3]=new Sprite(player_sheet,3,0,48,64);

        //jump to the right
        player[4]=new Sprite(player_sheet,0,1,48,64);
        player[5]=new Sprite(player_sheet,1,1,48,64);
        player[6]=new Sprite(player_sheet,2,1,48,64);

        //walk left
        player[7]=new Sprite(player_sheet,0,2,48,64);
        player[8]=new Sprite(player_sheet,1,2,48,64);
        player[9]=new Sprite(player_sheet,2,2,48,64);
        player[10]=new Sprite(player_sheet,3,2,48,64);

        //jump to the left
        player[11]=new Sprite(player_sheet,0,3,48,64);
        player[12]=new Sprite(player_sheet,1,3,48,64);
        player[13]=new Sprite(player_sheet,2,3,48,64);

        //walk right
        walker[0]=new Sprite(walker_sheet,0,0,48,64);
        walker[1]=new Sprite(walker_sheet,1,0,48,64);
        walker[2]=new Sprite(walker_sheet,2,0,48,64);
        walker[3]=new Sprite(walker_sheet,3,0,48,64);

        //walk left
        walker[4]=new Sprite(walker_sheet,0,2,48,64);
        walker[5]=new Sprite(walker_sheet,1,2,48,64);
        walker[6]=new Sprite(walker_sheet,2,2,48,64);
        walker[7]=new Sprite(walker_sheet,3,2,48,64);

        points[0]=new Sprite(points_sheet,0,0,32,32);
        points[1]=new Sprite(points_sheet,1,0,32,32);
        points[2]=new Sprite(points_sheet,2,0,32,32);
        points[3]=new Sprite(points_sheet,0,1,32,32);

        go[0]=new Sprite(gOver,0,0,256,190);





    }
}
