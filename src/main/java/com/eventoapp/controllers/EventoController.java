package com.eventoapp.controllers;

import com.eventoapp.models.Convidado;
import com.eventoapp.models.Evento;
import com.eventoapp.repository.ConvidadoRepository;
import com.eventoapp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller // indica que a classe é um controlador de Spring MVC
public class EventoController {

    @Autowired //faz uma injeção de dependencias em um objeto, será criada uma nova instancia quando for solicitada.
    private EventoRepository er;

    @Autowired //faz uma injeção de dependencias em um objeto, será criada uma nova instancia quando for solicitada.
    private ConvidadoRepository cr;

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET) // mapeia uma solicitação HTTP para um método em um controlador e especifica a URL da solicitação, o metodo HTTP e os paramentos.
                                                                            // GET pois retorna o formulario
    public String form() {

        return "evento/formEvento";
    }

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST) //quando salvar os dados manda para a requisição para a BD.
    public String form(Evento evento) {

        er.save(evento); //persiste os eventos na BD, ou seja, salva-os na BD

        return "redirect:/cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos() {

        ModelAndView mv = new ModelAndView("index");
        Iterable<Evento> eventos = er.findAll();                //faz a busca de todos os elementos da lista de eventos
        mv.addObject("eventos", eventos);
        return mv;

    }

    @RequestMapping(value = "/{codigo}", method=RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("codigo") int codigo) {
        Evento evento = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("detalhesEvento");
        mv.addObject("evento", evento);
        return mv;
    }

    @RequestMapping(value = "/{codigo}", method=RequestMethod.POST)
    public String detalhesEvento(@PathVariable("codigo") int codigo, Convidado convidado) {
        Evento evento = er.findByCodigo(codigo);
        convidado.setEvento(evento);
        cr.save(convidado);


        return "redirect:/{codigo}";
    }




}
