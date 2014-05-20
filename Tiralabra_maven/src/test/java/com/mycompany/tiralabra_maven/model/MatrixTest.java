/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.tiralabra_maven.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gabriel
 */
public class MatrixTest {
    
    private Matrix matrix;
    
    @Before
    public void setUp() {
        double[][] values = {{1,2,3},{4,5,6}};
        matrix = new Matrix(values);
    }
    
    @Test
    public void correctNumberOfRowsReturned(){
        
        assertEquals("Rows: ", 2, matrix.rows());
    }   
    
    @Test
    public void correctNumberOfColumnsReturned(){
        assertEquals("Columns: ", 3, matrix.cols());
    }
    
    @Test
    public void correctNumberOfRowsReturnerAfterCreatingZeroMatrix(){
        matrix = new Matrix(7, 9);
        assertEquals("Rows: ", 7, matrix.rows());
    }
    
    @Test
    public void correctNumberOfColumnsReturnedAfterCreatingZeroMatrix(){
        matrix = new Matrix(7, 9);
        assertEquals("Columns: ", 9, matrix.cols());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void exceptionIsThrownIfTryingToCreateMatrixWithNegativeNumberOfRows(){
        matrix = new Matrix(-5, 2);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void exceptionIsThrownIfTryingToCreateMatrixWithNegativeNumberOfColumns(){
        matrix = new Matrix(5, -2);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void exceptionIsThrownIfTryingToCreateMatrixWithZeroRows(){
        matrix = new Matrix(0, 2);
    }
    
     @Test (expected = IllegalArgumentException.class)
    public void exceptionIsThrownIfTryingToCreateMatrixWithZeroColumns(){
        matrix = new Matrix(5, 0);
    }
    
    @Test
    public void toStringIsCorrect(){
        String expected = "1\t2\t3\n4\t5\t6";
        assertEquals(expected, matrix.toString());
    }
    
    @Test
    public void twoMatricesWithTheSameElementsAreEqual(){
        double[][] values = {{1,2,3},{4,5,6}};
        Matrix matrixB = new Matrix(values);
        assertEquals(matrix, matrixB);
    }
}