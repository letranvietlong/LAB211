/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlp0022;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Hi
 */
public class Manager {

    //display menu
    public static int menu() {
        System.out.println("========== MENU=========");
        System.out.println("Press 1: Experience");
        System.out.println("Press 2: Fresher");
        System.out.println("Press 3: Internship");
        System.out.println("Press 4: Searching");
        System.out.println("Press 5: Exit");
        System.out.println("=========================");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 5);
        return choice;
    }

    public static void createCandidate(ArrayList<Candidate> candidates,
            int type) {
        while (true) {
            System.out.println("-------- CREATE CANDIDATE --------");
            System.out.print("Enter ID: ");
            String id = Validation.checkInputString();
            System.out.print("Enter First Name: ");
            String firstName = Validation.checkInputString();
            System.out.print("Enter Last Name: ");
            String lastName = Validation.checkInputString();
            System.out.print("Enter Birthyears: ");
            int birthDate = Validation.checkInputIntLimit(1900,
                    Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter Address: ");
            String address = Validation.checkInputString();
            System.out.print("Enter Phone Number: ");
            String phone = Validation.checkInputPhone();
            System.out.print("Enter Email: ");
            String email = Validation.checkInputEmail();
            Candidate candidate = new Candidate(id, firstName, lastName,
                    birthDate, address, phone, email, type);
            if (Validation.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidates, candidate);
                        break;
                    case 1:
                        createFresher(candidates, candidate);
                        break;
                    case 2:
                        createInternship(candidates, candidate);
                        break;
                }
            } else {
                return;
            }
            System.out.print("Do you want to continue (Y/N): ");
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }

    public static void createExperience(ArrayList<Candidate> candidates,
            Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int yearExperience = Validation.checkInputExprience(candidate.getBirthDate());
        System.out.print("Enter professional skill: ");
        String professionalSkill = Validation.checkInputString();
        candidates.add(new Experience(yearExperience, professionalSkill,
                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    public static void createFresher(ArrayList<Candidate> candidates,
            Candidate candidate) {
        System.out.print("Enter graduation date: ");
        String graduationDate = Validation.checkInputString();
        System.out.print("Enter graduation rank: ");
        String graduationRank = Validation.checkInputGraduationRank();
        candidates.add(new Fresher(graduationDate, graduationRank, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    public static void createInternship(ArrayList<Candidate> candidates,
            Candidate candidate) {
        System.out.print("Enter major: ");
        String major = Validation.checkInputString();
        System.out.print("Enter Semester: ");
        String semester = Validation.checkInputString();
        System.out.print("Enter University: ");
        String university = Validation.checkInputString();
        candidates.add(new Internship(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    public static void searchCandidate(ArrayList<Candidate> candidates) {
        printListNameCandidate(candidates);
        System.out.print("Enter andidate name (First name or Last name): ");
        String nameSearch = Validation.checkInputString();
        System.out.print("Enter type of candidate: ");
        int typeCandidate = Validation.checkInputIntLimit(0, 2);
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && candidate.getFirstName().contains(nameSearch)
                    || candidate.getLastName().contains(nameSearch)) {
                System.out.println(candidate.toString());
            }
        }
    }

    public static void printListNameCandidate(ArrayList<Candidate> candidates) {
        System.err.println("Experience Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("Fresher Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("Internship Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
    }

}
