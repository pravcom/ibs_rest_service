package org.ibs.service.confing;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    GroupedOpenApi apiV1(){
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch("/v1/**")
                .packagesToScan("org.ibs.service.rest.v1")
                .build();
    }

    @Bean
    GroupedOpenApi apiV2(){
        return GroupedOpenApi.builder()
                .group("v2")
                .pathsToMatch("/v2/**")
                .packagesToScan("org.ibs.service.rest.v2")
                .build();
    }

}
