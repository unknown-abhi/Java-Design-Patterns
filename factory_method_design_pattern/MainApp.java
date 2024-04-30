package factory_method_design_pattern;

public class MainApp {
    public static void main(String[] args) {

        Employee employee = EmployeeFactory.getEmployee("JavaDev");
        System.out.println(employee.writeCode());

        employee = EmployeeFactory.getEmployee("PythonDev");
        System.out.println(employee.writeCode());
    }
}