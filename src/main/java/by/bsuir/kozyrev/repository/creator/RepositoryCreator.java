package by.bsuir.kozyrev.repository.creator;

import by.bsuir.kozyrev.repository.impl.UserRepository;
import by.bsuir.kozyrev.database.ConnectionPool;
import by.bsuir.kozyrev.repository.impl.RoomRepository;

import java.sql.Connection;

public class RepositoryCreator implements AutoCloseable {

    private final ConnectionPool connectionPool;
    private final Connection connection;

    public RepositoryCreator() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    public UserRepository getUserRepository() {
        return new UserRepository(connection);
    }

    public RoomRepository getRoomRepository() {
        return new RoomRepository(connection);
    }

    @Override
    public void close() {
        connectionPool.returnConnection(connection);
    }


}
