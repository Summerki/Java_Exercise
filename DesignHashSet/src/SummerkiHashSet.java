import java.util.HashMap;

/**
 * 自定义实现一个HashSet
 * @author summerki
 */
public class SummerkiHashSet {
    HashMap map;

    private static final Object PRESENT = new Object();

    public SummerkiHashSet(){
        map = new HashMap();
    }

    public void add(Object o){
        map.put(o, PRESENT);
    }

    public int size(){
        return map.size();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Object key:map.keySet()){
            sb.append(key + ",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        SummerkiHashSet summerkiHashSet = new SummerkiHashSet();

        summerkiHashSet.add("aa");
        summerkiHashSet.add("bb");
        summerkiHashSet.add("aa");

        System.out.println(summerkiHashSet);
    }
}
