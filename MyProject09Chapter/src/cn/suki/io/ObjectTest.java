package cn.suki.io;

import java.io.*;
import java.util.Date;

/**
 * @author Summerki
 */
public class ObjectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 写出---->序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(baos));
        // 操作数据类型 + 数据
        dos.writeUTF("编码辛酸泪");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        // 对象
        dos.writeObject("谁解其中泪");
        dos.writeObject(new Date());
        Employee emp = new Employee("马云",400);
        dos.writeObject(emp);
        dos.flush();
        byte[] datas = baos.toByteArray();
        System.out.println(datas.length);
        // 读取---->反序列化
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        // 顺序与写出一致
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        System.out.println(flag);
        Object str = dis.readObject();
        Object date = dis.readObject();
        Object employee = dis.readObject();
        System.out.println(employee);

        if(str instanceof String){
            String strObj = (String)str;
            System.out.println(strObj);
        }
    }


}
class Employee implements java.io.Serializable{
    private transient String name;//该数据不需要序列化，transient关键字使序列化不会保留相关信息
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
