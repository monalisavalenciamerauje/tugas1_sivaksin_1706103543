package tugas1.sivaksin.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tugas1.sivaksin.FakesModel;

import tugas1.sivaksin.repository.FakestDb;

@Service
@Transactional
public class FakesServiceImpl implements FakesService {
	@Autowired
	private FakesDb fakesDb;

	@Override
	public FakesModel getFakestDetailByLicenseumber(String licenseNumber) {
		// TODO Auto-generated method stub
		return fakesDb.findByLicenseNumber(licenseNumber);
	}

	@Override
	public void addFakes(FakesModel fakes) {
		// TODO Auto-generated method stub
		fakesDb.save(fakes);
	}
	
	@Override
	public List<FakesModel> getAllFakes(){
		return fakesDb.findAll();
	}
	
	@Override
	public void deleteFakes(FakesModel fakes) {
		fakesDb.delete(fakes);
	}
	
}