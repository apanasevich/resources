package examples;

import examples.resources.Author;
import examples.resources.Book;
import examples.resources.Publisher;

import java.io.IOException;
import java.net.URISyntaxException;

import static examples.ClassIndex.getResource;
import static examples.ClassIndex.gson;

public final class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        final Publisher publisher = gson.fromJson(getResource("/resources/sun.json"), Publisher.class);
        final Author author = gson.fromJson(getResource("/resources/williams.json"), Author.class);
        final Book coreJava2 = gson.fromJson(getResource("/resources/core_java_2.json"), Book.class);
    }
}
