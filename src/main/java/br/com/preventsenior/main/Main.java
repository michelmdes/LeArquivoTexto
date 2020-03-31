package br.com.preventsenior.main;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        System.out.printf("\nConteúdo do arquivo texto:\n");
        try {
            FileReader arq = new FileReader("/home/michel/Downloads/logPlantaoPlanejado/data.json");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                System.out.printf("%s\n", linha);
                linha = lerArq.readLine();
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        System.out.println();
    }

    /*public static void main(String[] args) {
        InputStream inputstream;
        try {
            inputstream = new BufferedInputStream(
                    new FileInputStream("/home/michel/Downloads/logPlantaoPlanejado/data.json"));
            byte[] dataAsByte = new byte[2];
            inputstream.read(dataAsByte);
            for(int i =0; i < 2 ; i++){
                System.out.println((char) dataAsByte[i]);
            }

            inputstream.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }*/

    /*public static void main(String[] args) {
        InputStream inputstream;
        try {
            int i = 0;
            inputstream = new FileInputStream("/home/michel/Downloads/logPlantaoPlanejado/data.json");

            int data = inputstream.read();
            while (data != -1) {
                System.out.println(data);

                data = inputstream.read();
                i++;
                if (i > 10) break;
            }
            inputstream.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }*/

    /*public static void main2(String[] args)  throws IOException {
        InputStream is = System.in;
        System.out.print("Digite um texto: ");

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String digitado = br.readLine();

        while(digitado != null){
            System.out.println("Texto Digitado = "+digitado);
            digitado = br.readLine();
        }

    }*/
}
