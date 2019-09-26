package com.training.secure.service;

import java.util.List;

import com.training.secure.model.Subject;

public interface SubjectService {
	public void addSubject(Subject subject);
	public List<Subject> getAllSubjects();
	public String deleteSubject(String subTitle);
	public List<Subject> searchSubject(String subTitle);
	public Subject getSubject(long subjectId);
	
}
