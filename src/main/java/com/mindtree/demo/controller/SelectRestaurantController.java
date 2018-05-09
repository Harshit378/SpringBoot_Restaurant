package com.mindtree.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.demo.entity.Menu;
import com.mindtree.demo.entity.Restaurants;
import com.mindtree.demo.service.GetDetails;

/**
 * @author M1037580
 *
 */
@RestController

public class SelectRestaurantController {
	@Autowired
	GetDetails getDetails;
	Menu menu = null;
	Restaurants restuarants = null;
	private String restaurantName= null;
	@RequestMapping(value="/")
	public ModelAndView showView(ModelAndView model,HttpServletRequest req, HttpServletResponse res)
	{
		model.setViewName("HomePage");
		
		model.addObject("model",getDetails.findAll());
		return model;
		
	}
	
	@RequestMapping(value="MenuPage")
	public ModelAndView showMenu(ModelAndView model,HttpServletRequest req, HttpServletResponse res) {
		
		model.setViewName("MenuPage");
		
		for(Restaurants restq:getDetails.findAll())
		{
			if((req.getParameter("RestaurantName").equalsIgnoreCase(restq.getName())))
					{
				
					menu=restq.getMenu();
					
					restuarants=restq;
					}
		}
		model.addObject("model", menu);
		//int tableCount = Integer.parseInt(req.getParameter("tableCount"));
		
		return model;
	}
	@RequestMapping(value = "AddDetails")
	public ModelAndView showDetails( ModelAndView model,HttpServletRequest req, HttpServletResponse res) {
		model.setViewName("AddDetails");
		int tableCount = Integer.parseInt(req.getParameter("tableCount"));
		model.addObject("model",tableCount);
		model.addObject("modelMenu", menu);
		model.addObject("modelRes",restuarants);
		return model;	
	}

	


}
