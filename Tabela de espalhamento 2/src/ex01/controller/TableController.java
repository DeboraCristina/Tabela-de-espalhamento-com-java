package ex01.controller;

import br.fatec.ListInt.ListInt;

public class TableController implements I_TableObject
{
    ListInt[] table;

    public TableController(int lengthTable)
    {
        this.table = new ListInt[lengthTable];

        for (int index = 0; index < lengthTable; index++)
        {
            table[index] = new ListInt();
        }
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

    public void show() throws Exception
    {
        int length = table.length;

        for (int index = 0; index < length; index++)
        {
            ListInt list = table[index];
            if (!list.isEmpty())
                printList(list);
        }
    }

    private void printList(ListInt list) throws Exception
    {
        int size = list.size();
        for (int index = 0; index < size; index++) {
            int value = list.get(index);
            System.out.print(value);
            if (index != size - 1)
                System.out.print(", ");
        }
        System.out.println();
    }

    public int hashCode(int number)
    {
        int index = (int) (100 * (((Math.sqrt(7-1)/2) * number) % 1));
        return index;
    }
}
