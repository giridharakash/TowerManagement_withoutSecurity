package com.tmanagement.service;

import java.util.List;

import com.tmanagement.model.Tower;

public interface TowerService {
	public List<Tower> getTowerByCircle(String circle);
	public List<Tower> getTowerByCsaId(int inputCsaId);
	
	public Tower getTowerByTowerId (int towerId);
	public boolean toggleStatus(int towerId);
	
//	public boolean existsByCsaId();
//	public boolean existsByTowerId(int towerId);
//	public boolean existsByCircle(String circle);
	
	public List<Tower> allTowers();
}
