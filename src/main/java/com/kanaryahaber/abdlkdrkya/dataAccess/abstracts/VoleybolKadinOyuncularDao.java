package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolKadinOyuncular;

public interface VoleybolKadinOyuncularDao extends JpaRepository<VoleybolKadinOyuncular, Integer>{
	VoleybolKadinOyuncular getByOyuncuId(int oyuncuId);
}
