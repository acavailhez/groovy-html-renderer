package acavailhez.html.scope

import acavailhez.html.tests.AbstractTests
import org.junit.Test

public class HtmlScopeListenerTests extends AbstractTests {

    static class Listener extends HtmlScopeListener<StringBuilder> {

        @Override
        protected StringBuilder create() {
            return new StringBuilder()
        }

        @Override
        protected StringBuilder merge(StringBuilder toMergeInto, StringBuilder objectToMerge) {
            return toMergeInto.append(objectToMerge)
        }

        public String getFullString() {
            return getCurrentScope().toString()
        }
    }

    @Test
    public void simple() throws Exception {
        Listener listener = new Listener()
        listener.prepareForNewScope()
        assert listener.getCurrentScope() != null
        listener.getCurrentScope().append("A")
        listener.commitToPreviousScope()
        assert listener.getFullString() == "A"
    }

    @Test
    public void rollback() throws Exception {
        Listener listener = new Listener()

        listener.prepareForNewScope()
        listener.getCurrentScope().append("A")
        listener.rollbackCurrentScope()

        assert listener.getFullString() == ""
    }

    @Test
    public void twoLevels() throws Exception {
        Listener listener = new Listener()

        listener.prepareForNewScope()
        listener.getCurrentScope().append("A")
        listener.getCurrentScope().append("B")
        listener.prepareForNewScope()
        listener.getCurrentScope().append("C")
        listener.getCurrentScope().append("D")
        listener.commitToPreviousScope()
        listener.getCurrentScope().append("F")
        listener.getCurrentScope().append("E")
        listener.commitToPreviousScope()

        assert listener.getFullString() == "ABCDFE"
    }

    @Test
    public void severalLevelsWithRollback() throws Exception {
        Listener listener = new Listener()

        listener.prepareForNewScope()
        listener.getCurrentScope().append("A")

        listener.prepareForNewScope()
        listener.getCurrentScope().append("B")
        listener.commitToPreviousScope()

        listener.prepareForNewScope()
        listener.getCurrentScope().append("C")
        listener.rollbackCurrentScope()

        listener.prepareForNewScope()
        listener.getCurrentScope().append("D")
        listener.commitToPreviousScope()

        listener.prepareForNewScope()
        listener.getCurrentScope().append("E")
        listener.rollbackCurrentScope()

        listener.getCurrentScope().append("F")
        listener.commitToPreviousScope()

        assert listener.getFullString() == "ABDF"
    }

    @Test
    public void rollbackSeveralLevels() throws Exception {
        Listener listener = new Listener()

        listener.prepareForNewScope()
        listener.getCurrentScope().append("A")

        listener.prepareForNewScope()
        listener.getCurrentScope().append("B")

        listener.prepareForNewScope()
        listener.getCurrentScope().append("C")
        listener.commitToPreviousScope()

        listener.getCurrentScope().append("D")
        listener.rollbackCurrentScope()

        listener.getCurrentScope().append("F")
        listener.commitToPreviousScope()

        assert listener.getFullString() == "AF"
    }
}