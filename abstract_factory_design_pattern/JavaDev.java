package abstract_factory_design_pattern;

/**
 * Concrete Employee product for Java developers.
 */
public class JavaDev implements Employee {
    @Override
    public String writeCode() {
        return "JavaDev writes Java code";
    }
}