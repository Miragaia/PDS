public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        db.addEmployee(new Employee("Joao Afonso", 1, 740));
        db.addEmployee(new Employee("Ricardo Aleixo", 2, 755));

        for (Employee emp : db.getAllEmployees())
            System.out.printf("%-15s %5d %1f€\n", emp.getName(), emp.getEmpNum(), emp.getSalary());

        db.deleteEmployee(2);

        for (Employee emp : db.getAllEmployees())
            System.out.printf("%-15s %5d %1f€\n", emp.getName(), emp.getEmpNum(), emp.getSalary());

        
        // petiscos
        Registos rg = new Registos();
        rg.insere(new Empregado("Jose", "Ricardo", 1, 420));
        rg.insere(new Empregado("Maria", "Catarina", 2, 422));

        for (Empregado emp : rg.listaDeEmpregados())
            System.out.printf("%-15s %5d %1f€\n", emp.nome() + " " + emp.apelido(), emp.codigo(), emp.salario());

        if (rg.isEmpregado(1))
            System.out.println("1 exists");
        if (rg.isEmpregado(2))
            System.out.println("2 exists");

        rg.remove(2);

        if (rg.isEmpregado(1))
            System.out.println("1 exists");
        if (rg.isEmpregado(2))
            System.out.println("2 exists");

        for (Empregado emp : rg.listaDeEmpregados())
            System.out.printf("%-15s %5d %1f€\n", emp.nome() + " " + emp.apelido(), emp.codigo(), emp.salario());
    }
}
