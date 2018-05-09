package com.mindtree.demo.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SendEmailController {
	@Autowired
	private JavaMailSender sender;
	
/*	@RequestMapping(value = "simpleemail")
	public ModelAndView sendConfirmationEmail(ModelAndView model,HttpServletRequest req, HttpServletResponse res) {
		model.setViewName("simpleemail");
	
		return model;	
	}*/

@ResponseBody()
@RequestMapping(value = "simpleemail" )
	String home(HttpServletRequest req, HttpServletResponse res) {
		//System.out.println("email is"+req.getParameter("email"));
		String email= req.getParameter("email");
		        try {
		
		            sendEmail(email);
		
		            return "Email Sent!"
		            		+ "You have successfully booked the restaurant...Please be on time";
		
		        }catch(Exception ex) {
		
		            return "Error in sending email: "+ex;
		
		        }
		
		    }
	
	
	public void sendEmail(String email) throws MessagingException
	{
		MimeMessage message=sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(email);
        helper.setText("You have successfully booked the restaurant...Please be on time");
		
        
        sender.send(message);
	}


}
