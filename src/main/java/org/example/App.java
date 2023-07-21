package org.example;

import org.example.model.Principal;
import org.example.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Principal.class)
                .addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // получите любого директора, а затем получите его школу
//            Principal p = session.get(Principal.class, 3);
//            School s = p.getSchool();
//            System.out.println(p);
//            System.out.println(s);

            //Получите любую школу, а затем получите ее директора
//            School s = session.get(School.class, 2);
//            Principal p = s.getPrincipal();
//            System.out.println(p);

            //Создайте нового директора и новую школу и свяжите эти сущности
//            Principal p = new Principal("Todd", 89);
//            School s = new School(290);
//            p.setSchool(s);
//            System.out.println(p);
//
//            session.save(p);

            //Смените директора у существующей школы
//            School s = session.get(School.class, 4);
//            s.setPrincipal(session.get(Principal.class,5));

            //Попробуйте добавить вторую школу для существующего директора и
            //изучите возникающую ошибку
//            School s = new School(403);
//            Principal p =session.get(Principal.class,5);
//            p.setSchool(s);
            //Ошибка - повторяющееся значение ключа нарушает ограничение уникальности
            // у нас в таблице поле principal_id int UNIQUE REFERENCES Principal(id) ON DELETE SET NULL
            // UNIQUE - уникальный, не может быть повторений

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
