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

import com.plm.dao.DocumentDAO;
import com.plm.model.Document;
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
@RequestMapping(name = "api")
public class DocumentController {
	private DocumentDAO documentDAO;

	@Autowired
	public DocumentController(DocumentDAO documentDAO) {
		this.documentDAO = documentDAO;
	}

	@PostMapping(value = "/document/reserve")
	public ResponseEntity<?> reserve(@RequestHeader("userId") String userId,
			@Valid @RequestBody DocumentRequest request) {

		if (documentDAO.reserve(userId, request.getReference(), request.getVersion(), request.getIteration())) {

			return ResponseEntity.ok(new JsonObjectResponse(true, "Document reserve done !", null));
		}
		return ResponseEntity.ok(new JsonObjectResponse(true, "Error, Document reserve not done !", null));

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

		if (documentDAO.free(userId, request.getReference(), request.getVersion(), request.getIteration())) {
			return ResponseEntity.ok(new JsonObjectResponse(true, "Free document  done !", null));
		}

		return ResponseEntity.ok(new JsonObjectResponse(true, "Free document not  done !", null));

	}

	@GetMapping(value = "/document/set-state")
	public ResponseEntity<?> setState(@RequestHeader("userId") String userId,
			@Valid @RequestBody DocumentSetStateRequest request) {

		if (documentDAO.setState(userId, request.getReference(), request.getVersion(), request.getIteration(),
				request.getState())) {
			return ResponseEntity.ok(new JsonObjectResponse(true, "Document state set !", null));

		}

		return ResponseEntity.ok(new JsonObjectResponse(true, "Document state not set !", null));
	}

	@GetMapping(value = "/document/revise")
	public ResponseEntity<?> revise(@RequestHeader("userId") String userId,
			@Valid @RequestBody DocumentRequest request) {

		if (documentDAO.revise(userId, request.getReference(), request.getVersion(), request.getIteration())) {

			return ResponseEntity.ok(new JsonObjectResponse(true, "Document revised !", null));
		}

		return ResponseEntity.ok(new JsonObjectResponse(true, "Document not revised !", null));

	}

	@GetMapping(value = "/document")
	public ResponseEntity<?> all() {

		if (documentDAO.all().isEmpty()) {
			Collection<Document> documents = documentDAO.all();
			Map<String, Object> map = new HashMap<>();
			map.put("documents", documents);
			return ResponseEntity.ok(new JsonObjectResponse(true, "Document not revised !", null));

		}

		return ResponseEntity.ok(new JsonObjectResponse(true, "Documents empty !", null));

	}

	@GetMapping(value = "/document/all")
	public ResponseEntity<?> create(@Valid @RequestBody Document request) {

		documentDAO.create(request);

		return ResponseEntity.ok(new JsonObjectResponse(true, "Document created !", null));

	}

}
