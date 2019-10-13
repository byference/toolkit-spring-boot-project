package com.github.baifenghe.toolkit.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
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
    public void comparingTest() {

        List<Person> persons = getPersons();
        Collections.shuffle(persons);
        final List<Person> collect = persons.stream().sorted(BigDecimals.comparing(Person::getAccount)).collect(Collectors.toList());
        assert BigDecimals.compareTo(BigDecimal.ONE, collect.get(0).getAccount()) == 0;
        assert BigDecimals.compareTo(BigDecimal.valueOf(20L), collect.get(19).getAccount()) == 0;
    }


    @Test
    public void compareToTest() {

        assert BigDecimals.compareTo(null, null) == 0;
        assert BigDecimals.compareTo(BigDecimal.ONE, BigDecimal.valueOf(1L)) == 0;
        assert BigDecimals.compareTo(BigDecimal.valueOf(20L), null) == 1;
    }


    @Test
    public void minTest() {

        BigDecimal min = getPersons().stream().map(Person::getAccount).reduce(BigDecimals::min).orElse(BigDecimal.ZERO);
        assert min.compareTo(BigDecimal.valueOf(1L)) == 0;
    }


    @Test
    public void maxTest() {

        BigDecimal max = getPersons().stream().map(Person::getAccount).reduce(BigDecimals::max).orElse(BigDecimal.ZERO);
        assert max.compareTo(BigDecimal.valueOf(20L)) == 0;
    }


    @Test
    public void sumTest() {

        BigDecimal sum = getPersons().stream().map(Person::getAccount).reduce(BigDecimals::sum).orElse(BigDecimal.ZERO);
        assert sum.compareTo(BigDecimal.valueOf(210L)) == 0;
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
