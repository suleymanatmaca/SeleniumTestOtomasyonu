package screenplay.model;

public class PageCountInformation {
    private final String pageCount;

    public PageCountInformation(String pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return String.format("{pageCount='%s'}", pageCount);
    }
}
