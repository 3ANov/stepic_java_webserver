package servlets;

import accounts.AccountService;
import dbService.DBException;
import dbService.dataSets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        UsersDataSet profile = new UsersDataSet(login,pass,login);
        try {
            accountService.addNewUser(profile);
        } catch (DBException e) {
            e.printStackTrace();
        }
        response.setStatus(HttpServletResponse.SC_OK);

    }
}
