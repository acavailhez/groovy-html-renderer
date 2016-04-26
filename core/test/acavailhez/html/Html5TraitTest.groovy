package acavailhez.html

import org.junit.Test

public class Html5TraitTest extends AbstractTest {

    // --- Basic elements

    @Test
    public void testhtmlWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                html(class: 'class-of-html') {
                    escape << 'content of html'
                }
            }
        }).getRawHtml()

        assert html == '<html class="class-of-html">content of html</html>'
    }

    @Test
    public void testhtmlWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                html{
                    escape << 'content of html'
                }
            }
        }).getRawHtml()

        assert html == '<html>content of html</html>'
    }


    // --- Document metadata

    @Test
    public void testbaseWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                base(class: 'class-of-base') {
                    escape << 'content of base'
                }
            }
        }).getRawHtml()

        assert html == '<base class="class-of-base">content of base</base>'
    }

    @Test
    public void testbaseWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                base{
                    escape << 'content of base'
                }
            }
        }).getRawHtml()

        assert html == '<base>content of base</base>'
    }

    @Test
    public void testheadWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                head(class: 'class-of-head') {
                    escape << 'content of head'
                }
            }
        }).getRawHtml()

        assert html == '<head class="class-of-head">content of head</head>'
    }

    @Test
    public void testheadWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                head{
                    escape << 'content of head'
                }
            }
        }).getRawHtml()

        assert html == '<head>content of head</head>'
    }

    @Test
    public void testlinkWithoutContent() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                link(class:"class-of-link")
            }
        }).getRawHtml()

        assert html == '<link class="class-of-link">'
    }

    @Test
    public void testmetaWithoutContent() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                meta(class:"class-of-meta")
            }
        }).getRawHtml()

        assert html == '<meta class="class-of-meta">'
    }

    @Test
    public void teststyleWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                style(class: 'class-of-style') {
                    escape << 'content of style'
                }
            }
        }).getRawHtml()

        assert html == '<style class="class-of-style">content of style</style>'
    }

    @Test
    public void teststyleWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                style{
                    escape << 'content of style'
                }
            }
        }).getRawHtml()

        assert html == '<style>content of style</style>'
    }

    @Test
    public void testtitleWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                title(class: 'class-of-title') {
                    escape << 'content of title'
                }
            }
        }).getRawHtml()

        assert html == '<title class="class-of-title">content of title</title>'
    }

    @Test
    public void testtitleWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                title{
                    escape << 'content of title'
                }
            }
        }).getRawHtml()

        assert html == '<title>content of title</title>'
    }

    @Test
    public void testtitleInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                title("content of title")
            }
        }).getRawHtml()

        assert html == '<title>content of title</title>'
    }

    @Test
    public void testtitleInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                title([:],"content of title")
            }
        }).getRawHtml()

        assert html == '<title>content of title</title>'
    }


    // --- Content sectioning

    @Test
    public void testaddressWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                address(class: 'class-of-address') {
                    escape << 'content of address'
                }
            }
        }).getRawHtml()

        assert html == '<address class="class-of-address">content of address</address>'
    }

    @Test
    public void testaddressWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                address{
                    escape << 'content of address'
                }
            }
        }).getRawHtml()

        assert html == '<address>content of address</address>'
    }

    @Test
    public void testarticleWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                article(class: 'class-of-article') {
                    escape << 'content of article'
                }
            }
        }).getRawHtml()

        assert html == '<article class="class-of-article">content of article</article>'
    }

    @Test
    public void testarticleWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                article{
                    escape << 'content of article'
                }
            }
        }).getRawHtml()

        assert html == '<article>content of article</article>'
    }

    @Test
    public void testfooterWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                footer(class: 'class-of-footer') {
                    escape << 'content of footer'
                }
            }
        }).getRawHtml()

        assert html == '<footer class="class-of-footer">content of footer</footer>'
    }

    @Test
    public void testfooterWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                footer{
                    escape << 'content of footer'
                }
            }
        }).getRawHtml()

        assert html == '<footer>content of footer</footer>'
    }

    @Test
    public void testheaderWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                header(class: 'class-of-header') {
                    escape << 'content of header'
                }
            }
        }).getRawHtml()

        assert html == '<header class="class-of-header">content of header</header>'
    }

    @Test
    public void testheaderWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                header{
                    escape << 'content of header'
                }
            }
        }).getRawHtml()

        assert html == '<header>content of header</header>'
    }

    @Test
    public void testh1WithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h1(class: 'class-of-h1') {
                    escape << 'content of h1'
                }
            }
        }).getRawHtml()

        assert html == '<h1 class="class-of-h1">content of h1</h1>'
    }

    @Test
    public void testh1WithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h1{
                    escape << 'content of h1'
                }
            }
        }).getRawHtml()

        assert html == '<h1>content of h1</h1>'
    }

    @Test
    public void testh1Inline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h1("content of h1")
            }
        }).getRawHtml()

        assert html == '<h1>content of h1</h1>'
    }

    @Test
    public void testh1InlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h1([:],"content of h1")
            }
        }).getRawHtml()

        assert html == '<h1>content of h1</h1>'
    }

    @Test
    public void testh2WithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h2(class: 'class-of-h2') {
                    escape << 'content of h2'
                }
            }
        }).getRawHtml()

        assert html == '<h2 class="class-of-h2">content of h2</h2>'
    }

    @Test
    public void testh2WithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h2{
                    escape << 'content of h2'
                }
            }
        }).getRawHtml()

        assert html == '<h2>content of h2</h2>'
    }

    @Test
    public void testh2Inline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h2("content of h2")
            }
        }).getRawHtml()

        assert html == '<h2>content of h2</h2>'
    }

    @Test
    public void testh2InlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h2([:],"content of h2")
            }
        }).getRawHtml()

        assert html == '<h2>content of h2</h2>'
    }

    @Test
    public void testh3WithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h3(class: 'class-of-h3') {
                    escape << 'content of h3'
                }
            }
        }).getRawHtml()

        assert html == '<h3 class="class-of-h3">content of h3</h3>'
    }

    @Test
    public void testh3WithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h3{
                    escape << 'content of h3'
                }
            }
        }).getRawHtml()

        assert html == '<h3>content of h3</h3>'
    }

    @Test
    public void testh3Inline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h3("content of h3")
            }
        }).getRawHtml()

        assert html == '<h3>content of h3</h3>'
    }

    @Test
    public void testh3InlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h3([:],"content of h3")
            }
        }).getRawHtml()

        assert html == '<h3>content of h3</h3>'
    }

    @Test
    public void testh4WithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h4(class: 'class-of-h4') {
                    escape << 'content of h4'
                }
            }
        }).getRawHtml()

        assert html == '<h4 class="class-of-h4">content of h4</h4>'
    }

    @Test
    public void testh4WithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h4{
                    escape << 'content of h4'
                }
            }
        }).getRawHtml()

        assert html == '<h4>content of h4</h4>'
    }

    @Test
    public void testh4Inline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h4("content of h4")
            }
        }).getRawHtml()

        assert html == '<h4>content of h4</h4>'
    }

    @Test
    public void testh4InlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h4([:],"content of h4")
            }
        }).getRawHtml()

        assert html == '<h4>content of h4</h4>'
    }

    @Test
    public void testh5WithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h5(class: 'class-of-h5') {
                    escape << 'content of h5'
                }
            }
        }).getRawHtml()

        assert html == '<h5 class="class-of-h5">content of h5</h5>'
    }

    @Test
    public void testh5WithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h5{
                    escape << 'content of h5'
                }
            }
        }).getRawHtml()

        assert html == '<h5>content of h5</h5>'
    }

    @Test
    public void testh5Inline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h5("content of h5")
            }
        }).getRawHtml()

        assert html == '<h5>content of h5</h5>'
    }

    @Test
    public void testh5InlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h5([:],"content of h5")
            }
        }).getRawHtml()

        assert html == '<h5>content of h5</h5>'
    }

    @Test
    public void testh6WithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h6(class: 'class-of-h6') {
                    escape << 'content of h6'
                }
            }
        }).getRawHtml()

        assert html == '<h6 class="class-of-h6">content of h6</h6>'
    }

    @Test
    public void testh6WithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h6{
                    escape << 'content of h6'
                }
            }
        }).getRawHtml()

        assert html == '<h6>content of h6</h6>'
    }

    @Test
    public void testh6Inline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h6("content of h6")
            }
        }).getRawHtml()

        assert html == '<h6>content of h6</h6>'
    }

    @Test
    public void testh6InlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                h6([:],"content of h6")
            }
        }).getRawHtml()

        assert html == '<h6>content of h6</h6>'
    }

    @Test
    public void testhgroupWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                hgroup(class: 'class-of-hgroup') {
                    escape << 'content of hgroup'
                }
            }
        }).getRawHtml()

        assert html == '<hgroup class="class-of-hgroup">content of hgroup</hgroup>'
    }

    @Test
    public void testhgroupWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                hgroup{
                    escape << 'content of hgroup'
                }
            }
        }).getRawHtml()

        assert html == '<hgroup>content of hgroup</hgroup>'
    }

    @Test
    public void testnavWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                nav(class: 'class-of-nav') {
                    escape << 'content of nav'
                }
            }
        }).getRawHtml()

        assert html == '<nav class="class-of-nav">content of nav</nav>'
    }

    @Test
    public void testnavWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                nav{
                    escape << 'content of nav'
                }
            }
        }).getRawHtml()

        assert html == '<nav>content of nav</nav>'
    }

    @Test
    public void testsectionWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                section(class: 'class-of-section') {
                    escape << 'content of section'
                }
            }
        }).getRawHtml()

        assert html == '<section class="class-of-section">content of section</section>'
    }

    @Test
    public void testsectionWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                section{
                    escape << 'content of section'
                }
            }
        }).getRawHtml()

        assert html == '<section>content of section</section>'
    }


    // --- Text content

    @Test
    public void testddWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                dd(class: 'class-of-dd') {
                    escape << 'content of dd'
                }
            }
        }).getRawHtml()

        assert html == '<dd class="class-of-dd">content of dd</dd>'
    }

    @Test
    public void testddWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                dd{
                    escape << 'content of dd'
                }
            }
        }).getRawHtml()

        assert html == '<dd>content of dd</dd>'
    }

    @Test
    public void testdivWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div(class: 'class-of-div') {
                    escape << 'content of div'
                }
            }
        }).getRawHtml()

        assert html == '<div class="class-of-div">content of div</div>'
    }

    @Test
    public void testdivWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div{
                    escape << 'content of div'
                }
            }
        }).getRawHtml()

        assert html == '<div>content of div</div>'
    }

    @Test
    public void testdlWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                dl(class: 'class-of-dl') {
                    escape << 'content of dl'
                }
            }
        }).getRawHtml()

        assert html == '<dl class="class-of-dl">content of dl</dl>'
    }

    @Test
    public void testdlWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                dl{
                    escape << 'content of dl'
                }
            }
        }).getRawHtml()

        assert html == '<dl>content of dl</dl>'
    }

    @Test
    public void testdtWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                dt(class: 'class-of-dt') {
                    escape << 'content of dt'
                }
            }
        }).getRawHtml()

        assert html == '<dt class="class-of-dt">content of dt</dt>'
    }

    @Test
    public void testdtWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                dt{
                    escape << 'content of dt'
                }
            }
        }).getRawHtml()

        assert html == '<dt>content of dt</dt>'
    }

    @Test
    public void testfigcaptionWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                figcaption(class: 'class-of-figcaption') {
                    escape << 'content of figcaption'
                }
            }
        }).getRawHtml()

        assert html == '<figcaption class="class-of-figcaption">content of figcaption</figcaption>'
    }

    @Test
    public void testfigcaptionWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                figcaption{
                    escape << 'content of figcaption'
                }
            }
        }).getRawHtml()

        assert html == '<figcaption>content of figcaption</figcaption>'
    }

    @Test
    public void testfigureWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                figure(class: 'class-of-figure') {
                    escape << 'content of figure'
                }
            }
        }).getRawHtml()

        assert html == '<figure class="class-of-figure">content of figure</figure>'
    }

    @Test
    public void testfigureWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                figure{
                    escape << 'content of figure'
                }
            }
        }).getRawHtml()

        assert html == '<figure>content of figure</figure>'
    }

    @Test
    public void testhrEmpty() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                hr()
            }
        }).getRawHtml()

        assert html == '<hr>'
    }

    @Test
    public void testliWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                li(class: 'class-of-li') {
                    escape << 'content of li'
                }
            }
        }).getRawHtml()

        assert html == '<li class="class-of-li">content of li</li>'
    }

    @Test
    public void testliWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                li{
                    escape << 'content of li'
                }
            }
        }).getRawHtml()

        assert html == '<li>content of li</li>'
    }

    @Test
    public void testliInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                li("content of li")
            }
        }).getRawHtml()

        assert html == '<li>content of li</li>'
    }

    @Test
    public void testliInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                li([:],"content of li")
            }
        }).getRawHtml()

        assert html == '<li>content of li</li>'
    }

    @Test
    public void testmainWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                main(class: 'class-of-main') {
                    escape << 'content of main'
                }
            }
        }).getRawHtml()

        assert html == '<main class="class-of-main">content of main</main>'
    }

    @Test
    public void testmainWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                main{
                    escape << 'content of main'
                }
            }
        }).getRawHtml()

        assert html == '<main>content of main</main>'
    }

    @Test
    public void testolWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ol(class: 'class-of-ol') {
                    escape << 'content of ol'
                }
            }
        }).getRawHtml()

        assert html == '<ol class="class-of-ol">content of ol</ol>'
    }

    @Test
    public void testolWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ol{
                    escape << 'content of ol'
                }
            }
        }).getRawHtml()

        assert html == '<ol>content of ol</ol>'
    }

    @Test
    public void testpWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                p(class: 'class-of-p') {
                    escape << 'content of p'
                }
            }
        }).getRawHtml()

        assert html == '<p class="class-of-p">content of p</p>'
    }

    @Test
    public void testpWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                p{
                    escape << 'content of p'
                }
            }
        }).getRawHtml()

        assert html == '<p>content of p</p>'
    }

    @Test
    public void testpInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                p("content of p")
            }
        }).getRawHtml()

        assert html == '<p>content of p</p>'
    }

    @Test
    public void testpInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                p([:],"content of p")
            }
        }).getRawHtml()

        assert html == '<p>content of p</p>'
    }

    @Test
    public void testpreWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                pre(class: 'class-of-pre') {
                    escape << 'content of pre'
                }
            }
        }).getRawHtml()

        assert html == '<pre class="class-of-pre">content of pre</pre>'
    }

    @Test
    public void testpreWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                pre{
                    escape << 'content of pre'
                }
            }
        }).getRawHtml()

        assert html == '<pre>content of pre</pre>'
    }

    @Test
    public void testulWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ul(class: 'class-of-ul') {
                    escape << 'content of ul'
                }
            }
        }).getRawHtml()

        assert html == '<ul class="class-of-ul">content of ul</ul>'
    }

    @Test
    public void testulWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ul{
                    escape << 'content of ul'
                }
            }
        }).getRawHtml()

        assert html == '<ul>content of ul</ul>'
    }


    // --- Inline text semantics

    @Test
    public void testabbrWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                abbr(class: 'class-of-abbr') {
                    escape << 'content of abbr'
                }
            }
        }).getRawHtml()

        assert html == '<abbr class="class-of-abbr">content of abbr</abbr>'
    }

    @Test
    public void testabbrWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                abbr{
                    escape << 'content of abbr'
                }
            }
        }).getRawHtml()

        assert html == '<abbr>content of abbr</abbr>'
    }

    @Test
    public void testabbrInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                abbr("content of abbr")
            }
        }).getRawHtml()

        assert html == '<abbr>content of abbr</abbr>'
    }

    @Test
    public void testabbrInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                abbr([:],"content of abbr")
            }
        }).getRawHtml()

        assert html == '<abbr>content of abbr</abbr>'
    }

    @Test
    public void testbWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                b(class: 'class-of-b') {
                    escape << 'content of b'
                }
            }
        }).getRawHtml()

        assert html == '<b class="class-of-b">content of b</b>'
    }

    @Test
    public void testbWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                b{
                    escape << 'content of b'
                }
            }
        }).getRawHtml()

        assert html == '<b>content of b</b>'
    }

    @Test
    public void testbInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                b("content of b")
            }
        }).getRawHtml()

        assert html == '<b>content of b</b>'
    }

    @Test
    public void testbInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                b([:],"content of b")
            }
        }).getRawHtml()

        assert html == '<b>content of b</b>'
    }

    @Test
    public void testbdiWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                bdi(class: 'class-of-bdi') {
                    escape << 'content of bdi'
                }
            }
        }).getRawHtml()

        assert html == '<bdi class="class-of-bdi">content of bdi</bdi>'
    }

    @Test
    public void testbdiWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                bdi{
                    escape << 'content of bdi'
                }
            }
        }).getRawHtml()

        assert html == '<bdi>content of bdi</bdi>'
    }

    @Test
    public void testbdiInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                bdi("content of bdi")
            }
        }).getRawHtml()

        assert html == '<bdi>content of bdi</bdi>'
    }

    @Test
    public void testbdiInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                bdi([:],"content of bdi")
            }
        }).getRawHtml()

        assert html == '<bdi>content of bdi</bdi>'
    }

    @Test
    public void testbdoWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                bdo(class: 'class-of-bdo') {
                    escape << 'content of bdo'
                }
            }
        }).getRawHtml()

        assert html == '<bdo class="class-of-bdo">content of bdo</bdo>'
    }

    @Test
    public void testbdoWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                bdo{
                    escape << 'content of bdo'
                }
            }
        }).getRawHtml()

        assert html == '<bdo>content of bdo</bdo>'
    }

    @Test
    public void testbdoInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                bdo("content of bdo")
            }
        }).getRawHtml()

        assert html == '<bdo>content of bdo</bdo>'
    }

    @Test
    public void testbdoInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                bdo([:],"content of bdo")
            }
        }).getRawHtml()

        assert html == '<bdo>content of bdo</bdo>'
    }

    @Test
    public void testbrWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                br(class: 'class-of-br') {
                    escape << 'content of br'
                }
            }
        }).getRawHtml()

        assert html == '<br class="class-of-br">content of br</br>'
    }

    @Test
    public void testbrWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                br{
                    escape << 'content of br'
                }
            }
        }).getRawHtml()

        assert html == '<br>content of br</br>'
    }

    @Test
    public void testbrInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                br("content of br")
            }
        }).getRawHtml()

        assert html == '<br>content of br</br>'
    }

    @Test
    public void testbrInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                br([:],"content of br")
            }
        }).getRawHtml()

        assert html == '<br>content of br</br>'
    }

    @Test
    public void testciteWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                cite(class: 'class-of-cite') {
                    escape << 'content of cite'
                }
            }
        }).getRawHtml()

        assert html == '<cite class="class-of-cite">content of cite</cite>'
    }

    @Test
    public void testciteWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                cite{
                    escape << 'content of cite'
                }
            }
        }).getRawHtml()

        assert html == '<cite>content of cite</cite>'
    }

    @Test
    public void testciteInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                cite("content of cite")
            }
        }).getRawHtml()

        assert html == '<cite>content of cite</cite>'
    }

    @Test
    public void testciteInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                cite([:],"content of cite")
            }
        }).getRawHtml()

        assert html == '<cite>content of cite</cite>'
    }

    @Test
    public void testcodeWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                code(class: 'class-of-code') {
                    escape << 'content of code'
                }
            }
        }).getRawHtml()

        assert html == '<code class="class-of-code">content of code</code>'
    }

    @Test
    public void testcodeWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                code{
                    escape << 'content of code'
                }
            }
        }).getRawHtml()

        assert html == '<code>content of code</code>'
    }

    @Test
    public void testcodeInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                code("content of code")
            }
        }).getRawHtml()

        assert html == '<code>content of code</code>'
    }

    @Test
    public void testcodeInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                code([:],"content of code")
            }
        }).getRawHtml()

        assert html == '<code>content of code</code>'
    }

    @Test
    public void testdataWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                data(class: 'class-of-data') {
                    escape << 'content of data'
                }
            }
        }).getRawHtml()

        assert html == '<data class="class-of-data">content of data</data>'
    }

    @Test
    public void testdataWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                data{
                    escape << 'content of data'
                }
            }
        }).getRawHtml()

        assert html == '<data>content of data</data>'
    }

    @Test
    public void testdataInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                data("content of data")
            }
        }).getRawHtml()

        assert html == '<data>content of data</data>'
    }

    @Test
    public void testdataInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                data([:],"content of data")
            }
        }).getRawHtml()

        assert html == '<data>content of data</data>'
    }

    @Test
    public void testdfnWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                dfn(class: 'class-of-dfn') {
                    escape << 'content of dfn'
                }
            }
        }).getRawHtml()

        assert html == '<dfn class="class-of-dfn">content of dfn</dfn>'
    }

    @Test
    public void testdfnWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                dfn{
                    escape << 'content of dfn'
                }
            }
        }).getRawHtml()

        assert html == '<dfn>content of dfn</dfn>'
    }

    @Test
    public void testdfnInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                dfn("content of dfn")
            }
        }).getRawHtml()

        assert html == '<dfn>content of dfn</dfn>'
    }

    @Test
    public void testdfnInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                dfn([:],"content of dfn")
            }
        }).getRawHtml()

        assert html == '<dfn>content of dfn</dfn>'
    }

    @Test
    public void testemWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                em(class: 'class-of-em') {
                    escape << 'content of em'
                }
            }
        }).getRawHtml()

        assert html == '<em class="class-of-em">content of em</em>'
    }

    @Test
    public void testemWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                em{
                    escape << 'content of em'
                }
            }
        }).getRawHtml()

        assert html == '<em>content of em</em>'
    }

    @Test
    public void testemInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                em("content of em")
            }
        }).getRawHtml()

        assert html == '<em>content of em</em>'
    }

    @Test
    public void testemInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                em([:],"content of em")
            }
        }).getRawHtml()

        assert html == '<em>content of em</em>'
    }

    @Test
    public void testiWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                i(class: 'class-of-i') {
                    escape << 'content of i'
                }
            }
        }).getRawHtml()

        assert html == '<i class="class-of-i">content of i</i>'
    }

    @Test
    public void testiWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                i{
                    escape << 'content of i'
                }
            }
        }).getRawHtml()

        assert html == '<i>content of i</i>'
    }

    @Test
    public void testiInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                i("content of i")
            }
        }).getRawHtml()

        assert html == '<i>content of i</i>'
    }

    @Test
    public void testiInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                i([:],"content of i")
            }
        }).getRawHtml()

        assert html == '<i>content of i</i>'
    }

    @Test
    public void testkbdWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                kbd(class: 'class-of-kbd') {
                    escape << 'content of kbd'
                }
            }
        }).getRawHtml()

        assert html == '<kbd class="class-of-kbd">content of kbd</kbd>'
    }

    @Test
    public void testkbdWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                kbd{
                    escape << 'content of kbd'
                }
            }
        }).getRawHtml()

        assert html == '<kbd>content of kbd</kbd>'
    }

    @Test
    public void testkbdInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                kbd("content of kbd")
            }
        }).getRawHtml()

        assert html == '<kbd>content of kbd</kbd>'
    }

    @Test
    public void testkbdInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                kbd([:],"content of kbd")
            }
        }).getRawHtml()

        assert html == '<kbd>content of kbd</kbd>'
    }

    @Test
    public void testmarkWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                mark(class: 'class-of-mark') {
                    escape << 'content of mark'
                }
            }
        }).getRawHtml()

        assert html == '<mark class="class-of-mark">content of mark</mark>'
    }

    @Test
    public void testmarkWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                mark{
                    escape << 'content of mark'
                }
            }
        }).getRawHtml()

        assert html == '<mark>content of mark</mark>'
    }

    @Test
    public void testmarkInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                mark("content of mark")
            }
        }).getRawHtml()

        assert html == '<mark>content of mark</mark>'
    }

    @Test
    public void testmarkInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                mark([:],"content of mark")
            }
        }).getRawHtml()

        assert html == '<mark>content of mark</mark>'
    }

    @Test
    public void testqWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                q(class: 'class-of-q') {
                    escape << 'content of q'
                }
            }
        }).getRawHtml()

        assert html == '<q class="class-of-q">content of q</q>'
    }

    @Test
    public void testqWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                q{
                    escape << 'content of q'
                }
            }
        }).getRawHtml()

        assert html == '<q>content of q</q>'
    }

    @Test
    public void testqInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                q("content of q")
            }
        }).getRawHtml()

        assert html == '<q>content of q</q>'
    }

    @Test
    public void testqInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                q([:],"content of q")
            }
        }).getRawHtml()

        assert html == '<q>content of q</q>'
    }

    @Test
    public void testrpWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                rp(class: 'class-of-rp') {
                    escape << 'content of rp'
                }
            }
        }).getRawHtml()

        assert html == '<rp class="class-of-rp">content of rp</rp>'
    }

    @Test
    public void testrpWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                rp{
                    escape << 'content of rp'
                }
            }
        }).getRawHtml()

        assert html == '<rp>content of rp</rp>'
    }

    @Test
    public void testrpInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                rp("content of rp")
            }
        }).getRawHtml()

        assert html == '<rp>content of rp</rp>'
    }

    @Test
    public void testrpInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                rp([:],"content of rp")
            }
        }).getRawHtml()

        assert html == '<rp>content of rp</rp>'
    }

    @Test
    public void testrtWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                rt(class: 'class-of-rt') {
                    escape << 'content of rt'
                }
            }
        }).getRawHtml()

        assert html == '<rt class="class-of-rt">content of rt</rt>'
    }

    @Test
    public void testrtWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                rt{
                    escape << 'content of rt'
                }
            }
        }).getRawHtml()

        assert html == '<rt>content of rt</rt>'
    }

    @Test
    public void testrtInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                rt("content of rt")
            }
        }).getRawHtml()

        assert html == '<rt>content of rt</rt>'
    }

    @Test
    public void testrtInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                rt([:],"content of rt")
            }
        }).getRawHtml()

        assert html == '<rt>content of rt</rt>'
    }

    @Test
    public void testrtcWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                rtc(class: 'class-of-rtc') {
                    escape << 'content of rtc'
                }
            }
        }).getRawHtml()

        assert html == '<rtc class="class-of-rtc">content of rtc</rtc>'
    }

    @Test
    public void testrtcWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                rtc{
                    escape << 'content of rtc'
                }
            }
        }).getRawHtml()

        assert html == '<rtc>content of rtc</rtc>'
    }

    @Test
    public void testrtcInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                rtc("content of rtc")
            }
        }).getRawHtml()

        assert html == '<rtc>content of rtc</rtc>'
    }

    @Test
    public void testrtcInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                rtc([:],"content of rtc")
            }
        }).getRawHtml()

        assert html == '<rtc>content of rtc</rtc>'
    }

    @Test
    public void testrubyWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ruby(class: 'class-of-ruby') {
                    escape << 'content of ruby'
                }
            }
        }).getRawHtml()

        assert html == '<ruby class="class-of-ruby">content of ruby</ruby>'
    }

    @Test
    public void testrubyWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ruby{
                    escape << 'content of ruby'
                }
            }
        }).getRawHtml()

        assert html == '<ruby>content of ruby</ruby>'
    }

    @Test
    public void testrubyInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ruby("content of ruby")
            }
        }).getRawHtml()

        assert html == '<ruby>content of ruby</ruby>'
    }

    @Test
    public void testrubyInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ruby([:],"content of ruby")
            }
        }).getRawHtml()

        assert html == '<ruby>content of ruby</ruby>'
    }

    @Test
    public void testsWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                s(class: 'class-of-s') {
                    escape << 'content of s'
                }
            }
        }).getRawHtml()

        assert html == '<s class="class-of-s">content of s</s>'
    }

    @Test
    public void testsWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                s{
                    escape << 'content of s'
                }
            }
        }).getRawHtml()

        assert html == '<s>content of s</s>'
    }

    @Test
    public void testsInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                s("content of s")
            }
        }).getRawHtml()

        assert html == '<s>content of s</s>'
    }

    @Test
    public void testsInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                s([:],"content of s")
            }
        }).getRawHtml()

        assert html == '<s>content of s</s>'
    }

    @Test
    public void testsampWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                samp(class: 'class-of-samp') {
                    escape << 'content of samp'
                }
            }
        }).getRawHtml()

        assert html == '<samp class="class-of-samp">content of samp</samp>'
    }

    @Test
    public void testsampWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                samp{
                    escape << 'content of samp'
                }
            }
        }).getRawHtml()

        assert html == '<samp>content of samp</samp>'
    }

    @Test
    public void testsampInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                samp("content of samp")
            }
        }).getRawHtml()

        assert html == '<samp>content of samp</samp>'
    }

    @Test
    public void testsampInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                samp([:],"content of samp")
            }
        }).getRawHtml()

        assert html == '<samp>content of samp</samp>'
    }

    @Test
    public void testsmallWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                small(class: 'class-of-small') {
                    escape << 'content of small'
                }
            }
        }).getRawHtml()

        assert html == '<small class="class-of-small">content of small</small>'
    }

    @Test
    public void testsmallWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                small{
                    escape << 'content of small'
                }
            }
        }).getRawHtml()

        assert html == '<small>content of small</small>'
    }

    @Test
    public void testsmallInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                small("content of small")
            }
        }).getRawHtml()

        assert html == '<small>content of small</small>'
    }

    @Test
    public void testsmallInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                small([:],"content of small")
            }
        }).getRawHtml()

        assert html == '<small>content of small</small>'
    }

    @Test
    public void testspanWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                span(class: 'class-of-span') {
                    escape << 'content of span'
                }
            }
        }).getRawHtml()

        assert html == '<span class="class-of-span">content of span</span>'
    }

    @Test
    public void testspanWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                span{
                    escape << 'content of span'
                }
            }
        }).getRawHtml()

        assert html == '<span>content of span</span>'
    }

    @Test
    public void testspanInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                span("content of span")
            }
        }).getRawHtml()

        assert html == '<span>content of span</span>'
    }

    @Test
    public void testspanInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                span([:],"content of span")
            }
        }).getRawHtml()

        assert html == '<span>content of span</span>'
    }

    @Test
    public void teststrongWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                strong(class: 'class-of-strong') {
                    escape << 'content of strong'
                }
            }
        }).getRawHtml()

        assert html == '<strong class="class-of-strong">content of strong</strong>'
    }

    @Test
    public void teststrongWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                strong{
                    escape << 'content of strong'
                }
            }
        }).getRawHtml()

        assert html == '<strong>content of strong</strong>'
    }

    @Test
    public void teststrongInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                strong("content of strong")
            }
        }).getRawHtml()

        assert html == '<strong>content of strong</strong>'
    }

    @Test
    public void teststrongInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                strong([:],"content of strong")
            }
        }).getRawHtml()

        assert html == '<strong>content of strong</strong>'
    }

    @Test
    public void testsubWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                sub(class: 'class-of-sub') {
                    escape << 'content of sub'
                }
            }
        }).getRawHtml()

        assert html == '<sub class="class-of-sub">content of sub</sub>'
    }

    @Test
    public void testsubWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                sub{
                    escape << 'content of sub'
                }
            }
        }).getRawHtml()

        assert html == '<sub>content of sub</sub>'
    }

    @Test
    public void testsubInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                sub("content of sub")
            }
        }).getRawHtml()

        assert html == '<sub>content of sub</sub>'
    }

    @Test
    public void testsubInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                sub([:],"content of sub")
            }
        }).getRawHtml()

        assert html == '<sub>content of sub</sub>'
    }

    @Test
    public void testsupWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                sup(class: 'class-of-sup') {
                    escape << 'content of sup'
                }
            }
        }).getRawHtml()

        assert html == '<sup class="class-of-sup">content of sup</sup>'
    }

    @Test
    public void testsupWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                sup{
                    escape << 'content of sup'
                }
            }
        }).getRawHtml()

        assert html == '<sup>content of sup</sup>'
    }

    @Test
    public void testsupInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                sup("content of sup")
            }
        }).getRawHtml()

        assert html == '<sup>content of sup</sup>'
    }

    @Test
    public void testsupInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                sup([:],"content of sup")
            }
        }).getRawHtml()

        assert html == '<sup>content of sup</sup>'
    }

    @Test
    public void testtimeWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                time(class: 'class-of-time') {
                    escape << 'content of time'
                }
            }
        }).getRawHtml()

        assert html == '<time class="class-of-time">content of time</time>'
    }

    @Test
    public void testtimeWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                time{
                    escape << 'content of time'
                }
            }
        }).getRawHtml()

        assert html == '<time>content of time</time>'
    }

    @Test
    public void testtimeInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                time("content of time")
            }
        }).getRawHtml()

        assert html == '<time>content of time</time>'
    }

    @Test
    public void testtimeInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                time([:],"content of time")
            }
        }).getRawHtml()

        assert html == '<time>content of time</time>'
    }

    @Test
    public void testuWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                u(class: 'class-of-u') {
                    escape << 'content of u'
                }
            }
        }).getRawHtml()

        assert html == '<u class="class-of-u">content of u</u>'
    }

    @Test
    public void testuWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                u{
                    escape << 'content of u'
                }
            }
        }).getRawHtml()

        assert html == '<u>content of u</u>'
    }

    @Test
    public void testuInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                u("content of u")
            }
        }).getRawHtml()

        assert html == '<u>content of u</u>'
    }

    @Test
    public void testuInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                u([:],"content of u")
            }
        }).getRawHtml()

        assert html == '<u>content of u</u>'
    }

    @Test
    public void testvarWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                var(class: 'class-of-var') {
                    escape << 'content of var'
                }
            }
        }).getRawHtml()

        assert html == '<var class="class-of-var">content of var</var>'
    }

    @Test
    public void testvarWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                var{
                    escape << 'content of var'
                }
            }
        }).getRawHtml()

        assert html == '<var>content of var</var>'
    }

    @Test
    public void testvarInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                var("content of var")
            }
        }).getRawHtml()

        assert html == '<var>content of var</var>'
    }

    @Test
    public void testvarInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                var([:],"content of var")
            }
        }).getRawHtml()

        assert html == '<var>content of var</var>'
    }

    @Test
    public void testwbrWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                wbr(class: 'class-of-wbr') {
                    escape << 'content of wbr'
                }
            }
        }).getRawHtml()

        assert html == '<wbr class="class-of-wbr">content of wbr</wbr>'
    }

    @Test
    public void testwbrWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                wbr{
                    escape << 'content of wbr'
                }
            }
        }).getRawHtml()

        assert html == '<wbr>content of wbr</wbr>'
    }

    @Test
    public void testwbrInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                wbr("content of wbr")
            }
        }).getRawHtml()

        assert html == '<wbr>content of wbr</wbr>'
    }

    @Test
    public void testwbrInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                wbr([:],"content of wbr")
            }
        }).getRawHtml()

        assert html == '<wbr>content of wbr</wbr>'
    }


    // --- Image and multimedia

    @Test
    public void testareaWithoutContent() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                area(class:"class-of-area")
            }
        }).getRawHtml()

        assert html == '<area class="class-of-area">'
    }

    @Test
    public void testaudioWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                audio(class: 'class-of-audio') {
                    escape << 'content of audio'
                }
            }
        }).getRawHtml()

        assert html == '<audio class="class-of-audio">content of audio</audio>'
    }

    @Test
    public void testaudioWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                audio{
                    escape << 'content of audio'
                }
            }
        }).getRawHtml()

        assert html == '<audio>content of audio</audio>'
    }

    @Test
    public void testmapWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                map(class: 'class-of-map') {
                    escape << 'content of map'
                }
            }
        }).getRawHtml()

        assert html == '<map class="class-of-map">content of map</map>'
    }

    @Test
    public void testmapWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                map{
                    escape << 'content of map'
                }
            }
        }).getRawHtml()

        assert html == '<map>content of map</map>'
    }

    @Test
    public void testtrackWithoutContent() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                track(class:"class-of-track")
            }
        }).getRawHtml()

        assert html == '<track class="class-of-track">'
    }

    @Test
    public void testvideoWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                video(class: 'class-of-video') {
                    escape << 'content of video'
                }
            }
        }).getRawHtml()

        assert html == '<video class="class-of-video">content of video</video>'
    }

    @Test
    public void testvideoWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                video{
                    escape << 'content of video'
                }
            }
        }).getRawHtml()

        assert html == '<video>content of video</video>'
    }


    // --- Embedded content

    @Test
    public void testembedWithoutContent() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                embed(class:"class-of-embed")
            }
        }).getRawHtml()

        assert html == '<embed class="class-of-embed">'
    }

    @Test
    public void testobjectWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                object(class: 'class-of-object') {
                    escape << 'content of object'
                }
            }
        }).getRawHtml()

        assert html == '<object class="class-of-object">content of object</object>'
    }

    @Test
    public void testobjectWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                object{
                    escape << 'content of object'
                }
            }
        }).getRawHtml()

        assert html == '<object>content of object</object>'
    }

    @Test
    public void testparamWithoutContent() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                param(class:"class-of-param")
            }
        }).getRawHtml()

        assert html == '<param class="class-of-param">'
    }

    @Test
    public void testpictureWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                picture(class: 'class-of-picture') {
                    escape << 'content of picture'
                }
            }
        }).getRawHtml()

        assert html == '<picture class="class-of-picture">content of picture</picture>'
    }

    @Test
    public void testpictureWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                picture{
                    escape << 'content of picture'
                }
            }
        }).getRawHtml()

        assert html == '<picture>content of picture</picture>'
    }


    // --- Scripting

    @Test
    public void testcanvasWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                canvas(class: 'class-of-canvas') {
                    escape << 'content of canvas'
                }
            }
        }).getRawHtml()

        assert html == '<canvas class="class-of-canvas">content of canvas</canvas>'
    }

    @Test
    public void testcanvasWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                canvas{
                    escape << 'content of canvas'
                }
            }
        }).getRawHtml()

        assert html == '<canvas>content of canvas</canvas>'
    }

    @Test
    public void testnoscriptWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                noscript(class: 'class-of-noscript') {
                    escape << 'content of noscript'
                }
            }
        }).getRawHtml()

        assert html == '<noscript class="class-of-noscript">content of noscript</noscript>'
    }

    @Test
    public void testnoscriptWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                noscript{
                    escape << 'content of noscript'
                }
            }
        }).getRawHtml()

        assert html == '<noscript>content of noscript</noscript>'
    }

    @Test
    public void testscriptWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                script(class: 'class-of-script') {
                    escape << 'content of script'
                }
            }
        }).getRawHtml()

        assert html == '<script class="class-of-script">content of script</script>'
    }

    @Test
    public void testscriptWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                script{
                    escape << 'content of script'
                }
            }
        }).getRawHtml()

        assert html == '<script>content of script</script>'
    }


    // --- Demarcating edits

    @Test
    public void testdelWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                del(class: 'class-of-del') {
                    escape << 'content of del'
                }
            }
        }).getRawHtml()

        assert html == '<del class="class-of-del">content of del</del>'
    }

    @Test
    public void testdelWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                del{
                    escape << 'content of del'
                }
            }
        }).getRawHtml()

        assert html == '<del>content of del</del>'
    }

    @Test
    public void testdelInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                del("content of del")
            }
        }).getRawHtml()

        assert html == '<del>content of del</del>'
    }

    @Test
    public void testdelInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                del([:],"content of del")
            }
        }).getRawHtml()

        assert html == '<del>content of del</del>'
    }

    @Test
    public void testinsWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ins(class: 'class-of-ins') {
                    escape << 'content of ins'
                }
            }
        }).getRawHtml()

        assert html == '<ins class="class-of-ins">content of ins</ins>'
    }

    @Test
    public void testinsWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ins{
                    escape << 'content of ins'
                }
            }
        }).getRawHtml()

        assert html == '<ins>content of ins</ins>'
    }

    @Test
    public void testinsInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ins("content of ins")
            }
        }).getRawHtml()

        assert html == '<ins>content of ins</ins>'
    }

    @Test
    public void testinsInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                ins([:],"content of ins")
            }
        }).getRawHtml()

        assert html == '<ins>content of ins</ins>'
    }


    // --- Table content

    @Test
    public void testcaptionWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                caption(class: 'class-of-caption') {
                    escape << 'content of caption'
                }
            }
        }).getRawHtml()

        assert html == '<caption class="class-of-caption">content of caption</caption>'
    }

    @Test
    public void testcaptionWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                caption{
                    escape << 'content of caption'
                }
            }
        }).getRawHtml()

        assert html == '<caption>content of caption</caption>'
    }

    @Test
    public void testcolWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                col(class: 'class-of-col') {
                    escape << 'content of col'
                }
            }
        }).getRawHtml()

        assert html == '<col class="class-of-col">content of col</col>'
    }

    @Test
    public void testcolWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                col{
                    escape << 'content of col'
                }
            }
        }).getRawHtml()

        assert html == '<col>content of col</col>'
    }

    @Test
    public void testcolgroupWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                colgroup(class: 'class-of-colgroup') {
                    escape << 'content of colgroup'
                }
            }
        }).getRawHtml()

        assert html == '<colgroup class="class-of-colgroup">content of colgroup</colgroup>'
    }

    @Test
    public void testcolgroupWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                colgroup{
                    escape << 'content of colgroup'
                }
            }
        }).getRawHtml()

        assert html == '<colgroup>content of colgroup</colgroup>'
    }

    @Test
    public void testtableWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                table(class: 'class-of-table') {
                    escape << 'content of table'
                }
            }
        }).getRawHtml()

        assert html == '<table class="class-of-table">content of table</table>'
    }

    @Test
    public void testtableWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                table{
                    escape << 'content of table'
                }
            }
        }).getRawHtml()

        assert html == '<table>content of table</table>'
    }

    @Test
    public void testtbodyWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                tbody(class: 'class-of-tbody') {
                    escape << 'content of tbody'
                }
            }
        }).getRawHtml()

        assert html == '<tbody class="class-of-tbody">content of tbody</tbody>'
    }

    @Test
    public void testtbodyWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                tbody{
                    escape << 'content of tbody'
                }
            }
        }).getRawHtml()

        assert html == '<tbody>content of tbody</tbody>'
    }

    @Test
    public void testtdWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                td(class: 'class-of-td') {
                    escape << 'content of td'
                }
            }
        }).getRawHtml()

        assert html == '<td class="class-of-td">content of td</td>'
    }

    @Test
    public void testtdWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                td{
                    escape << 'content of td'
                }
            }
        }).getRawHtml()

        assert html == '<td>content of td</td>'
    }

    @Test
    public void testtfootWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                tfoot(class: 'class-of-tfoot') {
                    escape << 'content of tfoot'
                }
            }
        }).getRawHtml()

        assert html == '<tfoot class="class-of-tfoot">content of tfoot</tfoot>'
    }

    @Test
    public void testtfootWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                tfoot{
                    escape << 'content of tfoot'
                }
            }
        }).getRawHtml()

        assert html == '<tfoot>content of tfoot</tfoot>'
    }

    @Test
    public void testthWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                th(class: 'class-of-th') {
                    escape << 'content of th'
                }
            }
        }).getRawHtml()

        assert html == '<th class="class-of-th">content of th</th>'
    }

    @Test
    public void testthWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                th{
                    escape << 'content of th'
                }
            }
        }).getRawHtml()

        assert html == '<th>content of th</th>'
    }

    @Test
    public void testtheadWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                thead(class: 'class-of-thead') {
                    escape << 'content of thead'
                }
            }
        }).getRawHtml()

        assert html == '<thead class="class-of-thead">content of thead</thead>'
    }

    @Test
    public void testtheadWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                thead{
                    escape << 'content of thead'
                }
            }
        }).getRawHtml()

        assert html == '<thead>content of thead</thead>'
    }

    @Test
    public void testtrWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                tr(class: 'class-of-tr') {
                    escape << 'content of tr'
                }
            }
        }).getRawHtml()

        assert html == '<tr class="class-of-tr">content of tr</tr>'
    }

    @Test
    public void testtrWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                tr{
                    escape << 'content of tr'
                }
            }
        }).getRawHtml()

        assert html == '<tr>content of tr</tr>'
    }


    // --- Forms

    @Test
    public void testbuttonWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                button(class: 'class-of-button') {
                    escape << 'content of button'
                }
            }
        }).getRawHtml()

        assert html == '<button class="class-of-button">content of button</button>'
    }

    @Test
    public void testbuttonWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                button{
                    escape << 'content of button'
                }
            }
        }).getRawHtml()

        assert html == '<button>content of button</button>'
    }

    @Test
    public void testbuttonInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                button("content of button")
            }
        }).getRawHtml()

        assert html == '<button>content of button</button>'
    }

    @Test
    public void testbuttonInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                button([:],"content of button")
            }
        }).getRawHtml()

        assert html == '<button>content of button</button>'
    }

    @Test
    public void testdatalistWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                datalist(class: 'class-of-datalist') {
                    escape << 'content of datalist'
                }
            }
        }).getRawHtml()

        assert html == '<datalist class="class-of-datalist">content of datalist</datalist>'
    }

    @Test
    public void testdatalistWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                datalist{
                    escape << 'content of datalist'
                }
            }
        }).getRawHtml()

        assert html == '<datalist>content of datalist</datalist>'
    }

    @Test
    public void testfieldsetWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                fieldset(class: 'class-of-fieldset') {
                    escape << 'content of fieldset'
                }
            }
        }).getRawHtml()

        assert html == '<fieldset class="class-of-fieldset">content of fieldset</fieldset>'
    }

    @Test
    public void testfieldsetWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                fieldset{
                    escape << 'content of fieldset'
                }
            }
        }).getRawHtml()

        assert html == '<fieldset>content of fieldset</fieldset>'
    }

    @Test
    public void testformWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                form(class: 'class-of-form') {
                    escape << 'content of form'
                }
            }
        }).getRawHtml()

        assert html == '<form class="class-of-form">content of form</form>'
    }

    @Test
    public void testformWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                form{
                    escape << 'content of form'
                }
            }
        }).getRawHtml()

        assert html == '<form>content of form</form>'
    }

    @Test
    public void testinputWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                input(class: 'class-of-input') {
                    escape << 'content of input'
                }
            }
        }).getRawHtml()

        assert html == '<input class="class-of-input">content of input</input>'
    }

    @Test
    public void testinputWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                input{
                    escape << 'content of input'
                }
            }
        }).getRawHtml()

        assert html == '<input>content of input</input>'
    }

    @Test
    public void testkeygenWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                keygen(class: 'class-of-keygen') {
                    escape << 'content of keygen'
                }
            }
        }).getRawHtml()

        assert html == '<keygen class="class-of-keygen">content of keygen</keygen>'
    }

    @Test
    public void testkeygenWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                keygen{
                    escape << 'content of keygen'
                }
            }
        }).getRawHtml()

        assert html == '<keygen>content of keygen</keygen>'
    }

    @Test
    public void testlabelWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                label(class: 'class-of-label') {
                    escape << 'content of label'
                }
            }
        }).getRawHtml()

        assert html == '<label class="class-of-label">content of label</label>'
    }

    @Test
    public void testlabelWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                label{
                    escape << 'content of label'
                }
            }
        }).getRawHtml()

        assert html == '<label>content of label</label>'
    }

    @Test
    public void testlegendWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                legend(class: 'class-of-legend') {
                    escape << 'content of legend'
                }
            }
        }).getRawHtml()

        assert html == '<legend class="class-of-legend">content of legend</legend>'
    }

    @Test
    public void testlegendWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                legend{
                    escape << 'content of legend'
                }
            }
        }).getRawHtml()

        assert html == '<legend>content of legend</legend>'
    }

    @Test
    public void testmeterWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                meter(class: 'class-of-meter') {
                    escape << 'content of meter'
                }
            }
        }).getRawHtml()

        assert html == '<meter class="class-of-meter">content of meter</meter>'
    }

    @Test
    public void testmeterWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                meter{
                    escape << 'content of meter'
                }
            }
        }).getRawHtml()

        assert html == '<meter>content of meter</meter>'
    }

    @Test
    public void testoptgroupWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                optgroup(class: 'class-of-optgroup') {
                    escape << 'content of optgroup'
                }
            }
        }).getRawHtml()

        assert html == '<optgroup class="class-of-optgroup">content of optgroup</optgroup>'
    }

    @Test
    public void testoptgroupWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                optgroup{
                    escape << 'content of optgroup'
                }
            }
        }).getRawHtml()

        assert html == '<optgroup>content of optgroup</optgroup>'
    }

    @Test
    public void testoutputWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                output(class: 'class-of-output') {
                    escape << 'content of output'
                }
            }
        }).getRawHtml()

        assert html == '<output class="class-of-output">content of output</output>'
    }

    @Test
    public void testoutputWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                output{
                    escape << 'content of output'
                }
            }
        }).getRawHtml()

        assert html == '<output>content of output</output>'
    }

    @Test
    public void testprogressWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                progress(class: 'class-of-progress') {
                    escape << 'content of progress'
                }
            }
        }).getRawHtml()

        assert html == '<progress class="class-of-progress">content of progress</progress>'
    }

    @Test
    public void testprogressWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                progress{
                    escape << 'content of progress'
                }
            }
        }).getRawHtml()

        assert html == '<progress>content of progress</progress>'
    }

    @Test
    public void testselectWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                select(class: 'class-of-select') {
                    escape << 'content of select'
                }
            }
        }).getRawHtml()

        assert html == '<select class="class-of-select">content of select</select>'
    }

    @Test
    public void testselectWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                select{
                    escape << 'content of select'
                }
            }
        }).getRawHtml()

        assert html == '<select>content of select</select>'
    }


    // --- Interactive elements

    @Test
    public void testdetailsWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                details(class: 'class-of-details') {
                    escape << 'content of details'
                }
            }
        }).getRawHtml()

        assert html == '<details class="class-of-details">content of details</details>'
    }

    @Test
    public void testdetailsWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                details{
                    escape << 'content of details'
                }
            }
        }).getRawHtml()

        assert html == '<details>content of details</details>'
    }

    @Test
    public void testdialogWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                dialog(class: 'class-of-dialog') {
                    escape << 'content of dialog'
                }
            }
        }).getRawHtml()

        assert html == '<dialog class="class-of-dialog">content of dialog</dialog>'
    }

    @Test
    public void testdialogWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                dialog{
                    escape << 'content of dialog'
                }
            }
        }).getRawHtml()

        assert html == '<dialog>content of dialog</dialog>'
    }

    @Test
    public void testmenuWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                menu(class: 'class-of-menu') {
                    escape << 'content of menu'
                }
            }
        }).getRawHtml()

        assert html == '<menu class="class-of-menu">content of menu</menu>'
    }

    @Test
    public void testmenuWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                menu{
                    escape << 'content of menu'
                }
            }
        }).getRawHtml()

        assert html == '<menu>content of menu</menu>'
    }

    @Test
    public void testmenuitemWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                menuitem(class: 'class-of-menuitem') {
                    escape << 'content of menuitem'
                }
            }
        }).getRawHtml()

        assert html == '<menuitem class="class-of-menuitem">content of menuitem</menuitem>'
    }

    @Test
    public void testmenuitemWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                menuitem{
                    escape << 'content of menuitem'
                }
            }
        }).getRawHtml()

        assert html == '<menuitem>content of menuitem</menuitem>'
    }

    @Test
    public void testsummaryWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                summary(class: 'class-of-summary') {
                    escape << 'content of summary'
                }
            }
        }).getRawHtml()

        assert html == '<summary class="class-of-summary">content of summary</summary>'
    }

    @Test
    public void testsummaryWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                summary{
                    escape << 'content of summary'
                }
            }
        }).getRawHtml()

        assert html == '<summary>content of summary</summary>'
    }

    @Test
    public void testsummaryInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                summary("content of summary")
            }
        }).getRawHtml()

        assert html == '<summary>content of summary</summary>'
    }

    @Test
    public void testsummaryInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                summary([:],"content of summary")
            }
        }).getRawHtml()

        assert html == '<summary>content of summary</summary>'
    }


    // --- Web Components

    @Test
    public void testcontentWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                content(class: 'class-of-content') {
                    escape << 'content of content'
                }
            }
        }).getRawHtml()

        assert html == '<content class="class-of-content">content of content</content>'
    }

    @Test
    public void testcontentWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                content{
                    escape << 'content of content'
                }
            }
        }).getRawHtml()

        assert html == '<content>content of content</content>'
    }

    @Test
    public void testelementWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                element(class: 'class-of-element') {
                    escape << 'content of element'
                }
            }
        }).getRawHtml()

        assert html == '<element class="class-of-element">content of element</element>'
    }

    @Test
    public void testelementWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                element{
                    escape << 'content of element'
                }
            }
        }).getRawHtml()

        assert html == '<element>content of element</element>'
    }

    @Test
    public void testshadowWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                shadow(class: 'class-of-shadow') {
                    escape << 'content of shadow'
                }
            }
        }).getRawHtml()

        assert html == '<shadow class="class-of-shadow">content of shadow</shadow>'
    }

    @Test
    public void testshadowWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                shadow{
                    escape << 'content of shadow'
                }
            }
        }).getRawHtml()

        assert html == '<shadow>content of shadow</shadow>'
    }

    @Test
    public void testtemplateWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                template(class: 'class-of-template') {
                    escape << 'content of template'
                }
            }
        }).getRawHtml()

        assert html == '<template class="class-of-template">content of template</template>'
    }

    @Test
    public void testtemplateWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                template{
                    escape << 'content of template'
                }
            }
        }).getRawHtml()

        assert html == '<template>content of template</template>'
    }


    // --- Elements strangely absent from the doc

    @Test
    public void testaWithAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                a(class: 'class-of-a') {
                    escape << 'content of a'
                }
            }
        }).getRawHtml()

        assert html == '<a class="class-of-a">content of a</a>'
    }

    @Test
    public void testaWithoutAttr() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                a{
                    escape << 'content of a'
                }
            }
        }).getRawHtml()

        assert html == '<a>content of a</a>'
    }

    @Test
    public void testaInline() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                a("content of a")
            }
        }).getRawHtml()

        assert html == '<a>content of a</a>'
    }

    @Test
    public void testaInlineWithAttrs() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                a([:],"content of a")
            }
        }).getRawHtml()

        assert html == '<a>content of a</a>'
    }

    @Test
    public void testbrEmpty() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                br()
            }
        }).getRawHtml()

        assert html == '<br>'
    }

    @Test
    public void testimgWithoutContent() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                img(class:"class-of-img")
            }
        }).getRawHtml()

        assert html == '<img class="class-of-img">'
    }
}