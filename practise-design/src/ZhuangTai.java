import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/11/7.
 * 1.状态模式又称状态对象模式，允许一个对象在其内部状态改变的时候改变
 * 其行为。这个对象看上去就像改变了它的类一样。
 *
 * 2.状态模式的意图是让一个对象在内部改变的时候，其行为也随之改变。
 *
 * 3.环境角色：定义客户端所感兴趣的接口，并且保留一个具体状态类的实例
 * 4.抽象状态角色：封装环境对象的一个特定的状态所对应的行为
 * 5.具体状态角色：每一个具体状态类都实现了环境的一个状态所对应的行为
 *
 */

//抽象状态类
interface VoteState {
    void vote(String user, String voteItem, VoteManager voteManager);
}

//具体状态类-正常投票
class NormalVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        voteManager.getMapVote().put(user, voteItem);
        System.out.println("恭喜投票成功");
    }
}
//具体状态类-重复投票
class RepeatVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //重复投票，暂时不做处理
        System.out.println("请不要重复投票");
    }
}

//具体状态类-恶意刷票
class SpiteVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        // 恶意投票，取消用户的投票资格，并取消投票记录
        String str = voteManager.getMapVote().get(user);
        if(str != null){
            voteManager.getMapVote().remove(user);
        }
        System.out.println("你有恶意刷屏行为，取消投票资格");
    }
}
//具体状态类-黑名单
class BlackVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //记录黑名单中，禁止登录系统
        System.out.println("进入黑名单，将禁止登录和使用本系统");
    }
}

//环境类
class VoteManager {
    private VoteState state = null;
    //用户投票结果
    private Map<String, String> mapVote = new HashMap<String, String>();
    //用户投票次数
    private Map<String, Integer> mapVoteCount = new HashMap<String, Integer>();

    //获取投票结果
    public Map<String, String> getMapVote() {
        return mapVote;
    }

    //投票动作---投票人以及投票选项
    public void vote(String user,String voteItem){
        //1.为该用户增加投票次数
        //从记录中取出该用户已有的投票次数
        Integer oldVoteCount = mapVoteCount.get(user);
        if(oldVoteCount == null){
            oldVoteCount = 0;
        }
        oldVoteCount += 1;
        mapVoteCount.put(user, oldVoteCount);
        //2.判断该用户的投票类型，就相当于判断对应的状态
        //到底是正常投票、重复投票、恶意投票还是上黑名单的状态
        if(oldVoteCount == 1){
            state = new NormalVoteState();
        }
        else if(oldVoteCount > 1 && oldVoteCount < 5){
            state = new RepeatVoteState();
        }
        else if(oldVoteCount >= 5 && oldVoteCount <8){
            state = new SpiteVoteState();
        }
        else if(oldVoteCount > 8){
            state = new BlackVoteState();
        }
        //然后转调状态对象来进行相应的操作
        state.vote(user, voteItem, this);
    }
}


public class ZhuangTai {

    public static void main(String[] args){

        VoteManager vm = new VoteManager();
            for(int i=0;i<9;i++){
                vm.vote("u1","A");
        }
    }
}
