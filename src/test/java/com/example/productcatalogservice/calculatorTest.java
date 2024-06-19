package com.example.productcatalogservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class calculatorTest {

    @Autowired
    Calculator calculator;

    @Test
     void TestCalculator_AddTwoNum_SuccessResponse()
    {
        //Arrange

        //->not req as the req obj is autowired

        //ACT
        int ans = calculator.add(10 , 20);
        assertEquals(30 , ans);
    }

    @Test
     void TestDivide_withDenominatorZero_ArithmeticException()
    {
        assertEquals(ArithmeticException.class , calculator.divide(11, 0));
    }


}
