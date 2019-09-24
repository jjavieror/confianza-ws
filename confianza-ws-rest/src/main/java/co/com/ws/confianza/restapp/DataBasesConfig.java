package co.com.ws.confianza.restapp;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;



@Configuration
public class DataBasesConfig
{
  @Bean(name = {"h2Database"})
  @Primary
  @ConfigurationProperties(prefix = "oauth.datasource")
  public DataSource slaveDataSource() { return DataSourceBuilder.create().build(); }


  
  @Bean(name = {"OracleDB"})
  @ConfigurationProperties(prefix = "oracle.datasource")
  public DataSource masterDataSource() { return DataSourceBuilder.create().build(); }


  
  @Bean(name = {"jdbcH2Sql"})
  @Autowired
  public JdbcTemplate slaveJdbcTemplate(DataSource dsSlave) { return new JdbcTemplate(dsSlave); }


  
  @Bean(name = {"jdbcOracleDB"})
  @Autowired
  public JdbcTemplate masterJdbcTemplate(@Qualifier("OracleDB") DataSource dsMaster) { return new JdbcTemplate(dsMaster); }
}
