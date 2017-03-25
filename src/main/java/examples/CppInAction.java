package examples;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import examples.resources.Book;
import org.jetbrains.annotations.NotNull;


public final class CppInAction {
    @NotNull
    private final Book book;

    @Inject
    public CppInAction(@NotNull @Named("/resources/cpp_in_action.json") Book book) {
        this.book = book;
    }

    @NotNull
    public Book getBook() {
        return book;
    }
}
