package co.edu.uco.onlinetest.data.dao.entity;

import co.edu.uco.onlinetest.crosscutting.excepciones.OnlineTestException;

import java.sql.SQLException;

public interface CreateDAO <E>{


    void create (E entity) throws OnlineTestException;
}
