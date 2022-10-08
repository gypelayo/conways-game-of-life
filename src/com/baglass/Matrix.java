package com.baglass;

public class Matrix {
    private String[][] content;

    public Matrix(String[][] content) {
        this.content = content;
    }

    /**
     * Updates current matrix according to Conway's Game of Life
     */
    public void updateMatrix() {
        String[][] temp = copyMatrix();

        for (int row = 0; row < this.content.length; row++) {
            for (int column = 0; column < this.content[0].length; column++) {
                if ((aliveNeighbours(this.content, row, column) < 2 || aliveNeighbours(this.content, row, column) > 3) && this.content[row][column].equals("X")) {
                    temp[row][column] = " ";
                }
                if (aliveNeighbours(this.content, row, column) == 3 && this.content[row][column].equals(" ")) {
                    temp[row][column] = "X";
                }
            }
        }
        this.content = temp;
    }

    /**
     * Prints current matrix
     */
    public void printMatrix() {
        for (int row = 0; row < this.content.length; row++) {
            for (int column = 0; column < this.content[0].length; column++) {
                System.out.print((content[row][column]));
            }
            System.out.println();
        }
    }

    /**
     * Returns number of alive neighbours for a given matrix
     * @param matrixToCheck
     * @param row
     * @param column
     * @return
     */
    private int aliveNeighbours(String[][] matrixToCheck, int row, int column) {
        int alive = 0;

        if (isCellValid(row - 1, column - 1) && matrixToCheck[row - 1][column - 1] == "X") { // top left //
            alive++;
        }
        if (isCellValid(row - 1, column) && matrixToCheck[row - 1][column] == "X") { // top
            alive++;
        }
        if (isCellValid(row - 1, column + 1) && matrixToCheck[row - 1][column + 1] == "X") { //top right
            alive++;
        }
        if (isCellValid(row, column - 1) && matrixToCheck[row][column - 1] == "X") { //left
            alive++;
        }
        if (isCellValid(row, column + 1) && matrixToCheck[row][column + 1] == "X") { //right
            alive++;
        }
        if (isCellValid(row + 1, column - 1) && matrixToCheck[row + 1][column - 1] == "X") { //bottom left
            alive++;
        }
        if (isCellValid(row + 1, column) && matrixToCheck[row + 1][column] == "X") { // bottom
            alive++;
        }
        if (isCellValid(row + 1, column + 1) && matrixToCheck[row + 1][column + 1] == "X") { //bottom right
            alive++;
        }
        return alive;
    }

    /**
     * Checks if the passed cell is inside the bounds of the matrix
     * @param row
     * @param column
     * @return
     */
    private boolean isCellValid(int row, int column) {
        if (row >= 0 && column >= 0 && row < content.length && column < content[0].length) {
            return true;
        }
        return false;
    }

    /**
     * Copies the original content matrix
     * @return
     */
    private String[][] copyMatrix() {
        String[][] temp = new String[content.length][content[0].length];
        for (int i = 0; i < this.content.length; i++) {
            for (int j = 0; j < this.content[0].length; j++) {
                temp[i][j] = content[i][j];
            }
        }
        return temp;
    }

    /**
     * For debugging purposes
     */
    private void printNeighbourMatrix() {
        for (int row = 0; row < this.content.length; row++) {
            for (int column = 0; column < this.content[0].length; column++) {
                System.out.print(aliveNeighbours(this.content, row, column));
            }
            System.out.println();
        }
    }
}
