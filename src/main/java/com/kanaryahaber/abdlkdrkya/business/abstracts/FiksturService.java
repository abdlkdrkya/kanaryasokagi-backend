package com.kanaryahaber.abdlkdrkya.business.abstracts;

import java.util.List;

import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Fikstur;

public interface FiksturService {

	DataResult<List<Fikstur>> fiksturSirala(int fiksturKategoriId, int fiksturCinsiyetId);

	Result add(String fiksturDeplasman, String fiksturDeplasmanSkor, String fiksturEvSahibi, String fiksturEvSahibiSkor,
			String fiksturTarih, String fiksturTurnuva, int fiksturKategoriId, int fiksturCinsiyetId);

	DataResult<List<Fikstur>> fiksturTumunuGetir(int fiksturKategoriId, int fiksturCinsiyetId);

	Result skorEkle(String fiksturEvSahibiSkor, String fiksturEvSahibiIlkPeriyotSkor,
			String fiksturEvSahibiIkinciPeriyotSkor, String fiksturEvSahibiUcuncuPeriyotSkor,
			String fiksturEvSahibiDorduncuPeriyotSkor, String fiksturEvSahibiBesinciPeriyotSkor,
			String fiksturEvSahibiIlkYariSkor, String fiksturEvSahibiIlkCeyrekSkor,
			String fiksturEvSahibiIkinciCeyrekSkor, String fiksturEvSahibiUcuncuCeyrekSkor,
			String fiksturEvSahibiDorduncuCeyrekSkor, String fiksturDeplasmanSkor,
			String fiksturDeplasmanIlkPeriyotSkor, String fiksturDeplasmanIkinciPeriyotSkor,
			String fiksturDeplasmanUcuncuPeriyotSkor, String fiksturDeplasmanDorduncuPeriyotSkor,
			String fiksturDeplasmanBesinciPeriyotSkor, String fiksturDeplasmanIlkYariSkor,
			String fiksturDeplasmanIlkCeyrekSkor, String fiksturDeplasmanIkinciCeyrekSkor,
			String fiksturDeplasmanUcuncuCeyrekSkor, String fiksturDeplasmanDorduncuCeyrekSkor, String fiksturTarih, int fiksturId);

}
