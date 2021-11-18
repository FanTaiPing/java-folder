package entity;

import java.util.Date;

public class News {
private int id;
private String title;
private String desc;
private String author;
private String content;
private Date createTime;
private Date updateTime;
private String smImg;
private String meImg;
private String laImg;
private int typeId;
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
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
public Date getUpdateTime() {
	return updateTime;
}
public void setUpdateTime(Date updateTime) {
	this.updateTime = updateTime;
}
public String getSmImg() {
	return smImg;
}
public void setSmImg(String smImg) {
	this.smImg = smImg;
}
public String getMeImg() {
	return meImg;
}
public void setMeImg(String meImg) {
	this.meImg = meImg;
}
public String getLaImg() {
	return laImg;
}
public void setLaImg(String laImg) {
	this.laImg = laImg;
}
public int getTypeId() {
	return typeId;
}
public void setTypeId(int typeId) {
	this.typeId = typeId;
}

}
