package acavailhez.html.bootstrap

import acavailhez.html.traits.CaptureTrait
import acavailhez.html.traits.Html5Trait
import acavailhez.html.utils.HtmlAttributes
import groovy.transform.CompileStatic

// shortcuts for bootstrap 4 navs
// http://v4-alpha.getbootstrap.com/components/navs
// http://v4-alpha.getbootstrap.com/components/navbar
@CompileStatic
trait Bootstrap4NavTrait implements Html5Trait, CaptureTrait {

    void navbar(Closure body) {
        navbar([:], body)
    }

    void navbar(Map map, Closure body) {
        HtmlAttributes attrs = HtmlAttributes.copy(map)
        nav(attrs.addToClass('navbar navbar-light')) {
            scope.put('navbar', true)
            body()
        }
    }

    // <a class="navbar-brand" href="#">Navbar</a>
    void brand(String brandName) {
        brand([:]) {
            escape << brandName
        }
    }

    void brand(Map map, Closure body) {
        a(HtmlAttributes.copy(map).addToClass('navbar-brand'), body)
    }

    // <ul class="nav">
    void ulNav(Closure body) {
        ulNav([:], body)
    }

    void ulNav(Map map, Closure body) {
        HtmlAttributes attrs = HtmlAttributes.wrap(map)
        attrs.addToClass('nav')
        if (scope.get('navbar')) {
            attrs.addToClass('navbar-nav')
        }
        ul(attrs, body)
    }

    void ulTabs(Closure body) {
        ulTabs([:], body)
    }

    void ulTabs(Map map, Closure body) {
        scope.put('tabs', true)
        ulNav(map, body)
    }

    // The attributes will be the attributes of <a> only
    void liANav(Map map, Closure body) {
        HtmlAttributes attrs = HtmlAttributes.wrap(map)
        li([class: 'nav-item']) {
            attrs.addToClass('nav-link')
            a(attrs) {
                body()
            }
        }
    }

    void tabs(Closure body) {
        tabs([:], body)
    }

    void tabs(Map map, Closure body) {
        List<Map> allTabs = []
        scope.put('tabs', allTabs)
        scope.put('navbar', true)

        // Let the user tell us what the tabs are named and contain
        capture(body)

        // Write the header
        ulNav(role: 'tab-list') {
            for (Map tab : allTabs) {
                String id = tab.id
                liANav(role: 'tab', 'data-toggle': 'tab', href: '#' + id) {
                    escape << tab.title
                }
            }
        }

        // Write the content
        div(class: 'tab-content') {
            for (Map tab : allTabs) {
                String id = tab.id
                div(class: 'tab-pane', id: id, role: 'tabpanel') {
                    html << tab.html
                }
            }
        }
    }

    void tab(String title, Closure body) {
        tab(title, [:], body)
    }

    void tab(String title, Map map, Closure body) {
        HtmlAttributes attrs = HtmlAttributes.wrap(map)
        List<Map> tabs = scope.opt('tabs', List)
        if (tabs == null) {
            throw new IllegalStateException("tab() used without being within a tabs{}, this cannot work, please consult the documentation of BootstrapNavTrait")
        }
        String id = attrs.opt('id', String)
        if (!id) {
            id = title.trim().replaceAll(" ", "-").replaceAll("[^a-zA-Z-]", "").toLowerCase();
        }
        String tabHtml = capture(body)
        tabs.add([
                title: title,
                id   : id,
                html : tabHtml
        ])
    }
}
