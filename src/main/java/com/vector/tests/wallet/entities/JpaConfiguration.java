package com.vector.tests.wallet.entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.vector.tests.wallet.entities")
@EntityScan(basePackages = "com.vector.tests.wallet.entities")
public class JpaConfiguration {

}
