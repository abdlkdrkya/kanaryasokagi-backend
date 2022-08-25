package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolErkekPuanDurumu;

public interface VoleybolErkekPuanDurumuDao extends JpaRepository<VoleybolErkekPuanDurumu, Integer>{
	VoleybolErkekPuanDurumu getByPuanDurumuId(int takimId);
}
