/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import jade.core.Runtime;
import java.util.Scanner;
import jade.tools.rma.*;

public class Calculadora {

    AgentController agenteController;
    Runtime runtime = Runtime.instance();
    Profile profile = new ProfileImpl(null, 1099, null);
    AgentContainer mainContainer = runtime.createMainContainer(profile);
       

    public void Operacion() throws StaleProxyException, Throwable {
        int opcion = 0;
        Scanner s = new Scanner(System.in);
        Numeros numero = new Numeros();
        System.out.println("=================Calculadora==================");
        System.out.println("Elija una opción");
        System.out.println("1 Suma");
        System.out.println("2 Resta");
        System.out.println("3 Division");
        System.out.println("4 Multiplicacion");
        System.out.println("0 Salir");
        System.out.println(">>>>>>>");
        opcion = s.nextInt();
        if (opcion == 1) {
            Object[] numeros = numero.LeerNumeros();
            agenteController = mainContainer.createNewAgent("AgenteSuma", Suma.class.getName(), numeros);
            agenteController.start();
        } else {
            if (opcion == 2) {
                Object[] numeros = numero.LeerNumeros();
                agenteController = mainContainer.createNewAgent("AgenteResta", Resta.class.getName(), numeros);
                agenteController.start();
            } else {
                if (opcion == 3) {
                    Object[] numeros = numero.LeerNumeros();
                    agenteController = mainContainer.createNewAgent("AgenteDivision", Division.class.getName(), numeros);
                    agenteController.start();
                } else {
                    if (opcion == 4) {
                        Object[] numeros = numero.LeerNumeros();
                        agenteController = mainContainer.createNewAgent("AgenteMultiplicacion", Multiplicacion.class.getName(), numeros);
                        agenteController.start();
                    } else {
                        if (opcion == 0) {
                            System.exit(0);
                        } else {
                            System.out.println("Elija una opción válida");
                            this.Operacion();
                        }

                    }
                }
            }

        }
    }

    public static void main(String[] args) throws StaleProxyException, Throwable {
        Calculadora c = new Calculadora();
        c.Operacion();

    }

}
