package factory_method_design_pattern;

public class MainApp {
    public static void main(String[] args) {

        Employee employee = EmployeeFactory.getEmployee("JavaDev");
        employee.writeCode();

        employee = EmployeeFactory.getEmployee("PythonDev");
        employee.writeCode();
    }
}