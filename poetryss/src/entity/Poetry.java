package entity;

/**
 * @author ljsy
 **/
public class Poetry {
    private int id;
    /**
     * 古诗内容
     */
    private String content;
    private String translate;
    private String translate_res;
    private String notes;
    private String appreciation;
    private String appreciation_res;
    private String title;
    private String dynasty;
    private Author author;
    private Type type;

    public Poetry() {
    }

    public Poetry(int id, String content, String translate, String translate_res, String notes, String appreciation, String appreciation_res, String title, String dynasty, Author author, Type type) {
        this.id = id;
        this.content = content;
        this.translate = translate;
        this.translate_res = translate_res;
        this.notes = notes;
        this.appreciation = appreciation;
        this.appreciation_res = appreciation_res;
        this.title = title;
        this.dynasty = dynasty;
        this.author = author;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getTranslate_res() {
        return translate_res;
    }

    public void setTranslate_res(String translate_res) {
        this.translate_res = translate_res;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public String getAppreciation_res() {
        return appreciation_res;
    }

    public void setAppreciation_res(String appreciation_res) {
        this.appreciation_res = appreciation_res;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
