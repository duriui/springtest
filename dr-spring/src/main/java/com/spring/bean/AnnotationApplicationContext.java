package com.spring.bean;

import com.spring.anno.Bean;
import com.spring.anno.Di;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext{

    //创建map集合，存放bean对象
    private  Map<Class,Object> beanFactory = new HashMap<>();
    private static String rootPath;

    // 返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    // 创建有参数构造，传递包路径，设置包扫描规则
    // 当前包及其子包，哪个类有@Bean注解，就把这个类通过反射实例化

    public  AnnotationApplicationContext(String basePackage) throws Exception {

        // org.example
        // 1、把.替换成\    mac中是/
        String packagePath = basePackage.replace(".", "/");;
        //System.out.println(packagePath);

        //2、获得包的绝对路径
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
        //System.out.println(urls.hasMoreElements());

        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            String filePath = URLDecoder.decode(url.getFile(),"utf-8");
            rootPath = filePath.substring(0,filePath.length()-packagePath.length());
            //System.out.println(filePath);
            //System.out.println(rootPath);
            // 包扫描
            loadBean(new File(filePath));
        }


        // 完成属性注入
        loadDi();
    }

    private void loadDi() throws IllegalAccessException {
        // 实例化对象在beanFactory的map集合里面
        // 1、遍历beanFactory的map集合
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for (Map.Entry<Class, Object> entry:entries) {
            // 2、获取map集合每个对象，获取到每个对象的属性
            Object obj = entry.getValue();
            // 获取对象的class
            Class<?> clazz = obj.getClass();
            Field[] declaredFields = clazz.getDeclaredFields();
            // 3、遍历得到每个对象的属性数组，得到每个属性
            for (Field f:declaredFields) {
                Di annotation = f.getAnnotation(Di.class);
                // 4、判断属性上是否存在@Di注解
                if(annotation!=null){
                    // 5、若是私有属性，需要设置f.setAccessible(true);
                    f.setAccessible(true);
                    f.set(obj,beanFactory.get(f.getType()));
                }
            }

        }

    }

    // 包扫描过程，实例化
    private  void loadBean(File file) throws Exception {

        // 1、判断是否文件夹
        if(file.isDirectory()){

            // 2、获取文件夹中所有内容
            File[] childrenFiles = file.listFiles();
            // 3、判断文件夹里面是否为空，若是直接返回
            if(childrenFiles==null || childrenFiles.length==0){
                return;
            }
            // 4、若不为空，遍历文件夹所有内容
            for (File child:childrenFiles) {
                // 4.1、遍历得到每个File对象，继续判断，如果还是文件，则递归
                if(child.isDirectory()){
                    loadBean(child);
                }else{
                    // 4.2、遍历得到File对象是文件
                    // 4.3、得到包路径+类名称部分-字符串截取
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length()-1);
                    //System.out.println(pathWithClass);
                    // 4.4、判断当前文件类型是否为.class
                    if(pathWithClass.contains(".class")){
                        // 4.5、若是，把路径\替换成.，把.class去掉
                        // org.example.service.UserServiceImpl
                        String allName = pathWithClass.replace("/",".").replace(".class","");
                        //System.out.println(allName);
                        String allNamenew = allName.substring(1,allName.length());
                        //System.out.println(allNamenew);
                        // 4.6、判断类上面是否有注解@Bean，若有则实例化过程
                        // 4.6.1、获取类的class
                        Class<?> clazz = Class.forName(allNamenew);
                        // 4.6.2、判断是不是接口
                        if(!clazz.isInterface()){
                            // 4.6.3、判断是否有注解@Bean
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if(annotation!=null){
                                // 4.6.4 实例化
                                Object o = clazz.getConstructor().newInstance();
                                // 4.7、把对象实例化后，存放到map集合beanFactory中
                                // 4.7.1、判断当前类是否有接口，若有，让接口class作为map的key
                                if(clazz.getInterfaces().length>0){
                                    beanFactory.put(clazz.getInterfaces()[0],o);
                                }else {
                                    beanFactory.put(clazz,o);
                                }
                            }
                        }

                    }
                }

            }
        }

    }

//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationApplicationContext("org.example");
//        Object bean = context.getBean();
//    }
//    public static void main(String[] args) throws Exception {
//        AnnotationApplicationContext("org.example");
//    }


}
