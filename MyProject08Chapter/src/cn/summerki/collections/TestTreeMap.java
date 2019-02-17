package cn.summerki.collections;

import java.util.Map;
import java.util.TreeMap;

/**
 * 测试TreeMap
 *
 */
public class TestTreeMap {
    public static void main(String[] args) {
        Map<Integer, String> treemap1 = new TreeMap<>();
        treemap1.put(1, "aa");
        treemap1.put(2, "bb");
        treemap1.put(3, "cc");

        // 按照key递增的方向排序
        for(Integer key:treemap1.keySet()){
            System.out.println(key + "---" + treemap1.get(key));
        }


        Map<Emp, String> treemap2 = new TreeMap<>();
        treemap2.put(new Emp(100, "A", 5000), "A同学");
        treemap2.put(new Emp(200, "B", 500), "B同学");
        treemap2.put(new Emp(150, "C", 600), "C同学");

        for(Emp key:treemap2.keySet()){
            System.out.println(key + "---" + treemap2.get(key));
        }
    }
}

class Emp implements Comparable<Emp>{
    int id;
    String name;
    double salary;

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "id:" + this.id + "name:" + this.name + "salary:" + this.salary;
    }

    @Override
    public int compareTo(Emp o) { // 负数:小于; 0:等于; 正数:大于
        if(this.salary > o.salary){
            return 1;
        }else if(this.salary < o.salary){
            return -1;
        }else{
            if(this.id > o.id){
                return 1;
            }
            else if(this.id < o.id){
                return -1;
            }else{
                return 0;
            }
        }
    }
}
