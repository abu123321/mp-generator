package com.abu.mpgenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.baomidou.mybatisplus.generator.config.rules.NamingStrategy.underline_to_camel;

@SpringBootTest
public class MpGenerator01 {
    @Test
    void name() {
        AutoGenerator autoGenerator = new AutoGenerator();
//        设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/mp?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC")
                .setUsername("root")
                .setPassword("kang123");
        autoGenerator.setDataSource(dsc);

        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java")
                .setAuthor("阿布")
                .setDateType(DateType.ONLY_DATE)
                .setOpen(false)
                .setControllerName("%sController")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setSwagger2(true)
                .setFileOverride(false);
        autoGenerator.setGlobalConfig(gc);


        PackageConfig pc = new PackageConfig();
        pc.setParent("com.abu")
                .setEntity("pojo")
                .setService("service")
                .setServiceImpl("serviceImpl")
                .setController("controller")
                .setModuleName("ums")
                .setXml("mapper.ums");
        autoGenerator.setPackageInfo(pc);

        StrategyConfig sc = new StrategyConfig();
        List<TableFill> tableFillList = new ArrayList<>();
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        tableFillList.add(createTime);
        tableFillList.add(updateTime);
        sc.setInclude("tbl_employee")
                .setTablePrefix("tbl_")        //去掉表的前缀
                .setLogicDeleteFieldName("deleted")
                .setVersionFieldName("version")
                .setTableFillList(tableFillList)
                .setEntityBooleanColumnRemoveIsPrefix(true)
                .setEntityTableFieldAnnotationEnable(true)
                .setNaming(underline_to_camel)
                .setColumnNaming(underline_to_camel)
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)
                .setEntityLombokModel(true);
        autoGenerator.setStrategy(sc);

        autoGenerator.execute();
    }
}
