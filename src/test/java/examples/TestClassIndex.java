package examples;

import examples.resources.Book;
import examples.resources.Country;
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
        final Book coreJava2 = ClassIndex.getResource("/resources/core_java_2.json", Book.class);
        final Book cppInAction = ClassIndex.getResource("/resources/cpp_in_action.json", Book.class);
        final Country country = ClassIndex.getResource("/resources/usa.json", Country.class);

        assertEquals(country, coreJava2.getPublisher().getInstance().getCountry().getInstance());
        assertEquals(country, cppInAction.getPublisher().getInstance().getCountry().getInstance());
    }
}
