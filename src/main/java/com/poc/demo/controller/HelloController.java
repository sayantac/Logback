package com.poc.demo.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/")
    public String hello(Model model) {

        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);

        logger.info("Hello \nfrom L\rogback\t {}", data);
        
		try {
			File file = ResourceUtils.getFile("classpath:data/sample.json");
			String content = new String(Files.readAllBytes(file.toPath()));
			logger.info(content);
		} catch (Exception e) {
			e.printStackTrace();
		}

        model.addAttribute("num", data);

        return "index"; // index.html
    }

}
