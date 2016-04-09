package acavailhez.html.traits.bootstrap

import acavailhez.html.traits.Html5Trait

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

    void bootstrapButton(Map attrs,
                         Closure body) {
        scopeAttrs(attrs)
        Bootstrap4ButtonStyle type = getAttr('btnStyle', Bootstrap4ButtonStyle, Bootstrap4ButtonStyle.DEFAULT)
        Map btnAttrs = attrs
        btnAttrs.remove('btnStyle')
        btnAttrs.type = 'button'
        btnAttrs.class = 'btn btn-' + type.name().toLowerCase()
        button(btnAttrs) {
            body()
        }
    }
}
