package acavailhez.html.utils

import acavailhez.html.AbstractTest
import org.junit.Test

public class HtmlAttributesTest extends AbstractTest {

    @Test
    public void testCopy() throws Exception {
        Map map = [
                a: 1,
                b: 2
        ]
        HtmlAttributes attrs = HtmlAttributes.copy(map)
        assert attrs.remove('b') == 2
        assert map['b'] == 2
    }

    @Test
    public void testWrap() throws Exception {
        Map map = [
                a: 1,
                b: 2
        ]
        HtmlAttributes attrs = HtmlAttributes.wrap(map)
        assert attrs.remove('b') == 2
        assert map['b'] == null
    }

    @Test
    public void testOptAttr() throws Exception {

        assert HtmlAttributes.wrap(null).opt('test', String, null) == null
        assert HtmlAttributes.wrap([:]).opt('test', String, null) == null
        assert HtmlAttributes.wrap(['a': 1]).opt('test', String, null) == null

        assert HtmlAttributes.wrap(null).opt('test', String, 'test') == 'test'
        assert HtmlAttributes.wrap([:]).opt('test', String, 'test') == 'test'
        assert HtmlAttributes.wrap(['a': 1]).opt('test', String, 'test') == 'test'

        assert HtmlAttributes.wrap(['test': 'test2']).opt('test', String, 'test') == 'test2'

        assert HtmlAttributes.wrap(['test2': 1]).opt('test', Integer, 2) == 2
        assert HtmlAttributes.wrap(['test': 1]).opt('test', Integer, 2) == 1
    }

    @Test
    public void testOpt() throws Exception {

        HtmlAttributes attrs = HtmlAttributes.wrap([one: 1, two: 'two'])
        assert attrs.opt('one') == 1
        assert attrs.opt('one', Integer) == 1
        assert attrs.opt('one', Integer, 3) == 1
        assert attrs.opt('two') == 'two'
        assert attrs.opt('two', String) == 'two'
        assert attrs.opt('two', String, 'three') == 'two'
        assert attrs.opt('three') == null
        assert attrs.opt('three', String) == null
        assert attrs.opt('three', String, 'three') == 'three'

    }

    @Test
    public void testGet() throws Exception {

        HtmlAttributes attrs = HtmlAttributes.wrap([one: 1, two: 'two'])
        try {
            attrs.get('three', String)
            throw new RuntimeException("Should not happen")
        }
        catch (IllegalArgumentException ex) {
            // we're good
        }

    }
}