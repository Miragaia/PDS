package Ex2;

public class Chef {
    private Chef sucessor=null;
    public void cook(String dish){
        if(sucessor!=null){
            sucessor.cook(dish);
        }else{
            System.out.println("Request can't be cooked");
        }
    }

    protected boolean canCook(String dish, String chefDish){
        return (dish==null) || dish.contains(chefDish);
    }

    public Chef setSucessor(Chef sucessor) {
        this.sucessor=sucessor;
        return this;
    }


}
