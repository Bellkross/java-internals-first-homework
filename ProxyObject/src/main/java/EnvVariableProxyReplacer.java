import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static java.util.Objects.nonNull;

public class EnvVariableProxyReplacer implements InvocationHandler {

    private static final String portParameter = "server.port";
    private static final String portReplacement = "${port}";
    private TextService textService;

    public EnvVariableProxyReplacer(final TextService textService) {
        this.textService = textService;
    }

    private static String getPropertyValue(final String propertyName, final String defaultValue) {
        return System.getProperty(propertyName, defaultValue);
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {

        boolean isVariableMethod = method.getName().equals("variable");
        if (isVariableMethod && nonNull(System.getProperty(portParameter))) {
            String target = (String) args[0];
            if (nonNull(target) && target.contains(portReplacement)) {
                return target.replace(portReplacement, getPropertyValue(portParameter, portReplacement));
            }
        }
        return method.invoke(textService, args);
    }
}
