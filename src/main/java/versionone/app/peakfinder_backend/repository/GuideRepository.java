package versionone.app.peakfinder_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import versionone.app.peakfinder_backend.model.Guide;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {

}