package com.kanaryahaber.abdlkdrkya.business.concretes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kanaryahaber.abdlkdrkya.business.abstracts.FiksturService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.ErrorResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessDataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessResult;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.FiksturCinsiyetDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.FiksturDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.FiksturKategoriDao;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Fikstur;
import com.kanaryahaber.abdlkdrkya.entities.concretes.FiksturCinsiyet;
import com.kanaryahaber.abdlkdrkya.entities.concretes.FiksturKategori;

@Service
public class FiksturManager implements FiksturService {

	private FiksturDao fiksturDao;
	private FiksturKategoriDao fiksturKategoriDao;
	private FiksturCinsiyetDao fiksturCinsiyetDao;

	@Autowired
	public FiksturManager(FiksturDao fiksturDao, FiksturKategoriDao fiksturKategoriDao,
			FiksturCinsiyetDao fiksturCinsiyetDao) {
		super();
		this.fiksturDao = fiksturDao;
		this.fiksturKategoriDao = fiksturKategoriDao;
		this.fiksturCinsiyetDao = fiksturCinsiyetDao;
	}

	@Override
	public DataResult<List<Fikstur>> fiksturSirala(int fiksturKategoriId, int fiksturCinsiyetId) {
		Sort sort = Sort.by(Sort.Direction.ASC, "fiksturTarih");
		List<Fikstur> maclar = this.fiksturDao.getByFiksturKategori_FiksturKategoriIdAndFiksturCinsiyet_CinsiyetId(
				fiksturKategoriId, fiksturCinsiyetId, sort);
		List<Fikstur> sonMac = new ArrayList<Fikstur>();
		LocalDate bugun = LocalDate.now();
		for (Fikstur mac : maclar) {

			if (mac.getFiksturTarih().compareTo(bugun) >= 0)
				sonMac.add(mac);
		}
		return new SuccessDataResult<List<Fikstur>>(sonMac, "Fikstur listelendi");
	}

	@Override
	public Result add(String fiksturDeplasman, String fiksturDeplasmanSkor, String fiksturEvSahibi,
			String fiksturEvSahibiSkor, String fiksturTarih, String fiksturTurnuva, int fiksturKategoriId,
			int fiksturCinsiyetId) {
		Fikstur fikstur = new Fikstur();
		FiksturKategori kategori = fiksturKategoriDao.getByFiksturKategoriId(fiksturKategoriId);
		FiksturCinsiyet cinsiyet = fiksturCinsiyetDao.getByCinsiyetId(fiksturCinsiyetId);
		fikstur.setFiksturDeplasman(fiksturDeplasman);
		fikstur.setFiksturDeplasmanSkor(fiksturDeplasmanSkor);
		fikstur.setFiksturEvSahibiLogo("/images/logolar/basketbol/erkek/noimage.png");
		fikstur.setFiksturDeplasmanLogo("/images/logolar/basketbol/erkek/noimage.png");
		fikstur.setFiksturEvSahibi(fiksturEvSahibi);
		fikstur.setFiksturEvSahibiSkor(fiksturEvSahibiSkor);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate tarih = LocalDate.parse(fiksturTarih,formatter);
		fikstur.setFiksturKategori(kategori);
		fikstur.setFiksturCinsiyet(cinsiyet);
		fikstur.setFiksturTarih(tarih);
		fikstur.setFiksturTurnuva(fiksturTurnuva);
		this.fiksturDao.save(fikstur);
		return new SuccessResult(true, "Fikstur eklendi");
	}

	@Override
	public DataResult<List<Fikstur>> fiksturTumunuGetir(int fiksturKategoriId, int fiksturCinsiyetId) {
		Sort sort = Sort.by(Sort.Direction.ASC, "fiksturTarih");
		return new SuccessDataResult<List<Fikstur>>(
				this.fiksturDao.getByFiksturKategori_FiksturKategoriIdAndFiksturCinsiyet_CinsiyetId(fiksturKategoriId,
						fiksturCinsiyetId, sort));
	}

	@Override
	public Result skorEkle(String fiksturEvSahibiSkor, String fiksturEvSahibiIlkPeriyotSkor,
			String fiksturEvSahibiIkinciPeriyotSkor, String fiksturEvSahibiUcuncuPeriyotSkor,
			String fiksturEvSahibiDorduncuPeriyotSkor, String fiksturEvSahibiBesinciPeriyotSkor,
			String fiksturEvSahibiIlkYariSkor, String fiksturEvSahibiIlkCeyrekSkor,
			String fiksturEvSahibiIkinciCeyrekSkor, String fiksturEvSahibiUcuncuCeyrekSkor,
			String fiksturEvSahibiDorduncuCeyrekSkor, String fiksturDeplasmanSkor,
			String fiksturDeplasmanIlkPeriyotSkor, String fiksturDeplasmanIkinciPeriyotSkor,
			String fiksturDeplasmanUcuncuPeriyotSkor, String fiksturDeplasmanDorduncuPeriyotSkor,
			String fiksturDeplasmanBesinciPeriyotSkor, String fiksturDeplasmanIlkYariSkor,
			String fiksturDeplasmanIlkCeyrekSkor, String fiksturDeplasmanIkinciCeyrekSkor,
			String fiksturDeplasmanUcuncuCeyrekSkor, String fiksturDeplasmanDorduncuCeyrekSkor, String fiksturTarih, int fiksturId) {
		Fikstur mac = this.fiksturDao.getByFiksturId(fiksturId);
		if (mac == null) {
			return new ErrorResult(false, "Maç bulunamadı");
		}
		if (mac.getFiksturKategori().getFiksturKategoriId() == 1) {
			int evSahibiIlkCeyrek = Integer.parseInt(fiksturEvSahibiIlkCeyrekSkor.trim());
			int evSahibiIkiCeyrek = Integer.parseInt(fiksturEvSahibiIkinciCeyrekSkor.trim());
			int depIlkCeyrek = Integer.parseInt(fiksturDeplasmanIlkCeyrekSkor.trim());
			int depIkiCeyrek = Integer.parseInt(fiksturDeplasmanIkinciCeyrekSkor.trim());
			int evIlkYari = evSahibiIlkCeyrek + evSahibiIkiCeyrek;
			int depIlkYari = depIlkCeyrek + depIkiCeyrek;
			String sonEv = String.valueOf(evIlkYari);
			String sonDep = String.valueOf(depIlkYari);
			mac.setFiksturEvSahibiIlkYariSkor(sonEv);
			mac.setFiksturDeplasmanIlkYariSkor(sonDep);
			mac.setFiksturEvSahibiIlkCeyrekSkor(fiksturEvSahibiIlkCeyrekSkor);
			mac.setFiksturEvSahibiIkinciCeyrekSkor(fiksturEvSahibiIkinciCeyrekSkor);
			mac.setFiksturEvSahibiUcuncuCeyrekSkor(fiksturEvSahibiUcuncuCeyrekSkor);
			mac.setFiksturEvSahibiDorduncuCeyrekSkor(fiksturEvSahibiDorduncuCeyrekSkor);
			mac.setFiksturDeplasmanIlkCeyrekSkor(fiksturDeplasmanIlkCeyrekSkor);
			mac.setFiksturDeplasmanIkinciCeyrekSkor(fiksturDeplasmanIkinciCeyrekSkor);
			mac.setFiksturDeplasmanUcuncuCeyrekSkor(fiksturDeplasmanUcuncuCeyrekSkor);
			mac.setFiksturDeplasmanDorduncuCeyrekSkor(fiksturDeplasmanDorduncuCeyrekSkor);
		}
		if (mac.getFiksturKategori().getFiksturKategoriId() == 2) {
			mac.setFiksturEvSahibiIlkYariSkor(fiksturEvSahibiIlkYariSkor);
			mac.setFiksturDeplasmanIlkYariSkor(fiksturDeplasmanIlkYariSkor);
		}
		if (mac.getFiksturKategori().getFiksturKategoriId() == 3) {
			mac.setFiksturEvSahibiIlkPeriyotSkor(fiksturEvSahibiIlkPeriyotSkor);
			mac.setFiksturEvSahibiIkinciPeriyotSkor(fiksturEvSahibiIkinciPeriyotSkor);
			mac.setFiksturEvSahibiUcuncuPeriyotSkor(fiksturEvSahibiUcuncuPeriyotSkor);
			mac.setFiksturEvSahibiDorduncuPeriyotSkor(fiksturEvSahibiDorduncuPeriyotSkor);
			mac.setFiksturEvSahibiBesinciPeriyotSkor(fiksturEvSahibiBesinciPeriyotSkor);
			mac.setFiksturDeplasmanIlkPeriyotSkor(fiksturDeplasmanIlkPeriyotSkor);
			mac.setFiksturDeplasmanIkinciPeriyotSkor(fiksturDeplasmanIkinciPeriyotSkor);
			mac.setFiksturDeplasmanUcuncuPeriyotSkor(fiksturDeplasmanUcuncuPeriyotSkor);
			mac.setFiksturDeplasmanDorduncuPeriyotSkor(fiksturDeplasmanDorduncuPeriyotSkor);
			mac.setFiksturDeplasmanBesinciPeriyotSkor(fiksturDeplasmanBesinciPeriyotSkor);
		}
		mac.setFiksturEvSahibiSkor(fiksturEvSahibiSkor);
		mac.setFiksturDeplasmanSkor(fiksturDeplasmanSkor);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate tarih = LocalDate.parse(fiksturTarih,formatter);
		mac.setFiksturTarih(tarih);
		this.fiksturDao.save(mac);
		return new SuccessResult(true, "Güncellendi");
	}

}
