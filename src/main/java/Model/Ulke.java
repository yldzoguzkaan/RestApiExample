package Model;

import java.util.ArrayList;
import java.util.List;

public class Ulke {
	private int id;
	private String adi;
	private String dili;
	private String baskenti;
	private String parabirimi;
	private String saatdilimi;
	private String telefonkodu;
	private String bayraklinki;
	private String kitasi;
	private int nufusu;
	private int yuzolcumu;
	private List<String> komsulari = new ArrayList<String>();
	
	public Ulke() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ulke(int id, String adi, String dili, String baskenti, String parabirimi, String saatdilimi,
			String telefonkodu, String bayraklinki, String kitasi, int nufusu, int yuzolcumu, List<String> komsulari) {
		super();
		this.id = id;
		this.adi = adi;
		this.dili = dili;
		this.baskenti = baskenti;
		this.parabirimi = parabirimi;
		this.saatdilimi = saatdilimi;
		this.telefonkodu = telefonkodu;
		this.bayraklinki = bayraklinki;
		this.kitasi = kitasi;
		this.nufusu = nufusu;
		this.yuzolcumu = yuzolcumu;
		this.komsulari = komsulari;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getDili() {
		return dili;
	}

	public void setDili(String dili) {
		this.dili = dili;
	}

	public String getBaskenti() {
		return baskenti;
	}

	public void setBaskenti(String baskenti) {
		this.baskenti = baskenti;
	}

	public String getParabirimi() {
		return parabirimi;
	}

	public void setParabirimi(String parabirimi) {
		this.parabirimi = parabirimi;
	}

	public String getSaatdilimi() {
		return saatdilimi;
	}

	public void setSaatdilimi(String saatdilimi) {
		this.saatdilimi = saatdilimi;
	}

	public String getTelefonkodu() {
		return telefonkodu;
	}

	public void setTelefonkodu(String telefonkodu) {
		this.telefonkodu = telefonkodu;
	}

	public String getBayraklinki() {
		return bayraklinki;
	}

	public void setBayraklinki(String bayraklinki) {
		this.bayraklinki = bayraklinki;
	}

	public String getKitasi() {
		return kitasi;
	}

	public void setKitasi(String kitasi) {
		this.kitasi = kitasi;
	}

	public int getNufusu() {
		return nufusu;
	}

	public void setNufusu(int nufusu) {
		this.nufusu = nufusu;
	}

	public int getYuzolcumu() {
		return yuzolcumu;
	}

	public void setYuzolcumu(int yuzolcumu) {
		this.yuzolcumu = yuzolcumu;
	}

	public List<String> getKomsulari() {
		return komsulari;
	}

	public void setKomsulari(List<String> komsulari) {
		this.komsulari = komsulari;
	}

	@Override
	public String toString() {
		return "Ulkeler [id=" + id + ", adi=" + adi + ", dili=" + dili + ", baskenti=" + baskenti + ", parabirimi="
				+ parabirimi + ", saatdilimi=" + saatdilimi + ", telefonkodu=" + telefonkodu + ", bayraklinki="
				+ bayraklinki + ", kitasi=" + kitasi + ", nufusu=" + nufusu + ", yuzolcumu=" + yuzolcumu
				+ ", komsulari=" + komsulari.toString() + "]";
	}
	
	
	
	
	
}
