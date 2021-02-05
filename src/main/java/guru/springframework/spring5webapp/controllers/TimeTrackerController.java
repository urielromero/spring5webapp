package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.model.TimeTracker;
import guru.springframework.spring5webapp.repositories.TimeTrackerRepository;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
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

        return "timetracker/list";
    }

    @RequestMapping("/deleteEntry")
    public String deleteEntry(HttpServletRequest request, Model model){

        //handle id entered by user
        String userInputValue = request.getParameter("idEntered");

        //turn string into long type
        Long id = Long.parseLong(userInputValue);


        timeTrackerRepository.deleteById(id);

        //send java obj to view "timetrackers"
        model.addAttribute("timetrackers", timeTrackerRepository.findAll());

        return "timetracker/list";
    }

    @RequestMapping("/deleteAll")
    public String deleteAll(){
        timeTrackerRepository.deleteAll();
        return "timetracker/list";
    }

    @RequestMapping("/update")
    public String update(HttpServletRequest request, Model model){

        //Take input from user and convert to Long
        String userInputId = request.getParameter("idEntered");
        String userInputHour = request.getParameter("hourEntered");
        String userInputMinutes = request.getParameter("minutesEntered");

        //convert ID to Long to use by repository
        Long id = Long.parseLong(userInputId);

        //convert to Int to use by LocalTime
        Integer hour = Integer.parseInt(userInputHour);
        Integer minutes = Integer.parseInt(userInputMinutes);

        //Update LocalTime with new user input
        LocalTime updatedTime = LocalTime.of(hour, minutes);


        TimeTracker newTime = new TimeTracker(updatedTime);

        //Update same obj
        timeTrackerRepository.findById(id).get().setCurrentTime(updatedTime);

        //save same obj
        timeTrackerRepository.save(timeTrackerRepository.findById(id).get());

        //refresh/display list on page
        model.addAttribute("timetrackers", timeTrackerRepository.findAll());

        return "timetracker/list";
    }


}
