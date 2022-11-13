package com.example.library_test.config;

import com.example.library_test.dao.entity.BaseEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.relational.core.mapping.NamingStrategy;
//import org.springframework.data.relational.core.mapping.RelationalPersistentProperty;
//import org.springframework.data.relational.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.util.ParsingUtils;
import org.springframework.util.Assert;

import java.util.UUID;

@Configuration
public class ApplicationConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setSkipNullEnabled(false);
        modelMapper.addMappings(
                new PropertyMap<BaseEntity, BaseEntity>() {
                    @Override
                    protected void configure() {
                        skip(destination.getId());
                        skip(destination.getVersion());
                        skip(destination.getCreateDate());
                    }
                });
        return modelMapper;
    }

//    @Bean
//    public NamingStrategy namingStrategy() {
//        return new NamingStrategy() {
//            @Override
//            public String getColumnName(RelationalPersistentProperty property) {
//                Assert.notNull(property, "Property must not be null.");
//                return ParsingUtils.reconcatenateCamelCase(property.getName(), "_");
//            }
//        };
//    }
//
//    @Bean
//    public ApplicationListener<?> idSetting(){
//        return (ApplicationListener<BeforeConvertEvent>) event -> {
//            if(event.getEntity() instanceof BaseEntity){
//                ((BaseEntity) event.getEntity()).setId(UUID.randomUUID());
//            }
//        };
//    }
}
