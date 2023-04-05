package test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class ConfigurationTest {
  @Test
  public void testRestTemplate(){
      AnnotationConfigApplicationContext context
              = new AnnotationConfigApplicationContext(RestTemplate.class);
      //别名
      for (String beanName : context.getBeanDefinitionNames()) {
          //别名
          String[] aliases = context.getAliases(beanName);
          System.out.println(String.format("bean名称:%s,别名:%s,bean对象:%s",
                  beanName,
                  Arrays.asList(aliases),
                  context.getBean(beanName)));
      }

  }
}
