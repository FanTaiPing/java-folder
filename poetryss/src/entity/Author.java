package entity;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 作者
 *
 * @author ljsy
 **/
public class Author {
    private int id;
    private String name;
    private int dynasty;
    private String lifeTime;
    private String pinyin;



    public Author() {

    }

    public Author(int id, String name, int dynasty, String lifeTime, String pinyin) {
        this.id = id;
        this.name = name;
        this.dynasty = dynasty;
        this.lifeTime = lifeTime;
        this.pinyin = pinyin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDynasty() {
        return dynasty;
    }

    public void setDynasty(int dynasty) {
        this.dynasty = dynasty;
    }

    public String getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(String lifeTime) {
        this.lifeTime = lifeTime;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dynasty=" + dynasty +
                ", lifeTime='" + lifeTime + '\'' +
                ", pinyin='" + pinyin + '\'' +
                '}';
    }
}
