package ie.tudublin;

public class Cat extends Animal
{
    private int numLives;
    public Cat(String name)
    {
        super(name);
        this.numLives = 9;
    }

    public int getLives()
    {
        return numLives;
    }

    public void setLives(int numLives)
    {
        this.numLives = numLives;
    }

    public void kill(){
        if (this.numLives>0){
            this.numLives --;
            System.out.println("Ouch!");
        }

        if(this.numLives==0){
            System.out.println("Dead");
        }
    }


}