package acavailhez.html.traits.bootstrap

import acavailhez.html.traits.Html5Trait
import acavailhez.html.utils.HtmlAttributes

// shortcuts for bootstrap 4 buttons
// http://v4-alpha.getbootstrap.com/components/buttons/
trait Bootstrap4BtnTrait extends Html5Trait {

    // Reconfigures the attributes of a tag
    HtmlAttributes btn(Map map){
        HtmlAttributes attrs = HtmlAttributes.wrap(map)
        Bootstrap4Color color = attrs.opt('color', Bootstrap4Color, Bootstrap4Color.DEFAULT)
        attrs.remove('color')
        Bootstrap4Size size = attrs.opt('size', Bootstrap4Size, null)
        attrs.remove('size')
        if (size) {
            attrs.addToClass('btn-' + size.name().toLowerCase())
        }
        attrs.type = 'button'
        attrs.addToClass('btn btn-' + color.name().toLowerCase())
        return attrs
    }
}
