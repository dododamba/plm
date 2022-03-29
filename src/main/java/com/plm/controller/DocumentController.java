package com.plm.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.plm.dao.DocumentDAO;
import com.plm.request.DocumentRequest;
import com.plm.request.DocumentSetStateRequest;
import com.plm.request.DocumentUpdateRequest;
import com.plm.response.JsonObjectResponse;

/*
|--------------------------------------------------------------------------
|
|--------------------------------------------------------------------------
|
| Controller  document
|
|
|
|*/

@RestController
public class DocumentController {
	private DocumentDAO documentDAO;

	@Autowired
	public DocumentController(DocumentDAO documentDAO) {
		this.documentDAO = documentDAO;
	}

	@PostMapping(value = "/document/reserve")
	public ResponseEntity<?> reserve(@RequestHeader("userId") String userId,
			@Valid @RequestBody DocumentRequest request) {

		documentDAO.reserve(userId, request.getReference(), request.getVersion(), request.getIteration());
		return ResponseEntity.ok(new JsonObjectResponse(true, "Document reserve done !", null));

	}

	@PutMapping(value = "/document/update")
	public ResponseEntity<?> update(@RequestHeader("userId") String userId,
			@Valid @RequestBody DocumentUpdateRequest request) {
		//
		documentDAO.update(userId, request.getReference(), request.getVersion(), request.getIteration(),
				request.getDocumentAttribute1(), request.getDocumentAttribute2());
		return ResponseEntity.ok(new JsonObjectResponse(true, "Document update done !", null));

	}

	@GetMapping(value = "/document/free")
	public ResponseEntity<?> free(@RequestHeader("userId") String userId, @Valid @RequestBody DocumentRequest request) {

		documentDAO.free(userId, request.getReference(), request.getVersion(), request.getIteration());

		return ResponseEntity.ok(new JsonObjectResponse(true, "Free document  done !", null));

	}

	@GetMapping(value = "/document/set-state")
	public ResponseEntity<?> setState(@RequestHeader("userId") String userId,
			@Valid @RequestBody DocumentSetStateRequest request) {

		documentDAO.setState(userId, request.getReference(), request.getVersion(), request.getIteration(),
				request.getState());

		return ResponseEntity.ok(new JsonObjectResponse(true, "Document state set !", null));
	}

	@GetMapping(value = "/document/revise")
	public ResponseEntity<?> revise(@RequestHeader("userId") String userId, @Valid @RequestBody DocumentRequest request) {

		documentDAO.revise(userId, request.getReference(), request.getVersion(), request.getIteration());

		return ResponseEntity.ok(new JsonObjectResponse(true, "Document revised !", null));

	}

}
