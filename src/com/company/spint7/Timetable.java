package com.company.spint7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Time implements Comparable<Time> {
    private final float start;
    private final float end;
    public Time(float start, float end) {
        this.start = start;
        this.end = end;
    }

    public float getStart() {
        return start;
    }

    public float getEnd() {
        return end;
    }

    public int compareTo(Time time) {
        return Float.compare(this.end, time.end);
    }
}

public class Timetable {
    public static void printLessons(List<Time> timetable) {
        //сортируем по времени окончания занятия
        Collections.sort(timetable);
//        List<Time> newTimetable = new ArrayList<>(timetable.size());
//        Time firstTime = timetable.get(0);
//        for (int i = 1; i < timetable.size(); i++) {
//
//        }
        int lessonCounter = 0;
        StringBuilder out = new StringBuilder();
        int n = timetable.size();
        boolean endCycle = false;
        for (int i = 0; i < n; i++) {
            Time lesson = timetable.get(i);
            if (!endCycle) {
                if (timetable.get(i).getStart() == (int) timetable.get(i).getStart()) {
                    out.append((int) timetable.get(i).getStart())
                            .append(" ");
                } else {
                    out.append(timetable.get(i).getStart())
                            .append(" ");
                }
                if (timetable.get(i).getEnd() == (int) timetable.get(i).getEnd()) {
                    out.append((int) timetable.get(i).getEnd())
                            .append("\n");
                } else {
                    out.append(timetable.get(i).getEnd())
                            .append("\n");
                }
                lessonCounter++;
                for (int j = i + 1; j < n; j++) {
                    if (timetable.get(j).getStart() >= lesson.getEnd()) {
                        i = j - 1;
                        break;
                    }
                    if (j == n - 1) {
                        endCycle = true;
                    }
                }
            }
        }
        System.out.println(lessonCounter);
        System.out.println(out);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Time> timetable = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            float start = Float.parseFloat(tokenizer.nextToken());
            float end = Float.parseFloat(tokenizer.nextToken());
            Time time = new Time(start, end);
            timetable.add(time);
        }
        printLessons(timetable);
    }
}
