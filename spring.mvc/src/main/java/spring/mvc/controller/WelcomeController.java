package spring.mvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import spring.mvc.dao.UserDao;
import spring.mvc.model.User;

@Controller
@SessionAttributes("username")
public class WelcomeController {

	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public UserDao getUserDao() {
		return userDao;
	}


	@RequestMapping("/")
	public String index(ModelMap modelMap) {
		User user=new User();
		//user.setName("Tops");
		modelMap.put("userData", user);
		return "index";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView modelAndView=new ModelAndView("hello");
		modelAndView.addObject("msg", "Welcome to Hello Page!!!");
		return modelAndView;
	}
	
	@RequestMapping(value = "/userPost", method=RequestMethod.POST)
	public ModelAndView userPost(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		ModelAndView modelAndView=new ModelAndView("userPost");
		modelAndView.addObject("name", name);
		modelAndView.addObject("age",age);
		return modelAndView;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute("userData") User user, 
			BindingResult bindingResult) {
		ModelAndView modelAndView=new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			modelAndView.setViewName("index");
		}
		else {
			System.out.println(user.getName());
			System.out.println(user.getEmail());
			System.out.println(user.getAge());
			userDao.saveUser(user);
			modelAndView.addObject("username", user.getName());
			modelAndView.setViewName("home");
		}
		return modelAndView;
	}
}
