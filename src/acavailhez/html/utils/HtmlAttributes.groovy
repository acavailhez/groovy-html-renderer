package acavailhez.html.utils

// Keeps a local copy of a map and adds extra methods
// Two ways to create from an existing map:
// HtmlAttributes.copy() will copy the content of the argument
// HtmlAttributes.wrap() will keep the existing map and modify it
//
// Added methods: get/opt
// opt(key, String, "default") will get the [key] value or default if not set
// get(key, String) will get the [key] value and raise an exception if not present

class HtmlAttributes implements Map<String, Object> {

    private final Map<String, Object> map;

    private HtmlAttributes(Map<String, Object> map) {
        this.map = map;
    }

    public static HtmlAttributes copy(Map map) {
        HtmlAttributes attrs = new HtmlAttributes(new HashMap<>())
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                attrs.put(entry.getKey().toString(), entry.getValue())
            }
        }
        return attrs
    }

    public static HtmlAttributes wrap(Map map) {
        if (map == null) {
            map = new HashMap<>();
        }
        return new HtmlAttributes(map)
    }

    // Accessors

    public Object opt(String key) {
        return opt(key, Object)
    }

    public <T> T opt(String key, Class<T> classToCast, T defaultValue = null) {
        if (!map.containsKey(key)) {
            return defaultValue
        }
        Object nonCast = map.get(key)
        // TODO cast more intelligently
        return (T) nonCast;
    }

    public Object get(String key) {
        return get(key, Object)
    }

    public <T> T get(String key, Class<T> classToCast) throws IllegalArgumentException {
        T value = opt(key, classToCast)
        if (value == null) {
            throw new IllegalArgumentException("Missing attribute '" + key + "'")
        }
        return value
    }

    // Implementation of Map

    @Override
    int size() {
        return map.size()
    }

    @Override
    boolean isEmpty() {
        return map.isEmpty()
    }

    @Override
    boolean containsKey(Object key) {
        return map.containsKey(key)
    }

    @Override
    boolean containsValue(Object value) {
        return map.containsValue()
    }

    @Override
    Object get(Object key) {
        return map.get(key)
    }

    @Override
    Object put(String key, Object value) {
        return map.put(key, value)
    }

    @Override
    Object remove(Object key) {
        return map.remove(key)
    }

    @Override
    void putAll(Map<? extends String, ?> m) {
        map.putAll(m)
    }

    @Override
    void clear() {
        map.clear()
    }

    @Override
    Set<String> keySet() {
        return map.keySet()
    }

    @Override
    Collection<Object> values() {
        return map.values()
    }

    @Override
    Set<Map.Entry<String, Object>> entrySet() {
        return map.entrySet()
    }
}
