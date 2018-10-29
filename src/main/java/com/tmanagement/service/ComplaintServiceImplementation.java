package com.tmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.tmanagement.dao.ComplaintDAO;
import com.tmanagement.model.Complaint;

@Service
public class ComplaintServiceImplementation implements ComplaintService {

	@Autowired
	public ComplaintDAO complaintRepo;

	@Override
	public List<Complaint> getComplaintByCsa(int inputCsaId) {
		List<Complaint> allComplaints = complaintRepo.findAll();
		List<Complaint> csaComplaints = new ArrayList<>();

		for (Complaint comp : allComplaints) {
			if (comp.csa.getCsaId() == inputCsaId) {
				csaComplaints.add(comp);
			}
		}
		return csaComplaints;
	}

	@Override
	public List<Complaint> getComplaintByTower(int inputTowerId) {
		List<Complaint> allComplaints = complaintRepo.findAll();
		List<Complaint> towerComplaints = new ArrayList<>();

		for (Complaint comp : allComplaints) {
			if (comp.tower.getTowerId() == inputTowerId) {
				towerComplaints.add(comp);
			}
		}
		return towerComplaints;
	}

	// @Override
	// public boolean existsByCsaId(int inputCasId) {
	// return false;
	// }
	//
	// @Override
	// public boolean existsByTowerId(int inputTowerId) {
	// // TODO Auto-generated method stub
	// return false;
	// }

	
	/*@Override
	public int numberOfComplaints() {
		int counter = 0;
		List<Complaint> complaints = complaintRepo.findAll();

		for (Complaint comp : complaints) {
			if (comp.status == false) {
				counter += 1;
			}
		}
		return counter;
	}

	@Override
	public List<Complaint> getComplaintByStatus() {
		List<Complaint> allComplaints = complaintRepo.findAll();
		List<Complaint> unresolvedComplaints = new ArrayList<>();

		for (Complaint comp : allComplaints) {
			if (comp.status == false) {
				unresolvedComplaints.add(comp);
			}
		}
		return unresolvedComplaints;
	}*/

	@Override
	public List<Complaint> fetchComplaints() {
		return complaintRepo.findAllByOrderByDateOfIssueDesc();
	}

	@Override
	public Complaint getComplaintByComplaintId(int complaintId) {
		Complaint complaint = null;

		Optional<Complaint> opComplaint = complaintRepo.findById(complaintId);
		if (opComplaint.isPresent()) {
			complaint = opComplaint.get();
		}

		return complaint;
	}

	@Override
	public Complaint addComplaint(Complaint complaint) {
		return complaintRepo.save(complaint);
	}



	@Override
	public Complaint updateComplaint(Complaint complaint) {
		/*boolean isUpdated = false;

		Optional<Complaint> opComplaint = complaintRepo.findById(complaint.getComplaintId());
		if (opComplaint.isPresent()) {
			complaint = opComplaint.get();
			isUpdated = true; 
		}
		*/
		return complaintRepo.save(complaint);
	}


}
