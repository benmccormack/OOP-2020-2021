package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {

    //use array list if you dont know how many elements are in the array
    ArrayList<star> stars = new ArrayList<star>();
    
    void printStars()
    {
        for(star s : stars){
            println(s);
        }
    }

    void loadStars()
    {
        Table table = loadTable("HabHYG15ly.csv", "header");
        //enhanced for loop specifically for iterating over collections
        for(TableRow row:table.rows())
        {
            star s = new star(row);
            stars.add(s);
        }

    }

    public void settings() {
        size(500, 500);
    }

    public void mouseClicked()
    {
        println("Mouse clicked");
    }

    public void setup() {
        colorMode(RGB);
        loadStars();
        printStars();
    }

    public void draw() {
        background(0);
    }
}