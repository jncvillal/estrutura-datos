SELECT Proyecto.Banco_Vinculado,AVG(Tipo.Area_Max) AS Area_Promedio FROM Proyecto
JOIN Tipo ON Tipo.ID_Tipo = Proyecto.ID_Tipo GROUP BY Proyecto.Banco_Vinculado ORDER BY Area_Promedio;