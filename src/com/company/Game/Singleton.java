package com.company.Game;
//clasa singleton ce permite o singura instantiere a jocului
public class Singleton extends Game {
    public Game game;
    private static Singleton instance=null;
    private Singleton()
    {
        game=new Game();
    }

    public static Singleton getInstance()
    {
        if(instance==null)
            instance=new Singleton();
        return instance;
    }
}
