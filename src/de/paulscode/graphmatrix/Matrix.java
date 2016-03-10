package de.paulscode.graphmatrix;

/**
 *
 * @author Paul Knulst
 */
public class Matrix {

    private final boolean[][] matrix;
    private final int amountOfNodes;
    private final boolean[] completeNodes;
    private final int[] inputNodes, outputNodes;

    public Matrix(boolean[][] matrix) throws IllegalArgumentException {
        this.matrix = matrix;
        this.amountOfNodes = matrix.length;
        for (int i = 0; i < amountOfNodes; i++) {
            if (matrix[i].length != amountOfNodes) {
                throw new IllegalArgumentException("Keine NxN Matrix");
            }
        }
        this.inputNodes = new int[this.amountOfNodes];
        this.outputNodes = new int[this.amountOfNodes];
        this.completeNodes = new boolean[this.amountOfNodes];

    }

    public void calculate() {
        this.calculateCompleteNodes();
        this.calculateIO();
    }

    public boolean[] getCompleteNodes() {
        return completeNodes;
    }

    public int[] getInputNodes() {
        return inputNodes;
    }

    public int[] getOutputNodes() {
        return outputNodes;
    }

    private void calculateCompleteNodes() {
        for (int i = 0; i < amountOfNodes; i++) {
            int amount = 0;
            for (int j = 0; j < amountOfNodes; j++) {
                if (i != j && matrix[i][j]) {
                    amount++;
                }
            }
            if (amount == (amountOfNodes - 1)) {
                completeNodes[i] = true;
            }
        }
    }

    private void calculateIO() {
        for (int i = 0; i < amountOfNodes; i++) {
            for (int j = 0; j < amountOfNodes; j++) {
                if (matrix[i][j]) {
                    outputNodes[i]++;
                }
                if (matrix[j][i]) {
                    inputNodes[i]++;
                }
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < amountOfNodes; i++) {
            sb.append("Knotennr ").append(i).append("\n");
            sb.append("Anzahl an Eingangsgrad: ").append(inputNodes[i]).append("\n");
            sb.append("Anzahl an Ausgangsgrad: ").append(outputNodes[i]).append("\n");
            sb.append("Knoten vollstaendig: ").append(completeNodes[i]).append("\n");
            sb.append("========================================================\n");
            sb.append("\n");
        }
        return sb.toString();
    }
}
