package it.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.spring.model.Auto;
import it.spring.model.AutoDao;

public class App 
{
    public static void main( String[] args ) throws Exception{
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AutoDao dao = context.getBean(AutoDao.class);
        System.out.println("I prodotti sono " + dao.count());
        // Auto a = dao.getOne(1L); 
        // System.out.println("id: " + a.getModello());
        // System.out.println("id: " + a.getColore());
        // System.out.println("id: " + a.getBrand_id());

        Auto newAuto = new Auto();
        newAuto.setModello("Giulia");
        newAuto.setColore("Rosso");
        newAuto.setCvv(280);
        newAuto.setBrand_id(5L);
        // dao.insert(newAuto);

        // dao.delete(15L);
        
        dao.update(13L, newAuto);
        
        List<Auto> aut = dao.getData();

        for (Auto au : aut) {
            System.out.println(au.getModello());
        }


    }
}
