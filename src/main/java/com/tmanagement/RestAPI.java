package com.tmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*import com.tmanagement.model.CSA;*/
import com.tmanagement.model.Complaint;
import com.tmanagement.model.Tower;
import com.tmanagement.service.ComplaintService;
import com.tmanagement.service.TowerService;

@RestController
@CrossOrigin
@RequestMapping("/towermgmt")
public class RestAPI {

	@Autowired
	public TowerService towerServ;

	@Autowired
	public ComplaintService complaintServ;


	@GetMapping("/{circle}")
	public ResponseEntity<List<Tower>> getAllTowerByCircle(@PathVariable("circle") String circle) {
		ResponseEntity<List<Tower>> resp;
		List<Tower> tower = null;

		tower = towerServ.getTowerByCircle(circle);

		if (tower == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(tower, HttpStatus.OK);
		return resp;
	}

	/*
	 * @GetMapping("/csa") public ResponseEntity<List<CSA>> getAllCsa() { return new
	 * ResponseEntity<>(towerServ., HttpStatus.OK); }
	 */
	@GetMapping("/Towers")
	public ResponseEntity<List<Tower>> getAllTowers() {
		return new ResponseEntity<>(towerServ.allTowers(), HttpStatus.OK);
	}

	@GetMapping("/Towers/{id}")
	public ResponseEntity<Tower> getTowerById(@PathVariable("id") int towerId) {
		ResponseEntity<Tower> resp;
		Tower tower = towerServ.getTowerByTowerId(towerId);

		if (tower == null) {
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			resp = new ResponseEntity<>(tower, HttpStatus.OK);
		}
		return resp;
	}

	@GetMapping("/Towers/csa/{id}")
	public ResponseEntity<List<Tower>> getTowerByCsaId(@PathVariable("id") int CsaId) {
		ResponseEntity<List<Tower>> resp;
		List<Tower> tower = towerServ.getTowerByCsaId(CsaId);

		if (tower == null) {
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			resp = new ResponseEntity<>(tower, HttpStatus.OK);
		}
		return resp;
	}

	@GetMapping("/Complaints")
	public ResponseEntity<List<Complaint>> getAllComplaints() {
		return new ResponseEntity<>(complaintServ.fetchComplaints(), HttpStatus.OK);
	}

	@GetMapping("/Complaints/{id}")
	public ResponseEntity<Complaint> getComplaintById(@PathVariable("id") int complaintId) {
		ResponseEntity<Complaint> resp;
		Complaint complaint = complaintServ.getComplaintByComplaintId(complaintId);

		if (complaint == null) {
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			resp = new ResponseEntity<>(complaint, HttpStatus.OK);
		}
		return resp;
	}

	@GetMapping("/Complaints/csa/{id}")
	public ResponseEntity<List<Complaint>> getComplaintByCsaId(@PathVariable("id") int CsaId) {
		ResponseEntity<List<Complaint>> resp;
		List<Complaint> complaint = complaintServ.getComplaintByCsa(CsaId);

		if (complaint == null) {
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			resp = new ResponseEntity<>(complaint, HttpStatus.OK);
		}
		return resp;
	}

	@GetMapping("/Complaints/tower/{id}")
	public ResponseEntity<List<Complaint>> getComplaintByTowerId(@PathVariable("id") int towerId) {
		ResponseEntity<List<Complaint>> resp;
		List<Complaint> complaint = complaintServ.getComplaintByTower(towerId);

		if (complaint == null) {
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			resp = new ResponseEntity<>(complaint, HttpStatus.OK);
		}
		return resp;
	}

	@PostMapping
	public ResponseEntity<Complaint> addComplaint(@RequestBody Complaint complaint) {
		ResponseEntity<Complaint> resp = null;

		if (resp == null) {
			Complaint c = complaintServ.addComplaint(complaint);
			if (c == null)
				resp = new ResponseEntity<Complaint>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Complaint>(c, HttpStatus.OK);
		}
		return resp;
	}

	@PutMapping("/changeViewStatus")
	public ResponseEntity<Void> viewToggle(@RequestBody Complaint complaint) {
		ResponseEntity<Void> resp = null;

		Complaint c = complaintServ.updateComplaint(complaint);
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			resp = new ResponseEntity<>(HttpStatus.OK);

		return resp;
	}

	@PutMapping("/changeActionStatus")
	public ResponseEntity<Void> actionToggle(@RequestBody Complaint complaint) {
		ResponseEntity<Void> resp = null;
		
		Complaint c = complaintServ.updateComplaint(complaint);
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			resp = new ResponseEntity<>(HttpStatus.OK);

		return resp;
	}

}
