package examples;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import examples.resources.Book;
import org.jetbrains.annotations.NotNull;


public final class CoreJava2 {
    @NotNull
    private final Book book;

    @Inject
    public CoreJava2(@NotNull @Named("/resources/core_java_2.json") Book book) {
        this.book = book;
    }

    @NotNull
    public Book getBook() {
        return book;
    }
}
