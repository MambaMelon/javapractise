import java.util.HashMap;
import java.util.Map;

/**
 * Created by Melon on 2017/10/16.
 * 1.原型模式：实现一个克隆自身的接口，无须通过new实现
 * 2.两种形式：简单形式；登记形式（多了一个原型管理器角色，该角色被用来创建具体原型类的对象，
 * 并记录每一个被创建的对象）
 * 3.角色：客户角色，抽象原型角色以及具体原型角色
 */

//抽象原型角色
interface Prototype{
    public Prototype clone();
    public String getName();
    public void setName(String name);
}

//具体原型角色1
class ConcretePrototype1 implements Prototype{

    private String name;
    @Override
    public Prototype clone() {
        ConcretePrototype1 prototype = new ConcretePrototype1();
        prototype.setName(this.name);
        return prototype;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Now in Prototype1, name = " + this.name;
    }
}

//具体原型角色2
class ConcretePrototype2 implements Prototype{

    private String name;
    @Override
    public Prototype clone() {
        ConcretePrototype2 prototype = new ConcretePrototype2();
        prototype.setName(this.name);
        return prototype;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Now in Prototype2, name = " + this.name;
    }
}

//原型管理器角色
class PrototypeManager{
    /**
     * 用来记录原型的编号和原型实例的对应关系
     */
    private static Map<String,Prototype> map = new HashMap<String,Prototype>();
    /**
     * 私有化构造方法，避免外部创建实例
     */
    private PrototypeManager(){}
    /**
     * 向原型管理器里面添加或是修改某个原型注册
     * @param prototypeId 原型编号
     * @param prototype    原型实例
     */
    public synchronized static void setPrototype(String prototypeId , Prototype prototype){
        map.put(prototypeId, prototype);
    }
    /**
     * 从原型管理器里面删除某个原型注册
     * @param prototypeId 原型编号
     */
    public synchronized static void removePrototype(String prototypeId){
        map.remove(prototypeId);
    }
    /**
     * 获取某个原型编号对应的原型实例
     * @param prototypeId    原型编号
     * @return    原型编号对应的原型实例
     * @throws Exception    如果原型编号对应的实例不存在，则抛出异常
     */
    public synchronized static Prototype getPrototype(String prototypeId) throws Exception{
        Prototype prototype = map.get(prototypeId);
        if(prototype == null){
            throw new Exception("您希望获取的原型还没有注册或已被销毁");
        }
        return prototype;
    }
}
public class YuanXing {
    public static void main(String[]args){
        try{
            Prototype p1 = new ConcretePrototype1();
            PrototypeManager.setPrototype("p1", p1);
            //获取原型来创建对象
            Prototype p3 = PrototypeManager.getPrototype("p1").clone();
            p3.setName("张三");
            System.out.println("第一个实例：" + p3);
            //有人动态的切换了实现
            Prototype p2 = new ConcretePrototype2();
            PrototypeManager.setPrototype("p1", p2);
            //重新获取原型来创建对象
            Prototype p4 = PrototypeManager.getPrototype("p1").clone();
            p4.setName("李四");
            System.out.println("第二个实例：" + p4);
            //有人注销了这个原型
            PrototypeManager.removePrototype("p1");
            //再次获取原型来创建对象
            Prototype p5 = PrototypeManager.getPrototype("p1").clone();
            p5.setName("王五");
            System.out.println("第三个实例：" + p5);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
