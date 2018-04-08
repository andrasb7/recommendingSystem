package tvssa.common;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import tvssa.common.dao.UserDAO;
import tvssa.common.entities.UserE;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        UserDAO userDAO = new UserDAO();
        UserE user = new UserE();
        user.setUserName("asdddddd");
        userDAO.create(user);
        
        
        
    }
}
