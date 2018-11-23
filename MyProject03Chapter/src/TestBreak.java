/**
 * 测试循环语句中的break
 * @author summerki
 */


public class TestBreak {
    public static void main(String[] args) {
        int total = 0;
        System.out.println("Begin");
        while(true){
            total++;
            int i = (int)Math.round(100 * Math.random());
            if(i == 88){
                break;
            }
        }
        System.out.println("Game Over, used " + total + " times.");
    }
}
