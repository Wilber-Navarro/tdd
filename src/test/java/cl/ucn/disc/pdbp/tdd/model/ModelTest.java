/*
 * MIT License
 *
 * Copyright (c) [2020.] [Wilber Mauricio Navarro Moreira]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cl.ucn.disc.pdbp.tdd.model;

import cl.ucn.disc.pdbp.utils.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Model test.
 */
public final class ModelTest {

    /**
     * The Logger (console).
     */
    private static final Logger log = LoggerFactory.getLogger(ModelTest.class);

    /**
     * Test the Persona.
     * - El nombre no puede ser null.
     * - El nombre debe tener al menos 2 letras.
     * - El apellido no puede ser null.
     * - El apellido debe tener al menos 3 letras.
     * - El rut debe ser valido.
     */
    @Test
    //@Disabled
    public void testPersona() {

        log.debug("Testing Persona ..");

        // The data!
        log.debug(".. valid ..");
        String nombre = "Andrea";
        String apellido = "Contreras";
        String nombreApellido = nombre + " " + apellido;
        String rutOk = "152532873";
        String rutError = "15253287K";
        String fijo = "345 6789";
        String movil = "(345) 67891234";
        String direccion = "Rupanco 9999";
        String email = "correo@gmail.com";

        // Test constructor and getters
        Persona persona = new Persona(nombre, apellido, rutOk,fijo,movil,direccion,email);
        Assertions.assertEquals(persona.getNombre(), nombre);
        Assertions.assertEquals(persona.getApellido(), apellido);
        Assertions.assertEquals(persona.getNombreApellido(), nombreApellido);

        // Testing nullity
        log.debug(".. nullity ..");
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(null, null, null,null,null,null,null));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(null, null, null,null,null,null,email));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(null, null, null,null,null,direccion,null));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(null, null, null,null,movil,null,null));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(null, null, null,fijo,null,null,null));
        //TODO: Necesario todas las combinaciones??
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(null, null, rutOk,null,null,null,null));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(null, apellido, null,null,null,null,null));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(null, apellido, rutOk,null,null,null,null));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(nombre, null, null,null,null,null,null));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(nombre, null, rutOk,null,null,null,null));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(nombre, apellido, null,null,null,null,null));

        // Testing invalid rut
        log.debug(".. rut ..");
        Assertions.assertThrows(RuntimeException.class, () -> new Persona(nombre, apellido, rutError,fijo,movil,direccion,email));

        // TODO: Add the size of nombre y apellido.

        log.debug("Done.");

    }

    /**
     * Test the digito verificador.
     */
    @Test
    //@Disabled // remove to run
    public void testDigitoVerificador() {

        Assertions.assertFalse(Validation.isRutValid(null));

        Assertions.assertTrue(Validation.isRutValid("152532873"));
        Assertions.assertTrue(Validation.isRutValid("21195194K"));
        Assertions.assertTrue(Validation.isRutValid("121244071"));
        Assertions.assertTrue(Validation.isRutValid("198127949"));
        Assertions.assertTrue(Validation.isRutValid("202294316"));

        Assertions.assertFalse(Validation.isRutValid("1525A2873"));
        Assertions.assertFalse(Validation.isRutValid("15253287K"));
        Assertions.assertFalse(Validation.isRutValid("15253287-"));

    }

    /**
     * Test the phone number.
     */
    @Test
    public void testPhoneNumber() {

        Assertions.assertFalse(Validation.isPhoneValid(null));

        Assertions.assertTrue(Validation.isPhoneValid("543 6785"));
        Assertions.assertTrue(Validation.isPhoneValid("(569) 56756689"));

        Assertions.assertFalse(Validation.isPhoneValid("NUMERO"));
        Assertions.assertFalse(Validation.isPhoneValid("1232sadsad12"));
        Assertions.assertFalse(Validation.isPhoneValid("1234$%%^^"));

    }
    /**
     * Test the address.
     */
    @Test
    public void testAddress() {

        Assertions.assertFalse(Validation.isDireccionValid(null));

        Assertions.assertTrue(Validation.isDireccionValid("Pucon 3345"));
        Assertions.assertTrue(Validation.isDireccionValid("Avenida Argentina 4567"));

        Assertions.assertFalse(Validation.isDireccionValid("NUMERO"));
        Assertions.assertFalse(Validation.isDireccionValid("1232sadsad12"));
        Assertions.assertFalse(Validation.isDireccionValid("1234$%%^^"));
        Assertions.assertFalse(Validation.isDireccionValid("Avenida Argentina"));
        Assertions.assertFalse(Validation.isDireccionValid("1234"));

    }
    /**
     * Test the email.
     */
    @Test
    public void testEmail() {

        Assertions.assertFalse(Validation.isEmailValid(null));

        Assertions.assertTrue(Validation.isEmailValid("Correo@alumnos.ucn.cl"));
        Assertions.assertTrue(Validation.isEmailValid("correo001@alumnos.ucn.cl"));

        Assertions.assertFalse(Validation.isEmailValid("Correo"));
        Assertions.assertFalse(Validation.isEmailValid("12345"));
        Assertions.assertFalse(Validation.isEmailValid("correo@qwer@gmail.com"));
        Assertions.assertFalse(Validation.isEmailValid("correo @ Gmail"));
    }
}
