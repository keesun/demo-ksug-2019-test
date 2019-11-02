package me.whiteship.ksug2019.study;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudyKeywordRepository extends JpaRepository<StudyKeyword, Long> {

    @Query("SELECT new me.whiteship.ksug2019.study.TagCloudData(s.keyword, COUNT(s)) " +
            "FROM StudyKeyword s " +
            "GROUP BY s.keyword")
    List<TagCloudData> getTagCloudData();

    List<StudyKeyword> findByKeyword(String keyword);
}
