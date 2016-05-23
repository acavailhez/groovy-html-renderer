package acavailhez.html.scope;

import acavailhez.optget.OptGet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Scoped state of the html
public class HtmlScope implements OptGet {

    private List<Map<Object, Object>> stack = new LinkedList<>();
    private List<HtmlScopable> scopables = new LinkedList<>();

    public void addScopable(HtmlScopable scopable) {
        scopables.add(scopable);
    }

    // save something in the current scope
    public void put(String key, Object value) {
        stack.get(stack.size() - 1).put(key, value);
    }

    @Override
    public void onMissingKey(Object key, Class classToCast) {
        throw new IllegalArgumentException("Scope does not contain:" + key + " of class:" + classToCast);
    }

    @Override
    public Object opt(Object key) {
        Object value = null;
        for (Map<Object, Object> map : stack) {
            if (map.containsKey(key)) {
                value = map.get(key);
            }
        }
        return value;
    }

    public void prepareForNewScope() {
        for (HtmlScopable scopable : scopables) {
            scopable.prepareForNewScope();
        }
        stack.add(new HashMap<>());
    }

    public void commitToPreviousScope() {
        for (HtmlScopable scopable : scopables) {
            scopable.commitToPreviousScope();
        }
        stack.remove(stack.size() - 1);  // pop
    }

    public void rollbackCurrentScope() {
        for (HtmlScopable scopable : scopables) {
            scopable.rollbackCurrentScope();
        }
        stack.remove(stack.size() - 1);  // pop
    }

    // make calls explicit for groovy classes
    public <T> T opt(String key, Class<T> classToCast) {
        return OptGet.super.opt(key, classToCast);
    }

    public <T> T opt(String key, Class<T> classToCast, T defaultValue) {
        return OptGet.super.opt(key, classToCast, defaultValue);
    }
}
