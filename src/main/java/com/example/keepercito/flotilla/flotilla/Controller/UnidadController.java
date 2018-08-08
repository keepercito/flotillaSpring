package com.example.keepercito.flotilla.flotilla.Controller;

import com.example.keepercito.flotilla.flotilla.Entity.Unidad;
import com.example.keepercito.flotilla.flotilla.Services.UnidadService;

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
@RequestMapping("/unidad")
public class UnidadController{

    @Autowired
    UnidadService unidadService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView show() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("unidades", unidadService.getAllUnidadAsc())
                .setViewName("unidad/show");
        return mv;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("u", new Unidad());
        mv.setViewName("/unidad/new");
        return mv;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public RedirectView store(@ModelAttribute("u") Unidad u, RedirectAttributes attributes) {
        Unidad u1 = unidadService.getUnidad(u.getNombreUnidad());
        if (u1 != null) {
            attributes.addFlashAttribute("message", "Tipo mantenimiento " + u1.getNombreUnidad() + " ya Existe");
            return new RedirectView("/unidad/new");
        }
        unidadService.saveUnidad(u);
        attributes.addFlashAttribute("message", "Registro se guardo con exito!");
        return new RedirectView("/unidad/show");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("u", unidadService.getUnidad(Integer.parseInt(id)));
        mv.setViewName("unidad/edit");
        return mv;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RedirectView update(@ModelAttribute("u") Unidad u, RedirectAttributes attributes) {
        Unidad u1 = unidadService.getUnidad(u.getNombreUnidad());
        if (u1 != null) {
            attributes.addFlashAttribute("message", "Tipo mantenimiento " + u1.getNombreUnidad() + "ya Existe");
            return new RedirectView("/unidad/edit/" + u.getIdUnidad());
        }
        u1 = unidadService.getUnidad(u.getIdUnidad());
        u1.setNombreUnidad(u.getNombreUnidad());
        unidadService.saveUnidad(u1);
        attributes.addFlashAttribute("message", "Registro se guardo con exito!");
        return new RedirectView("/unidad/show");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public RedirectView delete(@ModelAttribute("id") Unidad id, RedirectAttributes attributes) {
        unidadService.deleteUnidad(id);
        attributes.addFlashAttribute("message", "Registro se eliminó con exito!");
        return new RedirectView("/unidad/show");
    }
}