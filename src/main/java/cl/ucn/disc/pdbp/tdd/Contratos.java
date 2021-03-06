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

package cl.ucn.disc.pdbp.tdd;

import cl.ucn.disc.pdbp.tdd.model.Control;
import cl.ucn.disc.pdbp.tdd.model.Ficha;
import cl.ucn.disc.pdbp.tdd.model.Persona;

import java.util.List;

/**
 * Contratos del sistema.
 * @author Wilber Navarro.
 */
public interface Contratos {

    /**
     * Contrato: C01 Registrar los datos de un paciente.
     *
     * @param ficha to save in the backend,
     * @return the {@link Ficha}.
     */
    Ficha registrarPaciente(Ficha ficha);

    /**
     * Contrato: C02 Registrar los datos de un persona.
     *
     * @param persona to save in the backend.
     * @return the {@link Persona} saved.
     */
    Persona registrarPersona(Persona persona);

    /**
     * Contrato: C03 Buscar ficha.
     *
     * @param query to search.
     * @return the {@link List} of the {@link Ficha}.
     */
    List<Ficha> buscarFicha(String query);

    /**
     *
     * @return the {@link List} of {@link Ficha}.
     */
    List<Ficha> getAllFichas();

    /**
     *
     * @return the {@link List} of {@link Persona}.
     */
    List<Persona> getAllPersonas();

    /**
     *
     * @param numeroFicha .
     * @return the controls of Ficha.
     */
    List<Control> getControlesDeFicha(Integer numeroFicha);

    /**
     *
     * @param numeroFicha numero de Ficha.
     * @return The Persona of Ficha.
     */
    Persona getPersonaDeFicha(Integer numeroFicha);

}
