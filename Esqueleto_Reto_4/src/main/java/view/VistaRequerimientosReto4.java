package view;

import controller.ControladorRequerimientosReto4;
import model.vo.Requerimiento2;
import model.vo.Requerimiento3;
import model.vo.Requerimiento1;

import java.sql.SQLException;
import java.util.ArrayList;

public class VistaRequerimientosReto4 {

    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    public static void requerimiento1() {

        System.out.println("-----5 Proyectos Menos Gasto-------");

        try {

            ArrayList<Requerimiento1> rankingProyectosCompras = controlador.consultarProyectosCompras10();

            //Encabezado del resultado
            System.out.println("ID_Proyecto Clasificación Gasto_Compras Serial");

            //Cada VO cargado, mostrarlo en la vista
            for (Requerimiento1 proyectoRankeado : rankingProyectosCompras) {
                System.out.printf("%d %s %d %s \n", 
                        proyectoRankeado.getIdProyecto(),
                        proyectoRankeado.getClasificacion(),
                        Math.round(proyectoRankeado.getGastoCompras()),
                        proyectoRankeado.getSerial() );
            }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public static void requerimiento2() {

        System.out.println("-----Ranking Bancos Con Menor Área (Área Proyectos)-------");

        try {

            ArrayList<Requerimiento2> rankingBancosArea = controlador.consultarBancosRankeadosAreaPromedio();

            //Encabezado del resultado
            System.out.println("Banco_Vinculado Area_Promedio");

            //Cada VO cargado, mostrarlo en la vista
            for (Requerimiento2 banco : rankingBancosArea) {
                System.out.printf("%s %f %n",
                        banco.getBancoVinculado(),
                        banco.getAreaPromedio()
                );
            }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public static void requerimiento3() {

        System.out.println("-----Ranking Descendente Materiales Importados (Compras)-------");

        try {

            ArrayList<Requerimiento3> rankingMaterialesImportados = controlador.consultarMaterialesRankeadosCompras();

            //Encabezado del resultado
            System.out.println("Nombre_Material Importado No_Compras");

            //Cada VO cargado, mostrarlo en la vista
            for (Requerimiento3 material : rankingMaterialesImportados) {
                System.out.printf("%s %s %d %n",
                        material.getNombreMaterial(),
                        material.getImportado(),
                        material.getNoCompras()
                );
            }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

}
