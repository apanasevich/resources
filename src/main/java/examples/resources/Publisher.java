package examples.resources;

import examples.Resource;
import examples.ResourceRef;
import org.jetbrains.annotations.NotNull;

public final class Publisher implements Resource {
    @NotNull
    private final String name;
    @NotNull
    private final ResourceRef<Country> country;

    public Publisher(@NotNull String name, @NotNull ResourceRef<Country> country) {
        this.name = name;
        this.country = country;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public ResourceRef<Country> getCountry() {
        return country;
    }
}
