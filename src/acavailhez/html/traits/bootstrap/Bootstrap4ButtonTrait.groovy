package acavailhez.html.traits.bootstrap

import acavailhez.html.traits.Html5Trait
import acavailhez.html.utils.HtmlAttributes

// shortcuts for bootstrap 4 buttons
// http://v4-alpha.getbootstrap.com/components/buttons/
trait Bootstrap4ButtonTrait extends Html5Trait {

    // shortcut with just a text
    void bootstrapButton(Map attrs,
                         String text) {
        bootstrapButton(attrs) {
            escape << text
        }
    }

    void bootstrapButton(Map map,
                         Closure body) {
        HtmlAttributes attrs = HtmlAttributes.copy(map)
        Bootstrap4ButtonStyle type = attrs.opt('btnStyle', Bootstrap4ButtonStyle, Bootstrap4ButtonStyle.DEFAULT)
        attrs.remove('btnStyle')
        attrs.type = 'button'
        attrs.class = 'btn btn-' + type.name().toLowerCase()
        button(attrs) {
            body()
        }
    }
}
