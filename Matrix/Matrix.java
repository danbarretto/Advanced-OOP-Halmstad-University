public class Matrix {
    private double[][] elements;
    private int rows, columns;

    public Matrix(int rows, int columns) {
        elements = new double[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

    public void setElements(double[][] newElements){
        assert newElements.length == rows && newElements[0].length == columns;
        elements = newElements;
    }

    public double getElement(int row, int column) {
        assert row < rows && column < columns && row >= 0 && column >= 0;
        return elements[row][column];
    }

    public void setElement(int row, int column, double newElement) {
        assert row < rows && column < columns && row >= 0 && column >=0;
        elements[row][column] = newElement;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Matrix addMatrix(Matrix other) {
        assert rows == other.getRows() && columns == other.getColumns();

        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.setElement(i, j, getElement(i, j) + other.getElement(i, j));
            }
        }
        return result;
    }

    public Matrix multiplyMatrix(Matrix other) {
        assert columns == other.getRows();

        Matrix result = new Matrix(rows, other.getColumns());
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.getColumns(); j++) {
                for (int k = 0; k < other.getRows(); k++) {
                    result.setElement(i, j, getElement(i, k) * other.getElement(k, j) + result.getElement(i,j));
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result += getElement(i, j) + " ";
            }
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        Matrix m = new Matrix(3, 3);

        m.setElements(new double[][]{{1,2,3},{4,5,6},{7,8,9}});
        
        Matrix m2 = new Matrix(3, 3);
        m2.setElements(new double[][]{{9,8,7}, {6,5,4}, {3,2,1}});


        System.out.println(m.addMatrix(m2));
        System.out.println(m.multiplyMatrix(m2));

    }

}
