package love.dragonist.knowledge.bean;

public class KnowledgeCard {
    private String book;
    private String chapter;
    private String title;
    private String content;

    public KnowledgeCard(String book, String chapter, String title, String content) {
        this.book = book;
        this.chapter = chapter;
        this.title = title;
        this.content = content;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
