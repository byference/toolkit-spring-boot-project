package com.github.baifenghe.toolkit.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link BigDecimal} util
 *
 * @author byference
 * @since 2019-10-08
 */
public class BigDecimalsTest {


    @Test
    public void customBigDecimalReduce() {

        // simple
        BigDecimal sum = getPersons().stream().map(Person::getAccount).reduce(BigDecimals::sum).orElse(BigDecimal.ZERO);
        BigDecimal max = getPersons().stream().map(Person::getAccount).reduce(BigDecimals::max).orElse(BigDecimal.ZERO);
        BigDecimal min = getPersons().stream().map(Person::getAccount).reduce(BigDecimals::min).orElse(BigDecimal.ZERO);

        // complex
        Map<String, BigDecimal> complexSum = getPersons().stream()
                .filter(person -> person.getId() != 0)
                .collect(Collectors.toMap(Person::getUsername, Person::getAccount, BigDecimals::sum));

        assert sum.compareTo(BigDecimal.valueOf(210L)) == 0;
        assert max.compareTo(BigDecimal.valueOf(20L)) == 0;
        assert min.compareTo(BigDecimal.valueOf(1L)) == 0;
        assert complexSum.size() == 20;
    }


    /**
     * get list of {@link Person}
     */
    private static List<Person> getPersons() {

        return Stream.iterate(1, n -> n + 1).limit(20).map(num -> {
            Person person = new Person();
            person.setId(num);
            person.setUsername("name" + num);
            person.setAccount(BigDecimal.valueOf(num));
            return person;
        }).collect(Collectors.toList());
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person {

        private int id;

        private String username;

        private BigDecimal account;
    }

}
