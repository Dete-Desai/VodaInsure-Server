package io.springboot.Voda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.Voda.Entity.SelfmedicalCover;
import io.springboot.Voda.Service.SelfmedicalCoverImpli;

@RestController
@RequestMapping("/api/selfcovers")
public class SelfmedicalCoverController {
 @Autowired
private SelfmedicalCoverImpli selfmedicalCoverService;
 @PostMapping("/save")
 public SelfmedicalCover saveSelfmedicalCover(@RequestBody SelfmedicalCover selfmedicalCover) {
	 return selfmedicalCoverService.saveSelfmedicalCover(selfmedicalCover);
 }
 @GetMapping("/get/{selfId}")
 public SelfmedicalCover getSelfmedicalCoverById(@PathVariable Integer selfId) {
 return selfmedicalCoverService.getSelfmedicalCoverById(selfId);

}
 @GetMapping
 public List<SelfmedicalCover> getAllCovers() {
 return selfmedicalCoverService.getAllCovers();
}

}