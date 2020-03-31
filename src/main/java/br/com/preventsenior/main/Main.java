package br.com.preventsenior.main;

import java.io.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        System.out.printf("\nConteúdo do arquivo texto:\n");
        try {
            FileReader arq = new FileReader("/home/michel/Downloads/logPlantaoPlanejado/data.json");
            BufferedReader lerArq = new BufferedReader(arq);
            Long l = new Long(0);
            Date dataInicio = new Date();

            String linha = lerArq.readLine();
            while (linha != null) {
                System.out.printf("linha %s: %s\n",++l ,linha);
                linha = lerArq.readLine();
                //if (l > 100000) break;
            }
            arq.close();

            Date dataFim = new Date();
            Long intervalo = dataFim.getTime() - dataInicio.getTime();
            System.out.println("Processado em " + (intervalo/1000) + " segundos");

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        System.out.println();
    }

}
