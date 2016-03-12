package acavailhez.html

import org.junit.Test

public class JavascriptTest extends AbstractTest{


    @Test
    public void testJavascript() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div {
                    js << 'var a=1;'
                    js << 'a=2;'
                    span {
                        p {
                            escape << 'embed'
                            js << 'var a=3'
                            js << 'a=4'
                        }
                        js << 'var a=5'
                    }
                }
            }
        }).withStyle(HtmlStyle.PRETTY)
                .render().replaceAll(System.lineSeparator(), '\n')
        assert renderEquals(html, '''
<div>
 <span>
  <p>embed</p>
 </span>
</div>
<script>
 try{
  var a=1;
  a=2;
 }catch(e){console.log(e)}
 try{
  var a=3
  a=4
 }catch(e){console.log(e)}
 try{
  var a=5
 }catch(e){console.log(e)}
</script>
''')
    }

}