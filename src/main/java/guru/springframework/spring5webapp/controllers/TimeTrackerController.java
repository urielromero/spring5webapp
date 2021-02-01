package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.model.TimeTracker;
import guru.springframework.spring5webapp.repositories.TimeTrackerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalTime;

@Controller
public class TimeTrackerController {

    private final TimeTrackerRepository timeTrackerRepository;

    public TimeTrackerController(TimeTrackerRepository timeTrackerRepository) {
        this.timeTrackerRepository = timeTrackerRepository;
    }


    @RequestMapping("/timetracker")
    public String getMain(Model model){

        model.addAttribute("timetrackers", timeTrackerRepository.findAll());

        return "timetracker/list";
    }

    @PostMapping("/addEntry")
    public  String addEntry(Model model, TimeTracker newTime){

        LocalTime currentTime = LocalTime.now();

        newTime = new TimeTracker(currentTime);

        model.addAttribute("timetrackers", timeTrackerRepository.save(newTime));
        model.addAttribute("timetrackers", timeTrackerRepository.findAll());

        return "/timetracker/list";
    }


}
