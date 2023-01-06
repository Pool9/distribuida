package com.distribuida.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jdbi.v3.core.Jdbi;


@ApplicationScoped
public class Dbconfig {
    public Jdbi conf() {

        System.out.println("********** post construct");
        //Opcion1
        Config config = ConfigProvider.getConfig();

        String user = config.getValue("db.user",String.class);
        String passwd = config.getValue("db.password",String.class);
        String url = config.getValue("db.url",String.class);
        String driver = config.getValue("db.driver",String.class);

      /*  System.out.println("Op1" + user);
        System.out.println("Op1" + passwd);
        System.out.println("Op1" + url);
//Opcion 2
        System.out.println("Op2" + dbUser);
        System.out.println("Op2" + dbPassword);
        System.out.println("Op2" + dbUrl);*/ ///Archivos de clase
        HikariConfig poolConection = new HikariConfig();
        poolConection.setUsername(user);
        poolConection.setPassword(passwd);
        poolConection.setJdbcUrl(url);
        poolConection.setUsername(user);
        poolConection.setDriverClassName(driver);
        return Jdbi.create(new HikariDataSource(poolConection));


    }
    public void test(){

    }


}

