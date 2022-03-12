package com.mangu.congreso_api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.mangu.congreso_api.domain")
@EnableJpaRepositories("com.mangu.congreso_api.repos")
@EnableTransactionManagement
public class DomainConfig {
}
