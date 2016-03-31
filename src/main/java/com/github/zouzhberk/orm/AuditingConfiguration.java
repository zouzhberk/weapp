package com.github.zouzhberk.orm;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by berk (zouzhberk@163.com)) on 3/31/16.
 */
@Configuration
@EnableAsync
@EnableAutoConfiguration
@EntityScan(basePackageClasses = {AuditingConfiguration.class,
        Jsr310JpaConverters.class})
@EnableJpaAuditing
public class AuditingConfiguration
{
}
