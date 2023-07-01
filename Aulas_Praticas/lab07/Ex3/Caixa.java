

import java.util.ArrayList;
import java.util.List;

public class Caixa extends Produto {

    private List<Produto> produtos=new ArrayList<>();
    private double pesoTotal=0;
    protected static StringBuffer stringBuffer = new StringBuffer();
    

    public Caixa(String name,double peso){
        super(name,peso);

    }

    public void add(Produto prod){
        this.produtos.add(prod);
        this.pesoTotal+=prod.getPeso();
    }


    public void draw(){
        for(Produto prod:produtos){
            if(prod.getClass().equals(Caixa.class)){
                this.pesoTotal+=prod.pesoTotal();
            }
        }

        pesoTotal+=this.getPeso();

        System.out.println(stringBuffer.toString() + "*" + this.toString());
        stringBuffer.append("    ");

        for (Produto prod : produtos) {

            if (prod.getClass().equals(Caixa.class)) {
                prod.draw();
            } else {
                System.out.println(stringBuffer.toString() + prod);
            }
        }
        stringBuffer.setLength(stringBuffer.length() - 4);

    }



    @Override
    public double pesoTotal() {
        return this.pesoTotal;
    }


    @Override
    public String toString() {
        return "* Caixa '" + getName() + "' [Weight: " + getPeso() + "; Total: " + this.pesoTotal + "]";
    }


    

}
