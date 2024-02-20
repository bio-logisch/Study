package com.cafe.human;

import java.util.Locale;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	 
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		String formattedDate ="nodata";
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/abc", method = RequestMethod.GET)
	public String abd(Locale locale, Model model) {	
		String formattedDate ="abccc";		
		model.addAttribute("serverTime", formattedDate );		
		return "home";
	}
	@RequestMapping(value = "/selMenu", method = RequestMethod.GET)
	public String selMenu(Locale locale, Model model) {	
		Random r = new Random();
		String menu[] = {"pizz", "gamja", "goguma"};
		model.addAttribute("today", menu[r.nextInt(menu.length)] );		
		return "todayfood";
	}
	@RequestMapping(value = "/getSchedule", method = RequestMethod.GET)
	public String getsc(Locale locale, Model model) {
		model.addAttribute("am", "java");	
		model.addAttribute("pm", "spring");
		return "todaySchedule";
	}
	
}
