public class MineSweeperImpl implements MineSweeper {
    private String hintField;

    public void setMineField(String s) {
        String[] rows = s.split("\n");
        int numberOfRows = rows.length;
        int numberOfColumns = s.length() / numberOfRows;
        char[][] board = new char[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++)
            board[i] = rows[i].toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++)
                if (!isAMine(board[i][j]))
                    stringBuilder.append(numberOfMinesInNeighbourhood(board, i, j));
                else
                    stringBuilder.append('*');
            stringBuilder.append('\n');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        hintField = stringBuilder.toString();
    }

    private int numberOfMinesInNeighbourhood(char[][] board, int row, int column) {
        int result = 0;
        for (int i = row - 1; i <= row + 1; i++)
            for (int j = column - 1; j <= column + 1; j++)
                if (isInABoard(board, i, j) && isAMine(board[i][j]))
                    result++;
        return result;
    }

    private boolean isInABoard(char[][] board, int i, int j) {
        int numberOfRows = board.length;
        int numberOfColumns = board[0].length;
        return i >= 0 && i < numberOfRows && j >= 0 && j < numberOfColumns;
    }

    private boolean isAMine(char c) {
        return c == '*';
    }

    public String getHintField() {
        return hintField;
    }
}
