import java.util.ArrayList;
import java.util.List;

public class Registos {
 // Data elements
    private ArrayList<Empregado> empregados; // Stores the employees

    public Registos() {
        empregados = new ArrayList<>();
    }

    public void insere(Empregado empregado) {
        // Code to insert employee
        empregados.add(empregado);
    }

    public void remove(int codigo) {
        // Code to remove employee
        for(Empregado e: empregados) 
            if(e.codigo() == codigo) {
                empregados.remove(e);
                break;
            }
    }

    public boolean isEmpregado(int codigo) {
        // Code to find employee
        for(Empregado e: empregados) 
            if(e.codigo() == codigo) return true;
        return false;
    }

    public List<Empregado> listaDeEmpregados() {
        // Code to retrieve collection
        return empregados;
    }    
}
