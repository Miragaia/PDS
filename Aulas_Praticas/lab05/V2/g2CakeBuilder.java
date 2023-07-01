
public class g2CakeBuilder extends BaseCakeBuilder {
    public void  addCakeLayer(){
        this.getCake().setCakeLayer("Chocolate");
    }
    public void addCreamLayer(){
        this.getCake().setMidCream(Cream.lemon);
    }
    public void addTopLayer(){
        this.getCake().setTopCream(Cream.coffee);
    }
    public void addTopping(){
        this.getCake().setTopping(Topping.caramel);
    }
}
