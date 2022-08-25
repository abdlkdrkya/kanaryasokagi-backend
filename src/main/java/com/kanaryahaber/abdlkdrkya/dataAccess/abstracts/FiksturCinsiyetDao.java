package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kanaryahaber.abdlkdrkya.entities.concretes.FiksturCinsiyet;

public interface FiksturCinsiyetDao extends JpaRepository<FiksturCinsiyet, Integer>{
	FiksturCinsiyet getByCinsiyetId(int cinsiyetId);
}
