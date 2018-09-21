package br.uva.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model model) {

		return "index";
	}
	
	@RequestMapping(value = "/arvoreDecisao", method = RequestMethod.GET)
    public HttpEntity<byte[]> download() throws IOException {

        byte[] arquivo = Files.readAllBytes( Paths.get("/images/arvoreDecisao.png") );

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("Content-Disposition", "attachment;filename=\"arvoreDecisao.png\"");

        HttpEntity<byte[]> entity = new HttpEntity<byte[]>( arquivo, httpHeaders);

        return entity;
    }
}
