package com.z_waligorski.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.z_waligorski.spring.dao.ReagentDAO;
import com.z_waligorski.spring.model.Reagent;

@RestController
@RequestMapping("/reagent")
public class LabManagerController {
	
	@Autowired
	ReagentDAO reagentDAO;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> addReagent(@RequestBody Reagent reagent) {
		reagentDAO.addReagent(reagent);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateReagent(@PathVariable int id, @RequestBody Reagent reagent){
		if(reagentDAO.getReagent(id) == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		reagentDAO.updateReagent(id, reagent);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Reagent> getReagent(@PathVariable int id) {
		Reagent reagent = reagentDAO.getReagent(id);
		if(reagent == null) {
			return new ResponseEntity<Reagent>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Reagent>(reagent, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Reagent>> getAllReagents() {
		List<Reagent> list = reagentDAO.getAllReagents();
		if(list.isEmpty()){
			return new ResponseEntity<List<Reagent>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Reagent>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReagent(@PathVariable int id) {
		Reagent reagent = reagentDAO.getReagent(id);
		if(reagent == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		reagentDAO.deleteReagent(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
