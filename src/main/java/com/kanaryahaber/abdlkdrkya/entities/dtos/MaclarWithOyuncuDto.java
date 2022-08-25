package com.kanaryahaber.abdlkdrkya.entities.dtos;

import com.kanaryahaber.abdlkdrkya.entities.concretes.Fikstur;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Oyuncular;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaclarWithOyuncuDto {

	private int id;
	private Oyuncular oyuncu;
	private Fikstur mac;
}
