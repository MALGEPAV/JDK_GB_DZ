public class Program {
    public static void main(String[] args) {
        EmployeeRegistry employeeRegistry = new EmployeeRegistry();
        employeeRegistry.addEmployee(new Employee(1, "+79214546456", "Mark", 10));
        employeeRegistry.addEmployee(new Employee(2, "+79113838577", "John", 5));
        employeeRegistry.addEmployee(new Employee(3, "+79818761234", "Kate", 1));
        employeeRegistry.addEmployee(new Employee(4, "+79265676868", "Jennifer", 20));
        employeeRegistry.addEmployee(new Employee(5, "+79999876655", "Helen", 2));
        employeeRegistry.addEmployee(new Employee(6, "+79288761234", "Peter", 10));
        employeeRegistry.addEmployee(new Employee(7, "+79213232987", "Jack", 1));
        employeeRegistry.addEmployee(new Employee(8, "+79118763421", "Mark", 6));
        employeeRegistry.addEmployee(new Employee(9, "+79007476783", "John", 10));
        employeeRegistry.addEmployee(new Employee(10, "+79899477645", "Mary", 2));
        employeeRegistry.addEmployee(new Employee(11, "+79810985434", "Helen", 7));
        employeeRegistry.addEmployee(new Employee(12, "+79996543764", "Kate", 5));
        employeeRegistry.addEmployee(new Employee(13, "+79119348587", "Mark", 2));

        System.out.println("Employees with 5 years of experience:");
        System.out.println(employeeRegistry.getEmpByExp(5));

        System.out.println("Phone numbers of employyes named Mark:");
        System.out.println(employeeRegistry.getPhoneNumberByName("Mark"));

        System.out.println("The employee with ID: 4");
        System.out.println(employeeRegistry.getEmpByID(4));
    }
}
