package examples;

import com.google.inject.Guice;
import com.google.inject.Injector;
import examples.resources.Book;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class TestInjector {
    @NotNull
    private static Injector injector;

    @BeforeClass
    public static void setUp() {
        injector = Guice.createInjector(new ResourcesModule());
    }

    @Test
    public void countriesAreEqual() {
        final CppInAction cppInAction = injector.getInstance(CppInAction.class);
        final CoreJava2 coreJava2 = injector.getInstance(CoreJava2.class);
        assertEquals(cppInAction.getBook().getPublisher().getInstance().getCountry().getInstance(), coreJava2.getBook().getPublisher().getInstance().getCountry().getInstance());
    }
}
