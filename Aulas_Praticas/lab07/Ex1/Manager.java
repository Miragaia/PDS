

import java.util.Date;

public class Manager extends Decorator {

    public Manager(Interface tf) {
        super(tf);
    }

    public void start(Date date) {
        tf.start(date);
    }

    public void terminate(Date date) {
        tf.terminate(date);
    }

    public void work() {
        System.out.println("Is a Manager");
        tf.work();
        manage();
    }

    public void manage() {
        System.out.println("Manager is managing");
    }
    
}
