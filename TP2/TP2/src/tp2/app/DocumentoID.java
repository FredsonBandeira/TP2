package app;

public class DocumentoID {
    private String codigoID;
    private TipoDocumento tipo;

    public DocumentoID(String codigoID, TipoDocumento tipo) {
        this.codigoID = codigoID;
        this.tipo = tipo;
    }

    public String getCodigoID() {
        return codigoID;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }
}
