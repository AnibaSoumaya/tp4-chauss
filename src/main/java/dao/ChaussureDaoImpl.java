package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.SingletonConnection;
import metier.entities.Chaussure;


public class ChaussureDaoImpl  implements iChaussDao{

	@Override
	public Chaussure save(Chaussure c) {
	Connection conn=SingletonConnection.getConnection();
	try {
	PreparedStatement ps= conn.prepareStatement("INSERT INTO CHAUSSURES(NOM_CHAUSS,PRIX) VALUES(?,?)");
	ps.setString(1, c.getNomChaussure());
	ps.setDouble(2, c.getPrix());
	ps.executeUpdate();
	PreparedStatement ps2= conn.prepareStatement
	("SELECT MAX(ID_CHAUSS) as MAX_ID FROM CHAUSSURES");
	ResultSet rs =ps2.executeQuery();
	if (rs.next()) {
	c.setIdChaussure(rs.getLong("MAX_ID"));
	}
	ps.close();
	ps2.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return c;
	}
	@Override
	public List<Chaussure> chaussuresParMC(String mc) {
	List<Chaussure> chauss= new ArrayList<Chaussure>();
	Connection conn=SingletonConnection.getConnection();
	try {
	PreparedStatement ps= conn.prepareStatement("select * from CHAUSSURES where NOM_CHAUSS LIKE ?");
	ps.setString(1, "%"+mc+"%");
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
		Chaussure c = new Chaussure();
	c.setIdChaussure(rs.getLong("ID_CHAUSS"));
	c.setNomChaussure(rs.getString("NOM_CHAUSS"));
	c.setPrix(rs.getDouble("PRIX"));
	chauss.add(c);
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return chauss;
	}
	@Override
	public Chaussure getChaussure(Long id) {
		Connection conn=SingletonConnection.getConnection();
		Chaussure p = new Chaussure();
		try {
		PreparedStatement ps= conn.prepareStatement("select * from CHAUSSURES where ID_CHAUSS = ?");
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
		p.setIdChaussure(rs.getLong("ID_CHAUSS"));
		p.setNomChaussure(rs.getString("NOM_CHAUSS"));
		p.setPrix(rs.getDouble("PRIX"));
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return p;
	}
	@Override
	public Chaussure updateChaussure(Chaussure c) {
		Connection conn=SingletonConnection.getConnection();
		try {
		PreparedStatement ps= conn.prepareStatement("UPDATE CHAUSSURES SET NOM_CHAUSS=?,PRIX=? WHERE ID_CHAUSS=?");
		ps.setString(1, c.getNomChaussure());
		ps.setDouble(2, c.getPrix());
		ps.setLong(3, c.getIdChaussure());
		ps.executeUpdate();
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return c;
	}
	@Override
	public void deleteChaussure(Long id) {
		Connection conn=SingletonConnection.getConnection();
		try {
		PreparedStatement ps= conn.prepareStatement("DELETE FROM CHAUSSURES WHERE ID_CHAUSS = ?");
		ps.setLong(1, id);
		ps.executeUpdate();
		ps.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
}

