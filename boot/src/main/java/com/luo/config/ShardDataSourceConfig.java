package com.luo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author luohaoyu
 * 官方文档：http://shardingsphere.io/document/current/cn/features/read-write-split/
 */
@Configuration
@EnableConfigurationProperties(ShardDataSourceProperties.class)
public class ShardDataSourceConfig {

    @Autowired
    private ShardDataSourceProperties shardDataSourceProperties;

    /**
     * 数据源基础信息
     *
     * @return
     * @throws SQLException
     */
    @Bean
    public DruidDataSource parentDs() throws SQLException {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(shardDataSourceProperties.getDriverClassName());
        ds.setUsername(shardDataSourceProperties.getUsername());
        ds.setUrl(shardDataSourceProperties.getUrl());
        ds.setPassword(shardDataSourceProperties.getPassword());
        ds.setFilters(shardDataSourceProperties.getFilters());
        ds.setMaxActive(shardDataSourceProperties.getMaxActive());
        ds.setInitialSize(shardDataSourceProperties.getInitialSize());
        ds.setMaxWait(shardDataSourceProperties.getMaxWait());
        ds.setMinIdle(shardDataSourceProperties.getMinIdle());
        ds.setTimeBetweenEvictionRunsMillis(shardDataSourceProperties.getTimeBetweenEvictionRunsMillis());
        ds.setMinEvictableIdleTimeMillis(shardDataSourceProperties.getMinEvictableIdleTimeMillis());
        ds.setValidationQuery(shardDataSourceProperties.getValidationQuery());
        ds.setTestWhileIdle(shardDataSourceProperties.isTestWhileIdle());
        ds.setTestOnBorrow(shardDataSourceProperties.isTestOnBorrow());
        ds.setTestOnReturn(shardDataSourceProperties.isTestOnReturn());
        ds.setPoolPreparedStatements(shardDataSourceProperties.isPoolPreparedStatements());
        ds.setMaxPoolPreparedStatementPerConnectionSize(
                shardDataSourceProperties.getMaxPoolPreparedStatementPerConnectionSize());
        ds.setRemoveAbandoned(shardDataSourceProperties.isRemoveAbandoned());
        ds.setRemoveAbandonedTimeout(shardDataSourceProperties.getRemoveAbandonedTimeout());
        ds.setLogAbandoned(shardDataSourceProperties.isLogAbandoned());
        ds.setConnectionInitSqls(shardDataSourceProperties.getConnectionInitSqls());
        return ds;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        DataSource dataSource = parentDs();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
        return new DataSourceTransactionManager(parentDs());
    }
}
