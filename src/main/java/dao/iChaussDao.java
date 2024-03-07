package dao;

import java.util.List;

import metier.entities.Chaussure;

public interface iChaussDao {



	public Chaussure save(Chaussure c);
	public List<Chaussure> chaussuresParMC(String mc);
	public Chaussure getChaussure(Long id);
	public Chaussure updateChaussure(Chaussure c);
	public void deleteChaussure(Long id);
	
}

