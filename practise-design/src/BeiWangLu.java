/**
 * Created by admin on 2017/11/6.
 * 1.备忘录对象是一个用来存储另外一个对象内部状态的快照的对象。备忘录模式的用意是在不破坏封装的条件下，
 * 将一个对象的状态捕捉(Capture)住，并外部化，存储起来，从而可以在将来合适的时候把这个对象还原到存储起来的状态。
 *
 * 2.备忘录角色：可以根据发起人对象的判断来决定存储多少发起人对象的内部状态。备忘录可以保护其内容不被发起人
 * 对象之外的任何对象所读取。
 * 注：备忘录有两个等效的接口：
 * 窄接口：负责人（Caretaker）对象（和其他除发起人对象之外的任何对象）看到的是备忘录的窄接口(narrow interface)，
 * 这个窄接口只允许它把备忘录对象传给其他的对象。
 * 宽接口：与负责人对象看到的窄接口相反的是，发起人对象可以看到一个宽接口(wide interface)，这个宽接口允许它读取
 * 所有的数据，以便根据这些数据恢复这个发起人对象的内部状态。
 * 3.发起人角色：创建一个含有当前的内部状态的备忘录对象；使用备忘录对象存储其内部状态
 * 4.负责人角色：负责保存备忘录对象；不检查备忘录对象的内容
 */

//备忘录角色
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

//发起人角色
class Originator {
    private String state;
    //返回备忘录对象
    public Memento cretaeMemento(){
        return new Memento(state);
    }
    //将发起人恢复到备忘录对象所记载的状态
    public void restoreMemento(Memento memento){
        this.state = memento.getState();
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
        System.out.println("当前状态：" + this.state);
    }
}

//负责人角色负责保存备忘录对象
class Caretaker{
    private Memento memento;

    public Memento retrieveMemento(){
        return this.memento;
    }

    public void saveMemento(Memento memento){
        this.memento = memento;
    }
}
public class BeiWangLu {

    public static void main(String[] args){
        Originator o = new Originator();
        Caretaker c = new Caretaker();
        o.setState("ON");
        c.saveMemento(o.cretaeMemento());
        o.setState("OFF");
        o.restoreMemento(c.retrieveMemento());
        System.out.println(o.getState());
    }
}
