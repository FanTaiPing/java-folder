package test;

import entity.Emp;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author y
 */
public class ReadXml {
    public static List getXml() {
        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read(new File("emp.xml"));
            List<Emp> list = new ArrayList<Emp>();
            /**
             * 解析第一步，获取根标签（根元素）
             * 这里获取的根标签就相当于是<list>...</list>标签
             */
            Element root = doc.getRootElement();
            //获取名为emp的标签
            List<Element> elementList = root.elements("emp");
            //遍历每一个emp标签
            for (Element empEle : elementList) {
                //获取name
                String name = empEle.elementText("name");
                int age = Integer.parseInt(empEle.elementText("age"));
                String gender = empEle.elementText("gender");
                int salary = Integer.parseInt(empEle.elementText("salary"));
                //属性
                Attribute attr = empEle.attribute("id");
                int id = Integer.parseInt(attr.getValue());
                Emp emp = new Emp(id, name, age, gender, salary);
                list.add(emp);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
    public static void main(String[] args){
        List list = ReadXml.getXml();
        System.out.println(list.toString());

    }
}
