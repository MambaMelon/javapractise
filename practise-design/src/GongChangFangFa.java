/**
 * Created by Melon on 2017/10/13.
 */

//CPU产品系列
interface Cpu{
    void calculate();
}
class IntelCpu implements Cpu {

    private int pins = 0;
    public IntelCpu(int pins){
        this.pins = pins;
    }
    @Override
    public void calculate() {
        System.out.println("Intel CPU针脚数：" + pins);
    }
}
class AmdCpu implements Cpu {

    private int pins = 0;
    public AmdCpu(int pins){
        this.pins = pins;
    }
    @Override
    public void calculate() {
        System.out.println("Amd CPU针脚数：" + pins);
    }
}

//主板产品系列
interface Mainboard{
    public void installCPU();
}
class IntelMainboard implements Mainboard{

    private int cpuHoles = 0;
    public IntelMainboard(int cpuHoles){
        this.cpuHoles = cpuHoles;
    }
    @Override
    public void installCPU() {
        System.out.println("Intel主板的CPU槽孔数是：" + cpuHoles);
    }
}
class AmdMainboard implements Mainboard{

    private int cpuHoles = 0;
    public AmdMainboard(int cpuHoles){
        this.cpuHoles = cpuHoles;
    }
    @Override
    public void installCPU() {
        System.out.println("Amd主板的CPU槽孔数是：" + cpuHoles);
    }
}

//CPU工厂
class CpuFactory{

    static Cpu createCpu(int type){
        Cpu cpu = null;
        if(type == 1){
            cpu = new IntelCpu(755);
        }
        if(type == 2){
            cpu = new AmdCpu(938);
        }
        return cpu;
    }
}

//主板工厂
class MainboardFactory{

    static Mainboard createMainboard(int type){
        Mainboard mainboard = null;
        if(type == 1){
            mainboard = new IntelMainboard(755);
        }
        if(type == 2){
            mainboard = new AmdMainboard(938);
        }
        return mainboard;
    }
}

//装机工程师
class ComputerEngineer{
    private Cpu cpu = null;
    private Mainboard mainboard = null;

    public void makeComputer(int cpuType, int mainBoardType){
        this.cpu = CpuFactory.createCpu(cpuType);
        this.mainboard = MainboardFactory.createMainboard(mainBoardType);

        this.cpu.calculate();
        this.mainboard.installCPU();
    }
}

public class GongChangFangFa {
    public static void main(String[] args) {
        ComputerEngineer ce = new ComputerEngineer();
        ce.makeComputer(1,1);
    }

}
