import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EnvVariableProxyReplacer implements InvocationHandler {

    private TextService textService;
    private static final String portParameter = "server.port";
    private static final String portReplacement = "${port}";

    public EnvVariableProxyReplacer(final TextService textService) {
        this.textService = textService;
    }


    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        return null;
    }

    private static String getPropertyValue(final String propertyName, final String defaultValue) {
        return System.getProperty(propertyName, defaultValue);
    }
}
