package acavailhez.optget;

import java.util.Map;

// Cast an object to a class
public class CastUtils {

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object unknown, Class<T> target) {
        if (String.class.isAssignableFrom(target)) {
            return (T) castToString(unknown);
        } else if (Integer.class.isAssignableFrom(target)) {
            return (T) castToInteger(unknown);
        } else if (Long.class.isAssignableFrom(target)) {
            return (T) castToLong(unknown);
        } else if (Float.class.isAssignableFrom(target)) {
            return (T) castToFloat(unknown);
        } else if (Double.class.isAssignableFrom(target)) {
            return (T) castToDouble(unknown);
        } else if (Short.class.isAssignableFrom(target)) {
            return (T) castToShort(unknown);
        } else if (Byte.class.isAssignableFrom(target)) {
            return (T) castToByte(unknown);
        }else if (target.isEnum()) {
            return castToEnum(unknown, target);
        } else if (OptGet.class.isAssignableFrom(target)) {
            return (T) castToOptGet(unknown);
        }
        // unknown class, attempt to cast
        return (T) unknown;
    }

    public static String castToString(Object unknown) {
        return unknown.toString();
    }

    @SuppressWarnings("unchecked")
    public static <ENUM> ENUM castToEnum(Object unknown, Class<ENUM> enumClass) {
        if (enumClass.isAssignableFrom(unknown.getClass())) {
            return (ENUM) unknown;
        }
        // try to find the correct enum, ignore case
        for (Object enumValue : enumClass.getEnumConstants()) {
            if (enumValue.toString().toLowerCase().equals(unknown.toString().toLowerCase())) {
                return (ENUM) enumValue;
            }
        }
        return (ENUM) unknown;
    }

    public static OptGet castToOptGet(Object unknown) {
        if (unknown instanceof OptGet) {
            return (OptGet) unknown;
        }
        if (unknown instanceof Map) {
            return new OptGetMap((Map) unknown);
        }
        // Wrap the object directly, accessing its fields
        return new OptGetWrapper(unknown);
    }

    public static Integer castToInteger(Object unknown) {
        if (unknown instanceof String) {
            return Integer.valueOf((String) unknown);
        }
        if (unknown instanceof Number) {
            return ((Number) unknown).intValue();
        }
        return (Integer) unknown;
    }

    public static Long castToLong(Object unknown) {
        if (unknown instanceof String) {
            return Long.valueOf((String) unknown);
        }
        if (unknown instanceof Number) {
            return ((Number) unknown).longValue();
        }
        return (Long) unknown;
    }

    public static Short castToShort(Object unknown) {
        if (unknown instanceof String) {
            return Short.valueOf((String) unknown);
        }
        if (unknown instanceof Number) {
            return ((Number) unknown).shortValue();
        }
        return (Short) unknown;
    }

    public static Float castToFloat(Object unknown) {
        if (unknown instanceof String) {
            return Float.valueOf((String) unknown);
        }
        if (unknown instanceof Number) {
            return ((Number) unknown).floatValue();
        }
        return (Float) unknown;
    }

    public static Double castToDouble(Object unknown) {
        if (unknown instanceof String) {
            return Double.valueOf((String) unknown);
        }
        if (unknown instanceof Number) {
            return ((Number) unknown).doubleValue();
        }
        return (Double) unknown;
    }

    public static Byte castToByte(Object unknown) {
        if (unknown instanceof String) {
            return Byte.valueOf((String) unknown);
        }
        if (unknown instanceof Number) {
            return ((Number) unknown).byteValue();
        }
        return (Byte) unknown;
    }

}
