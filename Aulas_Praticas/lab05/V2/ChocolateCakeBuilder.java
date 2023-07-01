
public class ChocolateCakeBuilder extends BaseCakeBuilder {
    public void  addCakeLayer(){
        this.getCake().setCakeLayer("Soft Chocolate");
    }
    public void addCreamLayer(){
        this.getCake().setMidCream(null);
    }
    public void addTopLayer(){
        this.getCake().setTopCream(Cream.Whipped_Cream);
    }
    public void addTopping(){
        this.getCake().setTopping(Topping.fruit);
    }
}
