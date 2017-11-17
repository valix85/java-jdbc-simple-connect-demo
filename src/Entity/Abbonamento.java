package Entity;

public class Abbonamento {

    private long idAbbonamento;
    private String descrizione;
    private double costoAlSecondo;
    private boolean attivo;
    private boolean cancellato;

    public Abbonamento(){};

    public Abbonamento(long idAbbonamento, String descrizione, double costoAlSecondo, boolean attivo, boolean cancellato) {
        this.idAbbonamento = idAbbonamento;
        this.descrizione = descrizione;
        this.costoAlSecondo = costoAlSecondo;
        this.attivo = attivo;
        this.cancellato = cancellato;
    }

    public Abbonamento(String descrizione, double costoAlSecondo, boolean attivo, boolean cancellato) {
        this.descrizione = descrizione;
        this.costoAlSecondo = costoAlSecondo;
        this.attivo = attivo;
        this.cancellato = cancellato;
    }


    public long getIdAbbonamento() {
        return idAbbonamento;
    }

    public void setIdAbbonamento(long idAbbonamento) {
        this.idAbbonamento = idAbbonamento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getCostoAlSecondo() {
        return costoAlSecondo;
    }

    public void setCostoAlSecondo(double costoAlSecondo) {
        this.costoAlSecondo = costoAlSecondo;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public boolean isCancellato() {
        return cancellato;
    }

    public void setCancellato(boolean cancellato) {
        this.cancellato = cancellato;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "idAbbonamento=" + idAbbonamento +
                ", descrizione='" + descrizione + '\'' +
                ", costoAlSecondo=" + costoAlSecondo +
                ", attivo=" + attivo +
                ", cancellato=" + cancellato +
                '}';
    }
}


