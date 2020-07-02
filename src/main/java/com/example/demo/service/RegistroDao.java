package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Registro;

public interface RegistroDao {
	public List<Registro> readAll();
	public Registro readyBy(Long id);
}
