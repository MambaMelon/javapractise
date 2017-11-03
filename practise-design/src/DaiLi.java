/**
 * Created by admin on 2017/11/3.
 * 1.代理模式给某一个对象提供一个代理对象，并由代理对象控制原对象的引用
 *
 * 2.代理对象可以在客户端和目标对象之间起到中介的作用
 */


//抽象对象角色
abstract class AbstractObject {
    public abstract void operation();
}

//目标对象角色
class RealObject extends AbstractObject{

    @Override
    public void operation() {
        //一些操作
        System.out.println("一些操作");
    }
}

class ProxyObject extends AbstractObject{

    RealObject realObject = new RealObject();

    @Override
    public void operation() {
        System.out.println("before");
        realObject.operation();
        System.out.println("after");
    }
}

public class DaiLi {
    public static void main(String[] args){
        AbstractObject obj = new ProxyObject();
        obj.operation();
    }
}



