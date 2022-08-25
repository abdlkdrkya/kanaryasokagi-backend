package com.kanaryahaber.abdlkdrkya.business.abstracts;

import java.util.List;

import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolErkekPuanDurumu;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolKadinPuanDurumu;
import com.kanaryahaber.abdlkdrkya.entities.concretes.PuanDurumu;
import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolErkekPuanDurumu;
import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolKadinPuanDurumu;

public interface PuanDurumuService {
	
	
	Result addPuanDurumu(String takimAdi,int galibiyet, int beraberlik, int maglubiyet, int atilanGol, int yenilenGol);
	Result updatePuanDurumu(int takimId, int galibiyet, int beraberlik, int maglubiyet, int atilanGol, int yenilenGol);
	DataResult<List<PuanDurumu>> getAllSorted();

	Result addPuanDurumuBasketbolErkek(String takimAdi,int galibiyet, int maglubiyet, int atilanSayi, int yenilenSayi);
	Result updateBasketbolErkekPuanDurumu(int takimId, int galibiyet, int maglubiyet, int atilanSayi, int yenilenSayi);
	DataResult<List<BasketbolErkekPuanDurumu>> getAllSortedBasketbolErkek();
	
	Result addPuanDurumuBasketbolKadin(String takimAdi,int galibiyet, int maglubiyet, int atilanSayi, int yenilenSayi);
	Result updateBasketbolKadinPuanDurumu(int takimId, int galibiyet, int maglubiyet, int atilanSayi, int yenilenSayi);
	DataResult<List<BasketbolKadinPuanDurumu>> getAllSortedBasketbolKadin();
	
	Result addPuanDurumuVoleybolKadin(String takimAdi,int galibiyet, int maglubiyet, int atilanSayi, int yenilenSayi,
			int aldigiSet,int verdigiSet,int puan);
	Result updateVoleybolKadinPuanDurumu(int takimId, int galibiyet, int maglubiyet, int atilanSayi, int yenilenSayi,
			int aldigiSet,int verdigiSet,int puan);
	DataResult<List<VoleybolKadinPuanDurumu>> getAllSortedVoleybolKadin();
	
	Result addPuanDurumuVoleybolErkek(String takimAdi,int galibiyet, int maglubiyet, int atilanSayi, int yenilenSayi,
			int aldigiSet,int verdigiSet,int puan);
	Result updateVoleybolErkekPuanDurumu(int takimId, int galibiyet, int maglubiyet, int atilanSayi, int yenilenSayi,
			int aldigiSet,int verdigiSet,int puan);
	DataResult<List<VoleybolErkekPuanDurumu>> getAllSortedVoleybolErkek();
}
