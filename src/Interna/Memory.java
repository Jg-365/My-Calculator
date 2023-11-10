package Interna;

import java.util.ArrayList;

public class Memory {
    private ArrayList<String> numeros;
    public double resultado;
    public Memory() {
        numeros = new ArrayList<String>();
    }

    public String getNumeros() {
        String resultado = "";

        for (String num : numeros) {
            resultado += num;
        }

        return resultado;
    }

    public void setNumeros(String num) {
        numeros.add(num);
    }
    public void clearNumeros() {
    	numeros.clear();
    }

    public Boolean verificacaoIgual(String num) {
        return num.equals("=");
    }

    public double operations(String operacao) {
        String[] tokens = operacao.split(" ");
        double resultado = Double.parseDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            char operador = tokens[i].charAt(0);
            double numero = Double.parseDouble(tokens[i + 1]);

            switch (operador) {
                case '+':
                    resultado += numero;
                    break;
                case '-':
                    resultado -= numero;
                    break;
                case '/':
                	if(numero==0) {
                		throw new ArithmeticException("Erro");
                	}
                    resultado /= numero;
                    break;
                case 'x':
                    resultado *= numero;
                    break;
            }

        }

        return resultado;
    }

}
