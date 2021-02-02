package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.TimeTracker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface TimeTrackerRepository extends CrudRepository<TimeTracker, Long> {


}
