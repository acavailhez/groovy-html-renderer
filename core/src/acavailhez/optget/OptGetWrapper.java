package acavailhez.optget;

import org.apache.commons.lang3.text.WordUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

// Wrap an object to use its getters and properties as optget members
public class OptGetWrapper implements OptGet {

    private final Object wrapped;

    public OptGetWrapper(Object toWrap) {
        if (toWrap == null) {
            throw new RuntimeException("cannot wrap null object");
        }
        this.wrapped = toWrap;
    }

    @Override
    public void onMissingKey(Object key, Class classToCast) {
        throw new IllegalArgumentException("Missing key:" + key + " of class:" + classToCast);
    }

    @Override
    public Object opt(Object key) {
        // try to find a public getter matching the key
        String getterName = "get" + WordUtils.capitalize(key.toString());
        try {
            Method getter = wrapped.getClass().getDeclaredMethod(getterName);
            if (Modifier.isPublic(getter.getModifiers())) {
                return getter.invoke(wrapped);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            // expected if the method does not exist
        }

        // try to find a public field matching the key
        try {
            Field field = wrapped.getClass().getField(key.toString());
            if (Modifier.isPublic(field.getModifiers())) {
                return field.get(wrapped);
            }
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            // expected if the field does not exist
        }

        // could not find anything
        return null;
    }
}
