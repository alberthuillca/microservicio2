package com.example.demo.serviceImp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Registro;
import com.example.demo.service.RegistroDao;

@Service
public class AlumnoServiceImp implements RegistroDao{
	
	@Autowired
	private RestTemplate cliRestTemplate;
	
	@Override
	public List<Registro> readAll() {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = Arrays.asList(cliRestTemplate.getForObject("http://localhost:9001/listar", Alumno[].class));
		return alumnos.stream().map(a->new Registro(a)).collect(Collectors.toList());
	}

	@Override
	public Registro readyBy(Long id) {
		// TODO Auto-generated method stub
		Map<String, String> datos = new HashMap<String, String>();
		datos.put("id", id.toString());
		Alumno alumno = cliRestTemplate.getForObject("http://localhost:9001/listar/{id}", Alumno.class, datos); 
		return new Registro(alumno);
	}

}
