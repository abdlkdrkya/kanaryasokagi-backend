package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kanaryahaber.abdlkdrkya.entities.concretes.Fikstur;

public interface FiksturDao extends JpaRepository<Fikstur, Integer>{
	
    @Query("From Fikstur where fiksturTarih >= current_date")
    List<Fikstur> getAllSorted( int kategoriId, int cinsiyetId, Sort sort);
    
    Fikstur getByFiksturId(int fiksturId); 
    
    List<Fikstur> getByFiksturKategori_FiksturKategoriIdAndFiksturCinsiyet_CinsiyetId(int kategoriId, int cinsiyetId, Sort sort);
}
