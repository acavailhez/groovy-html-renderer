package acavailhez.html.bootstrap

import acavailhez.html.traits.Html5Trait
import acavailhez.html.utils.HtmlAttributes

// http://v4-alpha.getbootstrap.com/components/alerts/
trait Bootstrap4AlertTrait extends Html5Trait {

    public void alert(Map map, Closure body) {
        HtmlAttributes attrs = HtmlAttributes.wrap(map)
        Bootstrap4Color color = attrs.opt('color', Bootstrap4Color, Bootstrap4Color.DEFAULT)
        attrs.remove('color')
        attrs.put('role', 'alert')
        attrs.addToClass('alert alert-' + color.name().toLowerCase())
        div(attrs) {
            body()
        }
    }

}
