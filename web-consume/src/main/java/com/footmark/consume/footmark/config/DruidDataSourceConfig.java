/*
package com.footmark.consume.footmark.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

*/
/**
 * druid连接池注册
 * @author WindyHu
 *//*

@Configuration
@MapperScan(basePackages = "com.footmark.service.dao",sqlSessionFactoryRef = "sqlSessionFactory")
@Primary //在同样的DataSource中，首先使用被标注的DataSource
public class DruidDataSourceConfig extends DataSourceProperties {

    private static final Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);

    private static final String DB_PREFIX = "spring.datasource";
    @Bean
    public ServletRegistrationBean druidServlet() {
        logger.info("init Druid Servlet Configuration ");
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // IP白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // IP黑名单(共同存在时，deny优先于allow)
        //servletRegistrationBean.addInitParameter("deny", "192.168.1.100");
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    //解决 spring.datasource.filters=stat,wall,log4j 无法正常注册进去
    @ConfigurationProperties(prefix = DB_PREFIX)
    class IDataSourceProperties {
        @Value("${spring.datasource.url}")
        private String url;

        @Value("${spring.datasource.username}")
        private String username;

        @Value("${spring.datasource.password}")
        private String password;

        @Value("${spring.datasource.driver-class-name}")
        private String driverClassName;

        @Value("${spring.datasource.initialSize}")
        private int initialSize;

        @Value("${spring.datasource.minIdle}")
        private int minIdle;

        @Value("${spring.datasource.maxActive}")
        private int maxActive;

        @Value("${spring.datasource.maxWait}")
        private int maxWait;

        @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
        private int timeBetweenEvictionRunsMillis;

        @Value("${spring.datasource.minEvictableIdleTimeMillis}")
        private int minEvictableIdleTimeMillis;

        @Value("${spring.datasource.validationQuery}")
        private String validationQuery;

        @Value("${spring.datasource.testWhileIdle}")
        private boolean testWhileIdle;

        @Value("${spring.datasource.testOnBorrow}")
        private boolean testOnBorrow;

        @Value("${spring.datasource.testOnReturn}")
        private boolean testOnReturn;

        @Value("${spring.datasource.poolPreparedStatements}")
        private boolean poolPreparedStatements;

        @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
        private int maxPoolPreparedStatementPerConnectionSize;

        @Value("${spring.datasource.filters}")
        private String filters;

        @Value("{spring.datasource.connectionProperties}")
        private String connectionProperties;

        @Bean     //声明其为Bean实例
        @Primary  //在同样的DataSource中，首先使用被标注的DataSource
        public DataSource dataSource() {
            DruidDataSource datasource = new DruidDataSource();
            datasource.setUrl(url);
            datasource.setUsername(username);
            datasource.setPassword(password);
            datasource.setDriverClassName(driverClassName);

            //configuration
            datasource.setInitialSize(initialSize);
            datasource.setMinIdle(minIdle);
            datasource.setMaxActive(maxActive);
            datasource.setMaxWait(maxWait);
            datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
            datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
            datasource.setValidationQuery(validationQuery);
            datasource.setTestWhileIdle(testWhileIdle);
            datasource.setTestOnBorrow(testOnBorrow);
            datasource.setTestOnReturn(testOnReturn);
            datasource.setPoolPreparedStatements(poolPreparedStatements);
            datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
            try {
                datasource.setFilters(filters);
            } catch (SQLException e) {
                System.err.println("druid configuration initialization filter: " + e);
            }
            datasource.setConnectionProperties(connectionProperties);
            return datasource;
        }

        */
/**
         * 分页插件
         * @author WindyHu
         * @return
         *//*

        @Bean
        public PageHelper pageHelper() {

            System.out.println("MyBatisConfiguration.pageHelper()");

            PageHelper pageHelper = new PageHelper();

            Properties p = new Properties();

            p.setProperty("offsetAsPageNum", "true");

            p.setProperty("rowBoundsWithCount", "true");

            p.setProperty("reasonable", "true");

            pageHelper.setProperties(p);

            return pageHelper;

        }

    }
}
*/
