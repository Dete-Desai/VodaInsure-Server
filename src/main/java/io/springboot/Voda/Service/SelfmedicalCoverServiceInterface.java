package io.springboot.Voda.Service;

import io.springboot.Voda.Entity.SelfmedicalCover;

public interface SelfmedicalCoverServiceInterface {

	
	 SelfmedicalCover saveSelfmedicalCover(SelfmedicalCover selfmedicalCover);
	    SelfmedicalCover getSelfmedicalCoverById(Integer selfId);
}
