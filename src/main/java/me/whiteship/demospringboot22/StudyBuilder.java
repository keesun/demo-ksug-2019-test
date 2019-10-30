package me.whiteship.demospringboot22;

import java.util.HashSet;
import java.util.Set;

public class StudyBuilder {

    private String title;

    private int maxNumberOfParticipant;

    private Set<StudyTag> studyTags = new HashSet<>();

    public StudyBuilder title(String title) {
        this.title = title;
        return this;
    }

    public StudyBuilder maxNumberOfParticipant(int maxNumberOfParticipant) {
        if (maxNumberOfParticipant < 0) {
            throw new IllegalArgumentException("maxNumberOfParticipant can't be below zero");
        }
        this.maxNumberOfParticipant = maxNumberOfParticipant;
        return this;
    }

    public StudyBuilder addTag(StudyTag studyTag) {
        this.studyTags.add(studyTag);
        return this;
    }

    public Study build() {
        return new Study(this.title, this.maxNumberOfParticipant, this.studyTags);
    }
}
