package com.kanaryahaber.abdlkdrkya.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HaberWithCategoryDto {
	private int id;
	private String haberName;
	private String categoryName;
}
