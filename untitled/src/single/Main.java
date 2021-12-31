package single;

import java.io.File;

public class Main {
    public static void main(String[] args){
        File file = new File("d:/study/");
        String[] list = file.list();
        for(String dec : list){
            System.out.println(dec);
        }
    }
}
