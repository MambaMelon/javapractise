/**
 * Created by ThinkPad on 2017/9/3.
 */

abstract class Humburger {
    protected String name;

    public String getName(){
        return name;
    }

    public abstract double getPrice();
}

//被装饰者
class ChickenBurger extends Humburger {
    public ChickenBurger(){
        name = "鸡腿堡";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}

//配料的基类,装饰者
abstract class Condiment extends Humburger {
    public abstract String getName();
}

//配料：生菜
class Lettuce extends Condiment{

    Humburger hum;

    public Lettuce(Humburger hum){
        this.hum = hum;
    }

    @Override
    public String getName() {
        return hum.getName() + "加生菜";
    }

    @Override
    public double getPrice() {
        return hum.getPrice() + 1.5;
    }
}

public class ZhuangShiZhe {

    public static void main(String[] args){
        Humburger hum = new ChickenBurger();
        Lettuce let = new Lettuce(hum);
    }
}
