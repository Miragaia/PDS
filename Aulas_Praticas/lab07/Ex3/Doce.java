

public class Doce extends Produto {



    public Doce(String name, double peso) {
        super(name, peso);
    }

   
    @Override
    public String toString() {
        return "Doce '" +  getName() + "' - Weight : " + getPeso();
    }
}
