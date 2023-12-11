package io.springboot.Voda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.Voda.Entity.SelfmedicalCover;
import io.springboot.Voda.Repository.SelfmedicalcoverRepository;

@Service
public class SelfmedicalCoverImpli {
	
	@Autowired
	private SelfmedicalcoverRepository selfmedicalcoverRepository;
	 public SelfmedicalCover saveSelfmedicalCover(SelfmedicalCover selfmedicalCover) {
	 return selfmedicalcoverRepository.save(selfmedicalCover);
	    }
    public SelfmedicalCover getSelfmedicalCoverById(Integer selfId) {
	        return selfmedicalcoverRepository.findById(selfId).orElse(null);
	    }
    public List<SelfmedicalCover> getAllCovers() {
        return selfmedicalcoverRepository.findAll();
}
}
