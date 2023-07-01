import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Mediator {
    void sendMessage(String message, Colleague sender, Colleague receiver);
}

class ConcreteMediator implements Mediator {
    private Map<Colleague, List<Colleague>> colleagueChats;

    public ConcreteMediator() {
        colleagueChats = new HashMap<>();
    }

    public void addColleague(Colleague colleague) {
        colleagueChats.put(colleague, new ArrayList<>());
    }

    public void startChat(Colleague colleague1, Colleague colleague2) {
        colleagueChats.get(colleague1).add(colleague2);
        colleagueChats.get(colleague2).add(colleague1);
    }

    @Override
    public void sendMessage(String message, Colleague sender, Colleague receiver) {
        if (colleagueChats.containsKey(sender) && colleagueChats.containsKey(receiver)) {
            System.out.println(sender.getName() + " enviou uma mensagem para " + receiver.getName() + ": " + message);
            receiver.receiveMessage(message);
        }
        else if (!colleagueChats.containsKey(sender)){
            System.out.println("A pessoa " + sender.getName() + ", que enviou a mnesagem, nao esta registada no chat.");
        }
        else if (!colleagueChats.containsKey(receiver)){
            System.out.println("A pessoa " + receiver.getName() + ", que recebeu a mnesagem, nao esta registada no chat.");
        }
        else {
            System.out.println("A pessoa " + sender.getName() + ", que enviou a mnesagem, nao esta registada no chat.");
            System.out.println("A pessoa " + receiver.getName() + ", que recebeu a mnesagem, nao esta registada no chat.");
        }
    }
}

abstract class Colleague {
    protected Mediator mediator;
    protected String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void sendMessage(String message, Colleague receiver);
    public abstract void receiveMessage(String message);
    public String getName() {
        return name;
    }
}

class ConcreteColleague extends Colleague {
    public ConcreteColleague(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void sendMessage(String message, Colleague receiver) {
        mediator.sendMessage(message, this, receiver);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " recebeu uma mensagem: " + message);
    }
}

public class MediatorPatternDemo {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleague colleague1 = new ConcreteColleague(mediator, "MCoutinho");
        ConcreteColleague colleague2 = new ConcreteColleague(mediator, "Rui Derrotas");
        ConcreteColleague colleague3 = new ConcreteColleague(mediator, "Elideus");

        mediator.addColleague(colleague1);
        mediator.addColleague(colleague2);
        mediator.addColleague(colleague3);

        mediator.startChat(colleague1, colleague2);
        mediator.startChat(colleague1, colleague3);

        colleague1.sendMessage("Ola, Rui Derrotas!", colleague2);
        colleague2.sendMessage("Ola, MCoutinho!", colleague1);
        colleague3.sendMessage("Ola, MCoutinho! Como estas?", colleague1);

        ConcreteColleague colleague4 = new ConcreteColleague(mediator, "Maria");
        colleague1.sendMessage("Ola, Maria!", colleague4);
    }
}




