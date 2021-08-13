package model.vo;

public class Requerimiento1 {

    private Integer idProyecto;
    private String clasificacion;
    private Double gastoCompras;
    private String serial;

    public Requerimiento1() {

    }

    public Requerimiento1(Integer id_proyecto, String clasificacion, String serial) {
        this.idProyecto = id_proyecto;
        this.clasificacion = clasificacion;
        this.serial = serial;
    }

    public Requerimiento1(Integer id_proyecto, String clasificacion, String serial, Double gastoCompras) {
        this(id_proyecto, clasificacion, serial);
        this.gastoCompras = gastoCompras;
    }

    //Get and Set

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public Double getGastoCompras() {
        return gastoCompras;
    }

    public String getSerial() {
        return serial;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setGastoCompras(Double gastoCompras) {
        this.gastoCompras = gastoCompras;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
