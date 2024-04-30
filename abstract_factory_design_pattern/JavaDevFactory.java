package abstract_factory_design_pattern;

public class JavaDevFactory extends EmployeeAbstractFactory {
    @Override
    public Employee getEmployee() {
        return new JavaDev();
    }

}
