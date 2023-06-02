package rs.ac.bg.fon.repository.db;

import rs.ac.bg.fon.repository.Repository;

public interface DbConnectionRepository<T> extends Repository<T> {

    default public void connect() throws Exception {
        DbConnectionFactory.getInstance().getConnection();
    }

    default public void disconnect() throws Exception {
        DbConnectionFactory.getInstance().getConnection().close();
    }

    default public void commit() throws Exception {
        DbConnectionFactory.getInstance().getConnection().commit();
    }

    default public void rollback() throws Exception {
        DbConnectionFactory.getInstance().getConnection().rollback();
    }

}
