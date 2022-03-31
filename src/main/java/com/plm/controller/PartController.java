package com.plm.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
@RequestMapping(name = "/api")
public class PartController {

	private PartDAO partDAO;
	private MessageSource messageSource;

	@Autowired
	public PartController(PartDAO partDAO, MessageSource messageSource) {
		this.partDAO = partDAO;
		this.messageSource = messageSource;
	}

	@PostMapping(value = "/part/create")
	public ResponseEntity<?> createPart(@Valid @RequestBody Part part) {

		partDAO.create(part);

		return ResponseEntity.ok(new JsonObjectResponse(true, "part state set !", null));
	}

	@PostMapping(value = "/part/reserve")
	public ResponseEntity<?> reserve(@RequestHeader(name = "Accept-Language", required = false) Locale locale,
			@RequestHeader("userId") String userId, @Valid @RequestBody PartRequest request) {

		if (partDAO.reserve(userId, request.getReference(), request.getVersion(), request.getIteration())) {

			return ResponseEntity.ok(
					new JsonObjectResponse(true, messageSource.getMessage("part.reserve.done", null, locale), null));
		}
		return ResponseEntity
				.ok(new JsonObjectResponse(true, messageSource.getMessage("part.reserve.done", null, locale), null));

	}

	@PutMapping(value = "/part/update")
	public ResponseEntity<?> update(@RequestHeader(name = "Accept-Language", required = false) Locale locale,
			@Valid @RequestBody Part part) {

		partDAO.update(part);
		return ResponseEntity
				.ok(new JsonObjectResponse(true, messageSource.getMessage("part.update.done", null, locale), null));

	}

	@GetMapping(value = "/part/free")
	public ResponseEntity<?> free(@RequestHeader(name = "Accept-Language", required = false) Locale locale,
			@RequestHeader("userId") String userId, @Valid @RequestBody PartRequest request) {

		if (partDAO.free(userId, request.getReference(), request.getVersion(), request.getIteration())) {
			return ResponseEntity
					.ok(new JsonObjectResponse(true, messageSource.getMessage("part.free.done", null, locale), null));
		}

		return ResponseEntity
				.ok(new JsonObjectResponse(true, messageSource.getMessage("part.free.not.done", null, locale), null));

	}

	@GetMapping(value = "/part/set-state")
	public ResponseEntity<?> setState(@RequestHeader(name = "Accept-Language", required = false) Locale locale,
			@RequestHeader("userId") String userId, @Valid @RequestBody PartSetStateRequest request) {

		if (partDAO.setState(userId, request.getReference(), request.getVersion(), request.getIteration(),
				request.getState())) {
			return ResponseEntity
					.ok(new JsonObjectResponse(true, messageSource.getMessage("part.set.done", null, locale), null));

		}

		return ResponseEntity
				.ok(new JsonObjectResponse(true, messageSource.getMessage("part.set.not.done", null, locale), null));
	}

	@GetMapping(value = "/part/revise")
	public ResponseEntity<?> revise(@RequestHeader(name = "Accept-Language", required = false) Locale locale,
			@RequestHeader("userId") String userId, @Valid @RequestBody PartRequest request) {

		if (partDAO.revise(userId, request.getReference(), request.getVersion(), request.getIteration())) {

			return ResponseEntity
					.ok(new JsonObjectResponse(true, messageSource.getMessage("part.revise.done", null, locale), null));
		}

		return ResponseEntity
				.ok(new JsonObjectResponse(true, messageSource.getMessage("part.revise.not.done", null, locale), null));

	}

	@GetMapping(value = "/part")
	public ResponseEntity<?> all(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {

		if (partDAO.all().isEmpty()) {
			Collection<Part> parts = partDAO.all();
			Map<String, Object> map = new HashMap<>();
			map.put("parts", parts);
			return ResponseEntity
					.ok(new JsonObjectResponse(true, messageSource.getMessage("part.list", null, locale), null));

		}

		return ResponseEntity
				.ok(new JsonObjectResponse(true, messageSource.getMessage("part.empty", null, locale), null));

	}

	@GetMapping(value = "/part/create")
	public ResponseEntity<?> create(@Valid @RequestBody Part request) {

		partDAO.create(request);

		return ResponseEntity.ok(new JsonObjectResponse(true, "Part created !", null));

	}

}
