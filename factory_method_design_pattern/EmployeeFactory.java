package factory_method_design_pattern;

public class EmployeeFactory {
    public static Employee getEmployee(String employeeType) {
        if (employeeType.trim().equalsIgnoreCase("JavaDev")) {
            return new JavaDev();

        } else if (employeeType.trim().equalsIgnoreCase("PythonDev")) {

            return new PythonDev();
        } else {
            return null;
        }
    }
}
