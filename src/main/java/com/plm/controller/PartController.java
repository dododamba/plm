package com.plm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.plm.dao.PartDAO;
import com.plm.model.Part;
import com.plm.request.PartRequest;
import com.plm.request.PartSetStateRequest;
import com.plm.response.JsonObjectResponse;

/*
|--------------------------------------------------------------------------
|
|--------------------------------------------------------------------------
|
| Controller  Part
|
|
|
|*/

@RestController
public class PartController {

	private PartDAO partDAO;

	@Autowired
	public PartController(PartDAO partDAO) {
      this.partDAO = partDAO;
	}

	@PostMapping(value = "/part/reserve")
	public ResponseEntity<?> reserve(@RequestHeader("userId") String userId, @Valid @RequestBody Part request) {

		partDAO.reserve(userId, request.getReference(), request.getVersion(), request.getIteration());
		return ResponseEntity.ok(new JsonObjectResponse(true, "part reserve done !", null));

	}

	@PutMapping(value = "/part/update")
	public ResponseEntity<?> update(@Valid @RequestBody Part request) {
		//
		partDAO.update(request);
		return ResponseEntity.ok(new JsonObjectResponse(true, "part update done !", null));

	}

	@PutMapping(value = "/part/free")
	public ResponseEntity<?> free(@RequestHeader("userId") String userId, @Valid @RequestBody PartRequest request) {

		partDAO.free(userId, request.getReference(), request.getVersion(), request.getIteration());

		return ResponseEntity.ok(new JsonObjectResponse(true, "Free part  done !", null));

	}

	@PutMapping(value = "/part/set-state")
	public ResponseEntity<?> setState(@RequestHeader("userId") String userId,
			@Valid @RequestBody PartSetStateRequest request) {

		partDAO.setState(userId, request.getReference(), request.getVersion(), request.getIteration(),
				request.getState());

		return ResponseEntity.ok(new JsonObjectResponse(true, "part state set !", null));
	}

	@PostMapping(value = "/part/create")
	public ResponseEntity<?> createPart(@Valid @RequestBody Part part) {

		partDAO.create(part);

		return ResponseEntity.ok(new JsonObjectResponse(true, "part state set !", null));
	}

	@PutMapping(value = "/part/revise")
	public ResponseEntity<?> revise(@RequestHeader("userId") String userId, @Valid @RequestBody PartRequest request) {

		partDAO.revise(userId, request.getReference(), request.getVersion(), request.getIteration());

		return ResponseEntity.ok(new JsonObjectResponse(true, "part revised !", null));

	}

}
