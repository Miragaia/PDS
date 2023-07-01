package lab04.T1.ex2;

public class Voo {
    String n_voo;
    Aviao plane;
    
    public Voo(String n_voo, Aviao plane) {
        this.n_voo = n_voo;
        this.plane = plane;
    }

    public String getCodigoVoo() {
        return n_voo;
    }

    public Aviao getAviao() {
        return plane;
    }

    @Override
    public String toString() {
        String s = "";

        s += n_voo + "\n";
        s += plane.toString();
    
        return s;
    }
}
