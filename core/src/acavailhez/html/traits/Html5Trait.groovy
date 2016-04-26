package acavailhez.html.traits

import groovy.transform.CompileStatic

// All tags from https://developer.mozilla.org/en-US/docs/Web/HTML/Element
@CompileStatic
trait Html5Trait extends HtmlTrait {

    // --- Basic elements

    void html(Closure body) {
        tag('html', [:], body)
    }

    void html(Map attrs, Closure body) {
        tag('html', attrs, body)
    }


    // --- Document metadata

    void base(Closure body) {
        tag('base', [:], body)
    }

    void base(Map attrs, Closure body) {
        tag('base', attrs, body)
    }

    void head(Closure body) {
        tag('head', [:], body)
    }

    void head(Map attrs, Closure body) {
        tag('head', attrs, body)
    }

    void link(Map attrs) {
        tag('link', attrs, null)
    }

    void meta(Map attrs) {
        tag('meta', attrs, null)
    }

    void style(Closure body) {
        tag('style', [:], body)
    }

    void style(Map attrs, Closure body) {
        tag('style', attrs, body)
    }

    void title(Closure body) {
        tag('title', [:], body)
    }

    void title(Map attrs, Closure body) {
        tag('title', attrs, body)
    }

    void title(String escapeContent) {
        html << '<title>'
        escape << escapeContent
        html << '</title>'
    }

    void title(Map attrs, String escapeContent) {
        title(attrs){
            escape << escapeContent
        }
    }


    // --- Content sectioning

    void address(Closure body) {
        tag('address', [:], body)
    }

    void address(Map attrs, Closure body) {
        tag('address', attrs, body)
    }

    void article(Closure body) {
        tag('article', [:], body)
    }

    void article(Map attrs, Closure body) {
        tag('article', attrs, body)
    }

    void footer(Closure body) {
        tag('footer', [:], body)
    }

    void footer(Map attrs, Closure body) {
        tag('footer', attrs, body)
    }

    void header(Closure body) {
        tag('header', [:], body)
    }

    void header(Map attrs, Closure body) {
        tag('header', attrs, body)
    }

    void h1(Closure body) {
        tag('h1', [:], body)
    }

    void h1(Map attrs, Closure body) {
        tag('h1', attrs, body)
    }

    void h1(String escapeContent) {
        html << '<h1>'
        escape << escapeContent
        html << '</h1>'
    }

    void h1(Map attrs, String escapeContent) {
        h1(attrs){
            escape << escapeContent
        }
    }

    void h2(Closure body) {
        tag('h2', [:], body)
    }

    void h2(Map attrs, Closure body) {
        tag('h2', attrs, body)
    }

    void h2(String escapeContent) {
        html << '<h2>'
        escape << escapeContent
        html << '</h2>'
    }

    void h2(Map attrs, String escapeContent) {
        h2(attrs){
            escape << escapeContent
        }
    }

    void h3(Closure body) {
        tag('h3', [:], body)
    }

    void h3(Map attrs, Closure body) {
        tag('h3', attrs, body)
    }

    void h3(String escapeContent) {
        html << '<h3>'
        escape << escapeContent
        html << '</h3>'
    }

    void h3(Map attrs, String escapeContent) {
        h3(attrs){
            escape << escapeContent
        }
    }

    void h4(Closure body) {
        tag('h4', [:], body)
    }

    void h4(Map attrs, Closure body) {
        tag('h4', attrs, body)
    }

    void h4(String escapeContent) {
        html << '<h4>'
        escape << escapeContent
        html << '</h4>'
    }

    void h4(Map attrs, String escapeContent) {
        h4(attrs){
            escape << escapeContent
        }
    }

    void h5(Closure body) {
        tag('h5', [:], body)
    }

    void h5(Map attrs, Closure body) {
        tag('h5', attrs, body)
    }

    void h5(String escapeContent) {
        html << '<h5>'
        escape << escapeContent
        html << '</h5>'
    }

    void h5(Map attrs, String escapeContent) {
        h5(attrs){
            escape << escapeContent
        }
    }

    void h6(Closure body) {
        tag('h6', [:], body)
    }

    void h6(Map attrs, Closure body) {
        tag('h6', attrs, body)
    }

    void h6(String escapeContent) {
        html << '<h6>'
        escape << escapeContent
        html << '</h6>'
    }

    void h6(Map attrs, String escapeContent) {
        h6(attrs){
            escape << escapeContent
        }
    }

    void hgroup(Closure body) {
        tag('hgroup', [:], body)
    }

    void hgroup(Map attrs, Closure body) {
        tag('hgroup', attrs, body)
    }

    void nav(Closure body) {
        tag('nav', [:], body)
    }

    void nav(Map attrs, Closure body) {
        tag('nav', attrs, body)
    }

    void section(Closure body) {
        tag('section', [:], body)
    }

    void section(Map attrs, Closure body) {
        tag('section', attrs, body)
    }


    // --- Text content

    void dd(Closure body) {
        tag('dd', [:], body)
    }

    void dd(Map attrs, Closure body) {
        tag('dd', attrs, body)
    }

    void div(Closure body) {
        tag('div', [:], body)
    }

    void div(Map attrs, Closure body) {
        tag('div', attrs, body)
    }

    void dl(Closure body) {
        tag('dl', [:], body)
    }

    void dl(Map attrs, Closure body) {
        tag('dl', attrs, body)
    }

    void dt(Closure body) {
        tag('dt', [:], body)
    }

    void dt(Map attrs, Closure body) {
        tag('dt', attrs, body)
    }

    void figcaption(Closure body) {
        tag('figcaption', [:], body)
    }

    void figcaption(Map attrs, Closure body) {
        tag('figcaption', attrs, body)
    }

    void figure(Closure body) {
        tag('figure', [:], body)
    }

    void figure(Map attrs, Closure body) {
        tag('figure', attrs, body)
    }

    void hr(){
        html << '<hr>'
    }

    void li(Closure body) {
        tag('li', [:], body)
    }

    void li(Map attrs, Closure body) {
        tag('li', attrs, body)
    }

    void li(String escapeContent) {
        html << '<li>'
        escape << escapeContent
        html << '</li>'
    }

    void li(Map attrs, String escapeContent) {
        li(attrs){
            escape << escapeContent
        }
    }

    void main(Closure body) {
        tag('main', [:], body)
    }

    void main(Map attrs, Closure body) {
        tag('main', attrs, body)
    }

    void ol(Closure body) {
        tag('ol', [:], body)
    }

    void ol(Map attrs, Closure body) {
        tag('ol', attrs, body)
    }

    void p(Closure body) {
        tag('p', [:], body)
    }

    void p(Map attrs, Closure body) {
        tag('p', attrs, body)
    }

    void p(String escapeContent) {
        html << '<p>'
        escape << escapeContent
        html << '</p>'
    }

    void p(Map attrs, String escapeContent) {
        p(attrs){
            escape << escapeContent
        }
    }

    void pre(Closure body) {
        tag('pre', [:], body)
    }

    void pre(Map attrs, Closure body) {
        tag('pre', attrs, body)
    }

    void ul(Closure body) {
        tag('ul', [:], body)
    }

    void ul(Map attrs, Closure body) {
        tag('ul', attrs, body)
    }


    // --- Inline text semantics

    void abbr(Closure body) {
        tag('abbr', [:], body)
    }

    void abbr(Map attrs, Closure body) {
        tag('abbr', attrs, body)
    }

    void abbr(String escapeContent) {
        html << '<abbr>'
        escape << escapeContent
        html << '</abbr>'
    }

    void abbr(Map attrs, String escapeContent) {
        abbr(attrs){
            escape << escapeContent
        }
    }

    void b(Closure body) {
        tag('b', [:], body)
    }

    void b(Map attrs, Closure body) {
        tag('b', attrs, body)
    }

    void b(String escapeContent) {
        html << '<b>'
        escape << escapeContent
        html << '</b>'
    }

    void b(Map attrs, String escapeContent) {
        b(attrs){
            escape << escapeContent
        }
    }

    void bdi(Closure body) {
        tag('bdi', [:], body)
    }

    void bdi(Map attrs, Closure body) {
        tag('bdi', attrs, body)
    }

    void bdi(String escapeContent) {
        html << '<bdi>'
        escape << escapeContent
        html << '</bdi>'
    }

    void bdi(Map attrs, String escapeContent) {
        bdi(attrs){
            escape << escapeContent
        }
    }

    void bdo(Closure body) {
        tag('bdo', [:], body)
    }

    void bdo(Map attrs, Closure body) {
        tag('bdo', attrs, body)
    }

    void bdo(String escapeContent) {
        html << '<bdo>'
        escape << escapeContent
        html << '</bdo>'
    }

    void bdo(Map attrs, String escapeContent) {
        bdo(attrs){
            escape << escapeContent
        }
    }

    void br(Closure body) {
        tag('br', [:], body)
    }

    void br(Map attrs, Closure body) {
        tag('br', attrs, body)
    }

    void br(String escapeContent) {
        html << '<br>'
        escape << escapeContent
        html << '</br>'
    }

    void br(Map attrs, String escapeContent) {
        br(attrs){
            escape << escapeContent
        }
    }

    void cite(Closure body) {
        tag('cite', [:], body)
    }

    void cite(Map attrs, Closure body) {
        tag('cite', attrs, body)
    }

    void cite(String escapeContent) {
        html << '<cite>'
        escape << escapeContent
        html << '</cite>'
    }

    void cite(Map attrs, String escapeContent) {
        cite(attrs){
            escape << escapeContent
        }
    }

    void code(Closure body) {
        tag('code', [:], body)
    }

    void code(Map attrs, Closure body) {
        tag('code', attrs, body)
    }

    void code(String escapeContent) {
        html << '<code>'
        escape << escapeContent
        html << '</code>'
    }

    void code(Map attrs, String escapeContent) {
        code(attrs){
            escape << escapeContent
        }
    }

    void data(Closure body) {
        tag('data', [:], body)
    }

    void data(Map attrs, Closure body) {
        tag('data', attrs, body)
    }

    void data(String escapeContent) {
        html << '<data>'
        escape << escapeContent
        html << '</data>'
    }

    void data(Map attrs, String escapeContent) {
        data(attrs){
            escape << escapeContent
        }
    }

    void dfn(Closure body) {
        tag('dfn', [:], body)
    }

    void dfn(Map attrs, Closure body) {
        tag('dfn', attrs, body)
    }

    void dfn(String escapeContent) {
        html << '<dfn>'
        escape << escapeContent
        html << '</dfn>'
    }

    void dfn(Map attrs, String escapeContent) {
        dfn(attrs){
            escape << escapeContent
        }
    }

    void em(Closure body) {
        tag('em', [:], body)
    }

    void em(Map attrs, Closure body) {
        tag('em', attrs, body)
    }

    void em(String escapeContent) {
        html << '<em>'
        escape << escapeContent
        html << '</em>'
    }

    void em(Map attrs, String escapeContent) {
        em(attrs){
            escape << escapeContent
        }
    }

    void i(Closure body) {
        tag('i', [:], body)
    }

    void i(Map attrs, Closure body) {
        tag('i', attrs, body)
    }

    void i(String escapeContent) {
        html << '<i>'
        escape << escapeContent
        html << '</i>'
    }

    void i(Map attrs, String escapeContent) {
        i(attrs){
            escape << escapeContent
        }
    }

    void kbd(Closure body) {
        tag('kbd', [:], body)
    }

    void kbd(Map attrs, Closure body) {
        tag('kbd', attrs, body)
    }

    void kbd(String escapeContent) {
        html << '<kbd>'
        escape << escapeContent
        html << '</kbd>'
    }

    void kbd(Map attrs, String escapeContent) {
        kbd(attrs){
            escape << escapeContent
        }
    }

    void mark(Closure body) {
        tag('mark', [:], body)
    }

    void mark(Map attrs, Closure body) {
        tag('mark', attrs, body)
    }

    void mark(String escapeContent) {
        html << '<mark>'
        escape << escapeContent
        html << '</mark>'
    }

    void mark(Map attrs, String escapeContent) {
        mark(attrs){
            escape << escapeContent
        }
    }

    void q(Closure body) {
        tag('q', [:], body)
    }

    void q(Map attrs, Closure body) {
        tag('q', attrs, body)
    }

    void q(String escapeContent) {
        html << '<q>'
        escape << escapeContent
        html << '</q>'
    }

    void q(Map attrs, String escapeContent) {
        q(attrs){
            escape << escapeContent
        }
    }

    void rp(Closure body) {
        tag('rp', [:], body)
    }

    void rp(Map attrs, Closure body) {
        tag('rp', attrs, body)
    }

    void rp(String escapeContent) {
        html << '<rp>'
        escape << escapeContent
        html << '</rp>'
    }

    void rp(Map attrs, String escapeContent) {
        rp(attrs){
            escape << escapeContent
        }
    }

    void rt(Closure body) {
        tag('rt', [:], body)
    }

    void rt(Map attrs, Closure body) {
        tag('rt', attrs, body)
    }

    void rt(String escapeContent) {
        html << '<rt>'
        escape << escapeContent
        html << '</rt>'
    }

    void rt(Map attrs, String escapeContent) {
        rt(attrs){
            escape << escapeContent
        }
    }

    void rtc(Closure body) {
        tag('rtc', [:], body)
    }

    void rtc(Map attrs, Closure body) {
        tag('rtc', attrs, body)
    }

    void rtc(String escapeContent) {
        html << '<rtc>'
        escape << escapeContent
        html << '</rtc>'
    }

    void rtc(Map attrs, String escapeContent) {
        rtc(attrs){
            escape << escapeContent
        }
    }

    void ruby(Closure body) {
        tag('ruby', [:], body)
    }

    void ruby(Map attrs, Closure body) {
        tag('ruby', attrs, body)
    }

    void ruby(String escapeContent) {
        html << '<ruby>'
        escape << escapeContent
        html << '</ruby>'
    }

    void ruby(Map attrs, String escapeContent) {
        ruby(attrs){
            escape << escapeContent
        }
    }

    void s(Closure body) {
        tag('s', [:], body)
    }

    void s(Map attrs, Closure body) {
        tag('s', attrs, body)
    }

    void s(String escapeContent) {
        html << '<s>'
        escape << escapeContent
        html << '</s>'
    }

    void s(Map attrs, String escapeContent) {
        s(attrs){
            escape << escapeContent
        }
    }

    void samp(Closure body) {
        tag('samp', [:], body)
    }

    void samp(Map attrs, Closure body) {
        tag('samp', attrs, body)
    }

    void samp(String escapeContent) {
        html << '<samp>'
        escape << escapeContent
        html << '</samp>'
    }

    void samp(Map attrs, String escapeContent) {
        samp(attrs){
            escape << escapeContent
        }
    }

    void small(Closure body) {
        tag('small', [:], body)
    }

    void small(Map attrs, Closure body) {
        tag('small', attrs, body)
    }

    void small(String escapeContent) {
        html << '<small>'
        escape << escapeContent
        html << '</small>'
    }

    void small(Map attrs, String escapeContent) {
        small(attrs){
            escape << escapeContent
        }
    }

    void span(Closure body) {
        tag('span', [:], body)
    }

    void span(Map attrs, Closure body) {
        tag('span', attrs, body)
    }

    void span(String escapeContent) {
        html << '<span>'
        escape << escapeContent
        html << '</span>'
    }

    void span(Map attrs, String escapeContent) {
        span(attrs){
            escape << escapeContent
        }
    }

    void strong(Closure body) {
        tag('strong', [:], body)
    }

    void strong(Map attrs, Closure body) {
        tag('strong', attrs, body)
    }

    void strong(String escapeContent) {
        html << '<strong>'
        escape << escapeContent
        html << '</strong>'
    }

    void strong(Map attrs, String escapeContent) {
        strong(attrs){
            escape << escapeContent
        }
    }

    void sub(Closure body) {
        tag('sub', [:], body)
    }

    void sub(Map attrs, Closure body) {
        tag('sub', attrs, body)
    }

    void sub(String escapeContent) {
        html << '<sub>'
        escape << escapeContent
        html << '</sub>'
    }

    void sub(Map attrs, String escapeContent) {
        sub(attrs){
            escape << escapeContent
        }
    }

    void sup(Closure body) {
        tag('sup', [:], body)
    }

    void sup(Map attrs, Closure body) {
        tag('sup', attrs, body)
    }

    void sup(String escapeContent) {
        html << '<sup>'
        escape << escapeContent
        html << '</sup>'
    }

    void sup(Map attrs, String escapeContent) {
        sup(attrs){
            escape << escapeContent
        }
    }

    void time(Closure body) {
        tag('time', [:], body)
    }

    void time(Map attrs, Closure body) {
        tag('time', attrs, body)
    }

    void time(String escapeContent) {
        html << '<time>'
        escape << escapeContent
        html << '</time>'
    }

    void time(Map attrs, String escapeContent) {
        time(attrs){
            escape << escapeContent
        }
    }

    void u(Closure body) {
        tag('u', [:], body)
    }

    void u(Map attrs, Closure body) {
        tag('u', attrs, body)
    }

    void u(String escapeContent) {
        html << '<u>'
        escape << escapeContent
        html << '</u>'
    }

    void u(Map attrs, String escapeContent) {
        u(attrs){
            escape << escapeContent
        }
    }

    void var(Closure body) {
        tag('var', [:], body)
    }

    void var(Map attrs, Closure body) {
        tag('var', attrs, body)
    }

    void var(String escapeContent) {
        html << '<var>'
        escape << escapeContent
        html << '</var>'
    }

    void var(Map attrs, String escapeContent) {
        var(attrs){
            escape << escapeContent
        }
    }

    void wbr(Closure body) {
        tag('wbr', [:], body)
    }

    void wbr(Map attrs, Closure body) {
        tag('wbr', attrs, body)
    }

    void wbr(String escapeContent) {
        html << '<wbr>'
        escape << escapeContent
        html << '</wbr>'
    }

    void wbr(Map attrs, String escapeContent) {
        wbr(attrs){
            escape << escapeContent
        }
    }


    // --- Image and multimedia

    void area(Map attrs) {
        tag('area', attrs, null)
    }

    void audio(Closure body) {
        tag('audio', [:], body)
    }

    void audio(Map attrs, Closure body) {
        tag('audio', attrs, body)
    }

    void map(Closure body) {
        tag('map', [:], body)
    }

    void map(Map attrs, Closure body) {
        tag('map', attrs, body)
    }

    void track(Map attrs) {
        tag('track', attrs, null)
    }

    void video(Closure body) {
        tag('video', [:], body)
    }

    void video(Map attrs, Closure body) {
        tag('video', attrs, body)
    }


    // --- Embedded content

    void embed(Map attrs) {
        tag('embed', attrs, null)
    }

    void object(Closure body) {
        tag('object', [:], body)
    }

    void object(Map attrs, Closure body) {
        tag('object', attrs, body)
    }

    void param(Map attrs) {
        tag('param', attrs, null)
    }

    void picture(Closure body) {
        tag('picture', [:], body)
    }

    void picture(Map attrs, Closure body) {
        tag('picture', attrs, body)
    }


    // --- Scripting

    void canvas(Closure body) {
        tag('canvas', [:], body)
    }

    void canvas(Map attrs, Closure body) {
        tag('canvas', attrs, body)
    }

    void noscript(Closure body) {
        tag('noscript', [:], body)
    }

    void noscript(Map attrs, Closure body) {
        tag('noscript', attrs, body)
    }

    void script(Closure body) {
        tag('script', [:], body)
    }

    void script(Map attrs, Closure body) {
        tag('script', attrs, body)
    }


    // --- Demarcating edits

    void del(Closure body) {
        tag('del', [:], body)
    }

    void del(Map attrs, Closure body) {
        tag('del', attrs, body)
    }

    void del(String escapeContent) {
        html << '<del>'
        escape << escapeContent
        html << '</del>'
    }

    void del(Map attrs, String escapeContent) {
        del(attrs){
            escape << escapeContent
        }
    }

    void ins(Closure body) {
        tag('ins', [:], body)
    }

    void ins(Map attrs, Closure body) {
        tag('ins', attrs, body)
    }

    void ins(String escapeContent) {
        html << '<ins>'
        escape << escapeContent
        html << '</ins>'
    }

    void ins(Map attrs, String escapeContent) {
        ins(attrs){
            escape << escapeContent
        }
    }


    // --- Table content

    void caption(Closure body) {
        tag('caption', [:], body)
    }

    void caption(Map attrs, Closure body) {
        tag('caption', attrs, body)
    }

    void col(Closure body) {
        tag('col', [:], body)
    }

    void col(Map attrs, Closure body) {
        tag('col', attrs, body)
    }

    void colgroup(Closure body) {
        tag('colgroup', [:], body)
    }

    void colgroup(Map attrs, Closure body) {
        tag('colgroup', attrs, body)
    }

    void table(Closure body) {
        tag('table', [:], body)
    }

    void table(Map attrs, Closure body) {
        tag('table', attrs, body)
    }

    void tbody(Closure body) {
        tag('tbody', [:], body)
    }

    void tbody(Map attrs, Closure body) {
        tag('tbody', attrs, body)
    }

    void td(Closure body) {
        tag('td', [:], body)
    }

    void td(Map attrs, Closure body) {
        tag('td', attrs, body)
    }

    void tfoot(Closure body) {
        tag('tfoot', [:], body)
    }

    void tfoot(Map attrs, Closure body) {
        tag('tfoot', attrs, body)
    }

    void th(Closure body) {
        tag('th', [:], body)
    }

    void th(Map attrs, Closure body) {
        tag('th', attrs, body)
    }

    void thead(Closure body) {
        tag('thead', [:], body)
    }

    void thead(Map attrs, Closure body) {
        tag('thead', attrs, body)
    }

    void tr(Closure body) {
        tag('tr', [:], body)
    }

    void tr(Map attrs, Closure body) {
        tag('tr', attrs, body)
    }


    // --- Forms

    void button(Closure body) {
        tag('button', [:], body)
    }

    void button(Map attrs, Closure body) {
        tag('button', attrs, body)
    }

    void button(String escapeContent) {
        html << '<button>'
        escape << escapeContent
        html << '</button>'
    }

    void button(Map attrs, String escapeContent) {
        button(attrs){
            escape << escapeContent
        }
    }

    void datalist(Closure body) {
        tag('datalist', [:], body)
    }

    void datalist(Map attrs, Closure body) {
        tag('datalist', attrs, body)
    }

    void fieldset(Closure body) {
        tag('fieldset', [:], body)
    }

    void fieldset(Map attrs, Closure body) {
        tag('fieldset', attrs, body)
    }

    void form(Closure body) {
        tag('form', [:], body)
    }

    void form(Map attrs, Closure body) {
        tag('form', attrs, body)
    }

    void input(Closure body) {
        tag('input', [:], body)
    }

    void input(Map attrs, Closure body) {
        tag('input', attrs, body)
    }

    void keygen(Closure body) {
        tag('keygen', [:], body)
    }

    void keygen(Map attrs, Closure body) {
        tag('keygen', attrs, body)
    }

    void label(Closure body) {
        tag('label', [:], body)
    }

    void label(Map attrs, Closure body) {
        tag('label', attrs, body)
    }

    void legend(Closure body) {
        tag('legend', [:], body)
    }

    void legend(Map attrs, Closure body) {
        tag('legend', attrs, body)
    }

    void meter(Closure body) {
        tag('meter', [:], body)
    }

    void meter(Map attrs, Closure body) {
        tag('meter', attrs, body)
    }

    void optgroup(Closure body) {
        tag('optgroup', [:], body)
    }

    void optgroup(Map attrs, Closure body) {
        tag('optgroup', attrs, body)
    }

    void output(Closure body) {
        tag('output', [:], body)
    }

    void output(Map attrs, Closure body) {
        tag('output', attrs, body)
    }

    void progress(Closure body) {
        tag('progress', [:], body)
    }

    void progress(Map attrs, Closure body) {
        tag('progress', attrs, body)
    }

    void select(Closure body) {
        tag('select', [:], body)
    }

    void select(Map attrs, Closure body) {
        tag('select', attrs, body)
    }


    // --- Interactive elements

    void details(Closure body) {
        tag('details', [:], body)
    }

    void details(Map attrs, Closure body) {
        tag('details', attrs, body)
    }

    void dialog(Closure body) {
        tag('dialog', [:], body)
    }

    void dialog(Map attrs, Closure body) {
        tag('dialog', attrs, body)
    }

    void menu(Closure body) {
        tag('menu', [:], body)
    }

    void menu(Map attrs, Closure body) {
        tag('menu', attrs, body)
    }

    void menuitem(Closure body) {
        tag('menuitem', [:], body)
    }

    void menuitem(Map attrs, Closure body) {
        tag('menuitem', attrs, body)
    }

    void summary(Closure body) {
        tag('summary', [:], body)
    }

    void summary(Map attrs, Closure body) {
        tag('summary', attrs, body)
    }

    void summary(String escapeContent) {
        html << '<summary>'
        escape << escapeContent
        html << '</summary>'
    }

    void summary(Map attrs, String escapeContent) {
        summary(attrs){
            escape << escapeContent
        }
    }


    // --- Web Components

    void content(Closure body) {
        tag('content', [:], body)
    }

    void content(Map attrs, Closure body) {
        tag('content', attrs, body)
    }

    void element(Closure body) {
        tag('element', [:], body)
    }

    void element(Map attrs, Closure body) {
        tag('element', attrs, body)
    }

    void shadow(Closure body) {
        tag('shadow', [:], body)
    }

    void shadow(Map attrs, Closure body) {
        tag('shadow', attrs, body)
    }

    void template(Closure body) {
        tag('template', [:], body)
    }

    void template(Map attrs, Closure body) {
        tag('template', attrs, body)
    }


    // --- Elements strangely absent from the doc

    void a(Closure body) {
        tag('a', [:], body)
    }

    void a(Map attrs, Closure body) {
        tag('a', attrs, body)
    }

    void a(String escapeContent) {
        html << '<a>'
        escape << escapeContent
        html << '</a>'
    }

    void a(Map attrs, String escapeContent) {
        a(attrs){
            escape << escapeContent
        }
    }

    void br(){
        html << '<br>'
    }

    void img(Map attrs) {
        tag('img', attrs, null)
    }
}
