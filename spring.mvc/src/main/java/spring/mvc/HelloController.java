package spring.mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class HelloController {

	@Autowired
	private UserDaoSupport dao;
	
	public UserDaoSupport getDao() {
		return dao;
	}
	public void setDao(UserDaoSupport dao) {
		this.dao = dao;
	}

	@RequestMapping("/")
	public String index(ModelMap modelMap) {
		User user=new User();
		user.setName("Test");
		modelMap.put("userData", user);
		return "index";
	}
	
	@RequestMapping("/hello.html")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/welcome.html")
	public ModelAndView welcome() {
		ModelAndView modelView=new ModelAndView("welcome");
		modelView.addObject("msg", "Welcome to Spring MVC");
		return modelView;
	}
	
//	@RequestMapping("/postSubmit.html")
//	public ModelAndView postSubmit(HttpServletRequest req, HttpServletResponse resp) {
//		ModelAndView modelView=new ModelAndView("postSubmit");
//		String firstName=req.getParameter("fname");
//		String lastName=req.getParameter("lname");
//		modelView.addObject("fname",firstName);
//		modelView.addObject("lname",lastName);
//		return modelView;
//	}
	
	
	@RequestMapping(value="/postSubmit.html", method=RequestMethod.POST)
	public ModelAndView postSubmit(@Valid @ModelAttribute("userData")User user,
			BindingResult bindingResult) {
		ModelAndView modelView=new ModelAndView();
		if(bindingResult.hasErrors()) {
			modelView.setViewName("index");
		}else {
			System.out.println(user.getName());
			System.out.println(user.getEmail());
			System.out.println(user.getAge());
			dao.saveUser(user);
			modelView.setViewName("postSubmit");
			modelView.addObject("user", user);
		}
		return modelView;
	}
	
}
