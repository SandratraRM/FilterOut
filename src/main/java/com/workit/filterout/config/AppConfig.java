package com.workit.filterout.config;

import com.workit.filterout.controller.FilterOutController;
import com.workit.filterout.utils.ArgsParser;
import com.workit.filterout.words.FilterWordsService;
import com.workit.filterout.words.InputWordsService;
import com.workit.filterout.words.OutputWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackageClasses = FilterOutController.class)
public class AppConfig {
    @Autowired
    private Environment environment;

    @Autowired
    private ApplicationContext applicationContext;

    private ArgsParser getArgsParser(){
        return applicationContext.getBean(ArgsParser.class);
    }

    @Bean
    public InputWordsService inputWordsService(){
        return new InputWordsService(getArgsParser().getInput());
    }

    @Bean
    public FilterWordsService filterWordsService(){
        Set<String> toExcludes = new HashSet<>(getArgsParser().getRemainingArgs());
        return new FilterWordsService(toExcludes);
    }

    @Bean
    public OutputWordsService outputWordsService(){
        String outputFileName = getArgsParser().getOutput();
        outputFileName = isBlank(outputFileName) ? environment.getProperty("outputFilename") : outputFileName;
        return new OutputWordsService(outputFileName);
    }
}
