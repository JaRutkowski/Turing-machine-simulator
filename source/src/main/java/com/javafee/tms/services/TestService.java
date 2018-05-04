package com.javafee.tms.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Value(("${specs.dir}"))
	private String specsPath;

}
