package examples.resources;

public final class Author {
    private final String name;
    private final long birthday;

    public Author(String name, long birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public long getBirthday() {
        return birthday;
    }
}
