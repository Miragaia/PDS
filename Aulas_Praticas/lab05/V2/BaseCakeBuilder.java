
public abstract class BaseCakeBuilder implements CakeBuilder{
    private Cake cake= new Cake(); 

   public void setCakeShape(Shape shape) {
        this.cake.setShape(shape);
    }
    
    public void addMessage(String m) {
        cake.setMessage(m);
    }
    
    public void createCake() {
        this.addCakeLayer();
        this.addCreamLayer();
        this.addTopLayer();
        this.addTopping();
    }
    
    public Cake getCake() {
        return this.cake;
    }
}
