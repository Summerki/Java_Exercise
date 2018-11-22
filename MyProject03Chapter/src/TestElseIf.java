/**
 * 测试if-else
 * @author summerki
 */

public class TestElseIf {
    public static void main(String[] args) {
        double r = 4 * Math.random();

        double area = Math.PI * Math.pow(r, 2);
        double circle = Math.PI * 2 * r;
        System.out.println("半径为：" + r);
        System.out.println("面积为：" + area);
        System.out.println("周长为：" + circle);

        if(area > circle){
            System.out.println("面积大于周长");
        }else{
            System.out.println("周长大于面积");
        }
    }
}
