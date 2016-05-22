package acavailhez.html.utils;


import java.util.HashMap;
import java.util.Map;

// Keeps a local copy of a map and adds extra methods
// Two ways to create from an existing map:
// HtmlAttributes.copy() will copy the content of the argument
// HtmlAttributes.wrap() will keep the existing map and modify it
//
// Added methods: get/opt
// - opt(key, String, "default") will get the [key] value or default if not set
// - get(key, String) will get the [key] value and raise a IllegalArgumentException if not present
// - addToClass(String) will append new classes to the existing one (or create one)
public class HtmlAttributes extends OptGetMap {

    private HtmlAttributes(Map<String, Object> map) {
        super(map);
    }

    public static HtmlAttributes copy(Map<String, Object> map) {
        HtmlAttributes attrs = new HtmlAttributes(new HashMap<>());
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                attrs.put(entry.getKey().toString(), entry.getValue());
            }
        }
        return attrs;
    }

    public static HtmlAttributes wrap(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        return new HtmlAttributes(map);
    }

    // addToClass(String) will append new classes to the existing one (or create one)
    public HtmlAttributes addToClass(String newClass) {
        if (newClass == null) {
            return this;
        }
        if (!this.containsKey("class")) {
            this.put("class", newClass);
        } else {
            String classesString = get("class", String.class);
            this.put("class", classesString + " " + newClass);
        }
        return this;
    }

    // make call explicit for groovy classes
    public <T> T opt(String key, Class<T> classToCast) {
        return super.opt(key, classToCast);
    }

    public <T> T opt(String key, Class<T> classToCast, T defaultValue) {
        return super.opt(key, classToCast, defaultValue);
    }
}
