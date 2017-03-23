package examples.resources;

import examples.ResourceRef;

import java.util.Collection;

public final class Book {
    private final String name;
    private final Collection<ResourceRef<Author>> authors;
    private final ResourceRef<Publisher> publisher;

    public Book(String name, Collection<ResourceRef<Author>> authors, ResourceRef<Publisher> publisher) {
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public Collection<ResourceRef<Author>> getAuthors() {
        return authors;
    }

    public ResourceRef<Publisher> getPublisher() {
        return publisher;
    }
}
