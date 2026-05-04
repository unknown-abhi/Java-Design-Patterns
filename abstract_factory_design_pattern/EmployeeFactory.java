package abstract_factory_design_pattern;

/**
 * Factory helper that delegates object creation to a concrete abstract factory.
 */
public class EmployeeFactory {
    public static Employee getEmployee(EmployeeAbstractFactory factory) {
        return factory.creatEmployee();
    }
}
