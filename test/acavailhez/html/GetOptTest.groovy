package acavailhez.html

import org.junit.Test

public class GetOptTest extends AbstractTest {

    @Test
    public void testOpt() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div(one: 1, two: 'two') {
                    escape << optAttr('one')
                    escape << optAttr('one', Integer)
                    escape << optAttr('one', Integer, 3)
                    escape << optAttr('two')
                    escape << optAttr('two', String)
                    escape << optAttr('two', String, 'three')
                    escape << optAttr('three')
                    escape << optAttr('three', String)
                    escape << optAttr('three', String, 'three')
                }
            }
        }).getRawHtml()

        assert html == '<div one="1" two="two">111twotwotwothree</div>'
    }

    @Test
    public void testGet() throws Exception {
        String html = (new Html() {
            @Override
            public void build() {
                div(one: 1, two: 'two') {
                    escape << getAttr('one')
                    escape << getAttr('one', Integer)
                    escape << getAttr('one', Integer, 3)
                    escape << getAttr('two')
                    escape << getAttr('two', String)
                    escape << getAttr('two', String, 'three')
                    escape << getAttr('three', String, 'three')
                }
            }
        }).getRawHtml()

        assert html == '<div one="1" two="two">111twotwotwothree</div>'
    }

    @Test
    public void testGetAbsent() throws Exception {
        try {
            String html = (new Html() {
                @Override
                public void build() {
                    div(one: 1, two: 'two') {
                        escape << getAttr('three', String)
                    }
                }
            }).getRawHtml()
            throw new RuntimeException("This should not happen")
        }
        catch (IllegalArgumentException ex) {
            // this should happen
        }
    }
}