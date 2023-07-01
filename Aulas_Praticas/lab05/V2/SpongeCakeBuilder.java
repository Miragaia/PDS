
public class SpongeCakeBuilder  extends BaseCakeBuilder{
    public void  addCakeLayer(){
        this.getCake().setCakeLayer("Sponge");
    }
    public void addCreamLayer(){
        this.getCake().setMidCream(Cream.Red_Berries);
    }
    public void addTopLayer(){
        this.getCake().setTopCream(Cream.Whipped_Cream);
    }
    public void addTopping(){
        this.getCake().setTopping(Topping.fruit);
    }
}
