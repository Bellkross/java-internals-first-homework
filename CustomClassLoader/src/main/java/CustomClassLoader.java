import java.io.*;

public class CustomClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(final String name) throws ClassNotFoundException {
        return super.loadClass(name, true);
    }

    @Override
    public Class findClass(String name) {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassFromFile(String fileName)  {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(
                    "D:\\GLProCamp\\JavaFrameworks\\java-internals\\" +
                            "java-internals-first-homework\\" +
                            "CustomClassLoader\\src\\main\\" +
                            "resources\\" + fileName + ".class");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ( (nextValue = inputStream.read()) != -1 ) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }


}
