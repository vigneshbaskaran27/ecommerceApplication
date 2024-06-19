package com.example.productcatalogservice;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class Calculator {

    public int add(int num1 , int num2)
    {
        return num1+num2;

    }

    public int  divide(int num1 , int num2)
    {
        int res=0;
        try{
            res=num1/num2;
        }catch(ArithmeticException ex)
        {
            System.out.println(ex.getMessage());
        }

        return res;
    }
}
