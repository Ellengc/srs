package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.main.Student;
import service.TranscriptService;

/**
 * 对成绩单进行相关操作
 * 
 * @author Administrator
 *
 */
@Controller
public class TranscriptController {
	@Autowired
	private TranscriptService transcriptService;

	@RequestMapping(value = "transcript")

	public String queryTranscript(HttpSession session,Model model) {
		Student student = (Student) session.getAttribute("student");
		if (student != null) {
			String ssn = student.getSsn();
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			list = transcriptService.queryTranscript(ssn);
            if(list.size()==0){
            	Map<String,String> map=new HashMap<String, String>();
            	map.put("name", "您还没有选择任何课程,或者你的课程还没有出成绩");
            	list.add(map);
            }
			model.addAttribute("transcripts",list);
		}
		return "transcript";

	}

}
