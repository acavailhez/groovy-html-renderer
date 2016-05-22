package acavailhez.html.bootstrap

import acavailhez.html.traits.HtmlTrait
import groovy.transform.CompileStatic

// shortcuts for bootstrap 4
@CompileStatic
trait Bootstrap4Trait extends HtmlTrait
        implements Bootstrap4ModalTrait,
                Bootstrap4BtnTrait,
                Bootstrap4NavTrait,
                Bootstrap4GridTrait,
                Bootstrap4AlertTrait {
    // All bootstrap traits at once
}
