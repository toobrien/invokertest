package com.github.toobrien.invokertest;

import com.amazonaws.services.lambda.invoke.LambdaFunction;

public interface MyFunc {

  @LambdaFunction(functionName="A")
  public String handleRequest(String params);

}

