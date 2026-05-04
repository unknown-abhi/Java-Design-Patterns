package factory_method_design_pattern;

/**
 * Concrete Employee implementation for Python developers.
 */
public class PythonDev implements Employee {

    @Override
    public String writeCode() {
        return "PythonDev writes Python code";
    }

}
