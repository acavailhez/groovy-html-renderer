package acavailhez.optget

import acavailhez.html.bootstrap.Bootstrap4Color
import acavailhez.html.tests.AbstractTests
import org.junit.Assert
import org.junit.Test

public class GetOptTests extends AbstractTests {

    @Test
    public void testSimple() throws Exception {
        OptGetMap map = new OptGetMap([
                a: 1,
                b: "string",
                c: Locale.FRENCH,
                d: [
                        da: 1,
                        db: [
                                dba: "two"
                        ]
                ],
                e: [1, 2],
                f: "12"
        ])

        assert map.get('a') == 1
        assert map.get('b') == 'string'
        assert map.get('c') == Locale.FRENCH
        assert map.get('d.da') == 1
        assert map.get('d.db.dba') == "two"

        // cast
        assert map.get('a', String) == '1'
        assert map.get('e', List)[0] == 1
        assert map.get('f', Long) == 12L

        // opt
        assert map.opt('z') == null
        assert map.opt('a.b') == null
        assert map.opt('d.da.da') == null

        // default
        assert map.opt('z', String, "test") == "test"
    }

    @Test
    public void cast() {

        Assert.assertEquals("test", CastUtils.cast("test", String.class))
        Assert.assertEquals("1", CastUtils.cast(1, String.class))

        Assert.assertEquals(1, CastUtils.cast(1, Integer.class))
        Assert.assertEquals(1, CastUtils.cast("1", Integer.class))
        Assert.assertEquals(1, CastUtils.cast(1L, Integer.class))

        Assert.assertEquals(Bootstrap4Color.DANGER, CastUtils.cast(Bootstrap4Color.DANGER, Bootstrap4Color.class))
        Assert.assertEquals(Bootstrap4Color.DANGER, CastUtils.cast('DANGER', Bootstrap4Color.class))
        Assert.assertEquals(Bootstrap4Color.DANGER, CastUtils.cast('danger', Bootstrap4Color.class))
    }
}