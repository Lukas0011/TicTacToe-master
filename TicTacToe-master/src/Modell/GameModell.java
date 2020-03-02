package Modell;


public class GameModell  {
    private char[] places = new char[9];
    private char currentPlayer;
    private boolean off;



    public GameModell() {
        this.newGame();
    }

    public boolean isoff() {
        return this.off;
    }

    public char place(int x, int y) {
        return this.places[3 * y + x];
    }

    public char play(int x, int y) {
        if (!this.off && this.places[3 * y + x] == ' ') {
            this.places[3 * y + x] = this.currentPlayer;
            this.changePlayer();
        }

        return this.checkforEnd();
    }

    public void changePlayer() {
        this.currentPlayer = (char)(this.currentPlayer == 'X' ? 79 : 88);
    }

    public void newGame() {
        for(int i = 0; i < this.places.length; ++i) {
            this.places[i] = ' ';
        }

        this.currentPlayer = 'X';
        this.off = false;
    }

    public char checkforEnd() {
        int i;
        for(i = 0; i < 3; ++i) {
            if (this.place(i, 0) != ' ' && this.place(i, 0) == this.place(i, 1) && this.place(i, 1) == this.place(i, 2)) {
                this.off = true;
                return this.place(i, 0);
            }

            if (this.place(0, i) != ' ' && this.place(0, i) == this.place(1, i) && this.place(1, i) == this.place(2, i)) {
                this.off = true;
                return this.place(0, i);
            }
        }

        if (this.place(0, 0) != ' ' && this.place(0, 0) == this.place(1, 1) && this.place(1, 1) == this.place(2, 2)) {
            this.off = true;
            return this.place(0, 0);
        } else if (this.place(2, 0) != ' ' && this.place(2, 0) == this.place(1, 1) && this.place(1, 1) == this.place(0, 2)) {
            this.off = true;
            return this.place(2, 0);
        } else {
            for(i = 0; i < 9; ++i) {
                if (this.places[i] == ' ') {
                    return ' ';
                }
            }

            return 'D';
        }
    }



    public void stoppgame(){

    }

    public void resetgame(){

    }

}
