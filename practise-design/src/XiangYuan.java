import java.util.HashMap;
import java.util.Map;

/**
 * Created by Melon on 2017/10/24.
 * 1.以共享的方式高效的支持大量的细粒度对象，如String
 * 2.享元模式能做到共享的关键是是内蕴状态以及外蕴状态
 * 3.享元模式可以分为单纯享元模式和复合享元模式
 * 4.抽象享元角色：接口
 * 5.具体享元角色:实现
 * 6.享元工厂角色：负责创建和管理享元角色
 */
public class XiangYuan {

    public interface Flyweight{
           public void operation(Character state);
    }

    public class ConcreteFlyweight implements Flyweight{

        private Character intrinsicState = null;

        public ConcreteFlyweight(Character state){
            this.intrinsicState = state;
        }

        @Override
        public void operation(Character state) {
            System.out.println("Intrinsic State = " + this.intrinsicState);
            System.out.println("Extrinsic State = " + state);
        }
    }

    public class FlyweightFactory{
        private Map<Character,Flyweight> files = new HashMap<Character,Flyweight>();

        public Flyweight factory(Character state){
            Flyweight flyweight = files.get(state);
            if(flyweight == null){
                flyweight = new ConcreteFlyweight(state);
                files.put(state, flyweight);
            }
            return flyweight;
        }
    }

    public static void main(String[] args){
        XiangYuan xiangYuan = new XiangYuan();
        XiangYuan.FlyweightFactory factory = xiangYuan.new FlyweightFactory();
        Flyweight fly = factory.factory(new Character('a'));
        fly.operation('a');

        fly = factory.factory(new Character('b'));
        fly.operation('b');

        fly = factory.factory(new Character('a'));
        fly.operation('a');
    }
}
