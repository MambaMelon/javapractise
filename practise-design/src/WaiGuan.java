/**
 * Created by Melon on 2017/10/23.
 * 1.门面(Facade)角色 ：客户端可以调用这个角色的方法。此角色知晓相关的（一个或者多个）子系统的功能和责任。
 * 在正常情况下，本角色会将所有从客户端发来的请求委派到相应的子系统去。
 *
 * 2.子系统(SubSystem)角色 ：可以同时有一个或者多个子系统。每个子系统都不是一个单独的类，而是一个类的集合
 * ,如上面的子系统就是由ModuleA、ModuleB、ModuleC三个类组合而成。每个子系统都可以被客户端直接调用，
 * 或者被门面角色调用。子系统并不知道门面的存在，对于子系统而言，门面仅仅是另外一个客户端而已。
 */
public class WaiGuan {

    public class ModuleA {
        //示意方法
        public void testA(){
            System.out.println("调用ModuleA中的testA方法");
        }
    }

    public class ModuleB {
        //示意方法
        public void testB(){
            System.out.println("调用ModuleB中的testB方法");
        }
    }

    public class ModuleC {
        //示意方法
        public void testC(){
            System.out.println("调用ModuleC中的testC方法");
        }
    }

    //门面角色
    public void test(){
        ModuleA a = new ModuleA();
        a.testA();
        ModuleB b = new ModuleB();
        b.testB();
        ModuleC c = new ModuleC();
        c.testC();
    }

    public static void main(String[] args) {

        WaiGuan waiGuan = new WaiGuan();
        waiGuan.test();
    }

}