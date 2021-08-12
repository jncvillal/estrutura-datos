package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import model.dao.Requerimiento1Dao;
import model.vo.Requerimiento1;
import model.dao.Requerimiento2Dao;
import model.vo.Requerimiento2;
import model.dao.Requerimiento3Dao;
import model.vo.Requerimiento3;

//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientosReto4 {       
    
    private final Requerimiento1Dao proyectoRankeadoDao;
    private final Requerimiento2Dao bancoRankeadoAreaPromedioDao;
    private final Requerimiento3Dao materialRankeadoComprasDao;

   //Costructor 
    public ControladorRequerimientosReto4(){
        this.proyectoRankeadoDao = new Requerimiento1Dao();
        this.bancoRankeadoAreaPromedioDao = new Requerimiento2Dao();       
        this.materialRankeadoComprasDao = new Requerimiento3Dao();
    }

    public ControladorRequerimientosReto4(Requerimiento1Dao proyectoRankeadoDao, Requerimiento2Dao bancoRankeadoAreaPromedioDao, Requerimiento3Dao materialRankeadoComprasDao) {
        this.proyectoRankeadoDao = proyectoRankeadoDao;
        this.bancoRankeadoAreaPromedioDao = bancoRankeadoAreaPromedioDao;
        this.materialRankeadoComprasDao = materialRankeadoComprasDao;
    }

    public ArrayList<Requerimiento1> consultarProyectosCompras10() throws SQLException {
        return this.proyectoRankeadoDao.rankingProyectosComprasDescendente10();
    }
    
    public ArrayList<Requerimiento2> consultarBancosRankeadosAreaPromedio() throws SQLException {
        return this.bancoRankeadoAreaPromedioDao.rankingBancosAreaPromedioDescendente();
    }

    public ArrayList<Requerimiento3> consultarMaterialesRankeadosCompras() throws SQLException {
        return this.materialRankeadoComprasDao.rankingMaterialesComprasDescendente();
    }
}
