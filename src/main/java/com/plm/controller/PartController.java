package com.plm.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plm.dao.PartDAO;
import com.plm.model.Part;
import com.plm.model.Part;
import com.plm.request.PartRequest;
import com.plm.request.PartSetStateRequest;
import com.plm.request.PartUpdateRequest;
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
@RequestMapping(name = "api")
public class PartController {

	private PartDAO partDAO;

	@Autowired
	public PartController(PartDAO partDAO) {
		this.partDAO = partDAO;
	}

	@PostMapping(value = "/part/create")
	public ResponseEntity<?> createPart(@Valid @RequestBody Part part) {

		partDAO.create(part);

		return ResponseEntity.ok(new JsonObjectResponse(true, "part state set !", null));
	}

	@PostMapping(value = "/part/reserve")
	public ResponseEntity<?> reserve(@RequestHeader("userId") String userId, @Valid @RequestBody PartRequest request) {

		if (partDAO.reserve(userId, request.getReference(), request.getVersion(), request.getIteration())) {

			return ResponseEntity.ok(new JsonObjectResponse(true, "Part reserve done !", null));
		}
		return ResponseEntity.ok(new JsonObjectResponse(true, "Error, Part reserve not done !", null));

	}

	@PutMapping(value = "/part/update")
	public ResponseEntity<?> update(@Valid @RequestBody Part part) {

		partDAO.update(part);
		return ResponseEntity.ok(new JsonObjectResponse(true, "Part update done !", null));

	}

	@GetMapping(value = "/part/free")
	public ResponseEntity<?> free(@RequestHeader("userId") String userId, @Valid @RequestBody PartRequest request) {

		if (partDAO.free(userId, request.getReference(), request.getVersion(), request.getIteration())) {
			return ResponseEntity.ok(new JsonObjectResponse(true, "Free part  done !", null));
		}

		return ResponseEntity.ok(new JsonObjectResponse(true, "Free part not  done !", null));

	}

	@GetMapping(value = "/part/set-state")
	public ResponseEntity<?> setState(@RequestHeader("userId") String userId,
			@Valid @RequestBody PartSetStateRequest request) {

		if (partDAO.setState(userId, request.getReference(), request.getVersion(), request.getIteration(),
				request.getState())) {
			return ResponseEntity.ok(new JsonObjectResponse(true, "Part state set !", null));

		}

		return ResponseEntity.ok(new JsonObjectResponse(true, "Part state not set !", null));
	}

	@GetMapping(value = "/part/revise")
	public ResponseEntity<?> revise(@RequestHeader("userId") String userId, @Valid @RequestBody PartRequest request) {

		if (partDAO.revise(userId, request.getReference(), request.getVersion(), request.getIteration())) {

			return ResponseEntity.ok(new JsonObjectResponse(true, "Part revised !", null));
		}

		return ResponseEntity.ok(new JsonObjectResponse(true, "Part not revised !", null));

	}

	@GetMapping(value = "/part")
	public ResponseEntity<?> all() {

		if (partDAO.all().isEmpty()) {
			Collection<Part> parts = partDAO.all();
			Map<String, Object> map = new HashMap<>();
			map.put("parts", parts);
			return ResponseEntity.ok(new JsonObjectResponse(true, "Part not revised !", null));

		}

		return ResponseEntity.ok(new JsonObjectResponse(true, "Parts empty !", null));

	}

	@GetMapping(value = "/part/all")
	public ResponseEntity<?> create(@Valid @RequestBody Part request) {

		partDAO.create(request);

		return ResponseEntity.ok(new JsonObjectResponse(true, "Part created !", null));

	}

}
