
public class YogurtCakeBuilder extends BaseCakeBuilder {
    public void  addCakeLayer(){
        this.getCake().setCakeLayer("Yougurt");
    }
    public void addCreamLayer(){
        this.getCake().setMidCream(Cream.vanilla);
    }
    public void addTopLayer(){
        this.getCake().setTopCream(Cream.Red_Berries);
    }
    public void addTopping(){
        this.getCake().setTopping(Topping.chocolate);
    }
}
