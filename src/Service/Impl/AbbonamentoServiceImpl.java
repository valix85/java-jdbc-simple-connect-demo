package Service.Impl;

import Entity.Abbonamento;
import Service.AbbonamentoService;

public class AbbonamentoServiceImpl implements AbbonamentoService {

    public String getAll() {
        return "SELECT * FROM abbonamento";
    }

    public String getLast() {
        return "SELECT * FROM abbonamento ORDER BY id DESC LIMIT 0,1;";
    }

    public String addAbbonamento(Abbonamento abb) {
        return "INSERT INTO abbonamento (`label`,`costo_secondo`,`attivato`,`cancellato`) VALUES (" +
                " '" + abb.getDescrizione() + "'" +
                ", " + abb.getCostoAlSecondo() + "" +
                ", " + abb.isAttivo() + "" +
                ", " + abb.isCancellato() + "" +
                ");";

    }

    public String deleteStmByID(){
        return "DELETE FROM abbonamento WHERE id = ? ;";
    }

    @Override
    public String update(Long id) {
        return "UPDATE abbonamento SET " +
                "id = ?, " +
                "label = ?, " +
                "costo_secondo = ?, " +
                "attivato= ?, " +
                "cancellato = ? " +
                "WHERE id = "+id+" ;";
    }
}
