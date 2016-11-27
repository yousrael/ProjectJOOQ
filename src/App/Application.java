package App;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.impl.DSL;
import java.sql.Connection;
import java.sql.DriverManager;


import  static test.generated.Tables.*;

public class Application {
    public static void main(String[] args) throws Exception {
       //Application des requetes JOOQ
          //printAllUsers();
    	//findUserById();
    	//findAccountByName();
    	//findAccountNameUserNotNULL();
    	findJoinUserAccount();
          
        }
    public static void printAllUsers(){
    	String userName = "root";
        String password ="123456";
        String url = "jdbc:mysql://localhost:3306/gestionAccount";
    	try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            Result<Record> result = create.select().from(USER).fetch();
            for (Record r : result) {
               Long id = r.getValue(USER.ID);
                String firstName = r.getValue(USER.FIRST_NAME);
                String lastName = r.getValue(USER.LAST_NAME);
                String email = r.getValue(USER.EMAIL);
                System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName+"email: "+email);
        } 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    public static void findUserById(){
    	String userName = "root";
        String password ="123456";
        String url = "jdbc:mysql://localhost:3306/gestionAccount";
    	try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            Record result = create.select().from(USER).where(USER.ID.eq((long) 1)).fetchOne();
          System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void findAccountByName(){
    	String userName = "root";
        String password ="123456";
        String url = "jdbc:mysql://localhost:3306/gestionAccount";
    	try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            Result<Record> result = create.select().from(ACCOUNT).where(ACCOUNT.NAME.like("acc%")).fetch();
          System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void findAccountNameUserNotNULL(){
    	String userName = "root";
        String password ="123456";
        String url = "jdbc:mysql://localhost:3306/gestionAccount";
    	try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            SelectConditionStep<Record1<String>> result = create.select(ACCOUNT.NAME).from(ACCOUNT).where(ACCOUNT.ID_U.isNotNull());
          System.out.println(result.fetch());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void findJoinUserAccount(){
    	String userName = "root";
        String password ="123456";
        String url = "jdbc:mysql://localhost:3306/gestionAccount";
    	try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            SelectOnConditionStep<Record3<String, Long, String>> result = create
                    .select(USER.FIRST_NAME,ACCOUNT.ID, ACCOUNT.NAME)
                    .from(ACCOUNT)
                    .join(USER).on(USER.ID.equal(ACCOUNT.ID_U));
          System.out.println(result.fetch());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    	
    }
    	
    
