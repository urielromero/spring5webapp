package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.TimeTracker;
import org.springframework.data.repository.CrudRepository;

public interface TimeTrackerRepository extends CrudRepository<TimeTracker, Long> {
}
