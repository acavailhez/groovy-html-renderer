package acavailhez.html.traits

// Functions to simplify writing groups of tags
trait ShortcutTrait extends HtmlTrait {

    // shortcut for <dd> including a simple <dt>
    // use:
    // dl{
    //   ddt("Title"){
    //     escape << "content of the dd"
    //   }
    // }
    public void ddt(String title, Closure body) {
        tag('dt', null) { escape(title) }
        tag('dd', null, body)
    }

}
