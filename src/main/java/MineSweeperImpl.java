public class MineSweeperImpl implements MineSweeper {
    private String hintField;

    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        String[] rows = mineField.split("\n");
        int numberOfRows = rows.length;
        int numberOfColumns = mineField.length() / numberOfRows;
        char[][] board = new char[numberOfRows][numberOfColumns];

        checkIfIsProperlyFormatted(rows, numberOfColumns);
        fillBoard(rows, board);
        setHintField(board);
    }

    @Override
    public String getHintField() throws IllegalStateException {
        if (hintField == null)
            throw new IllegalStateException();
        return hintField;
    }

    private void checkIfIsProperlyFormatted(String[] rows, int numberOfColumns) throws IllegalArgumentException {
        for (String row : rows)
            if (isImproperlyFormatted(numberOfColumns, row.toCharArray()))
                throw new IllegalArgumentException();
    }

    private boolean isImproperlyFormatted(int numberOfColumns, char[] fields) {
        return fields.length != numberOfColumns || hasImproperCharacters(fields);
    }

    private boolean hasImproperCharacters(char[] fields) {
        for (char field : fields)
            if (!isAMine(field) && field != '.')
                return true;
        return false;
    }

    private void fillBoard(String[] rows, char[][] board) {
        for (int i = 0; i < rows.length; i++)
            board[i] = rows[i].toCharArray();
    }

    private void setHintField(char[][] board) {
        int numberOfRows = board.length;
        int numberOfColumns = board[0].length;
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

    private boolean isAMine(char c) {
        return c == '*';
    }

    private boolean isInABoard(char[][] board, int i, int j) {
        int numberOfRows = board.length;
        int numberOfColumns = board[0].length;
        return i >= 0 && i < numberOfRows && j >= 0 && j < numberOfColumns;
    }
}
