package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolErkekOyuncular;

public interface VoleybolErkekOyuncularDao extends JpaRepository<VoleybolErkekOyuncular, Integer>{
	VoleybolErkekOyuncular getByOyuncuId(int oyuncuId);
}
