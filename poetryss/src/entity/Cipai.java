package entity;

/**
 * 词牌名
 * @author ljsy
 **/
public class Cipai {
    private int id;
    private String cipaiName;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCipaiName() {
        return cipaiName;
    }

    public void setCipaiName(String cipaiName) {
        this.cipaiName = cipaiName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
