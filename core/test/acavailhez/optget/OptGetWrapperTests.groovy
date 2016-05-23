package acavailhez.optget

import acavailhez.html.tests.AbstractTests
import org.junit.Test

public class OptGetWrapperTests extends AbstractTests {

    public static class Wrapped {
        public int publicField = 10;
        private int privateField = 20;

        public String getPublicProperty() {
            return "publicProperty"
        }

        private String getPrivateProperty() {
            return "privateProperty"
        }

        public Wrapped getNested() {
            return new Wrapped()
        }
    }

    @Test
    public void wrap() throws Exception {
        OptGetWrapper wrapper = new OptGetWrapper(new Wrapped())

        assert wrapper.get('publicField', Integer) == 10
        assert wrapper.get('publicProperty', String) == "publicProperty"

        assert wrapper.opt("missing") == null

        assert wrapper.get("nested.publicField") == 10

        try {
            wrapper.get("privateField")
            assert false
        }
        catch (IllegalArgumentException ex) {
        }


        try {
            wrapper.get("privateProperty")
            assert false
        }
        catch (IllegalArgumentException ex) {
        }
    }
}