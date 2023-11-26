package gestion.stock.entity;

import java.sql.Connection;

public class AbstractDAO {
    protected Connection connection=SingleConnection.getConnection();
}
