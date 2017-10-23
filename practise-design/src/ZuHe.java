import java.util.ArrayList;
import java.util.List;

/**
 * Created by Melon on 2017/10/23.
 * 1.组合模式使得用户对单个对象和组合对象的使用具有一致性，比如会员卡在总店与分店消费
 */
public class ZuHe {

    public abstract class Market{
        String name;

        public abstract void add(Market m);
        public abstract void remove(Market m);
        public abstract void PayByCard();
    }

    //分店，其下可以还有一级加盟店
    public class MarketBranch extends Market{
        List<Market> list = new ArrayList<ZuHe.Market>();

        public MarketBranch(String name) {
            this.name = name;
        }

        @Override
        public void add(Market m) {
            // TODO Auto-generated method stub
            list.add(m);
        }

        @Override
        public void remove(Market m) {
            // TODO Auto-generated method stub
            list.remove(m);
        }

        //消费之后，积分累计
        @Override
        public void PayByCard() {
            System.out.println(name + "积分已累加");
            for(Market m : list){
                m.PayByCard();
            }
        }

    }

    // 加盟店 下面不在有分店和加盟店，最底层
    public class MarketJoin extends Market {
        public MarketJoin(String s) {
            this.name = s;

        }

        @Override
        public void add(Market m) {
            // TODO Auto-generated method stub

        }

        @Override
        public void remove(Market m) {
            // TODO Auto-generated method stub

        }

        @Override
        public void PayByCard() {
            // TODO Auto-generated method stub
            System.out.println(name + "消费,积分已累加入该会员卡");
        }
    }

    public static void main(String[] args){
        ZuHe demo = new ZuHe();

        MarketBranch rootBranch = demo.new MarketBranch("总店");
        MarketBranch qhdBranch = demo.new MarketBranch("秦皇岛分店");
        MarketJoin hgqJoin = demo.new MarketJoin("秦皇岛分店一海港区加盟店");
        MarketJoin btlJoin = demo.new MarketJoin("秦皇岛分店二白塔岭加盟店");

        qhdBranch.add(hgqJoin);
        qhdBranch.add(btlJoin);
        rootBranch.add(qhdBranch);
        rootBranch.PayByCard();
    }
}


















