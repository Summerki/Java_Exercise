package com.suki.rhino;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;

/**
 * 测试脚本引擎执行javascript代码
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        // 获取脚本引擎的对象
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

        // 定义变量，存储到引擎的上下文中
        engine.put("msg", "xiaohu");
        String str = "var user = {name:'xiaohu',age:18,schools:['清华大学','中南大学']};";
        str += "print(user.name);"; // 我的例子上println是不行的；print可以用

        // 执行脚本
        engine.eval(str);

        engine.eval("msg = 'sxt';");
        System.out.println(engine.get("msg"));
        System.out.println("####分隔符####");
        // 定义函数
        engine.eval("function add(a,b){var sum = a + b;return sum;}");
        // 取得调用的接口
        Invocable jsInvoke = (Invocable) engine;
        // 执行脚本中定义的方法
        Object result = jsInvoke.invokeFunction("add", new Object[]{13, 20});
        System.out.println(result);

        // 导入其他java包，使用其他包中的java类
//        String jsCode = "importPackage(java.util); var list = Arrays.asList([\"中南大学\", \"清华大学\"]);";
//        engine.eval(jsCode);
//
//        List<String> list2 = (List<String>) engine.get("list");
//        for(String temp : list2){
//            System.out.println(temp);
//        }

        // 执行一个js文件(将a.js置于项目的src下即可)
        URL url = Demo01.class.getClassLoader().getResource("a.js");
        FileReader fr = new FileReader(url.getPath());
        engine.eval(fr);
        fr.close();
    }
}

