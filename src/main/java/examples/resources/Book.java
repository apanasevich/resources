package examples.resources;

import com.google.inject.Inject;

import java.util.Collection;

public final class Book {
    private String name;
    @Inject
    private Collection<Author> authors;
    @Inject
    private Publisher publisher;

    public String getName() {
        return name;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }
}
