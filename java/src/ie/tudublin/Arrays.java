package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {

    public float map1(float from, float start1, float stop1, float start2, float stop2)
    {
        float range1 = stop1 - start1;
        float range2 = stop2 - start2;
        //how far the from variable is between start and stop
        float howFar = from - start1;

        return start2 + (howFar / range1) * range2;
    }

    public void drawGrid()
    {
        stroke(0,255,0);
        float border = width * .1f;
        textAlign(CENTER, CENTER);
        for(int i = -5; i <=5; i++)
        {
            float x = map1(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }
    }

    public void settings() {
        size(500, 500);   
        float f = map1(2,0,10,0,width);
        println(f); //this should print 100 
        
        float g = map1(9, 0, 1, 0, 10);
        println(g); //this should print 90

        float h = map1(250, 200, 300, 400, 500);
        println(h); //this should print 450

        float j = map1(5, 0, 10, 1000, 2000);
        println(j); //this should print 1500
    }

    int mode = 0;

    //floating array - they are fixed size cannot grow and shrink
    float[] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};

    //allocating array without assigning valuses - array capable of 100 floats default val in each section will be 0.
    float[] arr = new float[100];

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(RGB);
        //one way of iterating over an array
        for( int i = 0; i < rainfall.length; i++)
        {
            println(months[i] + "\t" + rainfall[i]);
        }

        //enhanced for loop for iterating over an array
        for(float f:rainfall)
        {
            println(f);
        }

        //what month had the most rainfall and what month had the least rainfall
        //what is the total rainfall?
        //what is the average rainfall
        int minIndex = 0;
        int maxIndex = 0;
        int sum = 0;
        for(int j = 0; j < rainfall.length; j++)
        {
            if(rainfall[j] < rainfall[minIndex])
            {
                minIndex = j;
            }

            if(rainfall[j] > rainfall[maxIndex])
            {
                maxIndex = j;
            }
            sum += rainfall[j];
        }

        float average = sum / (float) rainfall.length;
        println("Least Rainfall was in" + months[minIndex]+ " with" + rainfall[minIndex]);
        println("Max Rainfall was in" + months[maxIndex]+ " with" + rainfall[maxIndex]);
        println("Average rainfall" + average);

        //draw a bar chart of the rainfall
        //use the map function
        colorMode(HSB);
        float w = width / (float) rainfall.length;
        for(int i = 0; i < rainfall.length; i++)
        {
            noStroke();
            fill(random(255),255,255);
            float x = map(i, 0, rainfall.length, 0, width);
            rect(x, height, w, - rainfall[i]);
        }
    }

    float offset = 0;

    public void draw() {
        background(0);
        //drawGrid();
       // colorMode(HSB);
        //float c = map(mouseX, 0, width, 0 ,255);
        //background(c,255,255);
    }
}
