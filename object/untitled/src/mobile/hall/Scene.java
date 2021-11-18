package mobile.hall;
/**
 * 使用场景
 * @author y
 *
 */
public class Scene {
String type;
int data;
String description;
int talkTime;
public Scene(String type,int data,String description,int talkTime) {
	this.type = type;
	this.data = data;
	this.description = description;
	this.talkTime = talkTime;
}

public Scene() {
	
}
}
