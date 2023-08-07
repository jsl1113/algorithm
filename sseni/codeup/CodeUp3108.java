package com.example.javaproject3.codeup;

import java.util.*;

class Student {
    private String code;
    private int testId;
    private String name;

    public Student(String code, int testId, String name) {
        this.code = code;
        this.testId = testId;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public int getTestId() {
        return testId;
    }

    public String getName() {
        return name;
    }
}

public class CodeUp3108 {
    private List<Student> students = new ArrayList<>();

    public Student makeAStudent(String code, int testId, String name) {
        return new Student(code, testId, name);
    }

    private boolean isExist(Student pStudent) {
        // 중복 여부 check
        for (Student student : students){
            if(pStudent.getTestId() == student.getTestId()){
                return true;
            }
        }
        return false;
    }
    private void addASudent(Student student) {
        if (!isExist(student)) {
            students.add(student);
        }
    }
    private void deleteStudent(Student pStudent) {
        // pStudent가 students에 몇번째에 있는지 알아야 함
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getTestId() == pStudent.getTestId()){
                students.remove(i);
            }
        }
    }
    public void process(String line) {
        String[] splitted = line.split(" ");
        Student student = makeAStudent(splitted[0], Integer.parseInt(splitted[1]), splitted[2]);
        switch (student.getCode()) {
            case "I": addASudent(student); break;
            case "D": deleteStudent(student); break;
        }
    }
    private void printSpecificStudents(int[] arr) {
        // 정렬
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getTestId() - o2.getTestId();
            }
        });
        // 출력
        for (int i = 0; i < arr.length; i++) {
            Student student = students.get(arr[i] - 1);
            System.out.printf("%s %s\n", student.getTestId(), student.getName());
        }
    }

    public static void main(String[] args) {
        CodeUp3108 codeup3108 = new CodeUp3108();

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<size; i++){
            codeup3108.process(sc.nextLine());
        }
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[str.length];
        for(int i=0;i <arr.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        codeup3108.printSpecificStudents(arr);
    }
}
