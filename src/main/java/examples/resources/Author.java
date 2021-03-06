package examples.resources;

import examples.Resource;
import org.jetbrains.annotations.NotNull;

public final class Author implements Resource {
    @NotNull
    private final String name;
    private final long birthday;

    public Author(@NotNull String name, long birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public long getBirthday() {
        return birthday;
    }
}
