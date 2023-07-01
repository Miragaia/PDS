

import java.util.Date;
import java.util.Calendar;

public class Employee implements Interface {

    private String name;
    private Date StartWorktime;
    private Date EndWorktime;
    
    Calendar calendario=Calendar.getInstance();

    public Employee(String name){
        this.name=name;
    }

    @Override
    public void start(Date date) {
        this.StartWorktime=date;
        calendario.setTime(StartWorktime);
        System.out.println("\n"+name+" started working at "+calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE)+":"+calendario.get(Calendar.SECOND));
    }

    @Override
    public void terminate(Date date){
        this.EndWorktime=date;
        calendario.setTime(EndWorktime);
        System.out.println(name+" terminated working at "+calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE)+":"+calendario.get(Calendar.SECOND));
    }

    @Override
    public void work() {
        System.out.println(name+" is working");
    }
    
}
