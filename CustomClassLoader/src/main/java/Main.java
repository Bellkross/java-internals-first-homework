import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        while (true) {
            CustomClassLoader customClassLoader = new CustomClassLoader();
            Class<?> cl = customClassLoader.findClass("TextService");
            Object textService = cl.getConstructor().newInstance();
            Method staticTextMethod = cl.getMethod("staticText");
            System.out.println(staticTextMethod.invoke(textService));
            Thread.sleep(2000);
        }
    }

}
