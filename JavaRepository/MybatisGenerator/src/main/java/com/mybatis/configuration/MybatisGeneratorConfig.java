package com.mybatis.configuration;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MybatisGeneratorConfig {
    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        // 读取配置文件
        File file = new File("src/main/resources/generator.xml");

        List <String> warnings = new ArrayList<String>();

        ConfigurationParser configurationParser = new ConfigurationParser(warnings);

        Configuration configuration = configurationParser.parseConfiguration(file);

        DefaultShellCallback callback = new DefaultShellCallback(true);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration,callback, warnings);

        myBatisGenerator.generate(null);
    }
}
