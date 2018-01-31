/* The current state of the game, i.e. the 3x3 grid and whose turn it is.
Checks for winning and drawing, and unit testing, have been left out. */

class Grid {
    private char X='X', O='O', S=' ';
    private char[][] cells = {{S,S,S},{S,S,S},{S,S,S}};
    private char whoseTurn = X;

    char get(int x, int y) { return cells[x][y]; }

    void move(int x, int y) {
        cells[x][y] = whoseTurn;
        whoseTurn = (whoseTurn == X) ? O : X;
    }
}
