import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MainAdapter implements DatabaseAdapter {
        private static DatabaseAdapter databaseAdapter = new SweetsDBAdapter();

        private List<DatabaseAdapter> adapters;

        public MainAdapter() {
            adapters = new ArrayList<>();
        }

        public void addAdapter(DatabaseAdapter adapter) {
            adapters.add(adapter);
        }

        @Override
        public void addEmployee(EmployeeAdapter employee) {
            if (adapters.size()>0) {
                adapters.get(0).addEmployee(employee);                
            } else{
                adapters.add(databaseAdapter);
                addEmployee(employee);
            }
        }

        @Override
        public void removeEmploye(long emp_num) {
           for (DatabaseAdapter db : adapters) {
               if (db.isEmployee(emp_num)) {
                   db.removeEmploye(emp_num);
               }
           }
        }

        @Override
        public EmployeeAdapter[] getAllEmployees() {
            List<EmployeeAdapter> employees = new ArrayList<>();
            for (DatabaseAdapter db : adapters) {
                employees.addAll(Arrays.asList(db.getAllEmployees()));
            }
            return employees.toArray(new EmployeeAdapter[employees.size()]);
        }

        @Override
        public boolean isEmployee(long emp_num) {
            for (DatabaseAdapter db : adapters) {
                if (db.isEmployee(emp_num)) {
                    return true;
                }
            }
            return false;
        }

}
