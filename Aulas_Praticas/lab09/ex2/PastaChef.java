package Ex2;

public class PastaChef extends Chef{

    public void cook(String dish){

        if(canCook(dish, "pasta")){
            String[] ingredients = dish.split(" ");
            String ingredients2=" ";

            for(int i=5;i<ingredients.length-1;i++){
                ingredients2+=ingredients[i]+" ";
                }
            System.out.println("PastaChef is cooking "+ingredients2);
            }
            else{
                System.out.println("PastaChef: I can't cook that");
                super.cook(dish);
            }

     }
    
}
