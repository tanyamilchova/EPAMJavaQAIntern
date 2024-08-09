package com.epam.rd.autocode.collections;

import java.math.BigDecimal;
import java.util.*;


public class StudentGradebookImpl implements StudentGradebook {

	private Map<Student, Map<String, BigDecimal>> map;
	private final Comparator<Student> comparator;


	public StudentGradebookImpl() {
		this.comparator = Comparator.comparing(Student::getFirstName)
				.thenComparing(Student::getLastName)
				.thenComparing(Student::getGroup);

		this.map = new TreeMap<>(comparator);
	}

	@Override
	public boolean addEntryOfStudent(Student student, String discipline, BigDecimal grade) {
		if (student == null || discipline == null || grade == null || grade.compareTo(BigDecimal.ZERO) < 0 || grade.compareTo(BigDecimal.valueOf(5)) > 0) {
			throw new IllegalArgumentException("Invalid input.");
		}
		Map<String, BigDecimal> grades = map.get(student);
		if (grades != null && grades.containsKey(discipline)) {
			if (grades.get(discipline).compareTo(grade) == 0) {
				return false;
			}
			grades.put(discipline, grade);
			return true;
		}
		if (grades == null) {
			grades = new HashMap<>();
			map.put(student, grades);
		}

		grades.put(discipline, grade);
		return true;
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public Comparator<Student> getComparator() {
		return comparator;
	}

	@Override
	public List<String> getStudentsByDiscipline(String discipline) {
		if (discipline == null) {
			throw new IllegalArgumentException("Discipline cannot be null.");
		}

		List<String> result = new ArrayList<>();

		for (Map.Entry<Student, Map<String, BigDecimal>> entry : map.entrySet()) {
			Student student = entry.getKey();
			Map<String, BigDecimal> grades = entry.getValue();

			if (grades.containsKey(discipline)) {
				BigDecimal grade = grades.get(discipline);
				result.add(student.getLastName() + "_" + student.getFirstName() + ": " + grade);
			}
		}

		return result;
	}

	@Override
	public Map<Student, Map<String, BigDecimal>> removeStudentsByGrade(BigDecimal grade) {

		if (grade == null || grade.compareTo(BigDecimal.ZERO) < 0 || grade.compareTo(BigDecimal.valueOf(5)) > 0) {
			throw new IllegalArgumentException("Invalid grade.");
		}
		Map<Student, Map<String, BigDecimal>> removedStudents = new TreeMap<>(getComparator());
		Iterator<Map.Entry<Student, Map<String, BigDecimal>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Student, Map<String, BigDecimal>> entry = iterator.next();
			Student student = entry.getKey();
			Map<String, BigDecimal> grades = entry.getValue();
			boolean hasBelowGrade = false;
			for (BigDecimal studentGrade : grades.values()) {
				if (studentGrade.compareTo(grade) < 0) {
					hasBelowGrade = true;
					break;
				}
			}
			if (hasBelowGrade) {
				removedStudents.put(student, new HashMap<>(grades));
				iterator.remove();
			}
		}

		return removedStudents;
	}

	@Override
	public Map<BigDecimal, List<Student>> getAndSortAllStudents() {

		Map<BigDecimal, List<Student>> result = new TreeMap<>();

		for (Map.Entry<Student, Map<String, BigDecimal>> entry : map.entrySet()) {
			Student student = entry.getKey();
			Map<String, BigDecimal> grades = entry.getValue();
			BigDecimal total = BigDecimal.ZERO;
			int count = 0;

			for (BigDecimal grade : grades.values()) {
				total = total.add(grade);
				count++;
			}
			BigDecimal averageGrade = count > 0 ? total.divide(BigDecimal.valueOf(count), 1, BigDecimal.ROUND_HALF_UP) : BigDecimal.ZERO;

			List<Student> students = result.get(averageGrade);
			if (students == null) {
				students = new ArrayList<>();
				result.put(averageGrade, students);
			}
			students.add(student);
		}
		return result;
	}
}
