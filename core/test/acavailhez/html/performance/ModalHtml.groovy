package acavailhez.html.performance

import acavailhez.html.Html
import acavailhez.html.bootstrap.Bootstrap4Color
import acavailhez.html.bootstrap.Bootstrap4Trait
import groovy.transform.CompileStatic

@CompileStatic
class ModalHtml extends Html implements Bootstrap4Trait {

    private final String title
    private final String content

    public ModalHtml(String title, String content) {
        this.title = title
        this.content = content
    }

    @Override
    protected void build() {
        modal(title: title, closeLabel: "Close") {
            if (content) {
                for (int i = 0; i < 5; i++) {
                    p(content)
                }
            }
        } {
            button(btn('data-dismiss': 'modal'), "Close")
            button(btn(color: Bootstrap4Color.PRIMARY), "Save changes")
        }
    }
}