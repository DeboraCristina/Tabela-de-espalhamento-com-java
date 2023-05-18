package ex02.controller;

import br.fatec.ListObject.ListObject;
import ex02.model.Resident;
import ex02.model.ResidentController;

public class CondominioTable implements I_CondominioTable
{
    ListObject[] table;

    public CondominioTable()
    {
        int length = 10;
        this.table = new ListObject[length];

        for (int index = 0; index < length; index++)
        {
            table[index] = new ListObject();
        }
    }

    @Override
    public void add(ResidentController srcResident) throws Exception
	{
        int hashCode = srcResident.hashCode();

        ListObject floorList = table[hashCode];

        if (floorList.isEmpty())
            floorList.addFirst(srcResident);
        else
            floorList.addLast(srcResident);
    }

    @Override
    public void remove(ResidentController  srcResident) throws Exception
	{
        int hashCode = srcResident.hashCode();

        ListObject floorList = table[hashCode];
        int size = floorList.size();

        for (int index = 0; index < size; index++)
        {
            ResidentController resident = (ResidentController ) floorList.get(index);
            if (resident.getNum_apartment() == srcResident.getNum_apartment())
            {
                floorList.remove(index);
                break;
            }
        }
    }

    @Override
    public ResidentController find(ResidentController  srcResident) throws Exception
	{        int hashCode = srcResident.hashCode();

        ListObject floorList = table[hashCode];
        int size = floorList.size();

        for (int index = 0; index < size; index++)
        {
            ResidentController  resident = (ResidentController  ) floorList.get(index);
            if (resident.getNum_apartment() == srcResident.getNum_apartment())
            {
                return resident;
            }
        }
        return null;
    }

    @Override
    public void list(int floor) throws Exception
    {
        int hashCode = floor - 1;

        ListObject apartmentList = table[hashCode];
        int size = apartmentList.size();

        for (int index = 0; index < size; index++) {
            System.out.println(apartmentList.get(index).toString());
        }
    }
}