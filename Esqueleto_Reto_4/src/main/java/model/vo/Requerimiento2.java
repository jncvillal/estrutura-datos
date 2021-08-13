package model.vo;

public class Requerimiento2 {

    private String bancoVinculado;
    private Double areaPromedio;

    public Requerimiento2() {

    }

    public Requerimiento2(String bancoVinculado, Double areaPromedio) {
        this.bancoVinculado = bancoVinculado;
        this.areaPromedio = areaPromedio;

    }

    public String getBancoVinculado() {
        return bancoVinculado;
    }

    public Double getAreaPromedio() {
        return areaPromedio;
    }

    public void setBancoVinculado(String bancoVinculado) {
        this.bancoVinculado = bancoVinculado;
    }

    public void setAreaPromedio(Double areaPromedio) {
        this.areaPromedio = areaPromedio;
    }
}
