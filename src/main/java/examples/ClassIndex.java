package examples;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import com.google.gson.*;
import examples.resources.Author;
import examples.resources.Book;
import examples.resources.Country;
import examples.resources.Publisher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;

public enum ClassIndex {
    ;
    @NotNull
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(ResourceRef.class, new ResourceRefDeserializer())
            .create();
    @NotNull
    private static final Map<String, Class<? extends Resource>> index = ImmutableMap.<String, Class<? extends Resource>>builder()
            .put("/resources/core_java_2.json", Book.class)
            .put("/resources/cpp_in_action.json", Book.class)
            .put("/resources/sun.json", Publisher.class)
            .put("/resources/manning.json", Publisher.class)
            .put("/resources/williams.json", Author.class)
            .put("/resources/cornell.json", Author.class)
            .put("/resources/horstmann.json", Author.class)
            .put("/resources/usa.json", Country.class)
            .build();

    @NotNull
    private static final Map<String, Resource> instances = new ConcurrentHashMap<>();
    private static final int THREAD_POOL_SIZE = 3;

    @Nullable
    public static <T extends Resource> T getResource(@NotNull String resourcePath, @NotNull Class<T> clazz) {
        return (T) instances.computeIfAbsent(resourcePath, (file) -> gson.fromJson(getResourceAsString(file), clazz));
    }

    @Nullable
    public static Resource getResource(@NotNull String resourcePath) {
        return getResource(resourcePath, index.get(resourcePath));
    }

    @NotNull
    private static String getResourceAsString(@NotNull String resourcePath) {
        final URL resource = ClassIndex.class.getResource(resourcePath);
        try {
            final String configFile = Paths.get(resource.toURI()).toFile().getAbsolutePath();
            return Files.toString(new File(configFile), Charsets.UTF_8);
        } catch (URISyntaxException | IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void initialize() {
        if(!instances.isEmpty()) {
            return;
        }
        final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>(index.keySet());
        final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        final CompletionService<Boolean> completionService = new ExecutorCompletionService<>(executorService);

        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            completionService.submit(new InitTask(queue));
        }

        try {
            for (int i = 0; i < THREAD_POOL_SIZE; i++) {
                final Future<Boolean> initCompleted = completionService.take();
                initCompleted.get();
            }
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException ignore) {
        } finally {
            executorService.shutdown();
        }
    }

    private static final class InitTask implements Callable<Boolean> {
        @NotNull
        private final Queue<String> queue;

        private InitTask(@NotNull ConcurrentLinkedQueue<String> queue) {
            this.queue = queue;
        }

        @NotNull
        @Override
        public Boolean call() {
            String resourcePath = queue.poll();
            while (resourcePath != null) {
                getResource(resourcePath);
                resourcePath = queue.poll();
            }
            return Boolean.TRUE;
        }
    }

}
