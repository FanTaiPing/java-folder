package arrayList;
/**
 * 使用List存储企鹅信息
 * 把多个企鹅的信息添加到集合中
 * 查看企鹅的数量及所有企鹅的信息
 * 删除集合中部分企鹅的元素
 * 判断集合中是否包含指定企鹅
 * @author y
 *
 */
public class NewPenguin {
private String name;
private String sex;
public NewPenguin() {
	
}
public NewPenguin(String name,String sex) {
	this.name = name;
	this.sex = sex;
}

public void setName(String name) {
	this.name = name;
}
public String getName() {
	return name;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getSex() {
	return sex;
}
public String toString() {
	return getName() + "\t" + getSex() + "\n" ;
}

}
