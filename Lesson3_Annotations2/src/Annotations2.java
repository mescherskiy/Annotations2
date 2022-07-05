import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Annotations2 {
    public static void main(String[] args) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Class<?> cls = TextContainer.class;
        Constructor<?> constructor = cls.getConstructor();
        TextContainer tc = (TextContainer) constructor.newInstance();
        Field field = cls.getDeclaredField("TEXT");
        field.setAccessible(true);
        String text = (String) field.get(null);
        SaveTo saveTo = cls.getAnnotation(SaveTo.class);
        String path = saveTo.path();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                method.invoke(tc, new File(path), text);
            }
        }
    }
}
