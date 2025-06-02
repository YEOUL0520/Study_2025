import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //맨 첫 줄은 반복 횟수 (몇 명 입력받나?)
        int n = Integer.parseInt(sc.nextLine());

        List<Person> personList = new ArrayList<>();

        //첫 번째 입력은 나이, 두번째는 이름
        for (int i=0; i<n; i++){
            int age = sc.nextInt();
            String name = sc.next();
            personList.add(new Person(age, name));
        }

        //정렬 함수 사용
        personList.sort(Comparator.comparingInt(p->p.age));

        for (Person p: personList){
            System.out.println(p.age + " " + p.name);
        }
    }

    //구조체 생성 (나이, 이름)
    static class Person{
        int age;
        String name;

        //자바에서는 재사용을 위해 this.사용
        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}

