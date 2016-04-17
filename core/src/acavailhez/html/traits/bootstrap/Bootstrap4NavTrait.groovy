package acavailhez.html.traits.bootstrap

import acavailhez.html.traits.Html5Trait
import acavailhez.html.utils.HtmlAttributes

// shortcuts for bootstrap 4 navs
// http://v4-alpha.getbootstrap.com/components/navs
// http://v4-alpha.getbootstrap.com/components/navbar
trait Bootstrap4NavTrait extends Html5Trait {

    void bootstrapNavbar(Closure body) {
        bootstrapNavbar([:], body)
    }

    void bootstrapNavbar(Map map, Closure body) {
        HtmlAttributes attrs = HtmlAttributes.copy(map)
        nav(attrs.addToClass('navbar navbar-light')) {
            scope.put('navbar', true)
            body()
        }
    }

    // <a class="navbar-brand" href="#">Navbar</a>
    void bootstrapBrand(Map map, String brand) {
        HtmlAttributes attrs = HtmlAttributes.copy(map)
        a(attrs.addToClass('navbar-brand')) {
            escape << brand
        }
    }

    // <ul class="nav">
    void bootstrapNavUl(Map map, Closure body) {
        HtmlAttributes attrs = HtmlAttributes.copy(map)
        attrs.addToClass('nav')
        if (scope.get('navbar')) {
            attrs.addToClass('navbar-nav')
        }
        ul(attrs, body)
    }

    void bootstrapNavLiA(Map map, Closure body) {
        HtmlAttributes attrs = HtmlAttributes.copy(map)
        attrs.addToClass('nav-item')
        li(attrs) {
            a(attrs.addToClass('nav-link')) {
                body()
            }
        }
    }
}
