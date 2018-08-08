package com.example.keepercito.flotilla.flotilla.Controller;

import com.example.keepercito.flotilla.flotilla.Entity.Vehiculo;
import com.example.keepercito.flotilla.flotilla.Services.MarcaService;
import com.example.keepercito.flotilla.flotilla.Services.TipoVehiculoService;
import com.example.keepercito.flotilla.flotilla.Services.VehiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoController{

    @Autowired
    VehiculoService vehiculoService;
    
    @Autowired
    TipoVehiculoService tipoVehiculoService;
    
    @Autowired
    MarcaService marcaService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView show() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("vehiculos", vehiculoService.getAllVehiculosAsc()).setViewName("vehiculo/show");
        return mv;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("v", new Vehiculo());
        mv.addObject("tipos", tipoVehiculoService.getAllTipoVehiculo());
        mv.addObject("marcas", marcaService.getAllMarcas());
        mv.setViewName("vehiculo/new");
        return mv;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public RedirectView store(@ModelAttribute("v") Vehiculo v, 
    @RequestParam("tipoVehiculo")int tv, @RequestParam("marca")int m, RedirectAttributes attributes) {
        Vehiculo v1 = vehiculoService.getVehiculoByChasis(v.getNumeroChasis());
        if (v1 != null) {
            attributes.addFlashAttribute("message", "Vehiculo " + v1.getNombre() + " ya Existe");
            return new RedirectView("/vehiculo/new");
        }
        v.setIdTipoVehiculo(tipoVehiculoService.getTipoVehiculo(tv));
        v.setIdMarca(marcaService.getMarca(m));
        vehiculoService.saveVehiculo(v);
        attributes.addFlashAttribute("message", "Registro se guardo con exito!");
        return new RedirectView("/vehiculo/show");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("v", vehiculoService.getVehiculo(Integer.parseInt(id)));
        mv.addObject("tipos", tipoVehiculoService.getAllTipoVehiculo());
        mv.addObject("marcas", marcaService.getAllMarcas());
        mv.setViewName("vehiculo/edit");
        return mv;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RedirectView update(@ModelAttribute("v") Vehiculo v, RedirectAttributes attributes) {
        Vehiculo v1 = vehiculoService.getVehiculoByChasis(v.getNumeroChasis());
        if (v1 != null) {
            attributes.addFlashAttribute("message", "Vehiculo " + v1.getNombre() + "ya Existe");
            return new RedirectView("/vehiculo/edit/" + v.getIdVehiculo());
        }
        v1 = vehiculoService.getVehiculo(v.getIdVehiculo());
        v1.setNombre(v.getNombre());
        vehiculoService.saveVehiculo(v1);
        attributes.addFlashAttribute("message", "Registro se guardo con exito!");
        return new RedirectView("/vehiculo/show");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public RedirectView delete(@ModelAttribute("id") int id, RedirectAttributes attributes) {
        vehiculoService.deleteVehiculo(vehiculoService.getVehiculo(id));
        attributes.addFlashAttribute("message", "Registro se eliminó con exito!");
        return new RedirectView("/vehiculo/show");
    }
}