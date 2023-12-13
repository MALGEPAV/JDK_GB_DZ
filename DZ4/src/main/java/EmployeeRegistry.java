import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRegistry {
    private Map<Integer, Employee> employeeMap;

    public EmployeeRegistry() {
        employeeMap = new HashMap<>();
    }

    public void addEmployee(Employee newEmployee) {
        employeeMap.put(newEmployee.getID(), newEmployee);
    }

    public List<Employee> getEmpByExp(int workExp) {
        return employeeMap.values().stream()
                .filter((emp) -> (emp.getWorkExperience() == workExp))
                .toList();
    }

    public List<String> getPhoneNumberByName(String name) {
        return employeeMap.values().stream()
                .filter((emp) -> (emp.getName().equals(name)))
                .map(Employee::getPhoneNumber)
                .toList();
    }

    public Employee getEmpByID(int ID) {
        return employeeMap.get(ID);
    }
}
