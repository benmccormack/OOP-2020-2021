package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet {
    boolean[] keys = new boolean[1024];

    Player p;
    Player p1;

    public void settings() {
        size(512, 512);

    }

    public void setup() {
        p = new Player(this ,width/2, height/2);
        p1 = new Player(this, 100, 100);
    }

    public void draw() {
        background(0);
        stroke(255);
        p.update();
        p.render();

        p1.update();
        p1.render();
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
