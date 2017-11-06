/**
 * Created by admin on 2017/11/6.
 * 1.责任链模式：在该模式里，很多对象由每一个对象对其下架的引用而连接起来
 * 形成一条链。请求在这个链上传递，直到链上的某一个对象决定处理此请求。发出
 * 这个请求的客户端并不知道链上的哪一个对象最终处理这个请求，这使得系统可以在、
 * 不影响客户端的情况下动态地重新组织和分配责任。
 *
 * 2.抽象处理者角色：定义出一个处理请求的接口。如果需要，接口可以定义出一个方法
 * 以设定和返回对下家的引用。
 *
 * 3.具体处理者角色：具体处理者接到其你去后，可以选择将请求处理掉，或者将请求传给
 * 下家。具体处理者持有下家的引用，因此，如果需要，具体处理者可以访问下家。
 */

abstract class Handler {
    //持有后继的责任对象
    protected Handler successor;

    //处理请求的方法
    public abstract void handleRequest();

    public Handler getSuccessor(){
        return successor;
    }

    public void setSuccessor(Handler successor){
        this.successor = successor;
    }
}

class ConcreteHandler extends Handler {

    @Override
    public void handleRequest() {
        if(getSuccessor() != null){
            System.out.println("放过请求");
            getSuccessor().handleRequest();
        } else {
            System.out.println("处理请求");
        }
    }
}

public class ZeRenLian {

    public static void main(String[] args){
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setSuccessor(handler2);
        handler1.handleRequest();
    }
}
