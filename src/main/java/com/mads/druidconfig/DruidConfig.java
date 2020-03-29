package com.mads.druidconfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/******
 * 德鲁伊 的启动配置，这里面 有两个数据源
 */
@Component
@PropertySource("classpath:/application.properties")
public class DruidConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.url2}")
    private String url2;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    /*
    * <bean >
    * */
    public DataSource getDs1() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);

        druidDataSource.setMaxActive(10);
        druidDataSource.setInitialSize(10);
        druidDataSource.setTimeBetweenConnectErrorMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("SELECT 1 FROM DUAL");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);

        try {
            druidDataSource.setFilters("stat,wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }

    public DataSource getDs2() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url2);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);

        druidDataSource.setMaxActive(10);
        druidDataSource.setInitialSize(10);
        druidDataSource.setTimeBetweenConnectErrorMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("SELECT 1 FROM DUAL");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);

        try {
            druidDataSource.setFilters("stat,wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }

    /****
     * 将两个数据源 放进DynamicDataSource，它本身也是个数据源对象，
     * @return
     */
    @Bean
    public DataSource dynamicDataSource() {

        Map<Object,Object> targetDataSources = new HashMap<>();
        DataSource ds1 = getDs1();
        DataSource ds2 = getDs2();
        targetDataSources.put("ds1",ds1);
        targetDataSources.put("ds2",ds2);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(ds1);
        return dynamicDataSource;
    }



    /**
     * 配置访问druid监控
     * @return
     */
    /*@Bean
    public ServletRegistrationBean druidStateViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //初始化参数initParams
        //添加白名单
        servletRegistrationBean.addInitParameter("allow","");
        //添加ip黑名单
        servletRegistrationBean.addInitParameter("deny","192.168.16.111");
        //登录查看信息的账号密码
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","123");
        //是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }*/

    /**
     * 过滤不需要监控的后缀
     * @return
     */
    /*@Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }*/
}
