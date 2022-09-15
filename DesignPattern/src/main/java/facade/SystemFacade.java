package facade;

/**
 * 系统门面
 *
 * @author James Zow
 * @create 2022/9/15
 */
public class SystemFacade {

    private SystemA systemA = new SystemA();

    private SystemB systemB = new SystemB();

    /**
     * 提供给外部访问的方法
     */
    public void doSomething() {
        systemA.doA();
        systemB.doD();
    }
}
