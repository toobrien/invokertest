package com.github.toobrien.invokertest;

import com.amazonaws.services.lambda.invoke.LambdaFunctionNameResolver;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactoryConfig;
import com.amazonaws.services.lambda.invoke.LambdaFunction;
import java.lang.reflect.Method;

public class MyResolver implements LambdaFunctionNameResolver {

  private String stage;
  
  public MyResolver(String stage) {
    this.stage = stage;
  }  

  public String getFunctionName(
      Method method, 
      LambdaFunction annotation,
      LambdaInvokerFactoryConfig config
    ) {
    System.out.println("about to pick: " + this.stage);
    if (this.stage.equals("prod"))
      return "A";
    else
      return "B";
  }
  
}
