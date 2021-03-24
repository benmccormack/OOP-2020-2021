package ie.tudublin;

import processing.core.PApplet;

public class Player {
    //player has / owns these fields
    float x, y; //x and y are going to be the center point of the player ship
    float dx, dy;
    float w = 50; //the width of the player
    float halfW = w/2; 
    float rotation;

    YASC yasc; //reference to yasc

    public Player(YASC yasc,float x, float y)
    {
        this.yasc = yasc;
        this.x = x;
        this.y = y;
        rotation = 0;
    }

    void render()
    {
        yasc.pushMatrix();
        yasc.translate(x, y);
        yasc.rotate(rotation);
        // calling the line method on the pApplet which is in the yasc file
        yasc.line(- halfW, halfW, 0, - halfW);
        yasc.line(0, - halfW, halfW, halfW);
        yasc.line(halfW, halfW, 0, 0);
        yasc.line(0, 0, -halfW, halfW);
        yasc.popMatrix();
    }

    void update()
    {
        dx = PApplet.sin(rotation);
        dy = - PApplet.cos(rotation);

        if(yasc.checkKey(PApplet.UP))
        {
            x += dx;
            y += dy;
        }

        if(yasc.checkKey(PApplet.DOWN))
        {
            x -= dx;
            y -= dy;
        }

        if(yasc.checkKey(PApplet.RIGHT))
        {
            rotation += 0.1f;
        }

        if(yasc.checkKey(PApplet.LEFT))
        {
            rotation -= 0.1f;
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }
}