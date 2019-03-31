package qcadmin.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class DBClientDetailsService {

    @Autowired
    DataSource dataSource;

    @Bean
    public ClientDetailsService getClientDetailsService(){
        return new JdbcClientDetailsService(dataSource);
    }

    @Bean
    public DataSource getDataSource(){
        return this.dataSource;
    }

}
