package examples;

import examples.resources.Book;
import org.jetbrains.annotations.NotNull;


public final class Main {
    public static void main(@NotNull String[] args) {
        ClassIndex.initialize();
        final Book coreJava2 = ClassIndex.getResource("/resources/core_java_2.json", Book.class);
        final Book cppInAction = ClassIndex.getResource("/resources/cpp_in_action.json", Book.class);
    }
}
