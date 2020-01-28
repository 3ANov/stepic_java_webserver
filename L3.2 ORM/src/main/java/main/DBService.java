package main;

import dbService.DBException;
import dbService.dataSets.UsersDataSet;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public interface DBService {

    void printConnectInfo();
    UsersDataSet getUser(String login) throws DBException;
    long addUser(UsersDataSet usersDataSet) throws DBException;
    UsersDataSet getUser(long id) throws DBException;


}
