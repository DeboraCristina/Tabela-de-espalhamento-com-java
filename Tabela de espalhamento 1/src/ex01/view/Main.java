package ex01.view;

import br.fatec.FileLibrary.FileLibrary;
import ex01.controller.TableController;

public class Main
{
    public static void main(String[] args)
    {
        String srcFile = "/home/debby/Testes/ListaNumAleatorios.csv";
        FileLibrary editFile = new FileLibrary(srcFile);

        try
        {
            String absolutContentFile = editFile.getContentFile();
            String[] numbers = absolutContentFile.split("\n");
            TableController table = new TableController(300);

            for (String number : numbers)
            {
                int nbr = Integer.parseInt(number);
                table.add(nbr);
            }

            table.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
