package ex02.controller;

import br.fatec.ListInt.ListInt;

public class TableController implements I_TableObject
{
    ListInt[] table;

    public TableController()
    {
        this.table = new ListInt[2];

        table[0] = new ListInt();
        table[1] = new ListInt();
    }

    @Override
    public void add(int number) throws Exception
    {
        int hash = hashCode(number);
        ListInt list = table[hash];

        if (list.isEmpty())
            list.addFirst(number);
        else
            list.addLast(number);
    }

    @Override
    public Object find(int number) throws Exception
    {
        int hash = hashCode(number);
        ListInt list = table[hash];
        int size = list.size();

        for (int index = 0; index < size; index++) {
            int node = list.get(index);
            if (node == number)
                return node;
        }
        return null;
    }

    @Override
    public void remove(int number) throws Exception
    {
        int hash = hashCode(number);
        ListInt list = table[hash];
        int size = list.size();

        for (int index = 0; index < size; index++) {
            int node = list.get(index);
            if (node == number)
            {
                list.remove(index);
                break;
            }
        }
    }

    public void list(boolean impar) throws Exception
    {
        int hash = impar ? 1 : 0;

        ListInt numbers = table[hash];
        int size = numbers.size();

        if (impar)
            System.out.print("Impares:\t");
        else
            System.out.print("Pares:\t\t");
        for (int index = 0; index < size; index++)
        {
            System.out.print(numbers.get(index));
            if (index != size -1)
                System.out.print(", ");
        }
        System.out.println();
    }

    public int hashCode(int number)
    {
        int index = 0;
        if (number % 2 != 0)
            index = 1;
        return index;
    }
}
