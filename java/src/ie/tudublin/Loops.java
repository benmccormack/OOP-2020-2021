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
                /* number of rectangles */
                int numRects = 10;
                // width of each rectangle
                float w = width/(float) numRects;
                //dividing the color value 255 by the rectangles
                float cgap = 255 / (float) numRects;
                //for loop to set the color of each rectangle also moves each rectangle across
                for (int i = 0; i < numRects; i++)
                {
                    fill(i * cgap, 255, 255);
                    rect(i * w, 0, w, height);
                }
                break;
            
            case 3:
                int numCircles = 10;
                float y = width /(float) numCircles;
                float colorsCircle = 255 /(float) numCircles;
                for (int j = 0; j<numCircles; j++)
                {
                    fill(j * colorsCircle, 255, 255);
                    ellipse(j * y + y/2, 250, y, y);
                }
                break;

            case 4:
                int numberOfCircles = 10;
                float colorCircleGap = 255 / (float) numberOfCircles;
                for(int k= 0; k<numberOfCircles; k++)
                {
                    fill(k * colorCircleGap, 255,255);
                    ellipse(250,250,width - 50 * (float)k, width - 50 * (float) k);
                }
                break;
            
            case 5: 
                int numRectangles = 10;
                float z = width / (float) numRectangles;
                float colorRectangleGap = 255 / (float) numRectangles;
                for (int l=0 ; l < numRectangles; l++)
                {
                    fill(l * colorRectangleGap, 255, 255);
                    rect(z * l, z * l, z, z);
                }
                break;

            case 6: 
                int numberOfRecs = 10;
                float a = width / (float) numberOfRecs;
                float b = width / (float) numberOfRecs;
                float colorRectGap = 255 / (float) numberOfRecs;
                for (int m=0; m<numberOfRecs; m++)
                {
                    fill(m * colorRectGap, 255, 255);
                    rect(a * m, a*m, a, a);
                    rect(b * m, (width - a) - b*m, b, b);
                }
        }
    }
}
