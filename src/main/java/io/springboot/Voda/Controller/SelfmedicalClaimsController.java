package io.springboot.Voda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.Voda.Entity.SelfmedicalClaims;

import io.springboot.Voda.Service.SelfmedicalClaimsimpli;


@RestController
@RequestMapping("/api/claims")
public class SelfmedicalClaimsController {
	 @Autowired
	 private SelfmedicalClaimsimpli selfmedicalClaimsService;
	  @PostMapping("/save")
	  public SelfmedicalClaims saveSelfmedicalClaims(@RequestBody SelfmedicalClaims selfmedicalClaims) {
	 	 return selfmedicalClaimsService.saveSelfmedicalClaims(selfmedicalClaims);
	  }
 @GetMapping("/get/{selfmedicalClaimId}")
 public SelfmedicalClaims getSelfmedicalClaimsById(@PathVariable Integer selfmedicalClaimId) {
return selfmedicalClaimsService.getSelfmedicalClaimsById(selfmedicalClaimId);

	 }
 @GetMapping
 public List<SelfmedicalClaims> getAllClaims() {
 return selfmedicalClaimsService.getAllClaims();
	 }
	 }


