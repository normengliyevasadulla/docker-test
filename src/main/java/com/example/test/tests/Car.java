package com.example.test.tests;

public class Car {
    public static Car getInstance(int budget){
        if (budget <= 1000){
            return new Mers();
        }
        return new BMW();
    }
}

class Mers extends Car{

}

class BMW extends Car{

}
