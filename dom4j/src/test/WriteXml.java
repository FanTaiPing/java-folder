package test;

import entity.Emp;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author y
 */
public class WriteXml {
    public static void main(String[] args){
        try{
            List<Emp> list = new ArrayList<Emp>();
            list.add(new Emp(1,"唐三",25,"男",8000));
            list.add(new Emp(2,"小舞",25,"女",7000));
            list.add(new Emp(3,"奥斯卡",25,"男",6000));
            list.add(new Emp(4,"戴沐白",25,"男",7000));
            list.add(new Emp(5,"朱竹清",25,"女",6000));
            Document doc = DocumentHelper.createDocument();
            //生成根元素
            Element root = doc.addElement("list");
            for (Emp emp : list){
                //根标签下添加子标签
                Element empEle = root.addElement("emp");
                //向emp标签中添加子标签name
                Element nameEle = empEle.addElement("name");
                //标签赋值
                nameEle.addText(emp.getName());
                Element ageEle = empEle.addElement("age");
                ageEle.addText(emp.getAge()+"");
                Element genderEle = empEle.addElement("gender");
                genderEle.addText(emp.getGender());
                Element salaryEle = empEle.addElement("salary");
                salaryEle.addText(emp.getSalary()+"");

                //添加属性
                empEle.addAttribute("id",emp.getId()+"");
            }
            org.dom4j.io.XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());
            /**
             * 项文件myemp.xml中写入数据
             */
            FileOutputStream fos = new FileOutputStream("myemp.xml");
            writer.setOutputStream(fos);
            writer.write(doc);
            writer.close();
        } catch(Exception e){
            System.out.print(e.toString());
        }
    }
}
