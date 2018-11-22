/**
 * 测试Switch语句
 * 遇到多值判断的时候，使用switch，当然，switch可以用if-elseif-elseif-else代替
 * @author summerki
 */

public class TestSwitch {
    public static void main(String[] args) {
        int month = 1 + (int)(12 * Math.random());// [1, 12]整数
        System.out.println(month);

        switch (month){
            case 1:
                System.out.println("1月份");
                break;
            case 2:
                System.out.println("2月份");
                break;
            default:
                System.out.println("反正不是1、2月份");
                break;
        }

    }
}
