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
    private Dynasty dynasty;
    private String lifeTime;
    private String pinyin;

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", lifeTime='" + lifeTime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getPinyin() {
        return pinyin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // 整理数据库数据专用
//        char familyName = name.charAt(0);
//        try {
//            String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(familyName, new HanyuPinyinOutputFormat());
//            pinyin = pinyins[0].substring(0, 1);
//        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
//            badHanyuPinyinOutputFormatCombination.printStackTrace();
//        }
        this.name = name;
    }

    public Dynasty getDynasty() {
        return dynasty;
    }

    public void setDynasty(Dynasty dynasty) {
        this.dynasty = dynasty;
    }

    public String getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(String lifeTime) {
        this.lifeTime = lifeTime;
    }
}
