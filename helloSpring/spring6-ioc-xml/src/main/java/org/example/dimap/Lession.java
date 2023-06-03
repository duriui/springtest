package org.example.dimap;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-03-1:08
 */
public class Lession {
    private String lessonName;

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    @Override
    public String toString() {
        return "Lession{" +
                "lessonName='" + lessonName + '\'' +
                '}';
    }
}
