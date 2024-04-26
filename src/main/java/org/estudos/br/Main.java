package org.estudos.br;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

    
        boolean continuar = true;

        
        while (continuar) {
   
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Consultar informações de uma regiao");
            System.out.println("2. Consultar informações de todos os estados");
            System.out.println("3. Consultar informações de um distrito");
            System.out.println("4. Sair");

            System.out.print("Opção: ");

            
            int opcao = scanner.nextInt();

            try {
               
                switch (opcao) {
                    case 1:
                        consultarRegiao(scanner);
                        break;
                    
                    case 2:
                        consultarEstados();
                        break;
                    case 3:
                        consultarDistritoIdentificador(scanner);
                        break;
                    case 4:
                        continuar = false;
                        System.out.println("\n Obrigado por usar nossos serviços!");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (IOException e) {
              
                System.err.println("Ocorreu um erro ao realizar a consulta: " + e.getMessage());
            }
        }

       
        scanner.close();
    }

    private static void consultarRegiao(Scanner scanner) throws IOException {
        
        System.out.println("Digite o id da região a ser consultada: ");

        
        int id = scanner.nextInt();

        
        String resultado = ConsultaIBGE.consultarRegiao(id);

        
        System.out.println("Resultado da consulta: ");
        System.out.println(resultado);
    } 


    private static void consultarEstados() throws IOException {

        
        String resultado = ConsultaIBGE.consultarEstados();

        
        System.out.println("Resultado da consulta: ");
        System.out.println(resultado);
    }

    private static void consultarDistritoIdentificador(Scanner scanner) throws IOException {
        
        System.out.println("Digite o identificador do distrito a ser consultado: ");

        
        int identificador = scanner.nextInt();

        
        String resultado = ConsultaIBGE.consultarDistritoIndentificador(identificador);

       
        System.out.println("Resultado da consulta: ");
        System.out.println(resultado);
    }

}

