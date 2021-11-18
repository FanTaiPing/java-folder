package entity;
/**
 * 员工类
 * @author y
 *
 */
public class Epet {
private int id;
private String name;
private String birthday;
private double salary;//员工薪水
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
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Epet [id=" + id + ", name=" + name + ", birthday=" + birthday + ", salary=" + salary + "]";
}


}
