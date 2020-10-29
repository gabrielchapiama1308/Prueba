package pe.edu.upc.market.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.market.models.entities.Distrito;
import pe.edu.upc.market.services.DistritoService;

// Siempre se tiene que utilizar el 'model' para el envio de la data al html

@Controller
@RequestMapping("/distritos")
@SessionAttributes("distrito")
public class DistritoController {
	
	@Autowired
	private DistritoService distritoService;	
	
	// Para obtener data de la BD y enviarlo al Front
	@GetMapping
	public String inicio(Model model) {
		Distrito distrito = new Distrito();
		distrito.setProvincia("Lima");
		
		try {
			List<Distrito> distritos = distritoService.findAll();
			model.addAttribute("distritos", distritos);
			// Enviando el objeto distrito para el nuevo elemento
			model.addAttribute("distrito", distrito);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve el nombre del archivo HTML
		return "/distritos/inicio";
	}
	//   /distritos/save
	@PostMapping("save")
	public String save(@ModelAttribute("distrito") Distrito distrito, SessionStatus status) {
		try {
			distritoService.save(distrito);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping 
		return "redirect:/distritos";
	}
	
	@GetMapping("view-{id}")
	public String view(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Distrito> optional = distritoService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("distrito", optional.get());
				return "distritos/view";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/distritos";		
	}

}




