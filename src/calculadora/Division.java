/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janina
 */
public class Division extends Agent {

    @Override
    protected void setup() {
        System.out.println(this.getLocalName() + " Inicializado ");
        addBehaviour(new ComportamientoDivision());
    }

    protected void takeDown() {
        System.out.println("Finaliza el "
                + this.getLocalName());
        System.out.println("--------------------------------------------------");
    }

    private class ComportamientoDivision extends Behaviour {

        @Override
        public void action() {
            Object[] args = getArguments();
            if (args != null) {
               String arg1 = args[0].toString();
                double num1 = Double.valueOf(arg1);
                String arg2 = args[1].toString();
                double num2 = Double.valueOf(arg2);
                if (num2 == 0) {
                    System.out.println("No se puede realiar divisiones para 0");
                } else {
                    double res = (num1 / num2);
                    System.out.println("División:" + res);
                }

            }

        }

        @Override
        public boolean done() {
            System.out.println("Finaliza el " + this.getBehaviourName());
            System.out.println("--------------------------------------------------");
            doDelete();
            Calculadora c = new Calculadora();
            try {
                c.Operacion();
            } catch (StaleProxyException ex) {
                Logger.getLogger(Suma.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Throwable ex) {
                Logger.getLogger(Division.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }

    }

}
