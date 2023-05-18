package ex02.controller;

import ex02.model.ResidentController;

public interface I_CondominioTable
{
    public void add(ResidentController srcResident) throws Exception;
    public void remove(ResidentController  srcResident) throws Exception;
    public ResidentController find(ResidentController  srcResident) throws Exception;
    public void list(int floor) throws Exception;
}
