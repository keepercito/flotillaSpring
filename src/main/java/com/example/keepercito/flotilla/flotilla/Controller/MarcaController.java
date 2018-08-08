package com.example.keepercito.flotilla.flotilla.Controller;

import com.example.keepercito.flotilla.flotilla.Entity.Marca;
import com.example.keepercito.flotilla.flotilla.Services.MarcaService;

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
@RequestMapping("/marca")
public class MarcaController{

    @Autowired
    MarcaService marcaService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView show() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("marcas", marcaService.getAllMarcasAsc())
                .setViewName("marca/show");
        return mv;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("m", new Marca());
        mv.setViewName("/marca/new");
        return mv;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public RedirectView store(@ModelAttribute("m") Marca m, RedirectAttributes attributes) {
        Marca m1 = marcaService.getMarca(m.getMarca());
        if (m1 != null) {
            attributes.addFlashAttribute("message", "Marca " + m1.getMarca() + " ya Existe");
            return new RedirectView("/marca/new");
        }
        marcaService.saveMarca(m);
        attributes.addFlashAttribute("message", "Registro se guardo con exito!");
        return new RedirectView("/marca/show");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("m", marcaService.getMarca(Integer.parseInt(id)));
        mv.setViewName("marca/edit");
        return mv;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RedirectView update(@ModelAttribute("m") Marca m, RedirectAttributes attributes) {
        Marca m1 = marcaService.getMarca(m.getMarca());
        if (m1 != null) {
            attributes.addFlashAttribute("message", "Marca " + m1.getMarca() + "ya Existe");
            return new RedirectView("/marca/edit/" + m.getId());
        }
        m1 = marcaService.getMarca(m.getId());
        m1.setMarca(m.getMarca());
        marcaService.saveMarca(m1);
        attributes.addFlashAttribute("message", "Registro se guardo con exito!");
        return new RedirectView("/marca/show");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public RedirectView delete(@ModelAttribute("id") Marca id, RedirectAttributes attributes) {
        marcaService.deleteMarca(id);
        attributes.addFlashAttribute("message", "Registro se eliminó con exito!");
        return new RedirectView("/marca/show");
    }
}