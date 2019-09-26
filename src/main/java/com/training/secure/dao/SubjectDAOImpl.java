package com.training.secure.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.secure.model.Subject;


@Repository
@Transactional
public class SubjectDAOImpl implements SubjectDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public String deleteSubject(String subTitle) {
		String hql = "FROM Subject b WHERE b.subtitle ='" + subTitle + "'";
		Session session= this.sessionFactory.getCurrentSession();
		Query<Subject> query = session.createQuery(hql);
		List<Subject> results = query.list();
		if(results == null || results.size() == 0) {
			System.out.println("Subject is not found." + subTitle);
			return "Subject is not found." + subTitle;
		} else {
			String subjectDelete = "";
			for (Subject subject : results) {
				System.out.println("Subject deleted successfully." + subject.getSubtitle());
				if(subjectDelete != "") {
					subjectDelete = subjectDelete + ";" + subject.getSubtitle();
				} else {
					subjectDelete = subject.getSubtitle();
				}
				session.delete(subject);
			}
			return "Subject deleted successfully." + subjectDelete;
		}
	}

	public void addSubject(Subject subject) {
		Session session= this.sessionFactory.getCurrentSession();
		session.save(subject);
		System.out.println("Subject added successfully." + subject);
	}

	
	public List<Subject> getAllSubjects() {
		Session session= this.sessionFactory.getCurrentSession();
		List<Subject> subjects = session.createQuery("from Subject").list();
		return subjects;
	}
	
	public List<Subject> searchSubject(String subTitle) {
		Session session= this.sessionFactory.getCurrentSession();
		String hql = "FROM Subject S WHERE S.subtitle = '" + subTitle +"'";
		Query query = session.createQuery(hql);
		List<Subject> subjects = query.list();
		for (Subject searchSubject : subjects) {
			System.out.println("Subject Id: " + searchSubject.getSubjectId());
			System.out.println("Subtitle: " + searchSubject.getSubtitle());
			System.out.println("DurationInHours: " + searchSubject.getDurationInHours());
			System.out.println("Reference Book: " + searchSubject.getReferences());
		}
		if(subjects == null || subjects.size() == 0) {
			System.out.println("Subject is not found.");
		}
		return subjects;
	}

	public Subject getSubject(long subjectId) {
		Session session= this.sessionFactory.getCurrentSession();
		Subject subject = session.get(Subject.class, subjectId);
		return subject;
	}

}
