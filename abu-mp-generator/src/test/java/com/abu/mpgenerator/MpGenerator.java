package com.abu.mpgenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;

import java.util.ArrayList;
import java.util.List;

import static com.baomidou.mybatisplus.generator.config.rules.NamingStrategy.underline_to_camel;

public class MpGenerator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();
//        设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/leyou?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai")
                .setUsername("root")
                .setPassword("kang123");
        autoGenerator.setDataSource(dsc);

        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java")
                .setAuthor("阿布")
                .setIdType(IdType.ASSIGN_ID)        //设置id主键类型
                .setDateType(DateType.ONLY_DATE)
                .setOpen(false)
                .setControllerName("%sController")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setBaseResultMap(true);
//                .setSwagger2(true);       //开启设置swagger2
        autoGenerator.setGlobalConfig(gc);


        PackageConfig pc = new PackageConfig();
        pc.setParent("com.abu")
                .setEntity("pojo")
                .setService("service")
                .setController("controller")
                .setModuleName("leyou")
                .setXml("mapper.leyou");
        autoGenerator.setPackageInfo(pc);

        StrategyConfig sc = new StrategyConfig();
//        List<TableFill> tableFillList = new ArrayList<>();
//        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
//        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
//        tableFillList.add(createTime);
//        tableFillList.add(updateTime);
        sc.setInclude("tb_brand", "tb_order")
                .setTablePrefix("tb_")        //去掉表的前缀
//                .setLogicDeleteFieldName("deleted")       //逻辑删除
//                .setVersionFieldName("version")       //乐观锁机制
//                .setTableFillList(tableFillList)      //自动填充更新插入时间
                .setEntityBooleanColumnRemoveIsPrefix(true)
                .setNaming(underline_to_camel)
                .setColumnNaming(underline_to_camel)
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)
                .setEntityLombokModel(true);
        autoGenerator.setStrategy(sc);

        autoGenerator.execute();
    }
}
