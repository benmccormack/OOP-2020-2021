package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

    public void settings() {
        size(500, 500);
        //These are two useful variables we are going to use in our program
        cx = width / 2;
        cy = height / 2;        
    }

    int mode = 0;

    float cx;
    float cy;

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        // assigning key pressed to the mode
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        // setting the color mode to be HSB - Hue, Saturation, Brightness
        colorMode(HSB);
    }

    public void draw() {
        background(0);
        noStroke();
        switch (mode)
        {
            case 0:
            //build in variable mouseX and mouseY are from the pApplet super class
                fill(50,255,255);
                if(mouseX < cx)
                {
                    rect(0, 0, cx, height);
                }
                else
                {
                    rect(cx, 0, cx, height);
                }
                break;
            
            case 1:
                fill(50,255,255);
                if(mouseX < cx && mouseY < cy)
                {
                    rect(0, 0, cx, cy);
                }
                else if(mouseX > cx && mouseY < cy)
                {
                    rect(cx, 0, cx, cy);
                }

                if(mouseY > cy && mouseX < cx)
                {
                    rect(0, cy, cx, cy);
                }
                else if(mouseX > cx && mouseY > cy)
                {
                    rect(cx, cy, cx, cy);
                }
                break;
            
            case 2:
                int numRects = 10;
                float w = width/(float) numRects;
                float cgap = 255 / (float) numRects;
                for (int i = 0; i < numRects; i++)
                {
                    fill(i * cgap, 255, 255);
                    rect(i * w, 0, w, height);
                }
            
            case 3:
                int numCircles = 10;
                float w = width/(float) numCircles;
                float cgap = 255 / (float) numCircles;
                for (int i = 0; i < numRects; i++)
                {
                    fill(i * cgap, 255, 255);
                    ellipse(w / 2 + (i * w), cy ,w ,w);
                }

        }
    }
}
