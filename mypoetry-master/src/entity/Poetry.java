package entity;

/**
 * @author ljsy
 **/
public class Poetry {

    private int id;
    private String title;
    private Author author;
    private String[] content;
    private String[] translate;
    private String[] translateRes;
    private String[] notes;
    private String[] appreciation;
    private String[] appreciationRes;
    private Type type;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String[] getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content.split("/");
    }

    public String[] getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate.split("/");
    }

    public String[] getTranslateRes() {
        return translateRes;
    }

    public void setTranslateRes(String translateRes) {
        this.translateRes = translateRes.split("/");
    }

    public String[] getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes.split("/");
    }

    public String[] getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation.split("/");
    }

    public String[] getAppreciationRes() {
        return appreciationRes;
    }

    public void setAppreciationRes(String appreciationRes) {
        this.appreciationRes = appreciationRes.split("/");
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
