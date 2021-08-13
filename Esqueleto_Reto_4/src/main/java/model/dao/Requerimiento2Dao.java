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
import model.vo.Requerimiento2;

public class Requerimiento2Dao {


    public ArrayList<Requerimiento2> rankingBancosAreaPromedioDescendente() throws SQLException {

        ArrayList<Requerimiento2> respuesta = new ArrayList<>();
        Connection conexion = JDBCUtilities.getConnection();

        try {

            String consulta = "SELECT Proyecto.Banco_Vinculado,AVG(Tipo.Area_Max) AS Area_Promedio FROM Proyecto\n" +
                              "JOIN Tipo ON Tipo.ID_Tipo = Proyecto.ID_Tipo GROUP BY Proyecto.Banco_Vinculado ORDER BY Area_Promedio;";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while (resultSet.next()) {
                Requerimiento2 bancoRankeadoAreaPromedio = new Requerimiento2();
                bancoRankeadoAreaPromedio.setBancoVinculado(resultSet.getString("Banco_Vinculado"));
                bancoRankeadoAreaPromedio.setAreaPromedio(resultSet.getDouble("Area_Promedio"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(bancoRankeadoAreaPromedio);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultando ranking de bancos según el área promedio de proyectos respaldados: " + e);
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

        //Retornar la colección de vo's
        return respuesta;

    }

}
