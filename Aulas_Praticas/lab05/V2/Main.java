
public class Main{
    public static void main(String[] args) {
        CakeMaster cakeMaster = new CakeMaster();

        CakeBuilder chocolate = new ChocolateCakeBuilder();
        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Congratulations");       // 1 cake layer
        Cake cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
        
        CakeBuilder sponge = new SpongeCakeBuilder();
        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.Square, 2, "Well done");    // squared, 2 layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
        
        CakeBuilder yogurt = new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake(3, "The best");           // 3 cake layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilder g2 = new g2CakeBuilder();    
        cakeMaster.setCakeBuilder(g2);
        cakeMaster.createCake(Shape.hexagon, 3, "The best 2 cake layers and 1 layer of chocolate cake with a hexagon shape and a message: Happy Birthday to you!");      
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
    }
}
