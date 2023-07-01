package lab04.T1.ex2;

public class Reserva {
    int n_reserva;
    int n_lugares;
    String classe;

    public Reserva(String classe, int n_lugares) {
        this.n_lugares = n_lugares;
        this.classe = classe;
    }


    public int getN_reserva() {
        return n_reserva;
    }

    public void setN_reserva(int n_reserva) {
        this.n_reserva = n_reserva;
    }

    public String getClasse() {
        return classe;
    }

    public int getN_lugares() {
        return n_lugares;
    }

    @Override
    public String toString() {
        return "Reserva{" + "n_reserva=" + n_reserva + ", n_lugares=" + n_lugares + ", classe=" + classe + '}';
    }
}
