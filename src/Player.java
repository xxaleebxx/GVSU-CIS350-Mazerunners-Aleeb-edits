package game.src.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {

    private double x; // x-coordinate of player
    private double y; // y-coordinate of player
    private double volX = 0;
    private double volY = 0;
    public double volMod = 1;
//    public int health = 3;

    private BufferedImage player;

    public Player(double x, double y, MazeGame game){
        this.x = x;
        this.y = y;

        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());

        player = ss.grabImage(1, 1, 32, 32);
        //change coordinates depending on future sprite sheet
    }

    public void tick(){
        if (volX != 0 && volY != 0) {
            x += volX / 2 * volMod;
            y += volY / 2 * volMod;
        }
        else {
            x += volX * volMod;
            y += volY * volMod;
        }
    }

    public void render(Graphics g){
        g.drawImage(player, (int)x, (int)y, null);
    }

    public double[] getBounds() {
        double[] bounds = new double[4];
        bounds[0] = getX();
        bounds[1] = getY();
        bounds[2] = getX() + player.getWidth();
        bounds[3] = getY() + player.getHeight();

        return bounds;
    }

//    public void setHealth(int change) {
//        this.health += change;
//    }
//
//    public int getHealth(){
//        return health;
//    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setVolX(double volX){
        this.volX = volX;
    }

    public void setVolY(double volY){
        this.volY = volY;
    }

    public void setVolMod(double volMod) { this.volMod = volMod; }
}