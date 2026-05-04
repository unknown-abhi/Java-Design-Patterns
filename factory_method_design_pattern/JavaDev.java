package factory_method_design_pattern;

/**
 * Concrete Employee implementation for Java developers.
 */
public class JavaDev implements Employee {
    @Override
    public String writeCode() {
        return "JavaDev writes Java code";
    }
}