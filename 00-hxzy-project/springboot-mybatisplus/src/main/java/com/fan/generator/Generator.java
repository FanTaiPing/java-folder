package com.fan.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Generator {

    // 创建一个 代码自动生成器对象
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        //1. 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");//获取当前的文件路径
        gc.setOutputDir(projectPath + "/src/main/java");  //设置输出文件路径
        gc.setAuthor("ftp"); //设置作者注解
        gc.setOpen(false);   //是否打开资源管理器
        gc.setFileOverride(false);  //是否覆盖原来生成的
        gc.setServiceName("%sService");  //去service的I前缀
        gc.setIdType(IdType.ID_WORKER);  //设置全局的ID生成策略。
        gc.setDateType(DateType.ONLY_DATE);  //设置全局的时间类型
        gc.setSwagger2(false);   //设置是否开启swagger
        mpg.setGlobalConfig(gc);


        //2. 设置数据源，自动生成代码会根据该配置查找数据表
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/hxzy?useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);


        //3. 包的配置
        PackageConfig pc = new PackageConfig();
//       pc.setModuleName("mybatis");   //设置模块，也就是跟路径下，是否创建一个模块的文件夹，多用于多数据源和库的情况
        pc.setParent("com.fan");   //设置跟路径
        pc.setEntity("entity"); //设置实体类的包名
        pc.setMapper("mapper");  //设置mapper的包名  xml文件也会在该路径下
        pc.setService("service.impl");  //设置service的包名
        pc.setController("controller");  //设置controller的包名
        mpg.setPackageInfo(pc);


        //4. 策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("pms_product_category");  //设置要映射生成的表名，可以是多个
        sc.setNaming(NamingStrategy.underline_to_camel);   //设置名称为下划线转大写的驼峰写法
        sc.setColumnNaming(NamingStrategy.underline_to_camel);  //设置字段的也是驼峰写法
        sc.setEntityLombokModel(true);  //自动设置lombok注解
        sc.setLogicDeleteFieldName("is_delete");   //设置逻辑删除字段名

        sc.setVersionFieldName("version");  //设置乐观锁机制

        // 设置自动填充字段，例如更新时间、创建时间
      /* TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
       TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
       ArrayList<TableFill> list = new ArrayList<>();
       list.add(createTime);
       list.add(updateTime);
       sc.setTableFillList(list);*/

        sc.setRestControllerStyle(true);   //是否开启restful风格的controller
        sc.setControllerMappingHyphenStyle(true);  //是否开启下划线的URL
        mpg.setStrategy(sc);


        mpg.execute(); //执行生成
    }
}
