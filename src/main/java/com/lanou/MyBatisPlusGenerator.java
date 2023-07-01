package com.lanou;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

/**
 * @Author: 段小威
 * @CreateTime: 2023/5/8
 */
public class MyBatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/xysf", "root", "1234").globalConfig(builder -> {
                    builder.author("段小威") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\咸阳师范\\springboot04\\src\\main\\java"); // 指定输出目录
                }).dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                })).packageConfig(builder -> {
                    builder.parent("com.lanou") // 设置父包名
                            //.moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\咸阳师范\\springboot04\\src\\main\\resources\\mappers")); // 设置mapperXml生成路径
                }).strategyConfig(builder -> {
                    builder.addInclude("user"); // 设置需要生成的表名
                            //.addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
