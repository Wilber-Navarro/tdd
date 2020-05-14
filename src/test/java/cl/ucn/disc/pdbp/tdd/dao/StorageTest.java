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

package cl.ucn.disc.pdbp.tdd.dao;

import cl.ucn.disc.pdbp.tdd.model.Persona;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

/**
 * @autor Wilber Navarro.
 */
public class StorageTest {

    /**
     * The logger
     */
    private static final Logger log= LoggerFactory.getLogger(StorageTest.class);

    /**
     *
     * Testing de ORMLite and H2(database).
     */
    @Test
    public void testDatabase() throws SQLException {

        //The database to use (in Ram memory)
        String databaseUrl="jdbc:h2:mem:fivet_db";

        //Connection source: autoclose with the try/catch
        try(ConnectionSource connectionSource=new JdbcConnectionSource(databaseUrl)){

            //Create the table from the persona annotations
            TableUtils.createTableIfNotExists(connectionSource, Persona.class);

            //The dao Persona
            Dao<Persona, Long> daoPersona= DaoManager.createDao(connectionSource,Persona.class);

            //New persona
            Persona persona=new Persona("Andrea","Contreras","152532873","234 6768","569 56435447","Argentina 1234","correo@alumnos.ucn.cl");

            //insert persona into the database
            int tuples =daoPersona.create(persona);
            log.debug("Id: {}", persona.getId());

            Assertions.assertEquals(1,tuples,"Save tuples != 1");

            //Get from db
            Persona personaDB=daoPersona.queryForId(persona.getId());

            Assertions.assertEquals(persona.getNombre(),personaDB.getNombre(),"Nombre not equals");
            Assertions.assertEquals(persona.getApellido(),personaDB.getApellido(),"Apellido not equals");
            Assertions.assertEquals(persona.getRut(),personaDB.getRut(),"Rut not equals");

            //Search by rut: SELECT * FROM 'persona' WHERE 'rut' = '152532873'
            List<Persona> personaList=daoPersona.queryForEq("rut","152532873");
            Assertions.assertEquals(1,personaList.size(),"More than one person");

            //Not found by rut
            Assertions.assertEquals(0,daoPersona.queryForEq("rut","19").size(),"Found something!?");
        }catch (IOException e) {
            log.error("Error", e);
        }
    }
}