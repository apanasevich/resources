package examples.resources;

import examples.Resource;
import examples.ResourceRef;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public final class Book implements Resource {
    @NotNull
    private final String name;
    @NotNull
    private final Collection<ResourceRef<Author>> authors;
    @NotNull
    private final ResourceRef<Publisher> publisher;

    public Book(@NotNull String name, @NotNull Collection<ResourceRef<Author>> authors, @NotNull ResourceRef<Publisher> publisher) {
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public Collection<ResourceRef<Author>> getAuthors() {
        return authors;
    }

    @NotNull
    public ResourceRef<Publisher> getPublisher() {
        return publisher;
    }
}
