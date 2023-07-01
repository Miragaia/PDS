

import java.util.Date;

public class TeamMember extends Decorator {

    public TeamMember(Interface tf){
        super(tf);
    }


    public void start(Date data){
        tf.start(data);

    }


    public void terminate(Date data){
        tf.terminate(data);

    }


    public void work(){
        System.out.println("Is a TeamMember");
        tf.work();
        colaborate();
    }

    public void colaborate(){
        System.out.println("TeamMember is colaborating");
    }

}
