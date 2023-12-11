package io.springboot.Voda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.Voda.Entity.CorporatemedicalCover;

import io.springboot.Voda.Repository.CorporatemedicalCoverRepository;



@Service
public class CorporatemedicalCoverServiceimpli {
	@Autowired
	CorporatemedicalCoverRepository corporateMedicalCoverRepository;
public CorporatemedicalCover saveCorporateMedicalCover(CorporatemedicalCover corporateMedicalCover) {
	return corporateMedicalCoverRepository.save(corporateMedicalCover);
}
public CorporatemedicalCover getSelfmedicalCoverById(Integer CorporateID) {
    return corporateMedicalCoverRepository.findById(CorporateID).orElse(null);
}
public List<CorporatemedicalCover> getAllCovers() {
return corporateMedicalCoverRepository.findAll();
}

	


public CorporatemedicalCover getCorporatemedicalCover(Integer corporateID) {
	// TODO Auto-generated method stub
	return null;
}
public List<CorporatemedicalCover> getAllcorporateCovers() {
	// TODO Auto-generated method stub
	return null;
}

}

