package acavailhez.html.performance

import acavailhez.html.HtmlPage
import groovy.transform.CompileStatic

@CompileStatic
class GrailsFrontPage extends HtmlPage {


    @Override
    protected String title() {
        return "The Grails Framework"
    }

    @Override
    protected void body() {

        a(href: 'https://github.com/grails/grails-core', target: '_blank') {
            div(id: 'fork-me') {
                p {
                    escape << "Fork me on Github"
                }
            }
        }
        div(id: 'st-container', class: 'st-container st-effect-9') {
            nav(class: 'st-menu st-effect-9', id: 'menu-12') {
                h2(class: 'icon icon-lab') {
                    escape << "Socialize"
                }
                ul {
                    li {
                        a(href: 'mailing-lists.html', class: 'icon') {
                            span(class: 'fa fa-envelope') {
                            }
                            escape << "Discuss on the Mailing List"
                        }
                    }
                    li {
                        a(href: 'http://slack-signup.grails.org', class: 'icon') {
                            span(class: 'fa fa-slack') {
                            }
                            escape << "Discuss on Slack"
                        }
                    }
                    li {
                        a(href: 'https://twitter.com/grailsframework', class: 'icon') {
                            span(class: 'fa fa-twitter') {
                            }
                            escape << "Grails on Twitter"
                        }
                    }
                    li {
                        a(href: 'events.html', class: 'icon') {
                            span(class: 'fa fa-calendar') {
                            }
                            escape << "Events and conferences"
                        }
                    }
                    li {
                        a(href: 'https://github.com/grails/grails-core', class: 'icon') {
                            span(class: 'fa fa-github') {
                            }
                            escape << "Source code on GitHub"
                        }
                    }
                    li {
                        a(href: 'contribute.html#reporting-issues', class: 'icon') {
                            span(class: 'fa fa-bug') {
                            }
                            escape << "Report issues on Github"
                        }
                    }
                    li {
                        a(href: 'http://stackoverflow.com/questions/tagged/grails', class: 'icon') {
                            span(class: 'fa fa-stack-overflow') {
                            }
                            escape << "Stack Overflow questions"
                        }
                    }
                }
            }
            div(class: 'st-pusher') {
                div(class: 'st-content') {
                    div(class: 'st-content-inner') {
                        div {
                            div(class: 'navbar navbar-default navbar-static-top', role: 'navigation') {
                                div(class: 'container') {
                                    div(class: 'navbar-header') {
                                        button(type: 'button', class: 'navbar-toggle', 'data-toggle': 'collapse', 'data-target': '.navbar-collapse') {
                                            span(class: 'sr-only') {
                                            }
                                            span(class: 'icon-bar') {
                                            }
                                            span(class: 'icon-bar') {
                                            }
                                            span(class: 'icon-bar') {
                                            }
                                        }
                                        a(class: 'navbar-brand', href: 'index.html') {
                                            i(class: 'fa grails-icon') {
                                                img(src: 'img/grails-cupsonly-logo-white.svg')
                                            }
                                            escape << "Grails"
                                        }
                                    }
                                    div(class: 'navbar-collapse collapse') {
                                        ul(class: 'nav navbar-nav navbar-right') {
                                            li(class: '') {
                                                a(href: 'learn.html') {
                                                    escape << "Learn"
                                                }
                                            }
                                            li(class: '') {
                                                a(href: 'documentation.html') {
                                                    escape << "Documentation"
                                                }
                                            }
                                            li(class: '') {
                                                a(href: 'support.html') {
                                                    escape << "Support"
                                                }
                                            }
                                            li(class: '') {
                                                a(href: 'download.html') {
                                                    escape << "Download"
                                                }
                                            }
                                            li(class: '') {
                                                a(href: 'plugins.html') {
                                                    escape << "Plugins"
                                                }
                                            }
                                            li(class: '') {
                                                a(href: 'community.html') {
                                                    escape << "Community"
                                                }
                                            }
                                            li(class: '') {
                                                a(href: 'ecosystem.html') {
                                                    escape << "Ecosystem"
                                                }
                                            }
                                            li {
                                                a('data-effect': 'st-effect-9', class: 'st-trigger', href: '#') {
                                                    escape << "Socialize"
                                                }
                                            }
                                            li(class: '') {
                                                a(href: 'search.html') {
                                                    i(class: 'fa fa-search') {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            div(id: 'band', class: 'band') {
                            }
                            div(id: 'content') {
                                section(class: 'row colset-2-its') {
                                    h1 {
                                        escape << "A powerful Groovy-based web application framework for the JVM"
                                    }
                                    p {
                                        strong {
                                            escape << "Grails"
                                        }
                                        escape << "is a"
                                        strong {
                                            escape << "powerful"
                                        }
                                        escape << "web framework, for the Java platform aimed at multiplying developersâ productivity thanks to a Convention-over-Configuration, sensible defaults and opinionated APIs. It integrates smoothly with the JVM, allowing you to be immediately productive whilst providing powerful features, including integrated ORM,"
                                        strong {
                                            escape << "Domain-Specific Languages"
                                        }
                                        escape << ", runtime and compile-time"
                                        strong {
                                            escape << "meta-programming"
                                        }
                                        escape << "and"
                                        strong {
                                            escape << "Asynchronous"
                                        }
                                        escape << "programming."
                                    }
                                    div(class: 'col1') {
                                        article {
                                            div(class: 'icon icon-1') {
                                            }
                                            h1 {
                                                escape << "Flat learning curve"
                                            }
                                            p {
                                                escape << "Convention-over-Configuration, sensible defaults, opinionated APIS and the Groovy language combine to make Grails easy to learn for Java developers"
                                            }
                                        }
                                        article {
                                            div(class: 'icon icon-2') {
                                            }
                                            h1 {
                                                escape << "Smooth Java integration"
                                            }
                                            p {
                                                escape << "Seamlessly and transparently integrates and interoperates with Java, the JVM and existing Java EE containers"
                                            }
                                        }
                                        article {
                                            div(class: 'icon icon-6') {
                                            }
                                            h1 {
                                                escape << "Plugins"
                                            }
                                            p {
                                                escape << "Build plugins that extend and enhance Grails or reuse an existing plugin already published by the vibrant plugin community!"
                                            }
                                        }
                                    }
                                    div(class: 'col2') {
                                        article {
                                            div(class: 'icon icon-4') {
                                            }
                                            h1 {
                                                escape << "Powerful features"
                                            }
                                            p {
                                                escape << "Integrated ORM / NoSQL support, a powerful view technology, plugins, and Spring-powered dependency injection. All you need to build modern web applications."
                                            }
                                        }
                                        article {
                                            div(class: 'icon icon-5') {
                                            }
                                            h1 {
                                                escape << "Domain-Specific Languages"
                                            }
                                            p {
                                                escape << "Expressive Domain Specific Languages (DSLs) used for validation, querying, markup rendering etc."
                                            }
                                        }
                                        article {
                                            div(class: 'icon icon-3') {
                                            }
                                            h1 {
                                                escape << "IDE Support"
                                            }
                                            p {
                                                escape << "Great support in IDEs and text editors such as Intellij IDEA, Eclipse, Sublime, Textmate etc."
                                            }
                                        }
                                    }
                                }
                                section(class: 'row colset-3-article first-event-row') {
                                    h1 {
                                        strong {
                                            escape << "Groovy and Grails events you shouldn't miss!"
                                        }
                                    }
                                    article {
                                        div(class: 'content') {
                                            div(class: 'event-img', style: 'background-image: url(img/confs/greach2016.png)') {
                                            }
                                            h1 {
                                                a(href: 'http://greachconf.com/') {
                                                    strong {
                                                        escape << "Greach 2016"
                                                    }
                                                    br {
                                                    }
                                                    em {
                                                        escape << "Madrid, Spain"
                                                    }
                                                }
                                            }
                                            time {
                                                escape << "April 8-9, 2016"
                                            }
                                            p {
                                                escape << "Greach, the Spanish gathering of enthusiasts of Groovy, Grails, Griffon, Gradle, Spock, Vert.x, Gaelyk, and many more. With inspirational talks from the makers and users of these projects, hands-on workshops with the rock stars, join the 150+ attendees, designers, students, designers, the best professionals together in a great atmosphere."
                                            }
                                        }
                                    }
                                    article {
                                        div(class: 'content') {
                                            div(class: 'event-img', style: 'background-image: url(img/confs/gr8confeu2016.png)') {
                                            }
                                            h1 {
                                                a(href: 'http://gr8conf.eu/') {
                                                    strong {
                                                        escape << "GR8Conf EU 2016"
                                                    }
                                                    br {
                                                    }
                                                    em {
                                                        escape << "Copenhagen, Denmark"
                                                    }
                                                }
                                            }
                                            time {
                                                escape << "June 1-3, 2016"
                                            }
                                            p {
                                                escape << "Groovy, Grails and the related technologies have seen astounding growth in interest and adoption the past few years, and with good reason. To spread the word even more we have created GR8Conf."
                                            }
                                            p {
                                                escape << "GR8Conf is an independent, affordable series of conferences. It's dedicated to the technologies in the Groovy ecosystem."
                                            }
                                        }
                                    }
                                    article {
                                        div(class: 'content') {
                                            div(class: 'event-img', style: 'background-image: url(img/confs/gr8confus2016.png)') {
                                            }
                                            h1 {
                                                a(href: 'http://gr8conf.us/') {
                                                    strong {
                                                        escape << "GR8Conf US 2016"
                                                    }
                                                    br {
                                                    }
                                                    em {
                                                        escape << "Minneapolis, MN, United States of America"
                                                    }
                                                }
                                            }
                                            time {
                                                escape << "July 27-29, 2016"
                                            }
                                            p {
                                                escape << "Groovy, Grails and the related technologies have seen astounding growth in interest and adoption the past few years, and with good reason. To spread the word even more we have created GR8Conf."
                                            }
                                            p {
                                                escape << "GR8Conf is an independent, affordable series of conferences. It's dedicated to the technologies in the Groovy ecosystem."
                                            }
                                        }
                                    }
                                }
                                section(class: 'row  last-event-row') {
                                    p(class: 'text-center') {
                                        escape << "For more events see the"
                                        a(href: 'events.html') {
                                            strong {
                                                escape << "Events"
                                            }
                                        }
                                        escape << "page"
                                    }
                                }
                            }
                            div(id: 'they-use-groovy', class: 'orange-band') {
                                div(class: 'row') {
                                    div(class: 'item') {
                                        h1 {
                                            strong {
                                                escape << "They all use Groovy!"
                                            }
                                        }
                                        div(id: 'logos-holder') {
                                            div(class: 'logo', style: 'background-image:url(img/logos/netflix.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/amadeus.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/bestbuy.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/carfax.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/carriots.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/cisco.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/credit-suisse.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/airbusgroup.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/energy-transfer.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/epo.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/fanniemae.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/google.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/hypoport.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/ibm.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/jpmorganchase.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/linkedin.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/mastercard.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/mtv.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/commerzbank.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/national-cancer-institute.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/nielsen.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/nestle.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/oracle.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/paterson-cancer-institute.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/roche.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/sas.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/sky.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/sony.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/smartthings.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/target.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/thales.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/ubs.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/vodafone.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/voyages-sncf.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/walmart.png)') {
                                            }
                                            div(class: 'logo', style: 'background-image:url(img/logos/wells-fargo.png)') {
                                            }
                                        }
                                    }
                                }
                            }
                            footer(id: 'footer') {
                                div(class: 'row') {
                                    div(class: 'colset-3-footer') {
                                        div(class: 'col-1') {
                                            h1 {
                                                escape << "Grails"
                                            }
                                            ul {
                                                li {
                                                    a(href: 'learn.html') {
                                                        escape << "Learn"
                                                    }
                                                }
                                                li {
                                                    a(href: 'documentation.html') {
                                                        escape << "Documentation"
                                                    }
                                                }
                                                li {
                                                    a(href: 'support.html') {
                                                        escape << "Support"
                                                    }
                                                }
                                                li {
                                                    a(href: 'download.html') {
                                                        escape << "Download"
                                                    }
                                                }
                                                li {
                                                    a(href: 'plugins.html') {
                                                        escape << "Plugins"
                                                    }
                                                }
                                                li {
                                                    a(href: 'community.html') {
                                                        escape << "Community"
                                                    }
                                                }
                                                li {
                                                    a(href: 'ecosystem.html') {
                                                        escape << "Ecosystem"
                                                    }
                                                }
                                            }
                                        }
                                        div(class: 'col-2') {
                                            h1 {
                                                escape << "About"
                                            }
                                            ul {
                                                li {
                                                    a(href: 'contribute.html') {
                                                        escape << "Contributing"
                                                    }
                                                }
                                                li {
                                                    a(href: 'https://github.com/grails/grails-core') {
                                                        escape << "Source code"
                                                    }
                                                }
                                                li {
                                                    a(href: 'buildstatus.html') {
                                                        escape << "Build status"
                                                    }
                                                }
                                                li {
                                                    a(href: 'learn.html#books') {
                                                        escape << "Books"
                                                    }
                                                }
                                                li {
                                                    a(href: 'faq.html') {
                                                        escape << "FAQ"
                                                    }
                                                }
                                                li {
                                                    a(href: 'search.html') {
                                                        escape << "Search"
                                                    }
                                                }
                                            }
                                        }
                                        div(class: 'col-3') {
                                            h1 {
                                                escape << "Socialize"
                                            }
                                            ul {
                                                li {
                                                    a(href: 'mailing-lists.html') {
                                                        escape << "Discuss on the Mailing List"
                                                    }
                                                }
                                                li {
                                                    a(href: 'http://slack-signup.grails.org') {
                                                        escape << "Discuss on Slack"
                                                    }
                                                }
                                                li {
                                                    a(href: 'https://twitter.com/grailsframework') {
                                                        escape << "Grails on Twitter"
                                                    }
                                                }
                                                li {
                                                    a(href: 'events.html') {
                                                        escape << "Events and conferences"
                                                    }
                                                }
                                                li {
                                                    a(href: 'https://github.com/grails/grails-core') {
                                                        escape << "Source code on GitHub"
                                                    }
                                                }
                                                li {
                                                    a(href: 'contribute.html#reporting-issues') {
                                                        escape << "Report issues on Github"
                                                    }
                                                }
                                                li {
                                                    a(href: 'http://stackoverflow.com/questions/tagged/grails') {
                                                        escape << "Stack Overflow questions"
                                                    }
                                                }
                                            }
                                        }
                                        div(class: 'col-right') {
                                            p {
                                                escape << "The Grails Framework"
                                                br {
                                                }
                                                escape << "repository is hosted by"
                                                a(href: 'http://artifactoryonline.com') {
                                                    escape << "Artifactory"
                                                }
                                                br {
                                                }
                                                escape << "Website hosting is provided by"
                                                a(href: 'http://run.pivotal.io') {
                                                    escape << "Pivotal"
                                                }
                                                br {
                                                }
                                                escape << "YourKit supports Grails with its"
                                                a(href: 'https://www.yourkit.com/java/profiler/index.jsp') {
                                                    escape << "Java Profiler"
                                                }
                                                br {
                                                }
                                            }
                                            a(href: 'http://artifactoryonline.com') {
                                                img(width: '150', src: 'img/logos/artifactory.png', title: 'Artifactory Online', alt: 'Aritfactory Online')
                                            }
                                            br {
                                            }
                                            br {
                                            }
                                            a(href: 'http://yourkit.com') {
                                                img(width: '150', src: 'https://www.yourkit.com/images/yklogo.png', title: 'YourKit Java Profiler', alt: 'YourKit Java Profiler')
                                            }
                                            br {
                                            }
                                            a(href: 'http://run.pivotal.io') {
                                                img(src: 'img/pws-thumb.png', title: 'Pivotal Web Service', alt: 'Pivotal Web Service')
                                            }
                                            br {
                                            }
                                        }
                                    }
                                    div(class: 'clearfix') {
                                        escape << "© 2005-2016 the Grails project — Grails is Open Source,"
                                        a(href: 'http://www.apache.org/licenses/LICENSE-2.0.html') {
                                            escape << "Apache 2 License"
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        script(src: 'js/vendor/jquery-1.10.2.min.js', defer: '') {
        }
        script(src: 'js/vendor/bootstrap.js', defer: '') {
        }
        script(src: 'js/vendor/modernizr.min.js', defer: '') {
        }
        script(src: 'js/vendor/classie.js', defer: '') {
        }
        script(src: 'js/vendor/sidebarEffects.js', defer: '') {
        }
        script(src: 'js/plugins.js', defer: '') {
        }
    }
}
