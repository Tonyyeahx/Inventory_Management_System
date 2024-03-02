package com.uw.cs506.team03.smartstock;

import com.uw.cs506.team03.smartstock.dao.NewTableDAO;
import com.uw.cs506.team03.smartstock.entity.NewTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
public class SmartstockApplication {
	public static void main(String[] args) {
		SpringApplication.run(SmartstockApplication.class, args);
	}

}
