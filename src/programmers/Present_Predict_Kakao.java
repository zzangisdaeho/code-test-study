package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Present_Predict_Kakao {

    public static void main(String[] args) {

        String[] friends = {"muzi", "ryan", "frodo", "neo"};

        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        int solution = new Present_Predict_Kakao().solution(friends, gifts);
        System.out.println("solution = " + solution);
    }

    public int solution(String[] friends, String[] gifts) {
        Map<String, Person> friendMap = new HashMap<>();

        settingHistory(friends, gifts, friendMap);

        Map<String, Integer> anticipate = new HashMap<>();
        friendMap.forEach((s, person) -> anticipate.put(s, 0));

        friendMap.forEach((s, person) -> {

            person.history.forEach((target, history) -> {

                if (history.take < history.give) countUpAnticipate(anticipate, person);
                else if (history.take == history.give) {
                    if (person.presentScore > target.presentScore) countUpAnticipate(anticipate, person);
                }
            });
        });

        return anticipate.values().stream().mapToInt(Integer::intValue).max().orElse(0);

    }

    private static void  countUpAnticipate(Map<String, Integer> anticipate, Person target) {
        anticipate.merge(target.name, 1, Integer::sum);
    }

    private static void settingHistory(String[] friends, String[] gifts, Map<String, Person> friendMap) {

        for (String name : friends) {
            friendMap.put(name, new Person(name));
        }

        for (String name : friends) {
            Person person = friendMap.get(name);
            for (String otherName : friends) {
                if (!name.equals(otherName)) {
                    person.history.put(friendMap.get(otherName), new Pair(0, 0));
                }
            }
        }

        for(String gift : gifts){
            String[] split = gift.split(" ");
            String giverName = split[0];
            String takerName = split[1];

            Person giver = friendMap.get(giverName);
            Person taker = friendMap.get(takerName);

            giver.givePresent(taker);
            taker.takePresent(giver);
        }
    }

    public static class Person{
        String name;

        int presentScore = 0;

        Map<Person, Pair> history = new HashMap<>();

        public Person(String name) {
            this.name = name;
        }

        public void takePresent(Person from){

            presentScore--;

            if(history.containsKey(from)){
                history.get(from).countUpTake();
            }else{
                history.put(from, new Pair(0, 1));
            }
        }

        public void givePresent(Person to){
            presentScore++;
            if(history.containsKey(to)){
                history.get(to).countUpGive();
            }else{
                history.put(to, new Pair(1, 0));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }
    }

    public static class Pair{
        int give = 0;
        int take = 0;

        public Pair(int give, int take) {
            this.give = give;
            this.take = take;
        }

        public void countUpGive(){
            this.give++;
        }

        public void countUpTake(){
            this.take++;
        }
    }
}
