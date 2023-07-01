public class JGaloImp implements JGaloInterface {
    char[][] tabuleiro = new char[3][3];
    int tamanho = 3;
    char result = ' ';
    char jogador1;

    public JGaloImp() {
        this.jogador1 = 'X';
        this.result = ' ';
    }

    public JGaloImp(char jogador1) {
        this.jogador1 = jogador1;
        this.result = ' ';
    }

    @Override
    public char getActualPlayer() {
        return this.jogador1;
    }

    @Override
    public boolean setJogada(int lin, int col) {
        if (lin >= 1 && lin <= tamanho && col >= 1 && col <= tamanho) {
            if (tabuleiro[lin-1][col-1] != 0) {
                return true;
            }
            tabuleiro[lin-1][col-1]= this.jogador1;
        
            if (this.jogador1 == 'X') {
                this.jogador1 = 'O';
            }
            else if(this.jogador1 == 'O'){
                this.jogador1 = 'X';
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isFinished() {
        if (checkDraw() || checkWin()) {
            return true;
        }
        return false;
    }

    private boolean checkWin(){
        if (DiagonalCheck() || HorizontalCheck() || VerticalCheck()) {
            return true;
        }
        return false;
    }

    private boolean checkDraw() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiro[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean HorizontalCheck(){
        for (int i = 0; i < tamanho; i++) {
            if ((tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) && tabuleiro[i][0] != 0) {
                if (tabuleiro[i][0] == 'X') {
                    this.result = 'X';
                }
                else if (tabuleiro[i][0] == 'O') {
                    this.result = 'O';
                }
                return true;
            }
        }
        return false;
    }

    private boolean VerticalCheck(){
        for (int i = 0; i < tamanho; i++) {
            if ((tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) && tabuleiro[0][i] != 0) {
                if (tabuleiro[0][i] == 'X') {
                    this.result = 'X';
                }
                else if (tabuleiro[0][i] == 'O') {
                    this.result = 'O';
                }
                return true;
            }
        }
        return false;
    }

    private boolean DiagonalCheck(){
        if ((tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) && tabuleiro[0][0] != 0 && tabuleiro[1][1] != 0 && tabuleiro[2][2] != 0) {
            if (tabuleiro[0][0] == 'X') {
                this.result = 'X';
            }
            else if (tabuleiro[0][0] == 'O') {
                this.result = 'O';
            }
            return true;
        }
        if ((tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) && tabuleiro[0][2] != 0 && tabuleiro[1][1] != 0 && tabuleiro[1][1] != 0) {
            if (tabuleiro[0][2] == 'X') {
                this.result = 'X';
            }
            else if (tabuleiro[0][2] == 'O') {
                this.result = 'O';
            }
            return true;
        }
        return false;
    }

    @Override
    public char checkResult() {
        return this.result;
    }
}


