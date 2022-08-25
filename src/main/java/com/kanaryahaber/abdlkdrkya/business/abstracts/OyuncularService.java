package com.kanaryahaber.abdlkdrkya.business.abstracts;

import java.util.List;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolErkekOyuncular;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolKadinOyuncular;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Oyuncular;
import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolErkekOyuncular;
import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolKadinOyuncular;

public interface OyuncularService {

	DataResult<List<Oyuncular>> erkekFutbolGetir();
	
	DataResult<Oyuncular> erkekFutbolGetirByOyuncuId(int oyuncuId);
	
	DataResult<BasketbolErkekOyuncular> erkekBasketbolGetirByOyuncuId(int oyuncuId);
	
	DataResult<BasketbolKadinOyuncular> kadinBasketbolGetirByOyuncuId(int oyuncuId);
	
	DataResult<List<BasketbolErkekOyuncular>> erkekBasketbolOyunculariGetir();

	DataResult<List<BasketbolKadinOyuncular>> kadinBasketbolOyunculariGetir();
	
	DataResult<List<VoleybolErkekOyuncular>> erkekVoleybolOyunculariGetir();
	
	DataResult<List<VoleybolKadinOyuncular>> kadinVoleybolOyunculariGetir();

	Result addFutbolErkek(String oyuncuAdi, String oyuncuSoyAdi, String oyuncuUyruk, String oyuncuMevki, String oyuncuProfil,
			int oyuncuYasi, int oyuncuFormaNumarasi, double oyuncuBoyu);

	Result addBasketbolErkek(String oyuncuAdi, String oyuncuSoyAdi, String oyuncuUyruk, String oyuncuMevki, String oyuncuProfil,
			int oyuncuYasi, int oyuncuFormaNumarasi, double oyuncuBoyu);

	Result addBasketbolKadin(String oyuncuAdi, String oyuncuSoyAdi, String oyuncuUyruk, String oyuncuMevki, String oyuncuProfil,
			int oyuncuYasi, int oyuncuFormaNumarasi, double oyuncuBoyu);
	
	Result addVoleybolErkek(String oyuncuAdi, String oyuncuSoyAdi, String oyuncuUyruk, String oyuncuMevki, String oyuncuProfil,
			int oyuncuYasi, int oyuncuFormaNumarasi, double oyuncuBoyu);

	Result addVoleybolKadin(String oyuncuAdi, String oyuncuSoyAdi, String oyuncuUyruk, String oyuncuMevki, String oyuncuProfil,
			int oyuncuYasi, int oyuncuFormaNumarasi, double oyuncuBoyu);
}
