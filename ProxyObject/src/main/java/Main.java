import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        Object textServiceProxy =
                Proxy.newProxyInstance(
                        TextServiceImpl.class.getClassLoader(),
                        TextServiceImpl.class.getInterfaces(),
                        new EnvVariableProxyReplacer(new TextServiceImpl())
                );
/*
        Method variableMethod = TextServiceImpl.class.getMethod("variable", String.class);
        variableMethod.invoke(textServiceProxy, "server.port=${port}");
        System.out.println(textServiceProxy.variable());
*/
    }
}
