package Service;

import Entity.Abbonamento;

import javax.management.Query;

public interface AbbonamentoService {

    public String getAll();
    public String getLast();
    public String addAbbonamento(Abbonamento abb);
    public String deleteStmByID();

    String update(Long id);
}
