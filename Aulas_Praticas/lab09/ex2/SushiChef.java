package Ex2;

public class SushiChef extends Chef{

    public void cook(String dish){

        if(canCook(dish, "sushi")){
            String[] ingredients = dish.split(" ");
            String ingredients2=" ";

            for(int i=5;i<ingredients.length-1;i++){
                ingredients2+=ingredients[i]+" ";
                }
            System.out.println("SushiChef is cooking "+ingredients2);
            }
            else{
                System.out.println("SushiChef: I can't cook that");
                super.cook(dish);
            }

     }
    
}
