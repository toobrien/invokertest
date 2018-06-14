package com.github.toobrien.invokertest;

import com.amazonaws.services.lambda.invoke.LambdaFunctionNameResolver;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;

public class Test {

  public static void main(String[] args) {
    System.out.println("stage: " + args[0]);    
    LambdaFunctionNameResolver resolver = new MyResolver(args[0].trim());

    System.out.println("resolver will return: " + 
                          resolver.getFunctionName(null,null,null));
    
    MyFunc func = LambdaInvokerFactory.builder()
                .lambdaClient(AWSLambdaClientBuilder.defaultClient())
                .lambdaFunctionNameResolver(resolver)
                .build(MyFunc.class);

    String res = func.handleRequest("some input...");
    
    System.out.println("result: " + res);
  }

}
