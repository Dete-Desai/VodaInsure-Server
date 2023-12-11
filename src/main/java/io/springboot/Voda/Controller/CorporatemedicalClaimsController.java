package io.springboot.Voda.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.Voda.Entity.CorporateMedicalClaims;

import io.springboot.Voda.Service.CorporateMedicalClaimsServiceimpli;

@RestController
@RequestMapping("/api/corpclaims")
public class CorporatemedicalClaimsController {
	private CorporateMedicalClaimsServiceimpli corporateMedicalClaimsService;
	
	 @PostMapping("/save")
	  public CorporateMedicalClaims saveSelfmedicalClaims(@RequestBody CorporateMedicalClaims corporateMedicalClaims) {
	 	 return corporateMedicalClaimsService.saveCorporateMedicalClaims(corporateMedicalClaims);
	  }
	 @GetMapping("/get/{CorporatemedicalClaimId}")
	  public CorporateMedicalClaims getCorporateMedicalClaimsById(@PathVariable Integer CorporatemedicalClaimId) {
	  return corporateMedicalClaimsService.getCorporateMedicalClaimsById(CorporatemedicalClaimId);

	 }
	 @GetMapping
	  public List<CorporateMedicalClaims> getAllcorparateClaims() {
	  return corporateMedicalClaimsService.getAllCorporateClaims();
	 }
}