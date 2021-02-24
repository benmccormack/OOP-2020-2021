package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {

    int size = 100;
    float cellSize;
    //2D boolean array to store for dead or alive
    boolean[][] board = new boolean[size][size];

    public int countCellsAround(int row, int col)
    {
        int count = 0;
        
        //use getCell here!
        //using if statements
        if(getCell(board, row-1, col-1))
        {
            count++;
        }
        if(getCell(board, row-1, col))
        {
            count++;
        }
        if(getCell(board, row - 1, col+1))
        {
            count++;
        }
        if(getCell(board, row, col-1))
        {
            count++;
        }
        if(getCell(board, row, col+1))
        {
            count++;
        }
        if(getCell(board, row+1, col+1))
        {
            count++;
        }
        if(getCell(board, row+1, col))
        {
            count++;
        }
        if(getCell(board, row+1, col+1))
        {
            count++;
        }

        //using a for loop to count
        for(int r = row -1; r <= row +1; r++)
        {
            for(int c = col -1; c <= col +1; c++)
            {
                if (! (r == row && c == col))  
                {
                    if(getCell(board,r,c))
                    {
                        count ++;
                    }
                }
            }
        }
        return count;
    }

    public void setCell(boolean[][] board, int row, int col, boolean b)
    {
        if (row >= 0 && row < size -1 && col >= 0 && col < size -1)
        {
            board[row][col] = b;
        }
    }

    public boolean getCell(boolean[][] board, int row, int col)
    {
        if(row > 0 && row < size -1 && col > 0 && col < size - 1)
        {
            return board[row][col];
        }
        else{
            return false;
        }
    }

    public void drawBoard(boolean[][] board)
    {
        //use nested loop
        //use map
        //rect to draw the cell
        //use the cellSize variable
        //use some colors
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                //calculating the x and y coordinates to map onto
                float x = map(col, 0, size, 0, width);
                float y = map(row, 0, size, 0, height);

                //could do this instead of map
                // float x = col * cellSize;
                // float y = row * cellSize;

                if(board[row][col]){
                    rect(x, y, cellSize, cellSize);
                }
            }
        }
    }

    private void printBoard(boolean[][] board)
    {
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col <size; col++)
            {
                print(board[row][col] ? 1 : 0);
            }
            println();
        }
    }

    //assigning some random elements to the 2D array
    public void randomize(){
        //randomise roughly 50% to be true and 50% to be false
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col <size; col++)
            {
                float dice = random(0.0f, 1.0f);
                if(dice < 0.5)
                {
                    board[row][col] = true;
                } else
                {
                    board[row][col] = false;
                }

                //board[row][col] = (dice < 0.5f) ? true : false;
            }
        }
    }


    public void settings(){
        size(500, 500);
    }
    
    int mode = 0;
    public void keyPressed() {
        // the value of mode will be the number of the
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(RGB);
        randomize();
        //board[0][1] = true;
        //board[1][2] = true;
        //board[3][2] = true;
        //printBoard(board);
        cellSize = width / (size);
    }


    public void draw() {
        background(0);
        drawBoard(board);
    }
}
