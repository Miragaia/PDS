package lab04.T1.Jogo_Do_Galo;

public class JG implements JGaloInterface{
    private char player;
    private char[][] board;
    private char winner = ' ';
    private int moves=0;

    public JG(char player){
        this.player = player;
        this.board = new char[3][3];
    }

    @Override
    public char getActualPlayer() {
        return player;
    }

    @Override
    public boolean setJogada(int lin, int col) {
        if (board[lin-1][col-1] == '\u0000'){
            board[lin-1][col-1] = player;
            moves++;
            if (player == 'o')
                player = 'x';
            else
                player = 'o';
            return true;
        }
        return false;
    }

    @Override
    public boolean isFinished() {
        // um jogo acaba quando alguem ganha ou quando nao ha mais jogadas possiveis
        
        for (int i=0; i<3; i++){
            // ganhar horizontalmente
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '\u0000'){
                winner = board[i][0];
                return true;
            }
            // ganhar verticalmente
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '\u0000'){
                winner = board[0][i];
                return true;
            }
        }

        // ganhar diagonalmente da esquerda para a direita
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '\u0000'){
            winner = board[0][0];
            return true;
        }

        // ganhar diagonalmente da direita para a esquerda
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '\u0000'){
            winner = board[0][0];
            return true;
        }

        // empate
        if(winner !=' '|| moves == 9){
            winner = ' ';
            return true;
        }
        return false;

    }

    @Override
    public char checkResult() {
        return winner;
    }
}
