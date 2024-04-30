package abstract_factory_design_pattern;

public class PythonDevFactory extends EmployeeAbstractFactory {
    @Override
    public Employee getEmployee() {
        return new PythonDev();
    }
}
