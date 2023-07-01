
public class Bebida extends Produto {


    public Bebida(String name, double peso) {
        super(name, peso);
    }

    @Override
    public String toString() {
        return "Bebida '" +  getName() + "' - Weight : " + getPeso();
    }
    
}
