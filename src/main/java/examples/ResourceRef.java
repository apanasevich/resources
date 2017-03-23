package examples;

import java.io.IOException;
import java.net.URISyntaxException;

public final class ResourceRef<T> {
    private final String ref;
    private final transient T instance;

    public ResourceRef(String ref) throws IOException, URISyntaxException {
        this.ref = ref;
        instance = (T) ClassIndex.gson.fromJson(ClassIndex.getResource(ref), ClassIndex.index.get(ref));
    }

    public String getRef() {
        return ref;
    }

    public T getInstance() {
        return instance;
    }
}
