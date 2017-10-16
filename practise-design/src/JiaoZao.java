/**
 * Created by Melon on 2017/10/16.
 *1.建造模式可以将一个产品的内部表象与产品的生产过程分割开来，
 从而可以使建造过程生成具有不同内部表象的产品对象；

 *2.一个产品由不同的零件组成，这些零件称为产品内部表象；

 *3.一个产品对象创造成功之前，有时有零件限制，即只有该零件创建了，
 产品才算创建完成；

 *4.建造模式有导演者对象、具体建造者对象以及产品角色对象。
 */

//产品类
class Product{
    private String part1;
    private String part2;
    public String getPart1() {
        return part1;
    }
    public void setPart1(String part1) {
        this.part1 = part1;
    }
    public String getPart2() {
        return part2;
    }
    public void setPart2(String part2) {
        this.part2 = part2;
    }
}

//建造类
interface Builder{
    public void buildPart1();
    public void buildPart2();
    public Product retrieveResult();
}
class ConcreteBuilder implements Builder{

    private Product product = new Product();

    @Override
    public void buildPart1() {
        product.setPart1("编号：9572");
    }

    @Override
    public void buildPart2() {
        product.setPart2("名称：零零七");
    }

    @Override
    public Product retrieveResult() {
        return product;
    }
}

//导演者类
class Director{
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }
    /**
     * 产品构造方法，负责调用各个零件建造方法
     */
    public void construct(){
        builder.buildPart1();
        builder.buildPart2();
    }
}

//客户端
public class JiaoZao {
    public static void main(String[] args){
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.retrieveResult();
        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
    }
}
