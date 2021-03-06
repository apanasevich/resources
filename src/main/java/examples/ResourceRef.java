package examples;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ResourceRef<T extends Resource> {
    @NotNull
    private final String ref;
    @Nullable
    private final transient T instance;

    public ResourceRef(@NotNull String ref) {
        this.ref = ref;
        instance = (T) ClassIndex.getResource(ref);
    }

    @NotNull
    public String getRef() {
        return ref;
    }

    @Nullable
    public T getInstance() {
        return instance;
    }
}
