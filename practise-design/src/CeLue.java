/**
 * Created by admin on 2017/11/7.
 * 1.策略模式属于对象的行为模式，将每一个算法封装到具有共同接口的独立的类
 * 中，从而使算法在不影响客户端的情况下发生变化
 *
 * 2.环境角色：持有一个Strategy的引用
 * 3.抽象策略角色：给出所有的策略类
 * 4.具体策略角色：包装了相关的算法或行为
 */

//抽象折扣类
interface MemberStrategy {
    public double calcPrice(double booksPrice);
}

//初级会员折扣类
class PrimaryMemberStrategy implements MemberStrategy{

    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("初级会员没有折扣");
        return booksPrice;
    }
}

class IntermediateMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("对于中级会员的折扣为10%");
        return booksPrice * 0.9;
    }
}

class AdvancedMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("对于高级会员的折扣为20%");
        return booksPrice * 0.8;
    }
}

class Price {
    private MemberStrategy strategy;

    public Price(MemberStrategy strategy){
        this.strategy = strategy;
    }

    public double quote(double booksPrice){
        return this.strategy.calcPrice(booksPrice);
    }
}
public class CeLue {
    public static void main(String[] args){
        MemberStrategy strategy = new AdvancedMemberStrategy();
        Price price = new Price(strategy);
        double quote = price.quote(300);
        System.out.println("图书价格为：" + quote);
    }


}
