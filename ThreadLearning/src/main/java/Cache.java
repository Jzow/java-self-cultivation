import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ClassName: Cache
 * Description: 读写分离 读写锁（读-读能共存，读-写不能共存，写-写不能共存）
 * Author: James Zow
 * Date: 2020/11/15 0015 15:28
 * Version:
 **/
public class Cache {
    private static volatile Map<String, Object> map= new HashMap<String, Object>();

    private static ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();

    private static Lock readLock = reentrantReadWriteLock.readLock();
    private static Lock writeLock =reentrantReadWriteLock.writeLock();
    /**
     * 写
     * @param key
     * @param object
     */
    public static void put(String key, Object object){
        try{
            writeLock.lock();
            System.out.println("正在写入key:"+key+",value:"+object+"开始。。");
            Thread.sleep(100);
            Object obj=map.put(key,object);
            System.out.println("写入key:"+key+",value:"+object+"结束。。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 读
     * @param key
     * @return
     */
    public static Object get(String key){
        try{
            readLock.lock();
            System.out.println("正在读取key:"+key+"开始。。");
            Thread.sleep(100);
            Object obj=map.get(key);
            System.out.println("读取key:"+key+",value:"+obj+"结束。。");
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Cache.put(i+"",i+"");
                }
            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Cache.get(i+""));
                }
            }
        }).start();
    }
}

