package acavailhez.html.bootstrap

import acavailhez.html.internal.HtmlEngine
import acavailhez.html.traits.Html5Trait
import acavailhez.html.utils.HtmlAttributes
import groovy.transform.CompileStatic

// shortcuts for bootstrap 4 modals
// http://v4-alpha.getbootstrap.com/components/modal/
@CompileStatic
trait Bootstrap4ModalTrait extends Html5Trait {

    // shortcut
    void modal(Map attrs,
               Closure body) {
        modal(attrs, null, body, null)
    }

    // shortcut
    void modal(Map attrs,
               Closure body,
               Closure footer) {
        modal(attrs, null, body, footer)
    }

    // A bootstrap modal with basic options
    // if header is null, a default header will be added
    // if footer is null, no footer will be added
    // Available attributes:
    // title, String: if present and header is null, the modal will have a head with this string (escaped)
    // tabindex, int: if present will set the tab-index
    // closeLabel, String: the label of the close cross
    void modal(Map map,
               Closure header,
               Closure body,
               Closure footer) {

        HtmlAttributes attrs = HtmlAttributes.wrap(map)

        String title = attrs.opt('title', String)
        attrs.remove('title')

        String close = attrs.opt('closeLabel', String)
        attrs.remove('closeLabel')

        attrs.addToClass('modal fade')
        attrs.put('role', 'dialog')
        attrs.put('tabindex', attrs.opt('tabindex', Integer, -1))

        // speed up and go around groovy trait bug (https://issues.apache.org/jira/browse/GROOVY-7843)
        HtmlEngine.openTag(html.stringBuilder, 'div', attrs)
        HtmlEngine.openTag(html.stringBuilder, 'div', [class: 'modal-dialog'])
        HtmlEngine.openTag(html.stringBuilder, 'div', [class: 'modal-content'])

        div(class: 'modal-header') {
            if (header) {
                header()
            } else {
                // default header
                button(type: 'button', class: 'close', 'data-dismiss': 'modal', 'aria-label': close) {
                    html << '<span aria-hidden="true">&times;</span>'
                }
                if (title && !title.isEmpty()) {
                    h4(class: 'modal-title') {
                        escape << title
                    }
                }

            }
        }

        div(class: 'modal-body') {
            body()
        }

        if (footer) {
            div(class: 'modal-footer') {
                footer()
            }
        }
        HtmlEngine.closeTag(html.stringBuilder, 'div')
        HtmlEngine.closeTag(html.stringBuilder, 'div')
        HtmlEngine.closeTag(html.stringBuilder, 'div')
    }

    // when applied to <a>, will open a modal
    HtmlAttributes modal(Map map) {
        HtmlAttributes attrs = HtmlAttributes.wrap(map)

        String modalId = attrs.get('modal', String)
        attrs.remove('modal')
        attrs.put('data-toggle', 'modal')
        attrs.put('data-target', '#' + modalId)

        return attrs
    }
}
