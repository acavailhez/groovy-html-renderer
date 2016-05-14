package acavailhez.html.demo

import acavailhez.html.HtmlPage
import Bootstrap4NavTrait

class Frontpage extends HtmlPage implements Bootstrap4NavTrait {

    @Override
    protected String title() {
        return "html-groovy-renderer demo"
    }

    @Override
    protected String description() {
        return "in-code html5 rendering engine leveraging the groovy syntax"
    }

    @Override
    protected void head() {
        css("https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css")
        javascript("https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js")
    }

    @Override
    protected void body() {
        navbar {
            brand("html-groovy-renderer")
            ulNav {
                liANav([href: '#']) {
                    escape << 'Simple'
                }
            }
        }
    }
}
