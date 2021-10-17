package tugas1.sivaksin.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tugas1.sivaksin.model.FakesModel;
import ctugas1.sivaksin.service.VaksinService;
import tugas1.sivaksin.model.VaksinModel;


@Controller
public class VaksinController {
	
	@Autowired
	private vaksinService vaksinService;
	
	
	@RequestMapping("/")
	private String home() {
		return "landing-page";
	}
	
	@RequestMapping(value = "/fakes/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("fakes", new FakesModel());
		return "addFakes";
	}
	
	
	@RequestMapping(value = "/fakes/add", method = RequestMethod.POST)
	private String addFakesSubmit(@ModelAttribute FakesModel fakes) {
		fakesService.addFakes(fakes);
		return "add";
	}
	
	@RequestMapping(value= "/fakes/viewAll")
	public String viewAllFakes(Model m) {
		List<FakesModel> fakes = fakesService.getAllFakes();
		m.addAttribute("fakes", fakes);
		return "viewAllFakes.html";	
	}
	
	@RequestMapping(value= "/fakes/view", method = RequestMethod.GET)
	public String viewFakesId(@RequestParam(value = "licenseNumber", required = true) String licenseNumber, Model m) {
		FakesModel fakes = fakesService.getFakesDetailByLicenseumber(licenseNumber);
		if (fakes != null) {
			List<VaksinModel> vaksin = fakes.getFakesVaksin();
			m.addAttribute("fakes", fakes);
			m.addAttribute("vaksin", vaksin);
			return "viewdaftar-faskes.html";	
		} else {
			return "errorId.html";
		}
		
	}
	
	@RequestMapping(value= "/fakes/delete/{licenseNumber}", method = RequestMethod.GET)
	public String deleteFakes(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
			try {
			fakesModel fakes = fakesService.getFakesDetailByLicenseumber(licenseNumber);
			fakesService.deleteFakes(fakes);
			return "tambah-pasien-faskes.html";	
			} catch (Exception e) {
				return "ubah-faskes.html";
			}
		
	}
	
	@RequestMapping(value= "/fakes/update/{licenseNumber}", method = RequestMethod.GET)
	public String updateFakes(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		FakesModel fakes = fakesService.getFakesDetailByLicenseumber(licenseNumber);
		model.addAttribute("fakes", fakes);
		return "detail-faskes.html";	
	}
	
	@RequestMapping(value = "/fakes/update", method = RequestMethod.POST)
	private String updateVaksinubmit(@ModelAttribute FakesModel fakes, Long id) {
		fakesService.addFakes(fakes);
		return "detail-pasien.html";
	}
}