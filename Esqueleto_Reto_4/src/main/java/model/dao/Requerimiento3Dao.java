package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.Requerimiento3;

public class Requerimiento3Dao {

   
    public ArrayList<Requerimiento3> rankingMaterialesComprasDescendente() throws SQLException {

        ArrayList<Requerimiento3> respuesta = new ArrayList<>();
        Connection conexion = JDBCUtilities.getConnection();

        try {

            String consulta = "SELECT MaterialConstruccion.Nombre_Material,MaterialConstruccion.Importado,count(*) AS No_Compras FROM MaterialConstruccion\n" +
                              "JOIN Compra ON Compra.ID_MaterialConstruccion = MaterialConstruccion.ID_MaterialConstruccion\n" +
                              "WHERE MaterialConstruccion.Importado = 'Si'\n" +
                              "GROUP BY Compra.ID_MaterialConstruccion ORDER BY No_Compras ASC ;";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while (resultSet.next()) {
                Requerimiento3 materialRankeadoCompras = new Requerimiento3();
                materialRankeadoCompras.setNombreMaterial(resultSet.getString("Nombre_Material"));
                materialRankeadoCompras.setImportado(resultSet.getString("Importado"));
                materialRankeadoCompras.setNoCompras(resultSet.getInt("No_Compras"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(materialRankeadoCompras);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultando ranking de materiales importados según número de compras: " + e);
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

        //Retornar la colección de vo's
        return respuesta;

    }

}
