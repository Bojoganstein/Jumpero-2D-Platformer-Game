package com.company.Game;

import com.company.Entity.Entity;
import com.company.Input.KeyInput;
import com.company.Input.MouseInput;
import com.company.Sprites.Texture;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

//clasa de baza a proiectului
public class Game extends Canvas implements Runnable {
    public static int WIDTH=800;
    public static int HEIGHT=600;
    public static int coins=0;
    public static int lives=3;
    private static int lvl=0;


    private  static BufferedImage levels[]=new BufferedImage[3];
    public static BufferedImage  background1;
    public static BufferedImage  background2;
    public static BufferedImage  background3;
    public static BufferedImage  victory;
    public static BufferedImage backgroundmenu;

    public enum STATE{
        MENU,GAME
    };

    public static STATE state=STATE.MENU;

    public  static boolean deathScreen=true;
    public static int deathTimer=0;
    public static boolean gameOver=false;

    private Thread thread;
    public Menu menu;
    private boolean running=false;
    public static Handler handler;
    public static Texture tex;
    public static Camera cam;


    // metoda ce initializeaza o fereastra
    public Game()
    {
        Dimension size=new Dimension(WIDTH,HEIGHT);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
    }

    //metoda de initializare a obiectelor pe care le vom folosi in joc
    private void init() throws IOException {
        handler=new Handler();
        menu=new Menu();
        tex=new Texture();
        cam=new Camera();
        addKeyListener(new KeyInput());
        addMouseListener(new MouseInput());
        levels[0]=ImageIO.read(getClass().getResource("/level1.png"));
        levels[1]=ImageIO.read(getClass().getResource("/level2.png"));
        levels[2]=ImageIO.read(getClass().getResource("/background3.png"));

        backgroundmenu=ImageIO.read(getClass().getResource("/backgroundmenu.jpg"));

        background1=ImageIO.read(getClass().getResource("/back.jpg"));
        background2=ImageIO.read(getClass().getResource("/hard.jpg"));
        victory=ImageIO.read(getClass().getResource("/v1ctory.jpg"));

    }

    //metoda sincrona de pornire a unui Thread
    public synchronized void start() {
        if(running) return;
        running=true;
        thread=new Thread(this,"Thread");
        thread.start();
    }

    // metoda sincrona  de oprire a unui Thread
    public synchronized void stop() {
        if(!running) return;
        running=false;
        try{
        thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //metoda pentru determinarea FPS si nr de updaturi
    public void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        requestFocus();
        long lastTime=System.nanoTime();
        long timer=System.currentTimeMillis();
        double delta=0;
        double ns=1000000000.0/60.0;
        int frames=0;
        int ticks=0;

        while(running) {
            long now=System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            while(delta>=1){
                tick();
                ticks++;
                delta--;
            }
            render();
            frames++;
            if(System.currentTimeMillis()-timer>1000){
                timer+=1000;
                System.out.println("Frames Per Second: "+frames+" , Ticks: "+ticks);
                frames=0;
                ticks=0;
            }
        }
        stop();
    }

    //metoda ce deseneaza backgroundul + ecran mort,victorie si infrangere
    public void render()  {
        BufferStrategy bs=getBufferStrategy();
        if(bs==null){
            createBufferStrategy(3);
            return;
        }
        Graphics g=bs.getDrawGraphics();
        if(state==STATE.GAME) {
            if (lvl == 0)
                g.drawImage(background1, 0, 0, getWidth(), getHeight(), null);
            else if (lvl == 1)
                g.drawImage(background2, 0, 0, getWidth(), getHeight(), null);
            else if (lvl == 2) {
                g.drawImage(background3, 0, 0, getWidth(), getHeight(), null);
                g.drawImage(victory, 0, 0, getWidth(), getHeight(), null);

            }
            if (!deathScreen) {
                g.drawImage(Texture.points[2].getBufferedImage(), 50, 20, 48, 48, null);
                g.setColor(Color.YELLOW);
                g.setFont(new Font("Courier", Font.BOLD, 30));
                g.drawString("x" + coins, 100, 100);
            } else {
                if (!gameOver) {
                    g.setColor(Color.WHITE);
                    g.drawImage(Texture.player[0].getBufferedImage(), 350, 200, 96, 128, null);
                    g.drawImage(Texture.points[3].getBufferedImage(), 280, 330, 64, 64, null);
                    g.setFont(new Font("Courier", Font.BOLD, 50));
                    g.setColor(Color.WHITE);
                    g.drawString("Lives:" + lives, 350, 375);
                } else {
                    g.drawImage(Texture.go[0].getBufferedImage(), 0, 0, 800, 600, null);
                }

            }

            g.translate(cam.getX(), cam.getY());
            if (!deathScreen)
                handler.render(g);
        }
        else if(state==STATE.MENU){
            g.drawImage(backgroundmenu,0,0,getWidth(),getHeight(),null);
            menu.render(g);
        }
        g.dispose();
        bs.show();
    }

    //metoda de update a clasei de baza
    public void tick()  {
        if(state==STATE.GAME) {
            handler.tick();
            for (Entity en : handler.entity) {
                if (en.getId() == Id.player)
                    cam.tick(en);
            }

            if (deathScreen && !gameOver)
                deathTimer++;
            if (deathTimer >= 100) {
                deathScreen = false;
                deathTimer = 0;
                handler.clearLvl();
                handler.createLevel(levels[lvl]);
            }
        }

    }

    //metoda de incarcare ce permite trecerea la un nou nivel
    public static void nextLvl(){
        Game.lvl++;
        handler.clearLvl();
        handler.createLevel(levels[lvl]);

    }
    //functia main principala
    public static void main(String[] args) {
        Singleton game=Singleton.getInstance();
        JFrame frame=new JFrame("Jumpero");
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        game.start();
    }


}
