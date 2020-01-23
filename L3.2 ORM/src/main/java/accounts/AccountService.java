package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {
    DBService loginToProfileDbService;
    private final Map<String, UsersDataSet> sessionIdToProfile;




    public AccountService() {
        loginToProfileDbService =  new DBService();
        sessionIdToProfile = new HashMap<>();
    }

    public void addNewUser(UsersDataSet usersDataSet) throws DBException {
        loginToProfileDbService.addUser(usersDataSet.getLogin(), usersDataSet.getPass(),usersDataSet.getEmail());
    }

    public UsersDataSet getUserByLogin(String login) throws DBException {
        return  loginToProfileDbService.getUser(login);
    }

    public UsersDataSet getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, UsersDataSet usersDataSet) {
        sessionIdToProfile.put(sessionId, usersDataSet);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }
}
