package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 动态跳转控制器
 * @author Administrator
 *
 */
@Controller
public class JspController {
	@RequestMapping("")
	public String index() {
		return "backlogin";
	}
	
	@RequestMapping(value="/{formName}")
	public String jspReturn(@PathVariable String formName){
		
		return formName;		
	}
}
