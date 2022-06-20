package com.edu.configruation;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan(basePackages = {"com.edu.dao","com.edu.service"})
@PropertySource(value = "classpath:day04-mybatis-spring/db.properties")
@EnableTransactionManagement
public class AnnoConfiguration {

    @Value("${c3p0.password}")
    private String password;
    @Value("${c3p0.jdbcUrl}")
    private String url;
    @Value("${c3p0.driverClass}")
    private String driverClass;
    @Value("${c3p0.user}")
    private String username;
    //数据源
    @Bean
    public ComboPooledDataSource comboPooledDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setPassword(password);
        dataSource.setUser(username);
        dataSource.setJdbcUrl(url);
        try {
            dataSource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
    //jdbc整合
    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource comboPooledDataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(comboPooledDataSource);
        return jdbcTemplate;
    }
    //事务管理器
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource comboPooledDataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(comboPooledDataSource);
        return transactionManager;
    }
}
