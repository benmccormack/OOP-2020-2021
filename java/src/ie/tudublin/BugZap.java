//The file is stored in the folder ie inside the other folder called tudublin
package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet{


    public void settings()
	{
        //setting the size of the canvas
		size(500, 500);
	}

	public void setup() {
		reset();
    }
    
    //Setting Variables For The Player
    float playerX, playerY;
    float playerSpeed = 5;
    float playerWidth = 40;
    float halfPlayerWidth = playerWidth / 2;

    //Setting Variables For The Bug
    float bugX, bugY, bugWidth = 30;
    float halfBugWidth = bugWidth /2;

    int score = 0;

    //Reset method that resets the bug and puts the player back to the starting position
    void reset() {
        resetBug();
        //The following width and height variables are defined and assigned values in the PApplet superclass
        //The variables don't get assigned until the size method is called.
        playerX = width/2;
        playerY = height - 50;
    }

    void resetBug()
    {
        bugX = random(halfBugWidth, width - halfBugWidth);
        bugY = 50;
    }

    void drawBug(float x, float y)
    {
        //Drawing the Bug
        Stroke(255);
        float saucerHeight = bugWidth * 0.7f;
        //draws line on left hand side of the bug
        line(x, y - saucerHeight, x - halfBugWidth, y);
        //draws line on the right hand side of the bug
        line(x, y - saucerHeight, x + halfBugWidth, y);
        //draws a line at the bottom of the triangle
        line(x - halfBugWidth, y, x + halfBugWidth, y);

        //drawing the bugs two feet
        float feet = bugWidth * 0.3f;
        line(x - feet, y, x - halfbugWidth, y + halfBugWidth);
        line(x + feet, y, x + halfbugWidth, y + halfBugWidth);

        //drawing the bugs eyes
        float eyes = bugWidth * 0.1f;
        line (x - eyes, y - eyes, x - eyes, y-eyes *2f);
        line (x + eyes, y - eyes, x + eyes, y-eyes *2f);
    }

    void drawPlayer(float x, float y, float w);
    {
        stroke(255);
        float playerHeight = w/2;

        line(x - halfPlayerWidth, y + playerHeight, x - halfPlayerWidth);

    }
	
	public void draw()
	{	
        drawPlayer(playerX,playerY,playerWidth);
        drawBug(bugX,bugY,bugWidth);
    }
    
}