package examples;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import examples.resources.Book;

public final class ResourcesModule extends AbstractModule {
    @Override
    protected void configure() {
        ClassIndex.initialize();
        bind(Book.class).annotatedWith(Names.named("/resources/cpp_in_action.json"))
                .toInstance(ClassIndex.getResource("/resources/cpp_in_action.json", Book.class));
        bind(Book.class).annotatedWith(Names.named("/resources/core_java_2.json"))
                .toInstance(ClassIndex.getResource("/resources/core_java_2.json", Book.class));
    }
}
