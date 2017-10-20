/**
 * Created by Melon on 2017/10/20.
 * 1.适配器模式把一个类的接口变换成客户端所期待的另一种接口，
 * 从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作
 *
 * 2.适配器模式分为类的适配器模式和对象的适配器模式
 *
 * 3.目标角色，源角色（Adapee）以及适配器角色（Adaper）
 */

interface Target{
    public void sampleOperation1();
    public void sampleOperation2();
}

class Adaptee{
    public void sampleOperation1(){
        System.out.println("方法1");
    }
}

/** 对象适配器模式start **/
class Adapter extends Adaptee implements Target{

    @Override
    public void sampleOperation2() {
        System.out.println("方法2");
    }
}
/** 对象适配器模式end **/

/** 类适配器start **/
class AdapterWrapper{
    private Adaptee adaptee;
    public AdapterWrapper(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    public void sampleOperation1(){
        this.adaptee.sampleOperation1();
    }
    public void sampleOperation2(){
        System.out.println("方法2");
    }
}
/** 类适配器end **/

public class ShiPeiQi {

}
