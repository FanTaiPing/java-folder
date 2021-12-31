package single;

public class TestSingle {
    public static void main(String[] args) {
        Single single = Single.getInstance();
        single.getMsg();
        single.showMessage();
    }
}
