
import java.util.Date;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("\nTodos Fazem Company \n");



        Interface e1=new Employee("Miguel");
        Interface e2=new Employee("Tiago");
        TeamMember tm1=new TeamMember(new Employee("Maria"));
        TeamMember tm2=new TeamMember(new Employee("Joana"));
        TeamLeader tl1=new TeamLeader(new Employee("Francisco"));
        Manager m1=new Manager(new Employee("Carlos"));


        Interface list[]={e1,e2,tm1,tm2,tl1,m1};

        for (Interface employee: list){
            Date date =new Date();
            employee.start(date);
            employee.work();
        
        }

        System.out.println("\n");



        for (Interface employee:list){

            Random r = new Random();
            int low = 1;
            int high = 10000;
            int result = r.nextInt(high-low) + low;
            Thread.sleep(result);
            Date date2 =new Date();
            employee.terminate(date2);
        }



    }
    
}
