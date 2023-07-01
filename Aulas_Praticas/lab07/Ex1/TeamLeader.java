import java.util.Date;

public class TeamLeader extends Decorator{



    public TeamLeader (Interface tf){
        super(tf);
    }

    public void start(Date data){
        tf.start(data);

    }

    public void terminate(Date data){
        tf.terminate(data);

    }

    public void work(){
        System.out.println("Is a TeamLeader");
        tf.work();
        plan();
    }


    public void plan(){
        System.out.println("TeamLeader is planning");
    }


}