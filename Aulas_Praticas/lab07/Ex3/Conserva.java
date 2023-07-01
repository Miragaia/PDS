

public class Conserva extends Produto{


    public Conserva(String name, double peso) {
        super(name, peso);
        
    }

    @Override
    public String toString() {
        return "Conserva '" +  getName() + "' - Weight : " + getPeso();
    }
}
