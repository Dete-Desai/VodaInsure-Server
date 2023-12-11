package io.springboot.Voda.Service;


import java.util.List;

import io.springboot.Voda.Entity.CorporatemedicalCover;


public interface CorporatemedicalCoverInterface {
	CorporatemedicalCover saveCorporatemedicalCover(CorporatemedicalCover corporatemedicalCover);
	CorporatemedicalCover getCorporateMedicalCoverById(Integer CorporateID);
	List<CorporatemedicalCover> getAllCorporatemedicalCovers();
}
