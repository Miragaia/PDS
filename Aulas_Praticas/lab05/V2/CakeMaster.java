
public class CakeMaster {
    private CakeBuilder cakeBuilder;

    public void setCakeBuilder(CakeBuilder cb) {
        this.cakeBuilder = cb;
    }
    public void createCake(String m) {
        cakeBuilder.addMessage(m);
        cakeBuilder.createCake();
    }
    public void createCake(int numLayers, String m) {
        cakeBuilder.getCake().setNumLayers(numLayers);
        this.createCake(m);
    }
    public void createCake(Shape shape, int numLayers, String m) {
        cakeBuilder.setCakeShape(shape);
        this.createCake(numLayers, m);
    }
    public Cake getCake() {
        return cakeBuilder.getCake();
    }
}
