package com.training.secure.dao;

import java.util.List;

import com.training.secure.model.Subject;

public interface SubjectDAO {
	public void addSubject(Subject subject);
	public List<Subject> getAllSubjects();
	public String deleteSubject(String subTitle);
	public List<Subject> searchSubject(String subTitle);
	public Subject getSubject(long subjectId);
	
}
