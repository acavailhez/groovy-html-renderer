package acavailhez.html.traits.bootstrap

import acavailhez.html.traits.Html5Trait
import acavailhez.html.utils.HtmlAttributes

// shortcuts for bootstrap 4 navs
// http://v4-alpha.getbootstrap.com/components/navs
// http://v4-alpha.getbootstrap.com/components/navbar
trait Bootstrap4NavTrait extends Html5Trait {

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
        if (scope.get('tabs')) {
            attrs.put('role','tablist')
        }
        ul(attrs, body)
    }

    void ulTabs(Closure body) {
        ulTabs([:], body)
    }

    void ulTabs(Map map, Closure body) {
        scope.put('tabs',true)
        ulNav(map, body)
    }

    // The attributes will be the attributes of <a> only
    void liANav(Map map, Closure body) {
        HtmlAttributes attrs = HtmlAttributes.wrap(map)
        li([class: 'nav-item']) {
            attrs.addToClass('nav-link')
            if (scope.get('tabs')) {
                attrs.put('data-toggle','tab')
                attrs.put('role','tab')
            }
            a(attrs) {
                body()
            }
        }
    }

    void tabs(Closure body){
        tabs([:],body)
    }

    void tabs(Map map,Closure body){
        HtmlAttributes attrs = HtmlAttributes.wrap(map)
        div(attrs.addToClass('tab-content'),body)
    }

    void tab(Map map,Closure body){
        HtmlAttributes attrs = HtmlAttributes.wrap(map)
        attrs.addToClass('tab-pane')
        if(attrs.get('active',Boolean)){
            attrs.remove('active')
            attrs.addToClass('active')
        }
        attrs.put('role','tabpanel')
        div(attrs,body)
    }
}
