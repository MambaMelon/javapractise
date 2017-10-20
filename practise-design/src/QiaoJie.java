/**
 * Created by Melon on 2017/10/20.
 * 1.桥接模式即将抽象部分与实现部分分开，使他们都可以独立变化
 *
 * 2.继承关系转化为关联关系，降低了类与类之间的耦合度，减少了
 *
 * 3.抽象类、扩充抽象类、实现类接口以及具体实现类
 */

interface INavigator {
    public void work();
}
class BDNavigator implements INavigator{

    @Override
    public void work() {
        System.out.println("我是北斗导航！");
    }
}
class SXZNavigator implements INavigator{

    @Override
    public void work() {
        System.out.println("我是神行者导航！");
    }

}

abstract class AbstractVehicleBrand{
    public abstract void install(INavigator n);
    public abstract void open();
}

class BMWVehicle extends AbstractVehicleBrand{
    //导航
    INavigator navigator = null;

    @Override
    public void install(INavigator n) {

        navigator = n;
    }

    @Override
    public void open() {
        navigator.work();
    }

}

class BenzVehicle extends AbstractVehicleBrand{
    //导航
    INavigator navigator = null;
    @Override
    public void install(INavigator n) {
        navigator = n;
    }

    @Override
    public void open() {
        navigator.work();
    }

}

public class QiaoJie {
    public static void main(String[] args){
        INavigator bdNavigator = new BDNavigator();
        INavigator sxzNavigator = new SXZNavigator();

        AbstractVehicleBrand bmw = new BMWVehicle();
        bmw.install(bdNavigator);
        bmw.open();

        AbstractVehicleBrand benz = new BMWVehicle();
        benz.install(sxzNavigator);
        benz.open();
    }
}
