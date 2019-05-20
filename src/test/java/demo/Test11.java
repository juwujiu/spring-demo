package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import demo.entity.Action;

public class Test11
{
    public static void main(String args[]) throws Exception
    {
        List<Action> actions = new ArrayList<>();
        for (int i = 0; i <= 10; i++)
        {
            Action action = new Action();
            action.setId(i + "");
            action.setName("f" + i);
            actions.add(action);
        }
        for (int i = 5; i <= 12; i++)
        {
            Action action = new Action();
            action.setId(i + "");
            action.setName("d" + i);
            actions.add(action);
        }
        actions = actions.stream().filter(distinctByKey(Action::getName)).collect(Collectors.toList());
        System.out.println("----------");
        actions.forEach(action ->
        {
            System.out.println(action.getId());
        });

    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor)
    {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
