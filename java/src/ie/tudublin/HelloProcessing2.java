package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing2 extends PApplet
{
	//This is the first set of code to be executed. Were stating the size of whre we can draw
	public void settings()
	{
		size(500, 500);
	}

	//This gets called once . Colors
	public void setup() {
		
	}
	
	//This method is called 60 times a second. Already in a method from its super class
	public void draw()
	{	
		background(255,0,0); //sets background color takes 1 or 3 or 4 parameters
		stroke(255); //sets the pen colour
		fill(255, 247, 0);
		ellipse(250,250,400,400); //drawing a circle cx,cy,w,h
		fill(20, 240, 247); //the fill colour
		triangle(250,30,30,400,470,400); //x1,y1,x2,y2, x3 y3
		fill(255, 255, 255);
		stroke(255, 255, 255);
		ellipse(250,250,250,100); //drawing a circle cx,cy,w,h
		fill(0, 0, 0);
		stroke(0, 0, 0);
		ellipse(250,250,50,50); //drawing a circle cx,cy,w,h
	}
}
