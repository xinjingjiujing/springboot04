package com.lanou;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.sql.Types;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: 段小威
 * @CreateTime: 2023/5/8
 */
public class MyBatisPlusGenerator2 {
   static DataSourceConfig.Builder builder =
            new DataSourceConfig
                    .Builder("jdbc:mysql://localhost:3306/xysf","root","1234")
                    .dbQuery(new MySqlQuery());

    public static void main(String[] args) {
        FastAutoGenerator.create(builder)
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称？")).fileOverride())
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名？")))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder().enableRestStyle().
                        enableHyphenStyle().entityBuilder().
                        enableLombok().
                        addTableFills(new Column("create_time", FieldFill.INSERT)).build())
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
