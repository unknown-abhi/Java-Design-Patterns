package abstract_factory_design_pattern;

/**
 * Concrete Employee product for Python developers.
 */
public class PythonDev implements Employee {

    @Override
    public String writeCode() {
        return "PythonDev writes Python code";
    }

}
