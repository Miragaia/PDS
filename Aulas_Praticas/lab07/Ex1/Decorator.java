

import java.util.Date;

public class Decorator implements Interface{

    protected Interface tf;

    public Decorator(Interface tf){
        this.tf=tf;
    }

    public void start(Date date){
        tf.start(date);
    }

    public void terminate(Date date){
        tf.terminate(date);
    }

    public void work(){
        tf.work();
    }
    

    
}
