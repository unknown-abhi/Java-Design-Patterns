package abstract_factory_design_pattern;

/**
 * Demonstrates the Abstract Factory pattern using JavaDev and PythonDev
 * factories.
 */
public class MainApp {
    public static void main(String[] args) {

        Employee employee = EmployeeFactory.getEmployee(new JavaDevFactory());
        System.out.println(employee.writeCode());

        employee = EmployeeFactory.getEmployee(new PythonDevFactory());
        System.out.println(employee.writeCode());

        // System.out.println(new JavaDevFactory().creatEmployee().writeCode());
    }
}