package pl.atena.core;

import java.sql.SQLException;
import java.util.List;

import pl.atena.domain.base.Entity;
import pl.atena.domain.polisa.PolisaFiltr;

public interface BaseDao<T extends Entity> {

	void create(T entity) throws SQLException;

	void retrieve(T entity) throws SQLException;

	void update(T entity) throws SQLException;

	void delete(T entity) throws SQLException;

	void select(PolisaFiltr filtr) throws SQLException;

}
