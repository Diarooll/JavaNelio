package application;

import entities.Circle;
import entities.Rectangle;
import interfaces.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Program {
    public static void main(String[] args) {


        List<Integer> myInts = Arrays.asList(1,2,3,4);
        List<Double> myDoubles = Arrays.asList(3.14, 2.6, 12.897);
        List<Object> myObjs = new ArrayList<>();

        copy(myInts, myObjs);
        printList(myObjs);
        copy(myDoubles, myObjs);
        printList(myObjs);

    }
    public static void copy(List<? extends Number> source, List<? super Number> destiny){
        for(Number num : source){
            destiny.add(num);
        }
    }

    public static void printList(List<?> list){
        for(Object obj : list){
            System.out.println(obj + " ");
        }
        System.out.println();
    }
}
