package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Ulke;

public class ServiceController {
	private final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost:3306/veri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
	private final String DB_USR = "root";
	private final String DB_PWD = "";
	
	public List<Ulke> getTop10ByYuzolcumu() {
		List<Ulke> ulkeler = new ArrayList<Ulke>();
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			Statement st = conn.createStatement();
			String query = "SELECT id FROM `ulke` order by yuzolcumu DESC limit 10";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				ulkeler.add(getUlkeById(id));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Hata!Kod001 ");
			System.err.println(e.getMessage());
		}
		return ulkeler;
	}
	
	
	public List<Ulke> getUlkeByIsim(String adi) {
		List<Ulke> ulkeler = new ArrayList<Ulke>();
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			Statement st = conn.createStatement();
			String query = "SELECT id FROM ulke where adi like ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, "%" + adi + "%");
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				ulkeler.add(getUlkeById(id));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Hata!Kod001 ");
			System.err.println(e.getMessage());
		}
		return ulkeler;
	}

	
	public Ulke getUlkeById(int ulkeId) {
		Ulke u = new Ulke();
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			String query = "SELECT * FROM ulke where id = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, ulkeId);
			ResultSet rs = preparedStmt.executeQuery();
			rs.next();
			u.setId(rs.getInt("id"));
			u.setAdi(rs.getString("adi"));
			u.setDili(rs.getNString("dili"));
			u.setBaskenti(rs.getString("baskenti"));
			u.setParabirimi(rs.getString("parabirimi"));
			u.setSaatdilimi(rs.getString("saatdilimi"));
			u.setTelefonkodu(rs.getString("telefonkodu"));
			u.setBayraklinki("http://localhost:8080/RESTfulExample/img/"+rs.getString("bayraklinki"));
			u.setKitasi(rs.getString("kitasi"));
			u.setNufusu(rs.getInt("nufusu"));
			u.setYuzolcumu(rs.getInt("yuzolcumu"));
			u.setKomsulari(getKosularByUlkeId(ulkeId));
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Hata!Kod001 ");
			System.err.println(e.getMessage());
		}
		return u;
	}

	public List<String> getKosularByUlkeId(int ulkeId) {
		List<String> komsular = new ArrayList<String>();
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			Statement st = conn.createStatement();
			String query = "SELECT * FROM komsulukbilgileri where ulkeId = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, ulkeId);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
//				int ID = rs.getInt("id");
//				int ulke_ID = rs.getInt("ulke_ID");
				int komsuId = rs.getInt("komsuId");
				komsular.add(getUlkeAdiByUlkeId(komsuId));
			}
			rs.close();
			st.close();
			conn.close();
			// return komsular;
		} catch (Exception e) {
			System.err.println("Hata!Kod001 ");
			System.err.println(e.getMessage());
		}
		return komsular;
	}

//	public String getDilByUlkeId(int ulkeId) {
//		String dili = null;
//		try {
//			Class.forName(DB_DRIVER);
//			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
//
//			String query = " SELECT * FROM ulke WHERE id = ?";
//			PreparedStatement preparedStmt = conn.prepareStatement(query);
//			preparedStmt.setInt(1, ulkeId);
//			ResultSet rs = preparedStmt.executeQuery();
//			rs.next();
////			int ID = rs.getInt("ID");
////			int ulke_ID = rs.getInt("ulke_ID");
//			dili = rs.getString("dili");
//			// preparedStmt.execute();
//			preparedStmt.close();
//			conn.close();
//		} catch (Exception e) {
//			System.err.println("hata alýndý!Kod:0001");
//			System.err.println(e.getMessage());
//		}
//		return dili;
//	}

	public String getUlkeAdiByUlkeId(int ulkeId) {
		String adi = null;
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);

			String query = " SELECT * FROM ulke WHERE id = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, ulkeId);
			ResultSet rs = preparedStmt.executeQuery();
			rs.next();
//			int ID = rs.getInt("ID");
//			int ulke_ID = rs.getInt("ulke_ID");
			adi = rs.getString("adi");
			// preparedStmt.execute();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("hata alýndý!Kod:0001");
			System.err.println(e.getMessage());
		}
		return adi;
	}
}
