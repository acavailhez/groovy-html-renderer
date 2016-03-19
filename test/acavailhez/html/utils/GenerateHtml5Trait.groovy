package acavailhez.html.utils

// Useful generators

void generateNormalTag(String tag) {
    print """void ${tag}(Closure body) {
        tag('${tag}', [:], body)
    }

    void ${tag}(Map attrs, Closure body) {
        tag('${tag}', attrs, body)
    }\n\n"""
}

void generateContentlessTag(String tag) {
    print """void ${tag}(Map attrs) {
        tag('${tag}', attrs, null)
    }\n\n"""
}

void generateInlineTag(String tag) {
    generateNormalTag(tag)
    print """void ${tag}(String escapeContent) {
        html << '<${tag}>'
        escape << escapeContent
        html << '</${tag}>'
    }\n\n"""
}

void generateEmptyTag(String tag) {
    print """void ${tag}(){
        html << '<${tag}>'
    }\n\n"""
}

void section(String section) {
    print "\n    // --- " + section + "\n\n"
}

// Actual content
// from https://developer.mozilla.org/en-US/docs/Web/HTML/Element

section("Basic elements")

generateNormalTag('html')

section("Document metadata")

generateNormalTag('base')
generateNormalTag('head')
generateContentlessTag('link')
generateContentlessTag('meta')
generateNormalTag('style')
generateInlineTag('title')

section("Content sectioning")

generateNormalTag('address')
generateNormalTag('article')
generateNormalTag('footer')
generateNormalTag('header')
generateNormalTag('h1')
generateNormalTag('h2')
generateNormalTag('h3')
generateNormalTag('h4')
generateNormalTag('h5')
generateNormalTag('h6')
generateNormalTag('hgroup')
generateNormalTag('nav')
generateNormalTag('section')

section("Text content")

generateNormalTag('dd')
generateNormalTag('div')
generateNormalTag('dl')
generateNormalTag('dt')
generateNormalTag('figcaption')
generateNormalTag('figure')
generateEmptyTag('hr')
generateNormalTag('li')
generateNormalTag('main')
generateNormalTag('ol')
generateNormalTag('p')
generateNormalTag('pre')
generateNormalTag('ul')

section("Inline text semantics")

generateInlineTag('abbr')
generateInlineTag('b')
generateInlineTag('bdi')
generateInlineTag('bdo')
generateInlineTag('br')
generateInlineTag('cite')
generateInlineTag('code')
generateInlineTag('data')
generateInlineTag('dfn')
generateInlineTag('em')
generateInlineTag('i')
generateInlineTag('kbd')
generateInlineTag('mark')
generateInlineTag('q')
generateInlineTag('rp')
generateInlineTag('rt')
generateInlineTag('rtc')
generateInlineTag('ruby')
generateInlineTag('s')
generateInlineTag('samp')
generateInlineTag('small')
generateInlineTag('span')
generateInlineTag('strong')
generateInlineTag('sub')
generateInlineTag('sup')
generateInlineTag('time')
generateInlineTag('u')
generateInlineTag('var')
generateInlineTag('wbr')

section("Image and multimedia")

generateContentlessTag('area')
generateNormalTag('audio')
generateNormalTag('map')
generateContentlessTag('track')
generateNormalTag('video')

section("Embedded content")

generateContentlessTag('embed')
generateNormalTag('object')
generateContentlessTag('param')
generateNormalTag('picture')

section("Scripting")

generateNormalTag('canvas')
generateNormalTag('noscript')
generateNormalTag('script')

section("Demarcating edits")

generateInlineTag('del')
generateInlineTag('ins')

section("Table content")

generateNormalTag('caption')
generateNormalTag('col')
generateNormalTag('colgroup')
generateNormalTag('table')
generateNormalTag('tbody')
generateNormalTag('td')
generateNormalTag('tfoot')
generateNormalTag('th')
generateNormalTag('thead')
generateNormalTag('tr')

section("Forms")

generateNormalTag('button')
generateNormalTag('datalist')
generateNormalTag('fieldset')
generateNormalTag('form')
generateNormalTag('input')
generateNormalTag('keygen')
generateNormalTag('label')
generateNormalTag('legend')
generateNormalTag('meter')
generateNormalTag('optgroup')
generateNormalTag('output')
generateNormalTag('progress')
generateNormalTag('select')

section("Interactive elements")

generateNormalTag('details')
generateNormalTag('dialog')
generateNormalTag('menu')
generateNormalTag('menuitem')
generateInlineTag('summary')

section("Web Components")

generateNormalTag('content')
generateNormalTag('element')
generateNormalTag('shadow')
generateNormalTag('template')

section("Elements strangely absent from the doc")

generateNormalTag('a')
generateEmptyTag('br')
generateContentlessTag('img')
