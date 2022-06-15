package com.edib.practica1.controller;


import com.edib.practica1.model.TablaClientes;
import com.edib.practica1.model.TablaFacturas;
import com.edib.practica1.repository.FacturasRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:9083")
@Controller
@RequestMapping(path = "practica")
public class FacturaController {
	
	@Autowired
	FacturasRepository facturasRepository;
	
	
	@GetMapping(path = "deletefactura")
	public String delete (Model model,@RequestParam long idFactura){

		Optional<TablaFacturas> tablaFacturas = facturasRepository.findById(idFactura);
		if (tablaFacturas.isPresent()) {
			facturasRepository.deleteById(idFactura);
			return "redirect:/practica/updateTablaFacturas?idFactura=" + tablaFacturas.get().getTablaClientes().getIdCliente();
		}

		return "error";
	}
	
	@GetMapping(path = "updateTablaFacturas")
	public String updateTablaFacturas (Model model, @RequestParam long idFactura){
		model.addAttribute("update", true);
		model.addAttribute("intupdate", 0);
		Optional<TablaFacturas> tablaFacturas = facturasRepository.findById(idFactura);
		if (tablaFacturas.isPresent()) {
				model.addAttribute("tablaFacturas",tablaFacturas.get() );
		}
		return "updateTablaFacturas";
	}
	
	/*
	@GetMapping(path = "insertarTablaFacturas")
	public String insertarTablaFacturas (Model model){
        model.addAttribute("update", false);
        model.addAttribute("intupdate", 1);
        model.addAttribute("tablaClientes", new TablaClientes());
        model.addAttribute("tablaFacturas", new TablaFacturas());
        
        return "updateTablaFacturas";
    }
	*/
    @PostMapping(path = "saveFactura")
    public String saveFactura( Model model,@ModelAttribute TablaFacturas tablaFacturas,@RequestParam int update){

        if (tablaFacturas.getDescripcion().length() < 5) {
            if (update == 1) {
                model.addAttribute("update", false);
                model.addAttribute("intupdate", 1);
            } else {
                model.addAttribute("update", true);
                model.addAttribute("intupdate", 0);
            }
            model.addAttribute("cliente", tablaFacturas);
            model.addAttribute("isError", true);
            model.addAttribute("error", "La descripción tiene que tener más de 5 letras.");

            return "updateTablaFacturas";
        }

        facturasRepository.save(tablaFacturas);

        return "redirect:/practica/tablaClientes";
    }
	
	
	
	
}
