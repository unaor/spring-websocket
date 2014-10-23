package com.datasol.paideia.socket;

import java.security.Principal;

import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TeacherSocket {

	@SubscribeMapping("/paideia/uri")
	public int sendDummyNumber(Principal principal){
		return 77;
	}

}
