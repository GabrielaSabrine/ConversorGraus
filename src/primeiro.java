

import java.util.Scanner;

public class Principal {

    private static double getTemp() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite uma temperatura: ");
        return input.nextDouble();
    }

    public static void main(String[] args) {
        double resultado;
        initialize();

        UnityTemp unityInput = getUnityTemp("entrada");
        UnityTemp unityOutput = getUnityTemp("saída");
        double temp = getTemp();

        System.out.println("Você vai transformar " + temp + " " + unityInput + " em " + unityOutput);

        switch (unityOutput) {
            case CELSIUS:
                resultado = toCelsiusTransform(unityInput, temp);
                break;

            case FAHRENHEIT:
                resultado = toFahrenheitTransform(temp);
                break;

            case KELVIN:
                resultado = 0;
                break;

            default:
                resultado = 0;
                break;
        }

        System.out.printf("O resultado da conversão é %f", resultado);
    }

    private static UnityTemp getUnityTemp(String nomeQualquerDeVariavel) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a unidade de temperatura de " + nomeQualquerDeVariavel);
        String typeString = input.nextLine();
        return UnityTemp.valueOf(typeString);
    }

    private static void initialize() {
        System.out.println("Bem vindo ao nosso conversor de temperaturas.");
    }

    public static double toFahrenheitTransform(double celsius) {
        // Colocar transformação de Kelvin tbm
        // Semelhante método abaixo
        return celsius * 9.0 / 5 + 32;
    }

    public static double toCelsiusTransform(UnityTemp type, double temp) {
        if (type == UnityTemp.FAHRENHEIT) {
            return (temp - 32) / 1.8;
        } else if (type == UnityTemp.KELVIN) {
            return temp - 273.15;
        } else {
            return temp;
        }
    }
}