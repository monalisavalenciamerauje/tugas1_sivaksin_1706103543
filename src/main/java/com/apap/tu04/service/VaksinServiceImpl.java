package tugas1.sivaksin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tugas1.sivaksin.model.VaksintModel;
import tugas1.sivaksin.repository.VaksinDb;

@Service
@Transactional
public class VaksintServiceImpl implements VaksinService {
	@Autowired
	private VaksinDb vaksinDb;
	
	@Override
	public void addVaksin(VaksintModel vaksin) {
		// TODO Auto-generated method stub
		vaksinDb.save(vaksin);
	}
	
}
