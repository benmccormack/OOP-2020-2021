package ie.tudublin;

import processing.data.TableRow;

public class star {

    //creating the fields - these are private fields, can only be accessed by methods inside the star class
    private boolean hab;
    private String displayName;
    private float distance;
    private float xG, yG, zG;
    private float absMag;

    public String toString(){
        return hab + "\t" + displayName +"\t" + distance + "\t" + xG + "\t" + yG + "\t" + zG;
    }

    //constructors do not have a return method
    public star()
    {

    }

    public star(TableRow row)
    {
        // constructor chaining - when you have lots of different constructors you can call one from another
        this(
            row.getInt("Hab?") == 1 ? true : false,
            row.getString("Display Name"),
            row.getFloat("Distance"),
            row.getFloat("Xg"),
            row.getFloat("Yg"),
            row.getFloat("Zg"),
            row.getFloat("AbsMag")
            );

    }

    public star(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag){
        this.hab = hab;
        this.displayName = displayName;
        this.distance = distance;
        this.xG = xG;
        this.yG = yG;
        this.zG = zG;
        this.absMag = absMag;
    }

    //creating accessors for the private fields - public methods to access these privat fieldss
    //toString method is a method that gets called automatically whenever we pass to something that expects a string
    public boolean isHab() {
        return hab;
    }

    public void setHab(boolean hab) {
        this.hab = hab;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getxG() {
        return xG;
    }

    public void setxG(float xG) {
        this.xG = xG;
    }

    public float getyG() {
        return yG;
    }

    public void setyG(float yG) {
        this.yG = yG;
    }

    public float getzG() {
        return zG;
    }

    public void setzG(float zG) {
        this.zG = zG;
    }

    public float getAbsMag() {
        return absMag;
    }

    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }
}
