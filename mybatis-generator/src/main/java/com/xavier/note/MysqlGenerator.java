package com.xavier.note;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.mysql.cj.jdbc.Driver;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 代码生成器演示
 *
 * @author hubin
 * @since 2016-12-01
 */
public class MysqlGenerator {

    public static String userName = "root";
    public static String password = "123456";
    public static String driverUrl = "jdbc:mysql://127.0.0.1:3306/my_database?useUnicode=true&allowPublicKeyRetrieval=true"
            + "&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    /**
     * moudle路径
     */
    public static String moduleName = "";
    /**
     * 包路径
     */
    public static String packageName = "com.xavier.note";
    /**
     * 要自动自成的表的名称
     */
    public static String[] tableNames = {"user"};


    /**
     * MySQL 生成演示
     */
    public static void main(String[] args) {
        int result = scanner();
        // 自定义需要填充的字段
//        List<TableFill> tableFillList = new ArrayList<>();
//        tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
                // 全局配置
                new GlobalConfig()
                        //输出目录
                        .setOutputDir("\\..\\spring-boot-note\\mybatis-generator\\src\\main\\java")
                        // 是否覆盖文件
                        .setFileOverride(true)
                        // 开启 activeRecord 模式
                        .setActiveRecord(true)
                        // XML 二级缓存
                        .setEnableCache(false)
                        // XML ResultMap
                        .setBaseResultMap(true)
                        // XML columList
                        .setBaseColumnList(true)
                        //是否生成 kotlin 代码
                        //.setKotlin(true)
                        .setAuthor("wuyanfeng")
                        // 自定义文件命名，注意 %s 会自动填充表实体属性！
                        .setEntityName("%s")
                        .setMapperName("%sMapper")
                        .setXmlName("%sMapper")
                        .setServiceName("%sService")
                        .setServiceImplName("%sServiceImpl")
                        .setControllerName("%sController")
        ).setDataSource(
                // 数据源配置
                new DataSourceConfig()
                        // 数据库类型
                        .setDbType(DbType.MYSQL)
                        .setTypeConvert(new MySqlTypeConvert() {
                            // 自定义数据库表字段类型转换【可选】
                            @Override
                            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                                System.out.println("转换类型：" + fieldType);
                                // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                                //    return DbColumnType.BOOLEAN;
                                // }
                                return super.processTypeConvert(globalConfig, fieldType);
                            }
                        })
                        .setDbQuery(new MySqlQuery() {

                            /**
                             * 重写父类预留查询自定义字段<br>
                             * 这里查询的 SQL 对应父类 tableFieldsSql 的查询字段，默认不能满足你的需求请重写它<br>
                             * 模板中调用：  table.fields 获取所有字段信息，
                             * 然后循环字段获取 field.customMap 从 MAP 中获取注入字段如下  NULL 或者 PRIVILEGES
                             */
                            @Override
                            public String[] fieldCustom() {
                                return new String[]{"NULL", "PRIVILEGES"};
                            }
                        })
                        .setDriverName(Driver.class.getName())
                        .setUsername(userName)
                        .setPassword(password)
                        .setUrl(driverUrl)
        ).setStrategy(
                // 策略配置
                new StrategyConfig()
                        // .setCapitalMode(true)// 全局大写命名
                        // .setDbColumnUnderline(true)//全局下划线命名
                        //.setTablePrefix(new String[]{"bmd_", "mp_"})// 此处可以修改为您的表前缀
                        // 表名生成策略
                        .setNaming(NamingStrategy.underline_to_camel)
                        // 需要生成的表
                        .setInclude(tableNames)
                        // .setExclude(new String[]{"test"}) // 排除生成的表
                        // 自定义实体父类
                        // .setSuperEntityClass("com.baomidou.demo.TestEntity")
                        // 自定义实体，公共字段
//                        .setSuperEntityColumns(new String[]{"test_id"})
//                        .setTableFillList(tableFillList)
                        .setEntityBooleanColumnRemoveIsPrefix(true)
                // 自定义 mapper 父类
                // .setSuperMapperClass("com.baomidou.demo.TestMapper")
                // 自定义 service 父类
                // .setSuperServiceClass("com.baomidou.demo.TestService")
                // 自定义 service 实现类父类
                // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
                // 自定义 controller 父类
                // .setSuperControllerClass("com.baomidou.demo.TestController")
                // 【实体】是否生成字段常量（默认 false）
                // public static final String ID = "test_id";
                // .setEntityColumnConstant(true)
                // 【实体】是否为构建者模型（默认 false）
                // public User setName(String name) {this.name = name; return this;}
                // .setEntityBuilderModel(true)
                // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                // .setEntityLombokModel(true)
                // Boolean类型字段是否移除is前缀处理
                // .setEntityBooleanColumnRemoveIsPrefix(true)
                // .setRestControllerStyle(true)
                // .setControllerMappingHyphenStyle(true)
        ).setPackageInfo(
                // 包配置
                new PackageConfig()
                        .setModuleName(moduleName)
                        // 自定义包路径
                        .setParent(packageName)
                        // 这里是控制器包名，默认 web
                        .setController("controller")
        ).setCfg(
                // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
                new InjectionConfig() {
                    @Override
                    public void initMap() {
                        Map<String, Object> map = new HashMap<>();
                        map.put("abc", this.getConfig().getGlobalConfig().getAuthor());
                        this.setMap(map);
                    }
                }.setFileOutConfigList(Collections.singletonList(new FileOutConfig(
                        "/templates/mapper.xml" + ((1 == result) ? ".ftl" : ".vm")) {
                    // 自定义输出文件目录
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return "../com/xml/" + tableInfo.getEntityName() + ".xml";
                    }
                }))
        ).setTemplate(
                // 关闭默认 xml 生成，调整生成 至 根目录
                new TemplateConfig().setXml(null)
                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                // .setController("...");
                // .setEntity("...");
                // .setMapper("...");
                // .setXml("...");
                // .setService("...");
                // .setServiceImpl("...");
        );
        // 执行生成
        if (1 == result) {
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        }
        mpg.execute();

        // 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }


    /**
     * 读取控制台内容
     */
    public static int scanner() {
        Scanner scanner = new Scanner(System.in);
        String help =
                " ！！代码生成, 输入 0 表示使用 Velocity 引擎 ！！" +
                        "\n对照表：" +
                        "\n0 = Velocity 引擎" +
                        "\n1 = Freemarker 引擎" +
                        "\n请输入：";
        System.out.println(help);
        int slt = 0;
        // 现在有输入数据
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if ("1".equals(ipt)) {
                slt = 1;
            }
        }
        return slt;
    }

}
