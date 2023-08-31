package Entity;

/**
 * @author ZAXIE
 * @date 2023/8/31 08:08
 */
public interface ParentsInterface {

    // implement this interface and Override this method, so you can use AOPTest to test you function.
    default public Object run(){
        return null;
    }
}
