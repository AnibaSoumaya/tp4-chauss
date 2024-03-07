package test;

import java.util.List;

import dao.ChaussureDaoImpl;
import metier.entities.Chaussure;

public class TestDao {

	public static void main(String[] args) {
		ChaussureDaoImpl cdao= new ChaussureDaoImpl();
		Chaussure chauss= cdao.save(new Chaussure("ado",280));
		System.out.println(chauss);
		List<Chaussure>chaus =cdao.chaussuresParMC("aldo");
		for (Chaussure c : chaus)
		System.out.println(c);
		}
}
