package examples;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class TestClassIndex {
    @BeforeClass
    public static void initialize() {
        ClassIndex.initialize();
    }

    @Test
    public void countriesAreEqual() {
        final CppInAction cppInAction = CppInAction.get();
        final CoreJava2 coreJava2 = CoreJava2.get();
        assertEquals(cppInAction.getBook().getPublisher().getInstance().getCountry().getInstance(),
                coreJava2.getBook().getPublisher().getInstance().getCountry().getInstance());
    }
}
