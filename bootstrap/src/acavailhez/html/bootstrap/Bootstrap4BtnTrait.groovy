package acavailhez.html.bootstrap

import acavailhez.html.traits.Html5Trait
import acavailhez.html.utils.HtmlAttributes

// shortcuts for bootstrap 4 buttons
// http://v4-alpha.getbootstrap.com/components/buttons/
trait Bootstrap4BtnTrait extends Html5Trait {

    // Reconfigures the attributes of a tag
    HtmlAttributes btn(Map map) {
        HtmlAttributes attrs = HtmlAttributes.wrap(map)

        attrs.addToClass('btn')
        attrs.put('type', 'button')

        // color
        Bootstrap4Color color = attrs.opt('color', Bootstrap4Color, Bootstrap4Color.DEFAULT)
        attrs.remove('color')
        String btnClass = 'btn-' + color.name().toLowerCase()
        if (attrs.opt('outline', Boolean, false)) {
            btnClass += '-outline'
        }
        attrs.remove('outline')
        attrs.addToClass(btnClass)

        // size
        Bootstrap4Size size = attrs.opt('size', Bootstrap4Size, null)
        attrs.remove('size')
        if (size) {
            attrs.addToClass('btn-' + size.name().toLowerCase())
        }

        return attrs
    }
}
