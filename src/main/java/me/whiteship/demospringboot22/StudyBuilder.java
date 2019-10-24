package me.whiteship.demospringboot22;

public class StudyBuilder {

    private String title;

    private int maxNumberOfParticipant;

    public StudyBuilder title(String title) {
        this.title = title;
        return this;
    }

    public StudyBuilder maxNumberOfParticipant(int maxNumberOfParticipant) {
        this.maxNumberOfParticipant = maxNumberOfParticipant;
        return this;
    }

    public Study build() {
        return new Study(this.title, this.maxNumberOfParticipant);
    }
}
