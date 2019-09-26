package com.training.secure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.secure.dao.SubjectDAO;
import com.training.secure.model.Subject;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	SubjectDAO subjectDao;

	public void addSubject(Subject subject) {
		subjectDao.addSubject(subject);
	}

	public List<Subject> getAllSubjects() {
		return subjectDao.getAllSubjects();
	}

	public String deleteSubject(String subTitle) {
		return subjectDao.deleteSubject(subTitle);
	}

	public List<Subject> searchSubject(String subTitle) {
		return subjectDao.searchSubject(subTitle);
	}

	public Subject getSubject(long subjectId) {
		return subjectDao.getSubject(subjectId);
	}
}
