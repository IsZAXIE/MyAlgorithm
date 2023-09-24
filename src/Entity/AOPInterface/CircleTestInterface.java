package Entity.AOPInterface;

import Entity.MyException.TestException;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

/**
 * @author ZAXIE
 * @date 2023/9/9 16:56
 */
public interface CircleTestInterface {

    Integer times = 20;

    // there should have a lock
    default void test() throws TestException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        Boolean flag = true;
        for (int i = 0; i < times; i++) {
            Thread thread = new Thread(new Runnable() {

                Boolean sharedFlag;

                public void setSharedFlag(Boolean flag) {
                    sharedFlag = flag;
                }

                @Override
                public void run() {

                    sharedFlag = eachTest() && sharedFlag;
                    if (!sharedFlag) {
                        System.err.println("o.O error");
                        throw new RuntimeException("O.o test failed! o.O");
                    }
                }
            });

            thread.start();

        }
        try {
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main End");
    }

    default boolean eachTest() {
        return true;
    }
}
