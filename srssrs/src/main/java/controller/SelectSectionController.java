package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Dto.SectionDto;
import dao.main.Student;
import service.LoginService;
import service.SectionService;
import service.SelectSectionService;

/**
 * 选课流程
 * 
 * @author Administrator
 *
 */
@Controller
public class SelectSectionController {
	private Student student;
	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;
	@Autowired
	private SectionService sectionService;
	@Autowired
	private SelectSectionService selectSectionService;

	@RequestMapping(value = "/studentLogin")
	@ResponseBody
	public Boolean login(String ssn, String password, Model model, HttpSession session) {
		student = loginService.studentLogin(ssn, password);
		if (student != null) {
		    session.setAttribute("student", student);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 选课之前查询课程安排
	 * 
	 * @return
	 */
	@RequestMapping(value = "section")

	public Object querySection(Model model) {
		List<SectionDto> list = new ArrayList<SectionDto>();
		list = sectionService.querySection();
		model.addAttribute("sections", list);
		return "section";
	}

	/**
	 * 学生选课
	 * 
	 * @param sectionNo
	 * @return
	 */
	@RequestMapping(value = "selectSection", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object selectSection(int sectionNo, HttpSession session) {
		Student student = (Student) session.getAttribute("student");
		String ssn = student.getSsn();
		String result = selectSectionService.selectSection(ssn, sectionNo);
		return result;
	}

	/**
	 * 查看某门课有哪些学生选了
	 */
	@RequestMapping(value = "queryEnrolledStudents")
	@ResponseBody
	public Object queryEnrolledStudents(int sectionNo) {
		/* int sectionNo=2; */
		ArrayList<Student> enrolledStudents = new ArrayList<Student>();
		enrolledStudents = selectSectionService.queryEnrolledStudents(sectionNo);
		return enrolledStudents;
	}

}
