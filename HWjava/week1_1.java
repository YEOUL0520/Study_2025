package HWjava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// 유저의 이름 나이 클래스 생성
class User{
	int age;
	String name;

	public User(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + "]";
	}
}

public class week1_1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		// 정수 하나 입력 받음
		int n = s.nextInt();

		int[] useAge = new int[n];
		String[] useName = new String[n];
		// 공백 기준 입력
		for(int i = 0; i < n; i++) {
			useAge[i] = s.nextInt();
			useName[i] = s.next();
		}

		// 안전정렬위한 ArrayList 생성
		List<User> userlist = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			userlist.add(new User(useAge[i], useName[i]));
		}
		// 안전정렬
		userlist.sort(Comparator.comparingInt(p -> p.age));

		// 공백 구분 출력
		for (User u : userlist) {
			System.out.println(u.age + " " + u.name);
		}

		// 스캐너 닫기
		s.close();
	}
}


