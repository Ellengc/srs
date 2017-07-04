package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.main.Professor;
import service.ProfessorService;
/**
 * 对教师进行增删查改,问题：教师编号无法以0开头，easyUI numberbox的bug
 * @author Administrator
 *
 */
@Controller
public class ProfessorController {
	@Autowired
	@Qualifier("professorService")
	private ProfessorService professorService;
	@RequestMapping(value="addProfessor")
	@ResponseBody
	public boolean addProfessor(@ModelAttribute Professor professor){
		boolean result=professorService.addProfessor(professor);		
		return result;
	}
	@RequestMapping(value="professorManager")

	public  String queryProfessor(Model model){
		List<Professor> result=professorService.queryProfessor();
		model.addAttribute("professors", result);
		return "professorManager";
	}
	@RequestMapping(value="deleteProfessor")
	@ResponseBody
	public ModelAndView deleteProfessor(String ssn,ModelAndView mv){
		boolean result=professorService.deleteProfessor(ssn);
		mv.setViewName("professorManager");
		mv.addObject("result", result);
		return mv;
	}
	@RequestMapping(value="updateProfessor")
	public ModelAndView updateProfessor(ModelAndView mv,
			@ModelAttribute Professor professor){
		boolean result=professorService.updateProfessor(professor);
		mv.setViewName("professorManager");
		mv.addObject("result", result);
		return mv;
	}
}
