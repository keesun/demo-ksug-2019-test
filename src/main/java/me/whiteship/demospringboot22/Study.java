package me.whiteship.demospringboot22;

import lombok.Builder;

//@Builder
public class Study {

    private String title;
    private int maximumNumberOfParticipant;
    private StudyStatus status;

    public Study(String title, int maxNumberOfParticipant) {
//        this.status = StudyStatus.DRAFT;
        this.title = title;
        this.maximumNumberOfParticipant = maxNumberOfParticipant;
    }

    public static StudyBuilder builder() {
        return new StudyBuilder();
    }

    public StudyStatus getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public int getMaxNumberOfParticipant() {
        return this.maximumNumberOfParticipant;
    }
}
