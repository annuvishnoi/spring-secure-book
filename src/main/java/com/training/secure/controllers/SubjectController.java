package com.training.secure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.secure.model.Subject;
import com.training.secure.service.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	
	@RequestMapping("/addsubject")
	public String subjectform(Model model) {
		model.addAttribute("subject", new Subject());
		return "subjectform";
	}
	
	@RequestMapping("/deletesubjectform")
	public String deletesubjectform() {
		return "deletesubjectform";
	}
	
	@RequestMapping("/searchsubjectform")
	public String searchsubjectform() {
		return "searchsubjectform";
	}
	@RequestMapping(value ="/savesubject", method = RequestMethod.POST)
	public String savebook(@ModelAttribute("Subject") Subject subject, Model model) {
		subjectService.addSubject(subject);
		model.addAttribute("subject", subject);
		return "success";
	}
	@RequestMapping(value = "/searchSubject")
	public String Search(@RequestParam("searchString") String searchString, Model model) {
		List<Subject> subjects = subjectService.searchSubject(searchString);
		model.addAttribute("subjects", subjects);
		return "searchResult";
	}
	@RequestMapping(value = "/deleteSubject")
	public String delete(@RequestParam("subjectTitle") String subjectTitle, Model model) {
		
		String result = subjectService.deleteSubject(subjectTitle);
		model.addAttribute("subjects", subjectService.getAllSubjects());
		model.addAttribute("fromSubject", true);
		model.addAttribute("result", result);
		return "deleteResult";
	}
}
