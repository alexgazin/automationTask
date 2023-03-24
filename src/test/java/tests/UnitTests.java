package tests;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

public class UnitTests {

    @Test
    public void testOne() {
        LocalDate birthDate = LocalDate.of(2005, 3, 3);
        Boolean result = checkAge(birthDate, LocalDate.now());
        Assert.assertTrue("Возраст по условию должен быть равен 18", result);
    }

    @Test
    public void testTwo() {
        LocalDate birthDate = LocalDate.of(1950, 2, 3);
        Boolean result = checkAge(birthDate, LocalDate.now());
        Assert.assertFalse("Возраст по условию должен быть больше 18", result);
    }

    @Test
    public void testThree() {
        LocalDate birthDate = LocalDate.of(2006, 2, 3);
        Boolean result = checkAge(birthDate, LocalDate.now());
        Assert.assertFalse("Возраст по условию должен быть равен 17 лет", result);
    }

    @Test
    public void testFour() {
        LocalDate birthDate = LocalDate.of(2022, 4, 3);
        Boolean result = checkAge(birthDate, LocalDate.now());
        Assert.assertFalse("Возраст по условию должен быть равен 0 лет", result);
    }

    @Test
    public void testFive() {
        LocalDate birthDate = LocalDate.of(5022, 4, 3);
        Boolean result = checkAge(birthDate, LocalDate.now());
        Assert.assertFalse("Возраст по условию должен быть отрицательным числом", result);
    }

    @Test
    public void testSix() {
        Boolean result = checkAge(null, null);
        Assert.assertFalse("По условию должно быть число 0", result);
    }

    private Boolean checkAge(LocalDate birthDate, LocalDate currentDate) {
        int age = 0;
        if ((birthDate != null) && (currentDate != null)) {
            age = Period.between(birthDate, currentDate).getYears();
        }
        if (age > 0) {
            if (age < 18) {
                return false;
            } else if (age > 18) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}