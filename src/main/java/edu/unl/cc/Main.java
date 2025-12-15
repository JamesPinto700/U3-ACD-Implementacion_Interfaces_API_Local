package edu.unl.cc;

import edu.unl.cc.succession.business.*;
import edu.unl.cc.succession.domain.Successionable;

import java.util.Scanner;

/**
 *
 * @author MacGyver2.0
 */
public class Main {

    private static void printMenu(){
        System.out.println("CALCULADORA DE SERIES");
        System.out.println("1. Serie de numeros pares hasta un limite (S = 2 + 4 + 6 + 8 + ... N): ");
        System.out.println("2. Serie de primos elevados al cubo  hasta un limite (S = 1^3 + 3^3 + 5^3 + 7^3 + 11^3 + 13^3 ... + N^3): ");
        System.out.println("3. Serie de primos elevados al cubo  hasta N términos (S = 1^3 + 3^3 + 5^3 + 7^3 + 11^3 + 13^3 ...): ");
        System.out.println("4. Serie de primos elevados por pares hasta un limite (S = 1^2 + 3^4 + 5^6 + 7^8 + 11^10 + 13^(12) ... + N): ");
        System.out.println("5. Serie de primos elevados a impares hasta n térmimos (S = S = 1^1 + 3^3 + 5^5 + 7^7 + 11^9 + 13^11 ..): ");
        System.out.println("6. Serie de primos elevados a la raiz de numeros pares hasta un limite (S = 1^(1/2) + 3^(1/4) + 5^(1/6) + 7^(1/8) + 11^(1/10) + 13^(1/12) ... + N): ");
        System.out.println("7. Serie de primos elevados a la raiz de numeros impares hasta un n términos (S = 1^(1/1) + 3^(1/3) + 5^(1/5) + 7^(1/7) + 11^(1/9) + 13^(1/11)): ");
        System.out.println("8. Serie de primos elevados a la raiz cúbica hasta un n términos (S = 1^(1/3) + 3^(1/3) + 5^(1/3) + 7^(1/3) + 11^(1/3) + 13^(1/3)): ");
        System.out.println("9. Serie de primos elevados a la raiz cuadrada hasta un limite (S = 1^(1/2) + 3^(1/2) + 5^(1/2) + 7^(1/2) + 11^(1/2) + 13^(1/2)+ .. + N^(1/2): ");
        System.out.println("10. Serie de primos hasta un limite (S = 1 + 2 + 3 + 5 + 7 + 11 + 13 + .. + N: ");
    }

    private static int readOption(Scanner scanner){
        int option;
        printMenu();
        System.out.print("Elija la opcion de la serie que desea calcular: ");
        option = scanner.nextInt();
        return option;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = readOption(scanner);
        System.out.print("Debe ingresar un limite/N terminos: ");
        int limit = scanner.nextInt();
        scanner.nextLine();
        Successionable successionable = null;

        switch (option){
            case 1: successionable = new EvenNumberCalculatorUpToLimit(limit); break;
            case 2: successionable = new PrimeNumberPowCubeCalculatorUpToLimit(limit); break;
            case 3: successionable = new PrimeNumberPowCubeCalculatorWithTerm(limit); break;
            case 4: successionable = new PrimeNumberPowEvenNumberCalculatorUpToLimit(limit); break;
            case 5: successionable = new PrimeNumberPowOddNumberCalculatorWithTerm(limit); break;
            case 6: successionable = new PrimeNumPowInverseEvenNumCalcToUpLim(limit); break;
            case 7: successionable = new PrimeNumPowInverseOddNumCalcWithTerm(limit); break;
            case 8: successionable = new PrimeNumPowInverseCubeNumCalculator(limit); break;
            case 9: successionable = new PrimeNumPowInverseSquareNumCalculator(limit); break;
            case 10: successionable = new PrimeNumberCalculatorUpToLimit(limit); break;
            default: System.out.printf("Opcion no valida");
        }

        if (successionable != null) {
            Number result = successionable.calculate();
            System.out.println(successionable.print());
            System.out.println("S = " + result + "\n");
        }
    }
}