

public abstract class Produto {
    private String name;
    private double peso;


    public Produto(String name,double peso){
        this.name=name;
        this.peso=peso;
    }

    public String getName() {
        return name;
    }

    public double getPeso() {
        return peso;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double pesoTotal(){
        return 0.0;
    }
    public void draw() {
        
    }

    @Override
    public String toString() {
        return "Produto '" + name + "' - Weight : " + peso;
    }

    
    
   
}
