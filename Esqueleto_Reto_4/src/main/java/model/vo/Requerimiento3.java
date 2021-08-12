package model.vo;

public class Requerimiento3 {

    private String nombreMaterial;
    private String importado;
    private Integer noCompras;

    public Requerimiento3() {

    }

    public Requerimiento3(String nombreMaterial, String importado, Integer noCompras) {
        this.nombreMaterial = nombreMaterial;
        this.importado = importado;
        this.noCompras = noCompras;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public String getImportado() {
        return importado;
    }

    public Integer getNoCompras() {
        return noCompras;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public void setImportado(String importado) {
        this.importado = importado;
    }

    public void setNoCompras(Integer noCompras) {
        this.noCompras = noCompras;
    }
}
