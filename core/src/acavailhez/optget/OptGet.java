package acavailhez.optget;

public interface OptGet {

    void onMissingKey(Object key, Class classToCast);

    Object opt(Object key);

    // Accessors
    default <T> T opt(String key, Class<T> classToCast) {
        return opt(key, classToCast, null);
    }

    @SuppressWarnings("unchecked")
    default <T> T opt(String key, Class<T> classToCast, T defaultValue) {
        Object nonCast = recursiveOpt(key);
        if (nonCast == null) {
            return defaultValue;
        }
        return CastUtils.cast(nonCast, classToCast);

    }

    // Will transform getString("key.sub") to getGetOpt("key").getString("sub")
    default Object recursiveOpt(Object key) {
        Object value = opt(key);
        if (value != null) {
            return value;
        }
        // Search recursively in the underlying opt object
        String stringKey = key.toString();
        String[] subkeys = stringKey.split("\\.");
        OptGet optGet = this;
        for (int i = 0; i < subkeys.length - 1; i++) {
            optGet = optGet.opt(subkeys[i], OptGet.class);
            if (optGet == null) {
                return null;
            }
        }
        return optGet.opt(subkeys[subkeys.length - 1]);
    }

    default Object get(String key) {
        return get(key, Object.class);
    }

    default <T> T get(String key, Class<T> classToCast) throws IllegalArgumentException {
        T value = opt(key, classToCast);
        if (value == null) {
            onMissingKey(key, classToCast);
        }
        return value;
    }

}
