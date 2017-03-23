package examples;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import examples.resources.Author;
import examples.resources.Book;
import examples.resources.Publisher;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public enum ClassIndex {
    ;
    public static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(ResourceRef.class, new ResourceRefDeserializer())
            .create();
    public static final Map<String, Class<?>> index = new HashMap<String, Class<?>>();

    static {
        index.put("/resources/core_java_2.json", Book.class);
        index.put("/resources/cpp_in_action.json", Book.class);
        index.put("/resources/sun.json", Publisher.class);
        index.put("/resources/manning.json", Publisher.class);
        index.put("/resources/williams.json", Author.class);
        index.put("/resources/cornell.json", Author.class);
        index.put("/resources/horstmann.json", Author.class);
    }

    static String getResource(String resourcePath) throws URISyntaxException, IOException {
        final URL resource = ClassIndex.class.getResource(resourcePath);
        final String configFile = Paths.get(resource.toURI()).toFile().getAbsolutePath();
        return Files.toString(new File(configFile), Charsets.UTF_8);
    }
}
