package com.oneToMany_ManyTOone;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        
        Question1 qus1=new Question1();
        qus1.setQuesid(345);
        qus1.setQuestions("what is java?");
        
        Answer1 ans1=new Answer1();
        ans1.setAnsid(789);
        ans1.setAnswer("java is a programming language");
        ans1.setQus(qus1);
        Answer1 ans11=new Answer1();
        ans11.setAnsid(791);
        ans11.setAnswer("java is object oriented language");
        ans11.setQus(qus1);
        Answer1 ans12=new Answer1();
        ans12.setAnsid(792);
        ans12.setAnswer("java is used to create many applications");
        ans12.setQus(qus1);
        
        List<Answer1> list=new ArrayList<>();
        list.add(ans1);
        list.add(ans11);
        list.add(ans12);
        qus1.setAnswers(list);
                
        Session session=sf.openSession();
        Transaction tc=session.beginTransaction();
        session.save(qus1);
        session.save(ans1);
        session.save(ans11);
        session.save(ans12);
        tc.commit();
        
        //Fetch data
        Question1 qs=(Question1)session.get(Question1.class, 345);
        System.out.println(qs.getQuestions());
        for(Answer1 a:qs.getAnswers())
        System.out.println(a.getAnswer());
        
        session.close();
        sf.close();
        
    }
}
