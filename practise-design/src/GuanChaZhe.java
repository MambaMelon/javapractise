/**
 * Created by Melon on 2017/8/31.
 * 1.观察者模式定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。
 * 这个主题对象在状态上发生变化时，会通知所有观察者对象，使它们能够自动更新。
 *
 * 2.抽象主题角色：抽象主题角色把所有对观察者对象的引用保存在一个集合里，每个主题
 * 都可以有任何数量的观察者，也可以增加或删除观察者对象。
 * 3.具体主题角色：将有关状态存入具体观察者对象。在具体主题的内部状态改变时，给所有
 * 登记过得观察者发出通知。
 * 4.抽象观察者角色：为所有的具体观察者定义一个接口，在得到主题的通知时更新自己
 * 5.具体观察者
 */

import java.util.Observable;
import java.util.Observer;

/**
 *被观察者
 */
class SimpleObservable extends Observable{
    private int data = 0;

    public int getData(){
        return data;
    }

    public void setData(int data){
        if(this.data != data){
            this.data = data;
            this.setChanged();
            this.notifyObservers();
        }
    }
}

/**
 * 观察者
 */
class SimpleObserver implements Observer{

    public SimpleObserver(SimpleObservable simpleObservable){
        simpleObservable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object data) {
        System.out.println("data has changed to " + ((SimpleObservable)o).getData());
    }
}

public class GuanChaZhe {

    public static void main(String[] args){
        SimpleObservable simpleObservable = new SimpleObservable();
        SimpleObserver simpleObserver = new SimpleObserver(simpleObservable);
        simpleObservable.setData(5);
        simpleObservable.setData(6);
        simpleObservable.setData(7);
    }

}
