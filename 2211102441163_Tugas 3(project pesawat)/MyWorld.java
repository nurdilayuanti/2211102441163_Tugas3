import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    ScoreBoard scoreBoard;
    public ScoreBoard getScoreBoard(){
        return this.scoreBoard;
    }

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 550, 1);
        spawnPlayer();
        this.scoreBoard = new ScoreBoard();
        this.addObject(scoreBoard, 60, 30);
    }

    private void spawnPlayer(){
        Random rnd = new Random();
        PLayer p1 = new PLayer();
        p1.setRotation(270);
        this.addObject(p1, rnd.nextInt(getWidth() -30), this.getHeight()-30);
    }

    private void spawnEnemies(){
        Random rnd = new Random();
        for(int i= 0; i<rnd.nextInt(5); i++){
            Enemies en = new Enemies();
            this.addObject(en, rnd.nextInt(this.getWidth() - 30), 5);
        }
    }

    public void act(){
        List<Enemies> enemies = this.getObjects(Enemies.class);
        System.out.println(enemies.size());
        if(enemies.size()==0){
            spawnEnemies();
        }
    }
}
