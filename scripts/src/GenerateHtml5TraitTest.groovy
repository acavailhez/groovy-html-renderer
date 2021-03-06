// Useful generators

void generateNormalTag(String tag) {
    print """@Test
    public void test${tag}WithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ${tag}(class: 'class-of-${tag}') {
                    escape << 'content of ${tag}'
                }
            }
        }).getRawHtml()

        assert html == '<${tag} class="class-of-${tag}">content of ${tag}</${tag}>'
    }

    @Test
    public void test${tag}WithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ${tag}{
                    escape << 'content of ${tag}'
                }
            }
        }).getRawHtml()

        assert html == '<${tag}>content of ${tag}</${tag}>'
    }\n\n"""
}

void generateContentlessTag(String tag) {
    print """ @Test
    public void test${tag}WithoutContent() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ${tag}(class:"class-of-${tag}")
            }
        }).getRawHtml()

        assert html == '<${tag} class="class-of-${tag}">'
    }\n\n"""
}

void generateInlineTag(String tag) {
    generateNormalTag(tag)
    print """@Test
    public void test${tag}Inline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ${tag}("content of ${tag}")
            }
        }).getRawHtml()

        assert html == '<${tag}>content of ${tag}</${tag}>'
    }\n\n"""

    print """@Test
    public void test${tag}InlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ${tag}([:],"content of ${tag}")
            }
        }).getRawHtml()

        assert html == '<${tag}>content of ${tag}</${tag}>'
    }\n\n"""
}

void generateEmptyTag(String tag) {
    print """@Test
    public void test${tag}Empty() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ${tag}()
            }
        }).getRawHtml()

        assert html == '<${tag}>'
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
generateInlineTag('h1')
generateInlineTag('h2')
generateInlineTag('h3')
generateInlineTag('h4')
generateInlineTag('h5')
generateInlineTag('h6')
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
generateInlineTag('li')
generateNormalTag('main')
generateNormalTag('ol')
generateInlineTag('p')
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

generateInlineTag('button')
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

generateInlineTag('a')
generateEmptyTag('br')
generateContentlessTag('img')