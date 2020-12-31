package com.mads.transaction;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Component
/*
 * 生成事务AOP的入口类
 * 扫描使用了@Repository注解的类，下面这三个方法，替代的及时基于XML对事务的支持，回忆下xml的配置方式。这里就很好理解了
 *
 * 显示使用 @Transactional注解开启事务，注意这里只是演示，真正开发中还是少使用显示事务方式，因为当spring执行到用
 * @Transactional修饰的方法时，立马就会拿一个数据库连接，直到方法执行完毕，万一方法里 到最后才是操作数据库，前面代码都是
 * IO操作呢，白白的占着连接不放手。对性能影响很大。慎重思之。。。
 * */
@EnableTransactionManagement(proxyTargetClass = false)
@MapperScan(basePackages = {"com.mads.dao"}, annotationClass = Repository.class)
public class EnableTransactionManagementBean {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager platformTransactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(platformTransactionManager);
        return transactionTemplate;
    }

}
