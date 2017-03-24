package examples.resources;

import examples.Resource;
import org.jetbrains.annotations.NotNull;

public final class Country implements Resource {
    @NotNull
    private final String name;

    public Country(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public String getName() {
        return name;
    }
}
