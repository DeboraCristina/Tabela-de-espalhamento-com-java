package ex02.view;

import br.fatec.FileLibrary.FileLibrary;
import ex02.controller.TableController;

public class Main
{
    public static void main(String[] args)
    {
        String srcFile = "/home/debby/Testes/NumerosImparesPares.csv";
        FileLibrary editFile = new FileLibrary(srcFile);

        try
        {
            String absolutContentFile = editFile.getContentFile();
            String[] numbers = absolutContentFile.split("\n");
            TableController table = new TableController();

            for (String number : numbers)
            {
                int nbr = Integer.parseInt(number);
                table.add(nbr);
            }

            table.list(true);
            table.list(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
