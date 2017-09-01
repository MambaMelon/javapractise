/**
 * Created by Melon on 2017/8/31.
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
