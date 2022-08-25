package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kanaryahaber.abdlkdrkya.entities.concretes.FiksturKategori;

public interface FiksturKategoriDao extends JpaRepository<FiksturKategori, Integer>{
	FiksturKategori getByFiksturKategoriId(int fiksturKategoriId);
}
