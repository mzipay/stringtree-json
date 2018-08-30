package tests.json;

import org.stringtree.json.ExceptionErrorListener;
import org.stringtree.json.JSONValidatingReader;

import junit.framework.TestCase;

public class ExceptionErrorListenerTest extends TestCase {
    public void testExceptionMessageExposesJsonSource() {
        try {
            new JSONValidatingReader(new ExceptionErrorListener()).read("{invalid}");
            fail("did not throw exception!");
        } catch (IllegalArgumentException ex) {
            assertTrue("JSON source not emitted!", ex.getMessage().contains("{invalid}"));
        }
    }

    public void testExceptionMessageDoesNotExposeJsonSource() {
        try {
            new JSONValidatingReader(new ExceptionErrorListener(false)).read("{invalid}");
            fail("did not throw exception!");
        } catch (IllegalArgumentException ex) {
            assertFalse("JSON source was emitted!", ex.getMessage().contains("{invalid}"));
        }
    }
}
