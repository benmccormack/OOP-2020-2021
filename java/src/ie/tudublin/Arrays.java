package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {

    // This is how the map function works!
    public float map1(float from, float start1, float stop1, float start2, float stop2) {
        float range1 = stop1 - start1;
        float range2 = stop2 - start2;
        float howFar = from - start1;

        return start2 + (howFar / range1) * range2;
    }

    // This is a demo of the map function
    public void drawGrid() {
        stroke(0, 255, 0);
        float border = width * 0.1f;
        textAlign(CENTER, CENTER);
        for (int i = -5; i <= 5; i++) {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }
    }
    
    // Return the sum of all the elements in an array
    float sum(float[] array) {
        float sum = 0;
        for (float r : array) {
            sum += r;
        }
        return sum;
    }

    public void settings() {
        size(1000, 1000);

        // Testing the map function
        float f = map1(2, 0, 10, 0, width);
        println(f); // Should print 100

        f = map1(9, 0, 1, 0, 10);
        println(f); // Should print 90

        f = map1(250, 200, 300, 400, 500);
        println(f); // Should print 450

        f = map1(5, 0, 10, 1000, 2000);
        println(f); // Should print 1500

    }

    int mode = 0;

    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };
    String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec" };
    float[] arr = new float[100]; // 100 float array
    int [] numbers = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120};

    public void keyPressed() {
        // the value of mode will be the number of the
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(RGB);

        // Iterating over an array in Java
        for (int i = 0; i < rainfall.length; i++) {
            println(months[i] + "\t" + rainfall[i]);
        }

        // Enhanced for loop
        for (float f : rainfall) {
            println(f);
        }

        // What month had the most and least rainfall??
        // What is the total rainfall?
        // What is the average rainfall??

        float sum = 0;
        int minIndex = 0;
        int maxIndex = 0;
        sum = 0;
        float average = 0;
        for (int i = 0; i < rainfall.length; i++) {
            if (rainfall[i] < rainfall[minIndex]) {
                minIndex = i;
            }
            if (rainfall[i] > rainfall[maxIndex]) {
                maxIndex = i;
            }
            sum += rainfall[i];
        }

        average = sum / (float) rainfall.length;
        println("Least rainfall was in " + months[minIndex] + " with " + rainfall[minIndex]);
        println("Most rainfall was in " + months[maxIndex] + " with " + rainfall[maxIndex]);
        println("Average rainfall: " + average);

        // rect(x, y, w, -h);

        // Draw a bar chart of the rainfall!!
        // Use the map function

        colorMode(HSB);
        float w = width / (float) rainfall.length;
        for (int i = 0; i < rainfall.length; i++) {
            noStroke();
            fill(random(255), 255, 255);
            float x = map(i, 0, rainfall.length, 0, width);
            rect(x, height, w, -rainfall[i]);
        }
    }


    public void draw() {
        background(0);
        switch (mode) {
            case 0: {
            // Bar chart
                float border = width * 0.15f;
                //drawing the axis
                stroke(255);
                line(border, border, border, height-border);
                line(border, height - border, height - border , height - border);
                textAlign(CENTER, CENTER);
                //placing ticks and text on the axis
                for (int i = 0; i < numbers.length; i++)
                {
                    //numbers and ticks
                    float y = map(i, 0, 12, height - border, border);
                    fill(255);
                    text(numbers[i], border * 0.5f, y);
                    line(border, y, border * 0.9f, y);
                }

                //inserting the bars
                float w = (width - border * 2) / rainfall.length;
                for(int i=0; i < rainfall.length; i++)
                {
                    float x = map(i, 0, rainfall.length, border , (width - border));
                    //creating a color range so the color of each bar will be different
                    float c = map(i, 0, rainfall.length, 0, 255);
                    fill(c, 255, 255);
                    float h = map(rainfall[i], 0, 120, 0, height - (border *2));
                    //float x = map(i, 0, rainfall.length, 0 , width); spans the whole width of the screen
                    rect(x, height - border, w, -h);
                    fill(255);
                    text(months[i], x + (w * 0.25f), height - (border * 0.5f));
                }
                fill(255);
                text("Rainfall Barchart", (width * 0.5f) - (border * 0.5f), border * 0.5f);
                break;
            }
            case 1: {
            // Trend line
                float border = width * 0.15f;
                //drawing the axis
                stroke(255);
                line(border, border, border, height-border);
                line(border, height - border, height - border , height - border);
                //placing ticks and text on the axis
                for (int i = 0; i < numbers.length; i++)
                {
                    //numbers and ticks
                    float y = map(i, 0, 12, height - border, border);
                    fill(255);
                    text(numbers[i], border * 0.5f, y);
                    line(border, y, border * 0.9f, y);
                }

                //need to start at 1 because if we go -1 and its originally 0 we will get an indexing error
                float w = (width - border * 2) / (float) rainfall.length;
                for(int i = 1; i < rainfall.length; i++)
                {
                    float x1 = map(i - 1, 0, rainfall.length - 1, border + (w * 0.5f), width - border - (w * 0.5f));
                    float y1 = map(rainfall[i - 1], 0, 120, height - border, border);
                    float x2 = map(i, 0, rainfall.length - 1, border + (w * 0.5f), width - border - (w * 0.5f));
                    float y2 = map(rainfall[i], 0, 120, height - border, border);
                    line(x1, y1, x2, y2);
                }

                for(int i=0; i < rainfall.length; i++)
                {
                    float x1 = map(i, 0, rainfall.length, border , width - border);
                    fill(255);
                    text(months[i], x1 + (w *0.5f), height - border * 0.5f);
                }
            }
            case 2: {
                // Pie chart
            }
        }
    }
}
