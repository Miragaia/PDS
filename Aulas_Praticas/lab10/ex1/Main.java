
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome!");
        System.out.println("Adding Productos, Clientes, and Gestores\n");
        wait(1000);

        Product[] produto = { new Product("Mclaren P1", 45), new Product("Buggatti Veyron", 22), new Product("Porsche 918 Spyder", 20),
                new Product("Ferrari la Ferrari", 10), new Product("Koenigsegg Agera S", 5) };

        Client[] cliente = { new Client("Antonieta"), new Client("Belchior"), new Client("Jonas") };

        Manager gestor1 = new Manager("Mantorras");

        produto[0].attach(gestor1);
        produto[1].attach(gestor1);
        produto[2].attach(gestor1);
        produto[3].attach(gestor1);
        produto[4].attach(gestor1);

        gestor1.start(produto[0]);
        gestor1.start(produto[1]);
        gestor1.start(produto[2]);
        gestor1.start(produto[3]);
        gestor1.start(produto[4]);

        produto[0].attach(cliente[0]);
        produto[0].attach(cliente[1]);

        produto[1].attach(cliente[2]);

        produto[3].attach(cliente[1]);

        cliente[0].makeAnOffer(produto[0], 60);
        wait(450);
        cliente[1].makeAnOffer(produto[1], 30);
        wait(450);
        cliente[2].makeAnOffer(produto[2], 70);
        wait(500);
        gestor1.sellItem(produto[2], produto[2].getHighestBidder().getName(), produto[2].getHighestBid());
        gestor1.sellItem(produto[1], produto[1].getHighestBidder().getName(), produto[1].getHighestBid());
        gestor1.sellItem(produto[0], produto[0].getHighestBidder().getName(), produto[0].getHighestBid());
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
