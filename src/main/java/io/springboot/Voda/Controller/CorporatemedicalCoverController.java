package io.springboot.Voda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.Voda.Entity.CorporatemedicalCover;

import io.springboot.Voda.Service.CorporatemedicalCoverServiceimpli;


@RestController
@RequestMapping("/api/corpcovers")
public class CorporatemedicalCoverController {
	@Autowired
	private CorporatemedicalCoverServiceimpli corporatemedicalCoverService;
	 @PostMapping("/save")
	 public CorporatemedicalCover saveCorporatemedicalCover(@RequestBody CorporatemedicalCover corporatemedicalCover) {
		 return corporatemedicalCoverService.saveCorporateMedicalCover(corporatemedicalCover);
}
	 @GetMapping("/get/{CorporateID}")
	 public CorporatemedicalCover getCorporatemedicalCoverById(@PathVariable Integer CorporateID) {
	 return corporatemedicalCoverService.getCorporatemedicalCover(CorporateID);
}
	 @GetMapping("/all")
	 public List<CorporatemedicalCover> getAllcorporateCovers() {
	 return corporatemedicalCoverService.getAllcorporateCovers();
	}
}
