package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper { private static QueryRunner runner = new QueryRunner();

    private SQLHelper() {
    }

    private static Connection getConnMySql() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    private static Connection getConnPostgres() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "app", "pass");
    }



  /*  @SneakyThrows
    public static DataHelper.VerificationCode getVerificationCode() {
        var codeSQL = "SELECT code FROM auth_codes ORDER by created DESC LIMIT 1";
        var conn = getConn();
        var code = runner.query(conn, codeSQL, new ScalarHandler<String>());
        return new DataHelper.VerificationCode(code);
    }

    @SneakyThrows
    public static void cleanDataBase() {
        var connection = getConn();
        runner.execute(connection, "DELETE FROM auth_code");
        runner.execute(connection, "DELETE FROM card_transactions");
        runner.execute(connection, "DELETE FROM card");
        runner.execute(connection, "DELETE FROM users");


    }
*/
    @SneakyThrows
    public static String getLastPayUserStatusMySQL() {
        var payStatus = "SELECT status FROM payment_entity order by created desc LIMIT 1";
        var conn = getConnMySql();
        var result = runner.query(conn, payStatus, new ScalarHandler<String>());
        return result;

    }
    @SneakyThrows
    public static int getLastPayUserAmountMySQL() {
        var amount = "SELECT amount FROM payment_entity order by created desc LIMIT 1";
        var conn = getConnMySql();
        var result = runner.query(conn, amount, new ScalarHandler<Integer>());
        return result;

    }
    @SneakyThrows
    public static String getLastPayOnCreditUserStatusMySQL() {
        var creditStatus = "SELECT status FROM credit_request_entity order by created desc LIMIT 1";
        var conn = getConnMySql();
        var result = runner.query(conn, creditStatus, new ScalarHandler<String>());
        return result;

    }

    @SneakyThrows
    public static int getLastPayOnCreditUserAmountMySQL() {
        var approvedAmount = "SELECT amount FROM credit_request_entity order by created desc LIMIT 1";
        var conn = getConnMySql();
        var result = runner.query(conn, approvedAmount, new ScalarHandler<Integer>());
        return result;

    }
  //SELECT amount,created,status  FROM payment_entity  order by created  desc limit 1
}
