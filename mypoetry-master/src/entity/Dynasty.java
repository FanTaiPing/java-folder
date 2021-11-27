package entity;

/**
 * 朝代
 * @author ljsy
 **/
public class Dynasty {
    private int id;
    private String dynastyName;
    private String[] describe;

    public Dynasty() {
    }

    public Dynasty(int id, String dynastyName) {
        this.id = id;
        this.dynastyName = dynastyName;
    }

    @Override
    public String toString() {
        return "Dynasty{" +
                "id=" + id +
                ", dynastyName='" + dynastyName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDynastyName() {
        return dynastyName;
    }

    public void setDynastyName(String dynastyName) {
        this.dynastyName = dynastyName;
    }

    public String[] getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe.split("/");
    }
}
