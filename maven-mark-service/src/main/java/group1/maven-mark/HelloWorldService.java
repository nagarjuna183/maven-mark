package group1.maven-mark;


import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import group1.maven-mark.conf.HelloWorldConfiguration;
import group1.maven-mark.health.TemplateHealthCheck;
import group1.maven-mark.resource.HelloWorldResource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pnajda
 */
public class HelloWorldService extends Service<HelloWorldConfiguration> {
    
    public static void main(String args[]) throws Exception {
        new HelloWorldService().run(args);        
    }
    
    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.setName("hello-world");
    }
    
    @Override
    public void run(HelloWorldConfiguration configuration,
                Environment environment) {
        
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new HelloWorldResource(template, defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));

    }
    
}
