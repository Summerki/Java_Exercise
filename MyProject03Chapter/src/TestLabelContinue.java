/**
 * 测试带标签的continue语句
 * @author summerki
 */

public class TestLabelContinue {
    public static void main(String[] args) {
        // 打印101-150之间的所有质数
        outer:for(int i = 101; i < 150; i++){
                for(int j = 2; j < i / 2; j++){
                    if(i % j == 0){
                        continue outer;// 本来continue只会跳转到里层的for循环，现在可以直接跳到外层
                    }
                }
            System.out.println(i + "、 ");
        }
    }
}
