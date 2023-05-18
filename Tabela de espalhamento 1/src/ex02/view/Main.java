package ex02.view;

import br.fatec.FileLibrary.FileLibrary;
import ex02.controller.CondominioTable;
import ex02.controller.I_CondominioTable;
import ex02.model.ResidentController;

public class Main
{
    public static void main(String[] args)
    {
        String filePath = "/home/debby/Testes/DadosCondominio.csv";
        FileLibrary openFile = new FileLibrary(filePath);
        I_CondominioTable condominio = new CondominioTable();

        try {
            String[] contentFile = openFile.getContentFile().split("\n");
            int len = contentFile.length;

            for (int i = 1; i < len; i++)
            {
                ResidentController resident = new ResidentController();
                String[] residentInfo = contentFile[i].split(",");

                int apartmentNum = Integer.parseInt(residentInfo[0]);
                String residentName = residentInfo[1];
                String model = residentInfo[2];
                String color = residentInfo[3];
                String plate = residentInfo[4];

                resident.setName(residentName);
                resident.setNum_apartment(apartmentNum);
                resident.setCar(model, color, plate);

                condominio.add(resident);
            }

            ResidentController newResident = new ResidentController();
            newResident.setName("ABC");
            newResident.setNum_apartment(101);
            newResident.setCar("Full", "Prata", "A-1123");
            condominio.add(newResident);

            condominio.list(1);

            condominio.remove(newResident);
            condominio.list(1);

        } catch (Exception e) {
            System.out.println("____"+e+"____");
        }

    }
}
