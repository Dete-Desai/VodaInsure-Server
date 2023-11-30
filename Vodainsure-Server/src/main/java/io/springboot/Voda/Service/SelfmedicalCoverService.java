package io.springboot.Voda.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.Voda.Entity.SelfmedicalCover;
import io.springboot.Voda.Repository.SelfmedicalcoverRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SelfmedicalCoverService {
	@Autowired
	private SelfmedicalcoverRepository selfmedicalcoverRepository;
	
	SelfmedicalCover Save(SelfmedicalCover selfmedicalCover);
	SelfmedicalCover findById(integer id);



}
