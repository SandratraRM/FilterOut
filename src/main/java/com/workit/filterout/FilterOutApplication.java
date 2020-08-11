package com.workit.filterout;

import com.workit.filterout.config.AppConfig;
import com.workit.filterout.controller.FilterOutController;
import com.workit.filterout.utils.ArgsParser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class FilterOutApplication {
    public static void main(String[] args){
        try {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
            context.registerBean(ArgsParser.class, Arrays.asList(args));
            context.register(AppConfig.class);
            context.refresh();
            FilterOutController controller = context.getBean(FilterOutController.class);
            controller.filterInputAndSave();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
