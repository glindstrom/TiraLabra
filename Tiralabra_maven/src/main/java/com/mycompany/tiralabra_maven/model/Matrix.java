package com.mycompany.tiralabra_maven.model;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Represents a matrix.
 *
 * @author gabriel
 */
public class Matrix {

    private double[][] values;
    private int rows;
    private int cols;

    /**
     * Constructs a matrix from an array.
     *
     * @param values a 2d double array containing the elements of the matrix
     */
    public Matrix(double[][] values) {
        this.values = values;
        this.rows = this.values.length;
        this.cols = this.values[0].length;
    }

    /**
     * Constructs a zero matrix with the specified dimensions.
     *
     * @param rows the number of rows
     * @param cols the number of columns
     * @throws IllegalArgumentException if the number of rows or columns is less
     * than one
     */
    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("The number of rows and columns must be positive.");
        }
        this.rows = rows;
        this.cols = cols;
        this.values = new double[rows][cols];
    }

    /**
     * Returns the number of rows in the matrix.
     *
     * @return the number of rows in the matrix
     */
    public int rows() {
        return rows;
    }

    /**
     * Returns the number of columns in the matrix.
     *
     * @return the number of columns in the matrix
     */
    public int cols() {
        return cols;
    }

    @Override
    public String toString() {
        String returnString = "";
        DecimalFormat format = new DecimalFormat();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                returnString += format.format(values[i][j]);
                if (j != cols - 1) {
                    returnString += "\t";
                }
            }
            if (i != rows - 1) {
                returnString += "\n";
            }
        }

        return returnString;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (!(otherObject instanceof Matrix)) {
            return false;
        }
        Matrix other = (Matrix) otherObject;
        if (this.rows() != other.rows || this.cols != other.cols) return false;
        return allElementsEqual(this, other);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Arrays.deepHashCode(this.values);
        return hash;
    }

    private boolean allElementsEqual(Matrix matrixA, Matrix matrixB) {
        for (int i = 0; i < matrixA.rows; i++){
            for (int j = 0; j < matrixA.cols; j++){
                if (matrixA.values[i][j] != matrixB.values[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}