package com.etf.model;


import com.etf.model.Pacijent;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ActiveProfiles("test")
public class PacijentTest {

    private static Validator validator;
    private static ValidatorFactory validatorFactory;


    @BeforeAll
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
    }

    @Test
    public void testPacijentImeNull(){
        String name = null;
        Pacijent pacijent = new Pacijent(

                "ime",
                "prezime"
        );

        pacijent.setIme(name);
        List<ConstraintViolation<Pacijent>> pacijents=new ArrayList<>(validator.validate(pacijent));

        assertEquals("First name must be entered.",pacijents.get(0).getMessage());

    }

    @Test
    public void testPacijentPrezimeNull(){
        String lastName = null;
        Pacijent pacijent = new Pacijent(

                "ime",
                "prezime"
        );

        pacijent.setPrezime(lastName);
        List<ConstraintViolation<Pacijent>> pacijents=new ArrayList<>(validator.validate(pacijent));

        assertEquals("Last name must be entered.",pacijents.get(0).getMessage());

    }

}
