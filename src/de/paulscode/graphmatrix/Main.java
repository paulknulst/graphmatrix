/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.paulscode.graphmatrix;

public class Main {

    static boolean[][] mat = {
        {false, true, true, true},
        {false, false, false, false},
        {true, false, true, false},
        {false, true, false, false}
    };

    public static void main(String[] args) throws Exception {
        Main.testWithFixedMatrix4x4(mat);
        System.out.println("====================================");
        Main.test2(mat);
    }

    public static void testWithFixedMatrix4x4(boolean[][] matrix) throws Exception {
        int knoten1 = 0, knoten2 = 1, knoten3 = 2, knoten4 = 3;
        int[] output = new int[4];
        int[] input = new int[4];

        int l = matrix.length;
        if (l != 4) {
            throw new Exception("Keine 4x4 Matrix");
        }
        for (int i = 0; i < l; i++) {
            if (matrix[i].length != l) {
                throw new Exception("Keine NxN Matrix");
            }
        }

        boolean[] vollstaendig = new boolean[4];
        for (int i = 0; i <= 3; i++) {
            int amount = 0;
            for (int j = 0; j <= 3; j++) {
                if (i != j && matrix[i][j]) {
                    amount++;
                }
            }
            if (amount == 3) {
                vollstaendig[i] = true;
            }
        }

        //Ausgangsknoten
        for (int i = 0; i <= 3; i++) {
            if (matrix[knoten1][i]) {
                output[knoten1]++;
            }
            if (matrix[knoten2][i]) {
                output[knoten2]++;
            }
            if (matrix[knoten3][i]) {
                output[knoten3]++;
            }
            if (matrix[knoten4][i]) {
                output[knoten4]++;
            }
        }

        //Eingangsknoten
        for (int i = 0; i <= 3; i++) {
            if (matrix[i][knoten1]) {
                input[knoten1]++;
            }
            if (matrix[i][knoten2]) {
                input[knoten2]++;
            }
            if (matrix[i][knoten3]) {
                input[knoten3]++;
            }
            if (matrix[i][knoten4]) {
                input[knoten4]++;
            }
        }

        for (int i = 0; i < l; i++) {
            System.out.println("Knotennr " + i);
            System.out.println("Anzahl an Eingangsgrad: " + input[i]);
            System.out.println("Anzahl an Ausgangsgrad: " + output[i]);
            System.out.println("Knoten vollstaendig: " + vollstaendig[i]);
            System.out.println("");
        }
    }

    public static void test2(boolean[][] matrix) throws Exception {
        int[] input, output;
        boolean[] vollstaendig;

        int amountOfKnoten = matrix.length;
        for (int i = 0; i < amountOfKnoten; i++) {
            if (matrix[i].length != amountOfKnoten) {
                throw new Exception("Keine NxN Matrix");
            }
        }

        input = new int[amountOfKnoten];
        output = new int[amountOfKnoten];
        vollstaendig = new boolean[amountOfKnoten];

        for (int i = 0; i < amountOfKnoten; i++) {
            int amount = 0;
            for (int j = 0; j < amountOfKnoten; j++) {
                if (i != j && matrix[i][j]) {
                    amount++;
                }
            }
            if (amount == (amountOfKnoten - 1)) {
                vollstaendig[i] = true;
            }
        }

        //Ausgangsknoten
        for (int i = 0; i < amountOfKnoten; i++) {
            for (int j = 0; j < amountOfKnoten; j++) {
                if (matrix[i][j]) {
                    output[i]++;
                }
                if (matrix[j][i]) {
                    input[i]++;
                }
            }
        }

        for (int i = 0; i < amountOfKnoten; i++) {
            System.out.println("Knotennr " + i);
            System.out.println("Anzahl an Eingangsgrad: " + input[i]);
            System.out.println("Anzahl an Ausgangsgrad: " + output[i]);
            System.out.println("Knoten vollstaendig: " + vollstaendig[i]);
            System.out.println("");
        }
    }
}
