package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolErkekPuanDurumu;

public interface BasketbolErkekPuanDurumuDao extends JpaRepository<BasketbolErkekPuanDurumu, Integer>{
	BasketbolErkekPuanDurumu getByPuanDurumuId(int takimId);
}