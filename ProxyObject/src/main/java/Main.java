import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TextService textServiceProxy = (TextService)
                Proxy.newProxyInstance(
                        TextServiceImpl.class.getClassLoader(),
                        TextServiceImpl.class.getInterfaces(),
                        new EnvVariableProxyReplacer(new TextServiceImpl())
                );
        System.out.println(textServiceProxy.variable("server.port=${port}"));
    }
}
