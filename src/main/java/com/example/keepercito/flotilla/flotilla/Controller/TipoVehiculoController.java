package com.example.keepercito.flotilla.flotilla.Controller;

import com.example.keepercito.flotilla.flotilla.Entity.TipoVehiculo;
import com.example.keepercito.flotilla.flotilla.Services.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/tipoVehiculo")
public class TipoVehiculoController{

    @Autowired
    TipoVehiculoService tipoVehiculoService;
    
    @RequestMapping(value="/show", method = RequestMethod.GET)
    public ModelAndView show (){
        ModelAndView mv = new ModelAndView();
        mv.addObject("tipos",tipoVehiculoService.getAllTipoVehiculoAsc()).setViewName("tipoVehiculo/show");
        return mv;
    }
    
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public ModelAndView create (){
        ModelAndView mv = new ModelAndView();
        mv.addObject("tv", new TipoVehiculo());
        mv.setViewName("/tipoVehiculo/new");
        return mv;
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public RedirectView store(@ModelAttribute("tv")TipoVehiculo tv, RedirectAttributes attributes){
        TipoVehiculo tv1 = tipoVehiculoService.getTipoVehiculo(tv.getTipoVehiculo());
        if (tv1!=null) {
            attributes.addFlashAttribute("message","Tipo de Vehiculo "+tv1.getTipoVehiculo()+" ya Existe");
            return new RedirectView("/tipoVehiculo/new");
        }
        tipoVehiculoService.saveTipoVehiculo(tv);
        attributes.addFlashAttribute("message", "Registro se guardo con exito!");
        return new RedirectView("/tipoVehiculo/show");
    }

    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("tv",tipoVehiculoService.getTipoVehiculo(Integer.parseInt(id)));
        mv.setViewName("tipoVehiculo/edit");
        return mv;
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public RedirectView update(@ModelAttribute("tv")TipoVehiculo tv, RedirectAttributes attributes) {
        TipoVehiculo tv1 = tipoVehiculoService.getTipoVehiculo(tv.getTipoVehiculo());
        if (tv1!=null) {
            attributes.addFlashAttribute("message","Tipo de Vehiculo "+tv1.getTipoVehiculo()+"ya Existe");
            return new RedirectView("/edit/"+tv.getId());
        }
        tv1 = tipoVehiculoService.getTipoVehiculo(tv.getId());
        tv1.setTipoVehiculo(tv.getTipoVehiculo());
        tipoVehiculoService.saveTipoVehiculo(tv1);
        attributes.addFlashAttribute("message", "Registro se guardo con exito!");
        return new RedirectView("/tipoVehiculo/show");
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    public String delete(@ModelAttribute("id")TipoVehiculo id){
        tipoVehiculoService.deleteTipoVehiculo(id);
        return "redirect:/tipoVehiculo/show";
    }
    
}