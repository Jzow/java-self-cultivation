package com.jameszow.abstrractfactory;

/**
 *
 * @author James Zow
 * @create 2022/9/8
 */
public class AbstractFactory {

    interface CpuCheck{};

    class Intel implements CpuCheck{};
    class MacM1 implements CpuCheck{};

    interface Cpu {
        CpuCheck getCpu();
    }

    class Windows implements Cpu {

        @Override
        public CpuCheck getCpu() {
            return new Intel();
        }
    }

    class MacOs implements Cpu {

        @Override
        public CpuCheck getCpu() {
            return new MacM1();
        }
    }

    protected void CheckAllCpu() {
        CpuCheck cpuCheck = new Windows().getCpu();
        cpuCheck = new MacOs().getCpu();
    }

    public static void main(String[] args) {
        AbstractFactory object = new AbstractFactory();
        object.CheckAllCpu();
    }
}
