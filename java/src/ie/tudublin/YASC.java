package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet {
    boolean[] keys = new boolean[1024];

    float x, y; //x and y are going to be the center point of the player ship
    float w = 50; //the width of the player
    float halfW = w/2; 

    void drawPlayer(float x, float y)
    {
        // Write this method
        line(x - halfW, y + halfW, x, y - halfW);
        line(x, y - halfW, x + halfW, y + halfW);
        line(x + halfW, y + halfW, x, y);
        line(x, y, x - halfW, y + halfW);
    }

    void movePlayer()
    {

        if(checkKey(UP))
        {
            y -= 1;
        }

        if(checkKey(DOWN))
        {
            y += 1;
        }

        if(checkKey(RIGHT))
        {
            x += 1;
        }

        if(checkKey(LEFT))
        {
            x -= 1;
        }
    }

    public void settings() {
        size(512, 512);

    }

    public void setup() {
        x = width / 2;
        y = height / 2;
    }

    public void draw() {
        background(0);
        stroke(255);
        drawPlayer(x, y);
        movePlayer();
    }

    boolean checkKey(int k) {
        if (keys.length >= k) {
            return keys[k] || keys[Character.toUpperCase(k)]; //checks the uppercase and lowercase of keycode is being pressed
        }

        return false;
    }

    public void mousePressed() {

    }

    public void keyPressed() {
        keys[keyCode] = true; //keycode is what key was pressed
    }

    public void keyReleased() {
        keys[keyCode] = false; //assigns keys at position keycode to be false
    }
}
