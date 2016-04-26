package acavailhez.html.utils

import acavailhez.html.AbstractTest
import org.junit.Test

public class GetOptTest extends AbstractTest {

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
}