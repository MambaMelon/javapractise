import com.sun.corba.se.pept.transport.InboundConnectionCache;

/**
 * Created by admin on 2017/11/6.
 * 1.命令模式把一个请求或者操作封装到一个对象中。命令模式的优点：更松散的耦合、更动态
 * 的控制、很自然的复合命令以及更好的扩展性
 *
 * 2.客户端角色：创建一个具体命令对象并确定其接收者
 * 3.命令角色：声明了一个给所有具体命令类的抽象接口
 * 4.具体命令角色：实现execute()
 * 5.请求者角色：负责调用命令对象执行请求，相关的方法叫做行动方法
 * 6.接收者角色：负责具体实施和执行一个请求。任何一个类都可以成为接收者。实施和执行请求的方法
 * 叫做行动方法
 */

class Receiver {
    public void action(){
        System.out.println("执行操作");
    }
}

interface Command {
    void execute();
}

//具体命令角色类
class ConcreteCommand implements Command {

    private Receiver receiver = null;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //通常会转调接收者对象的相应方法，让接收者来执行真正的功能
        receiver.action();
    }
}

//请求者角色类
class Invoker {
    private Command command = null;

    public Invoker(Command command){
        this.command = command;
    }

    public void action(){
        command.execute();
    }
}

public class MingLing {

    public static void main(String[] args){
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
