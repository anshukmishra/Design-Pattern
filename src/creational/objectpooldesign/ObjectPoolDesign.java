package creational.objectpooldesign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class DBConnection{
    Connection connection;

    DBConnection(){
        try{
            connection = DriverManager.getConnection("url", "username", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
};

class DBConnectionManager{
    private List<DBConnection> freeConnectionPool = new ArrayList<>();
    private List<DBConnection> connectionsCurrentlyInUse = new ArrayList<>();

    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 3;

    private static DBConnectionManager dbConnectionManager = null;

    private DBConnectionManager(){
        for(int i=0; i<INITIAL_POOL_SIZE; i++) freeConnectionPool.add(new DBConnection());
    }

    public static DBConnectionManager getInstance(){
        if(dbConnectionManager==null){
            synchronized (DBConnectionManager.class){
                dbConnectionManager = new DBConnectionManager();
            }
        }
        return dbConnectionManager;
    }

    public synchronized DBConnection getDBConnection(){
        if(freeConnectionPool.isEmpty() && connectionsCurrentlyInUse.size()<MAX_POOL_SIZE){
            freeConnectionPool.add(new DBConnection());
        }
        else if(freeConnectionPool.isEmpty() && connectionsCurrentlyInUse.size()>=MAX_POOL_SIZE){
            return null;
        }
        DBConnection dbConnection = freeConnectionPool.remove(freeConnectionPool.size()-1);
        connectionsCurrentlyInUse.add(dbConnection);
        return dbConnection;
    }

    public synchronized void releaseDBConnection(DBConnection dbConnection){
        if(dbConnection!=null){
            connectionsCurrentlyInUse.remove(dbConnection);
            freeConnectionPool.add(dbConnection);
        }
        return;
    }
};

public class ObjectPoolDesign {
    public static void main(String[] args) {
        DBConnectionManager dbPoolManager = DBConnectionManager.getInstance();
        DBConnection connection1 = dbPoolManager.getDBConnection();
        DBConnection connection2 = dbPoolManager.getDBConnection();
        DBConnection connection3 = dbPoolManager.getDBConnection();
        DBConnection connection4 = dbPoolManager.getDBConnection();
        DBConnection connection5 = dbPoolManager.getDBConnection();
        DBConnection connection6 = dbPoolManager.getDBConnection();
        dbPoolManager.releaseDBConnection(connection4);
    }
}
