/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.Scanner;

/**
 *
 * @author Janina
 */
public class Numeros {

    Scanner s = new Scanner(System.in);
    private double numero1;
    private double numero2;

    public Numeros() {
    }

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

   

    public Object[] LeerNumeros() {
   System.out.println("===============Calculadora==============");
        System.out.println("Ingrese el primer número");
        numero1 = s.nextDouble();

        System.out.println("Ingrese el segundo número");
        numero2 = s.nextDouble();
                
        Object numeros[] = {numero1, numero2};
        return numeros;
    }

}
