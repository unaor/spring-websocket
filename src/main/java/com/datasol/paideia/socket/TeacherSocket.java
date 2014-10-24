package com.datasol.paideia.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherSocket {
	
	
	private final SimpMessagingTemplate  template;
	
	@Autowired
    public TeacherSocket(SimpMessagingTemplate template) {
        this.template = template;
    }
	
	

	@MessageMapping("/add")
	@SendTo("/topic/showResult")
	public String sendDummyNumber(String message /*,Principal principal*/) throws InterruptedException{
		return "dude";
				
	}
	
	@RequestMapping("/start")
    public String start() {
        return "start3";
    }
	
	@MessageExceptionHandler
	@SendToUser("/queue/errors")
	public String handleException(Throwable exception) {
	return exception.getMessage();
	}

}
