public class Book {

    
    private String titulo;
    private int ISBN;
    private int ano;
    private String autor;
    private State current;




    public Book(String titulo, int ISBN, int ano, String autor){
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.ano = ano;
        this.autor = autor;
        this.current = new Inventory();
    }


  public void setState(State state){
        this.current = state;
    }

    public State getState(){
        return this.current;
    }

    @Override
    public String toString(){
         String bookToString = String.format("%-35s %-20s %-10s %-20s [%s]",  this.titulo, this.autor, this.ano, this.ISBN, this.current);
        return bookToString;
    }




    
}
