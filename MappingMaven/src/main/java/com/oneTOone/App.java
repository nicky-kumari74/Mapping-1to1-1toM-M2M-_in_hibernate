package com.oneTOone;

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
        
        Question qus1=new Question();
        qus1.setQuesid(345);
        qus1.setQuestions("what is java?");
        Answer ans1=new Answer();
        ans1.setAnsid(789);
        ans1.setAnswer("java is a programming language");
        qus1.setAnswer(ans1);
        
        Question qus2=new Question();
        qus2.setQuesid(389);
        qus2.setQuestions("what is javaScript?");
        Answer ans2=new Answer();
        ans2.setAnsid(756);
        ans2.setAnswer("javascript is a scripting language");
        qus2.setAnswer(ans2);
        
        Session session=sf.openSession();
        Transaction tc=session.beginTransaction();
        session.save(qus1);
        session.save(qus2);
        session.save(ans1);
        session.save(ans2);
        tc.commit();
        //Fetch data
        Question qs=(Question)session.get(Question.class, 389);
        System.out.println(qs.getQuestions());
        System.out.println(qs.getAnswer().getAnswer());
        session.close();
        sf.close();
        
    }
}
