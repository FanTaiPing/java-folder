package single;

public class Single {

    String msg;

    static Single instance;
    //使用private 声明，此类之外的类中不可以直接实例化此对象，并且调用
    private Single(){

    }

    public static Single  getInstance(){
        if (instance == null){
            instance = new Single();
        }
        return instance;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void showMessage(){
        System.out.println("Hello World!");
    }
}
