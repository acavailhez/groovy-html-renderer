package acavailhez.html

import org.junit.Test

public class ScopeTest extends AbstractTest {

    @Test
    public void testSameLevel() throws Exception {
        String value = null
        assert (new Html() {
            @Override
            public void build() {
                div {
                    scope.put("key", "value")
                    value = scope.get("key")
                }
            }
        }).render()

        assert value == "value"
    }

    @Test
    public void testSameLevelAfterStuff() throws Exception {
        String value = null
        assert (new Html() {
            @Override
            public void build() {
                div {
                    scope.put("key", "value")
                    div{

                    }
                    value = scope.get("key")
                }
            }
        }).render()

        assert value == "value"
    }

    @Test
    public void testAtRoot() throws Exception {
        String value = null
        assert (new Html() {
            @Override
            public void build() {
                scope.put("key", "value")
                div {

                }
                value = scope.get("key")
            }
        }).render()

        assert value == "value"
    }


    @Test
    public void testDeeperLevel() throws Exception {
        String value = null
        assert (new Html() {
            @Override
            public void build() {
                div {
                    scope.put("key", "value")
                    div {
                        value = scope.get("key")
                    }
                }
            }
        }).render()

        assert value == "value"
    }

    @Test
    public void testLowerLevel() throws Exception {
        String value = null
        assert (new Html() {
            @Override
            public void build() {
                div {

                    div {
                        scope.put("key", "value")
                    }
                    value = scope.get("key")
                }
            }
        }).render()

        assert value == null
    }

    @Test
    public void testOverwriteNewValue() throws Exception {
        String value = null
        assert (new Html() {
            @Override
            public void build() {
                div {
                    scope.put("key", "value1")
                    div {
                        scope.put("key", "value2")
                        div {
                            value = scope.get("key")
                        }
                    }

                }
            }
        }).render()

        assert value == "value2"
    }

    @Test
    public void testOverwriteKeptOldValue() throws Exception {
        String value = null
        assert (new Html() {
            @Override
            public void build() {
                div {
                    scope.put("key", "value1")
                    div {
                        scope.put("key", "value2")
                        div {

                        }
                    }
                    value = scope.get("key")
                }
            }
        }).render()

        assert value == "value1"
    }
}