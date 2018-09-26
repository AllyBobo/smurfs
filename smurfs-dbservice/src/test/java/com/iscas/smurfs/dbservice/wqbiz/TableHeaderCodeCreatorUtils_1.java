package com.iscas.smurfs.dbservice.wqbiz;


import com.iscas.smurfs.dbservice.entity.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 代码生成器工具类
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2018/7/25 17:11
 * @since jdk1.8
 */
public class TableHeaderCodeCreatorUtils_1 {
    private static String upperFist(String str){
        if(str == null){
            throw new RuntimeException("str can not be null");
        }
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
    private static String lowerFist(String str){
        if(str == null){
            throw new RuntimeException("str can not be null");
        }
        return str.substring(0,1).toLowerCase() + str.substring(1);
    }

    /**
     * 获取本地和父类的所有属性名称
     * @version 1.0
     * @since jdk1.8
     * @date 2018/7/25
     * @param clazz Class类型
     * @return java.util.List<java.lang.String>
     */
    private static List<String> getAllFieldNames(Class clazz){

        List<String> fields = new ArrayList<>();
        getFieldNames(fields, clazz);
        return fields;
    }
    private static void getFieldNames(List<String> fields, Class clazz){
        if(clazz != Object.class){
            Field[] declaredFields = clazz.getDeclaredFields();
            if(declaredFields != null){
                for (Field field : declaredFields) {
                    String name = field.getName();
                    fields.add(name);
                }
            }
            getFieldNames(fields, clazz.getSuperclass());
        }
    }


    /**改一下apache的collectionUtils到本地*/
    private static boolean  isEmpty(Collection c){
        return c == null || c.isEmpty();
    }

    private TableHeaderCodeCreatorUtils_1(){}

    /**
     * 生成表头信息到JSON文件
     *
     * @version 1.0
     * @since jdk1.8
     * @date 2018/7/25
     * @param clazzs 实体类集合
     * @param targetDir 目标路 最好写个径绝对路径
     * @throws FileNotFoundException
     * @return void
     */
    public static  void create(List<Class> clazzs, String targetDir) throws FileNotFoundException {

        for (Class clazz : clazzs) {
            create(clazz,targetDir);
        }
    }

    /**
     * 生成表头信息到JSON文件
     *
     * @version 1.0
     * @since jdk1.8
     * @date 2018/7/25
     * @param clazz 实体类
     * @param targetDir 目标路 最好写个径绝对路径
     * @throws FileNotFoundException
     * @return void
     */
    public static <T> void create(Class<T> clazz,  String targetDir) throws FileNotFoundException {
//        String packageRealPath = ScannerUtils.getPackageRealPath(packageName);

        File parentFile = new File(targetDir);
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        //创建tableInfo
        createTableInfo(clazz,  parentFile);
    }

    private static <T> void createTableInfo(Class<T> clazz,  File parentFile) throws FileNotFoundException {
        String changeLine = System.getProperty("line.separator");
        File file = new File(parentFile, "tableInfo");
        if(!file.exists()){
            file.mkdirs();
        }

        File reFile = new File(file, upperFist(clazz.getSimpleName()) + ".json");
        if(reFile.exists()){
            throw new RuntimeException(reFile.getAbsolutePath() + "已经存在,无法创建");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{\"cols\": ").append(changeLine);
        sb.append("[").append(changeLine);
        List<String> fields = getAllFieldNames(clazz);
        sb.append("\t").append("{").append(changeLine);
        sb.append("\t").append("\"field\": \"").append("no").append("\"").append(",").append(changeLine);
        sb.append("\t").append("\"header\": \"").append("no").append("\"").append(",").append(changeLine);
        sb.append("\t").append("\"editable\": ").append(false).append(",").append(changeLine);
        sb.append("\t").append("\"addable\": ").append(false).append(",").append(changeLine);
        sb.append("\t").append("\"sortable\": ").append(false).append(",").append(changeLine);
        sb.append("\t").append("\"search\": ").append(false).append(",").append(changeLine);
        sb.append("\t").append("\"link\": ").append(false).append(",").append(changeLine);
        sb.append("\t").append("\"type\": ").append("\"text\"").append(changeLine);
        sb.append("\t").append("\t").append("}").append(",").append(changeLine);
        if(!isEmpty(fields)){
            int i = 0;
            for (String name : fields) {
                if(i++ != 0){
                    sb.append("\t").append(",").append(changeLine);
                }
                sb.append("\t").append("{").append(changeLine);
                sb.append("\t").append("\"field\": \"").append(name).append("\"").append(",").append(changeLine);
                sb.append("\t").append("\"header\": \"").append(name).append("\"").append(",").append(changeLine);
                sb.append("\t").append("\"editable\": ").append(true).append(",").append(changeLine);
                sb.append("\t").append("\"addable\": ").append(true).append(",").append(changeLine);
                sb.append("\t").append("\"sortable\": ").append(false).append(",").append(changeLine);
                sb.append("\t").append("\"search\": ").append(false).append(",").append(changeLine);
                sb.append("\t").append("\"link\": ").append(false).append(",").append(changeLine);
                sb.append("\t").append("\"type\": ").append("\"text\"").append(changeLine);
                sb.append("\t").append("\t").append("}").append(changeLine);
            }
        }
        sb.append("]").append(changeLine);
        sb.append(",").append(changeLine);
        sb.append("\"setting\": ").append("{").append(changeLine);
        sb.append("\t").append("\"viewType\": ").append("\"multi\"").append(",").append(changeLine);
        sb.append("\t").append("\"checkbox\": ").append(true).append(",").append(changeLine);
        sb.append("\t").append("\"frontInfo\": ").append("\"\"").append(",").append(changeLine);
        sb.append("\t").append("\"backInfo\": ").append("\"\"").append(",").append(changeLine);
        sb.append("\t").append("\"title\": ").append("\"\"").append(changeLine);
        sb.append("}");
        sb.append("}");
        try(
                PrintWriter pw = new PrintWriter(new FileOutputStream(reFile, true));
        ){
            pw.println(sb.toString());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //targetDir 目标路径文件夹，会在此路径内生成一个tableInfo文件夹，Json文件在其中

//        create(User.class, "E:");
        //create(Users.class,"C:\\Users\\123\\Documents");
        create(Group.class,"C:\\Users\\123\\Documents");
        create(Fund.class,"C:\\Users\\123\\Documents");
        create(Facility.class,"C:\\Users\\123\\Documents");
        create(Base.class,"C:\\Users\\123\\Documents");
        create(Datasatellite.class,"C:\\Users\\123\\Documents");
        create(Dataaircraft.class,"C:\\Users\\123\\Documents");
    }

}
