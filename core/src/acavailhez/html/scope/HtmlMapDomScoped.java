package acavailhez.html.scope;

import acavailhez.optget.OptGet;

import java.util.HashMap;
import java.util.Map;

// Keeps track of properties at the current scope level
// eg:
// div{
//  scope.put("current-color","red")
//  scope.get("current-color") >> red
//  div{
//   scope.put("current-color","blue")
//   scope.get("current-color") >> blue
//  }
//  scope.get("current-color") >> red
// }
public class HtmlMapDomScoped extends HtmlScopeListener<Map> implements OptGet {


    @Override
    protected Map create() {
        return new HashMap();
    }

    @Override
    protected Map merge(Map toMergeInto, Map objectToMerge) {
        // Drop all state, do not actually merge
        return toMergeInto;
    }

    // save something in the current scope
    public void put(Object key, Object value) {
        getCurrentScope().put(key, value);
    }

    @Override
    public void onMissingKey(Object key, Class classToCast) {
        throw new IllegalArgumentException("Scope does not contain:" + key + " of class:" + classToCast);
    }

    @Override
    public Object opt(Object key) {
        Object value = null;
        // look into all maps in stack, and keep the latest (freshest) one
        for (Map map : stack) {
            if (map.containsKey(key)) {
                value = map.get(key);
            }
        }
        return value;
    }

    // make calls explicit for groovy classes
    public <T> T opt(String key, Class<T> classToCast) {
        return OptGet.super.opt(key, classToCast);
    }

    public <T> T opt(String key, Class<T> classToCast, T defaultValue) {
        return OptGet.super.opt(key, classToCast, defaultValue);
    }

}
