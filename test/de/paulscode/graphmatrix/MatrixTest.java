/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.paulscode.graphmatrix;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paul Knulst
 */
public class MatrixTest {

    private boolean[][] correctMatrix; //4x4
    private boolean[][] wrongMatrix; //4x3
    private boolean[] expCompleteNodes;
    private int[] expInputNodes;
    private int[] expOutputNodes;

    public MatrixTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        correctMatrix = new boolean[][]{
            {false, true, true, true},
            {false, false, false, false},
            {true, false, true, false},
            {false, true, false, false}
        };

        expCompleteNodes = new boolean[]{true, false, false, false};
        expInputNodes = new int[]{1, 2, 2, 1};
        expOutputNodes = new int[]{3, 0, 2, 1};

        wrongMatrix = new boolean[][]{
            {false, true, true, true},
            {false, false, false, false},
            {true, false, true, false}
        };
    }

    @After
    public void tearDown() {
        correctMatrix = null;
    }

    /**
     * Test of ctr, of class GraphMatrix.
     */
    @Test
    public void testCTOROK() {
        System.out.println("ctor-test");
        boolean exception = false;
        try {
            Matrix instance = new Matrix(correctMatrix);
        } catch (Exception ex) {
            exception = true;
        }
        assertFalse(exception);
    }

    /**
     * Failtest of ctr, of class GraphMatrix.
     */
    @Test
    public void testCTORFAIL() {
        System.out.println("ctor-test");
        boolean exception = false;
        try {
            Matrix instance = new Matrix(wrongMatrix);
        } catch (Exception ex) {
            exception = true;
        }
        assertTrue(exception);
    }

    /**
     * Test of getCompleteNodes method, of class GraphMatrix.
     */
    @Test
    public void testCalculate() throws Exception {
        System.out.println("calcuate");
        Matrix instance = new Matrix(correctMatrix);

        instance.calculate();

        boolean[] completeNodes = instance.getCompleteNodes();
        int[] outputNodes = instance.getOutputNodes();
        int[] inputNodes = instance.getInputNodes();

        assertArrayEquals(expCompleteNodes, completeNodes);
        assertArrayEquals(expOutputNodes, outputNodes);
        assertArrayEquals(expInputNodes, inputNodes);
    }
}
