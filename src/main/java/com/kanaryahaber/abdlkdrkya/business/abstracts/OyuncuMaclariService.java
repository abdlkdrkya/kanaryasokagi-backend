package com.kanaryahaber.abdlkdrkya.business.abstracts;

import java.util.List;

import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolErkekOyuncuMaclari;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolKadinOyuncuMaclari;
import com.kanaryahaber.abdlkdrkya.entities.concretes.OyuncuMaclari;

public interface OyuncuMaclariService {

	DataResult<List<OyuncuMaclari>> oyuncuMaclariGetirByOyuncuId(int oyuncuId);

	DataResult<List<OyuncuMaclari>> oyuncuMaclariGetirByFiksturId(int fiksturId);

	Result add(int macOyuncuId, boolean macIlk11, int macDakika, int macSariKart, int macKirmiziKart, int macGol,
			int macAsist, int macId);
	
	Result futbolcuGuncelle(int macOyuncuId, boolean macIlk11, int macDakika, int macSariKart, int macKirmiziKart, int macGol,
			int macAsist, int macId);

	DataResult<List<OyuncuMaclari>> getAll();

	DataResult<List<BasketbolErkekOyuncuMaclari>> basketbolErkekOyuncuMaclariGetirByOyuncuId(int oyuncuId);

	DataResult<List<BasketbolErkekOyuncuMaclari>> basketbolErkekOyuncuMaclariGetirByFiksturId(int fiksturId);

	Result addBasketbolErkekOyuncuMaci(int macOyuncuId, int macAsist, int macBlock, int macHucumRibaund, int macSavunmaRibaund,int macSayi,int macTopCalma,
			int macTopKaybi,int macId);
	
	Result guncelleBasketbolErkekOyuncuMaci(int macOyuncuId, int macAsist, int macBlock, int macHucumRibaund, int macSavunmaRibaund,int macSayi,int macTopCalma,
			int macTopKaybi,int macId);

	DataResult<List<BasketbolErkekOyuncuMaclari>> getAllBasketbolErkekOyuncuMaclari();

	DataResult<List<BasketbolKadinOyuncuMaclari>> basketbolKadinOyuncuMaclariGetirByOyuncuId(int oyuncuId);

	DataResult<List<BasketbolKadinOyuncuMaclari>> basketbolKadinOyuncuMaclariGetirByFiksturId(int fiksturId);

	Result addBasketbolKadinOyuncuMaci(int macOyuncuId, int macAsist, int macBlock, int macHucumRibaund, int macSavunmaRibaund,int macSayi,int macTopCalma,
			int macTopKaybi,int macId);
	
	Result guncelleBasketbolKadinOyuncuMaci(int macOyuncuId, int macAsist, int macBlock, int macHucumRibaund, int macSavunmaRibaund,int macSayi,int macTopCalma,
			int macTopKaybi,int macId);

	DataResult<List<BasketbolKadinOyuncuMaclari>> getAllBasketbolKadinOyuncuMaclari();
}
