package com.controller;

import com.model.Song;
import com.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping
    public String listSongs(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/save")
    public ModelAndView saveSong(@Valid @ModelAttribute("song") Song song, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("create");
        if (bindingResult.hasErrors()) {
            mv.addObject("message", "Input validation failed");
        } else {
            songService.save(song);
            mv.addObject("message", "New song added successfully");
        }
        return mv;
    }

    @GetMapping("/{id}/update")
    public ModelAndView showUpdateForm(@PathVariable("id") Integer id, Model model) {
        ModelAndView mv = new ModelAndView("update");
        Optional<Song> song = songService.findById(id);
        if (song.isPresent()) {
            mv.addObject("song", song.get());
        } else {
            return new ModelAndView("list");
        }
        return mv;
    }

    @PostMapping("/update")
    public ModelAndView updateSong(@Valid @ModelAttribute("song") Song song, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("update");
        if (bindingResult.hasErrors()) {
            mv.addObject("message", "Input validation failed");
        } else {
            songService.save(song);
            mv.addObject("message", "Song updated successfully");
        }
        return mv;
    }
}
