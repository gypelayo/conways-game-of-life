package com.baglass;

public class Main {

    /*
            Conway's Game of Life:

            - 2 dimensional matrix
            - Cells with two states: dead or alive
            - Determine the next generation of the matrix given a couple of rules and the current generation
                - Live cells stay alive if they have exactly 2 or 3 alive neighbors in the previous generation. Otherwise they die of loneliness (<2) or overcrowding (>3)
                - Dead cells stay dead unless they have exactly 3 alive neighbors in the previous generation.
            - Diagonals count as neighbors
            - Any number of rows and columns (except 0)

            1st Matrix:

              X X X  
                     

            2nd Matrix
                X    
                X    
                X    

            */

    public static String[][] matrix = {
            {" ", " ", " ", " ", " "},
            {" ", "X", "X", "X", " "},
            {" ", " ", " ", " ", " "},
    };

    public static String[][] toad = {
            {" ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " "},
            {" ", " ", "X", "X", "X", " "},
            {" ", "X", "X", "X", " ", " "},
            {" ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " "},
    };

    public static void main(String[] args) {

        Matrix lifeMatrix = new Matrix(toad);
        long lastCheck = System.currentTimeMillis();

        //Simple game loop
        while (true) {
            long elapsed = System.currentTimeMillis() - lastCheck;
            if (elapsed > 1000) {

                lifeMatrix.updateMatrix();
                lifeMatrix.printMatrix();

                lastCheck = System.currentTimeMillis();
                System.out.println("------------------------------");
            }
        }
    }
}

