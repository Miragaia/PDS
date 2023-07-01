package lab04.T1.ex2;

public class Aviao {
    private int n_lugar = 0;
    private int n_livres_exec = 0;
    private int n_livres_turistic = 0;

    private int n_reserva = 1;

    private int[][] classeTuristic;
    private int[][] classeExec;

    private int n_rows;
    private int n_cols;

    // Avião com classe executiva e turistica
    public Aviao(int executive[], int turistic[]) {
        int exec_rows = executive[0];
        int exec_cols = executive[1];
        int turist_rows = turistic[0];
        int turist_cols = turistic[1];

        // Número de lugares do avião
        this.n_lugar = (exec_cols * exec_rows) + (turist_rows * turist_cols);

        // Número de lugares livres do avião
        this.n_livres_exec = (exec_cols * exec_rows);
        this.n_livres_turistic = (turist_rows * turist_cols);
    
        // Criar o array da classe executiva e preencher com 0's
        this.classeExec = new int[exec_cols][exec_rows];
        for(int[] row : this.classeExec){
            for(int i = 0; i< row.length; i++){
                row[i] = 0;
            }
        }
        

        // Criar o array da classe turistica e preencher com 0's
        this.classeTuristic = new int[turist_cols][turist_rows];
        for(int[] row : this.classeExec){
            for(int i = 0; i< row.length; i++){
                row[i] = 0;
            }
        }

        // Número de filas do avião e número de colunas do avião
        this.n_rows = exec_rows + turist_rows;
        this.n_cols = Math.max(exec_cols, turist_cols);
    }
    
    // Avião apenas com classe turistica
    public Aviao (int turistic[]){
        int turist_rows = turistic[0];
        int turist_cols = turistic[1];

        // Número de lugares do avião
        this.n_lugar = (turist_cols * turist_cols);
        // Número de lugares livres do avião
        this.n_livres_turistic = this.n_lugar;

        // Criar o array da classe turistica e preencher com 0's
        this.classeTuristic = new int[turist_cols][turist_rows];
        for(int[] row : this.classeExec){
            for(int i = 0; i< row.length; i++){
                row[i] = 0;
            }
        }
        
        //Numero de filas e colunas do avião
        this.n_rows = turist_rows;
        this.n_cols = turist_cols;
    }

    public void marcarReserva(Reserva reserva) {
        String classe = reserva.getClasse();
        int n_lugar = reserva.getN_lugares();

        //Aumenta o número da reserva se a reserva for marcada com sucesso
        if(ocuparLugar(n_lugar, classe, this.n_reserva) == 0){
            System.out.printf("\nReserva %d marcada com sucesso!", this.n_reserva);
            reserva.setN_reserva(this.n_reserva);
            n_reserva ++;
        }
        else{
            System.out.println("Classe inválida");
        }
    }

    public void cancelarReserva(Reserva reserva){
        int n_reserva = reserva.getN_reserva();
        String c = reserva.getClasse();
        int n_lugar = reserva.getN_lugares();

        // itera sobre as classes e procura o número da reserva
        for(int i = 0; i<this.classeExec.length; i++){
            for(int j = 0; j<this.classeExec[i].length; j++){
                if(this.classeExec[i][j] == n_reserva){
                    // se encontrar o número da reserva, coloca o lugar a 0
                    this.classeExec[i][j] = 0;
                }
            }
        }
        // o mesmo aplica-se à classe turistica
        for(int i = 0; i<this.classeTuristic.length; i++){
            for(int j = 0; j<this.classeTuristic[i].length; j++){
                if(this.classeTuristic[i][j] == n_reserva){
                    this.classeTuristic[i][j] = 0;
                }
            }
        }

        // aumenta o número de lugares livres da classe
        if (c.equals("E")){
            this.n_livres_exec += n_lugar;
        }
        else if (c.equals("T")){
            this.n_livres_turistic += n_lugar;
        }
        else{
            System.out.println("Classe inválida");
        }

    }

    // função que ocupa os lugares
    private int ocuparLugar(int n_lugar, String c, int n_reserva){
        int count = 0;
        // marca os lugares da classe executiva
        if (c.equals("E")){
            // se o número de lugares pedidos for maior que o número de lugares livres, retorna 1
            if(n_lugar > this.n_livres_exec){
                System.out.println("Não há lugares suficientes");
                return 1;
            }
            else{
                // se não, verifica se existe alguma fila vazia
                if(!hasEmptyRows(this.classeExec)){
                    // se não existir, preenche os lugares vagos
                    for(int i = 0; i<this.classeExec.length; i++){
                        for(int j = 0; j<this.classeExec[i].length; j++){
                            if(count == n_lugar){
                                break;
                            }
                            if(this.classeExec[i][j] == 0){
                                // marca o lugar com o número da reserva
                                this.classeExec[i][j] = n_reserva;
                                count++;
                                this.n_livres_exec--;
                            }
                        }
                    }
                }
                else{
                    // se existirem filas vazias preferencialmente preenche-as
                    for(int row[] : this.classeExec){
                        if(isEmpty(row)){
                            for(int i = 0; i<row.length; i++){
                                if(count == n_lugar){
                                    break;
                                }
                                if(row[i] == 0){
                                    row[i] = n_reserva;
                                    count++;
                                    this.n_livres_exec--;
                                }
                            }
                        }
                    }
                }
            }
        }
        // o mesmo aplica-se à classe turistica
        else if (c.equals("T")){
            if(n_lugar > this.n_livres_turistic){
                System.out.println("Não há lugares suficientes");
                return 1;
            }
            else{
                if(!hasEmptyRows(this.classeTuristic)){
                    for(int i = 0; i<this.classeTuristic.length; i++){
                        for(int j = 0; j<this.classeTuristic[i].length; j++){
                            if(count == n_lugar){
                                break;
                            }
                            if(this.classeTuristic[i][j] == 0){
                                this.classeTuristic[i][j] = n_reserva;
                                count++;
                                this.n_livres_turistic--;
                            }
                        }
                    }
                }
                else{
                    for(int row[] : this.classeTuristic){
                        if(isEmpty(row)){
                            for(int i = 0; i<row.length; i++){
                                if(count == n_lugar){
                                    break;
                                }
                                if(row[i] == 0){
                                    row[i] = n_reserva;
                                    count++;
                                    this.n_livres_turistic--;
                                }
                            }
                        }
                    }
                }
            }
        }
        else{
            return 1;
        }
        

        return 0;
    }

    // Verifica se a fila está vazia
    private boolean isEmpty(int[] row){
        boolean b = true;

        for(int col : row)
            if(col != 0)
                b = false;
        
        return b;
    }

    // Verifica se existem filas vazias
    private boolean hasEmptyRows(int[][] classe){
        boolean b = true;

        for(int[] row : classe)
            if(!isEmpty(row))
                b = false;
        
        return b;
    }

    @Override
    public String toString() {
        // imprimir numeros das colunas
        String texto = String.format("%2s", " "); 
        for(int i=1; i <= this.n_cols; i++){
            texto += String.format("%2s", i);
        }
        texto += "\n";

        // imprimir o restante
        for(int lin=0; lin < this.n_rows; lin++){
            texto += String.format("%2s", String.valueOf((char)(65 + lin)));
            if(lin < this.classeExec.length){
                for(int col=0; col < this.classeExec[0].length; col++){
                    //System.out.println("Imprime");
                    texto += String.format("%2s", this.classeExec[col][lin]);
                }
            }
            else{
                for(int col=0; col < this.classeExec.length; col++){
                    texto += String.format("%2s", " ");
                }
            }

            if(lin < this.classeTuristic.length){
                for(int col=0; col < this.classeTuristic[0].length; col++){
                    texto += String.format("%2s", classeTuristic[col][lin]);
                }
            }
            texto += "\n"; 
        }
        return texto;
    }
}

