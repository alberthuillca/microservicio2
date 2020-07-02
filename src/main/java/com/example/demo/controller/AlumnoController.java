package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Registro;
import com.example.demo.service.RegistroDao;

@RestController

public class AlumnoController {
	@Autowired
	private RegistroDao registroDao;
	
	@GetMapping("/listar")
	public List<Registro> listar(){
		return registroDao.readAll();
	}
	
	@GetMapping("listar/{id}")
	public Registro registrar(@PathVariable Long id) {
		return registroDao.readyBy(id);
	}
}
