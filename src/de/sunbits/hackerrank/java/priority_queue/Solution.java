package de.sunbits.hackerrank.java.priority_queue;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */


class Student implements Comparable<Student> {

  private int id;
  private String name;

  private double CGPA;

  public Student(final int id, final String name, final double CGPA) {
    this.id = id;
    this.name = name;
    this.CGPA = CGPA;
  }

  public int getID() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getCGPA() {
    return CGPA;
  }

  @Override
  public int compareTo(@NotNull final Student o) {
    if (this.getCGPA() < o.getCGPA()) {
      return -1;
    }
    if (this.getCGPA() == o.getCGPA()) {
      return getName().compareTo(o.getName());
    }
    return 1;
  }
}

class Priorities {

  List<Student> getStudents(List<String> events) {

    List<Student> students = new LinkedList<>();

    for (String event : events) {
      String[] eventData = event.split(" ");
      if (eventData.length == 1) {
        Collections.sort(students);
        if (students.size() > 0) {
          students.remove(0);
        }
      } else {
        Student s = new Student(Integer.parseInt(eventData[3]), eventData[1], Double.parseDouble(eventData[2]));
        students.add(s);
      }
    }
    Collections.sort(students);
    return students;
  }
}

public class Solution {

  private final static Scanner scan = new Scanner(System.in);
  private final static Priorities priorities = new Priorities();

  public static void main(String[] args) {
    int totalEvents = Integer.parseInt(scan.nextLine());
    List<String> events = new ArrayList<>();

    while (totalEvents-- != 0) {
      String event = scan.nextLine();
      events.add(event);
    }

    List<Student> students = priorities.getStudents(events);

    if (students.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      for (Student st : students) {
        System.out.println(st.getName());
      }
    }
  }
}