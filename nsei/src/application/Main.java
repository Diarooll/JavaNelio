package application;

import entities.Cliente;

import java.lang.ref.Cleaner;

public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("diego", "diego.alejandro");
        Cliente c2 = new Cliente("diego", "diego.alejandro");

        String s1 = "teste";
        String s2 = "teste";

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.equals(c2));
        System.out.println(c1 == c2);
        System.out.println(s1 == s2);
    }
}
