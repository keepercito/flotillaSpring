package com.example.keepercito.flotilla.flotilla.Controller;

import com.example.keepercito.flotilla.flotilla.Entity.TipoMantenimiento;
import com.example.keepercito.flotilla.flotilla.Services.TipoMantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/tipoMantenimiento")
public class TipoMantenimientoController{

    @Autowired
    TipoMantenimientoService tipoMantenimientoService;
    
    @RequestMapping(value="/show", method = RequestMethod.GET)
    public ModelAndView show (){
        ModelAndView mv = new ModelAndView();
        mv.addObject("tipos",tipoMantenimientoService.getAllTipoMantenimientoAsc()).setViewName("tipoMantenimiento/show");
        return mv;
    }
    
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public ModelAndView create (){
        ModelAndView mv = new ModelAndView();
        mv.addObject("tm", new TipoMantenimiento());
        mv.setViewName("/tipoMantenimiento/new");
        return mv;
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public RedirectView store(@ModelAttribute("tm")TipoMantenimiento tm, RedirectAttributes attributes){
        TipoMantenimiento tm1 = tipoMantenimientoService.getTipoMantenimiento(tm.getTipoMant());
        if (tm1!=null) {
            attributes.addFlashAttribute("message","Tipo mantenimiento "+tm1.getTipoMant()+" ya Existe");
            return new RedirectView("/tipoMantenimiento/new");
        }
        tipoMantenimientoService.saveTipoMantenimiento(tm);
        attributes.addFlashAttribute("message", "Registro se guardo con exito!");
        return new RedirectView("/tipoMantenimiento/show");
    }

    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("tm",tipoMantenimientoService.getTipoMantenimiento(Integer.parseInt(id)));
        mv.setViewName("tipoMantenimiento/edit");
        return mv;
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public RedirectView update(@ModelAttribute("tm")TipoMantenimiento tm, RedirectAttributes attributes) {
        TipoMantenimiento tm1 = tipoMantenimientoService.getTipoMantenimiento(tm.getTipoMant());
        if (tm1!=null) {
            attributes.addFlashAttribute("message","Tipo mantenimiento "+tm1.getTipoMant()+"ya Existe");
            return new RedirectView("/tipoMantenimiento/edit/"+tm.getId());
        }
        tm1 = tipoMantenimientoService.getTipoMantenimiento(tm.getId());
        tm1.setTipoMant(tm.getTipoMant());
        tipoMantenimientoService.saveTipoMantenimiento(tm1);
        attributes.addFlashAttribute("message", "Registro se guardo con exito!");
        return new RedirectView("/tipoMantenimiento/show");
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    public RedirectView delete(@ModelAttribute("id")TipoMantenimiento id, RedirectAttributes attributes){
        tipoMantenimientoService.deleteTipoMantenimiento(id);
        attributes.addFlashAttribute("message", "Registro se eliminó con exito!");
        return new RedirectView("/tipoMantenimiento/show");
    }
    
}