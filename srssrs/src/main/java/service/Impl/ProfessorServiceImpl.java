package service.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.main.Professor;
import dao.main.ProfessorCatalog;
import service.ProfessorService;
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("professorService")
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
	private ProfessorCatalog professorCatlog;
	
	@Override
	public boolean addProfessor(Professor professor) {
		return professorCatlog.addProfessor(professor);
	}
	@Override
	public boolean deleteProfessor(String ssn) {
		// TODO Auto-generated method stub
		boolean result=professorCatlog.deleteProfessor(ssn);
		return result;
	}
	@Override
	public ArrayList<Professor> queryProfessor() {
		// TODO Auto-generated method stub
		return professorCatlog.getProfessorCatalog();
	}
	@Override
	public boolean updateProfessor(Professor professor) {
		// TODO Auto-generated method stub
		boolean result=professorCatlog.updateProfessor(professor);
		return result;
	}
 
	
}
