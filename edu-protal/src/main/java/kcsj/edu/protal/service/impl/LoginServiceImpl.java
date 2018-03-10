package kcsj.edu.protal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginServiceImpl {
	@Autowired
	private RestTemplate restTemplate;
}
