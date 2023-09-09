package Entity.MyException;

/**
 * @author ZAXIE
 * @date 2023/9/9 17:02
 */
public class TestException extends Exception{
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
